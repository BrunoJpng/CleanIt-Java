package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.locks.StampedLock;

public class DB {
	
	public static Connection conn = null;
	
	//inicia a conexão com o banco de dados
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				System.out.println("banco de dados executando ...");
			}catch (SQLException e) {
				throw new DbExecption(e.getMessage());
			}
		}
		return conn;
	}
	
	//fecha a conexão com o banco de dados
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}catch (SQLException e){
				throw new DbExecption(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st ) {
		if (st != null) {
			try {
				st.close();
			}catch (SQLException e){
				throw new DbExecption(e.getMessage());
			}
			
		}
		
	}
	
	
	//ler os dados do aqr db.properties esalvar no objeto tipo Properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbExecption(e.getMessage());
		}
	}
	
}
