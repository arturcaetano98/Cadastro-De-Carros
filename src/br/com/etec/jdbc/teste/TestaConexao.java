package br.com.etec.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.etec.jdbc.dao.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException{
		
		//Instancia da classe ConnectionFactory
		Connection connection = new ConnectionFactory().getConnection();
		System.out.print("Conexão Aberta");
		connection.close();

	}

}