package br.com.etec.jdbc.dao;

// É necessario realizar esses imports para usar o getConnection()
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// Metodo que realiza o retorno da conexão após a criar (fabrica de conexões).
	public Connection getConnection(){
		
		//É necessario passsar corretamente a string de conexão
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			return DriverManager.getConnection("jdbc:sqlserver://DESKTOP-JFIVRDG:1433;databaseName=dbCarros;user=sa;password=haha123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}