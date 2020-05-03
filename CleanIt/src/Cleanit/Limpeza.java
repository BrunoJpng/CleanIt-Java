package Cleanit;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Limpeza {
	Usuario usuario = Usuario.getInstancia();
	Celular celular = new Celular();
	Data data = new Data();
	String pl;

	public void LimparCelular() {
		celular.Limpar();
		pl = data.ProximaLimpeza();
	}
	
	public String RegistraData() {
		Connection conn = null;
		PreparedStatement st = null;

		String dataCompleta = data.getData();
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("UPDATE users SET data_limpeza = ?  WHERE email = ?");
			st.setString(1, dataCompleta );
			//mudar para um scan de email
			st.setString(2, usuario.getEmail());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Linhas afetadas: " +  rowsAffected);
			}else {
				System.out.println("Usuário não cadastrado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

		return data.getData();
	}
	
	public String LimpezaFutura() {
		if (pl == null) {
			return "Você ainda não limpou seu celular.";
		}
		return pl;
	}
	
}
