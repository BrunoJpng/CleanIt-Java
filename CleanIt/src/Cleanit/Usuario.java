package Cleanit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;

import db.DB;


public class Usuario {
	
	private String Nome, Email, Senha;
	private int status = 0;
	

	Connection conn = null;
	java.sql.PreparedStatement st = null;

	public static Usuario instancia;
	protected Usuario() {
	
	}
	
	public static Usuario getInstancia() {
		if(instancia == null) instancia = new Usuario();
		return instancia;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		this.Senha = senha;
	}
	
	public boolean Login(String email, String senha) {
		
		setEmail(email);
		setSenha(senha);
		
		conn = null;
		st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT * FROM users WHERE email = ? and senha = ?");
			st.setString(1, email);
			st.setString(2, senha);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				setNome(rs.getString("nome"));
				return true;
			}
		} catch(SQLException e) {
			return false;
		}
		return false;
	}
	
	public void CadastrarUsuario(String nome, String email, String senha) {
		
		this.Nome = nome;
		this.Email = email;
		this.Senha = senha;

		conn = null;
		st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO Users " + "(nome,senha, email,data_limpeza,administrador)"
					+ "VALUES " + "(?,?,?,null,false)");
			st.setString(1, nome);
			st.setString(3,email);
			st.setString(2, senha);

			int rowsAffected = st.executeUpdate();

			System.out.println("linhas afetadas: " + rowsAffected);

			}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			}
	
		}
		
		public boolean ExcluirUsuario(String email) {
			
			conn = null;
			st = null;
	
			try {
				conn = DB.getConnection();
				st = conn.prepareStatement("DELETE FROM users WHERE email = ?");
				
				st.setString(1, email);
				
				int rowsAffected = st.executeUpdate();
				
				if (rowsAffected > 0) {
					System.out.println("Linhas afetadas: " +  rowsAffected);
					return true;
				}else {
					System.out.println("Usuário não encontrado ou não existente.");
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.closeStatement(st);
				DB.closeConnection();
			}
			return false;
			
		}
	
}
