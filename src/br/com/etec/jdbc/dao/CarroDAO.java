package br.com.etec.jdbc.dao;

import br.com.etec.jdbc.modelo.Carros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
	
	private Connection connection;
	
	// Construtor da Classe (gcfs)
	public CarroDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insere(Carros carro){
		try{
			// Interrogações porque não sabemos o que sera inserido.
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO Carros VALUES (?, ?, ?, ?, ?)");
			
			// Passagem dos valores a serem inseridos
			stmt.setString(1, carro.getMarca());
			stmt.setString(2, carro.getModelo());
			stmt.setString(3, carro.getAno());
			stmt.setString(4, carro.getPlaca());
			stmt.setString(5, carro.getCor());
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Carros carro){
		try{
			// Interrogações porque não sabemos o que sera removido.
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM Carros WHERE id=?");
			
			// Passagem dos valores a serem removidos
			stmt.setInt(1, carro.getId());
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Carros carro){
		try{
			// Interrogações porque não sabemos o que sera editado.
			PreparedStatement stmt = connection.prepareStatement("UPDATE Carros SET marca=?, modelo=?, ano=?, placa=?, cor=? WHERE id=?");
			
			// Passagem dos valores a serem editados
			stmt.setString(1, carro.getMarca());
			stmt.setString(2, carro.getModelo());
			stmt.setString(3, carro.getAno());
			stmt.setString(4, carro.getPlaca());
			stmt.setString(5, carro.getCor());
			stmt.setInt(6, carro.getId());
			stmt.execute(); 							// Execução das exclusão
			stmt.close();								// Fechamento da Conexão
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Carros> getLista(){
		try{
		List<Carros> carros = new ArrayList<Carros>();
		PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Carros");
		
		ResultSet rs = stmt.executeQuery();
		
		//Ordem na qual foi salva no banco e aparecerá na busca
		while(rs.next()){
			Carros carro = new Carros();
			carro.setId(rs.getInt(1));
			carro.setMarca(rs.getString(2));
			carro.setModelo(rs.getString(3));
			carro.setAno(rs.getString(4));
			carro.setPlaca(rs.getString(5));
			carro.setCor(rs.getString(6));
			carros.add(carro);
		}
		
		rs.close();
		stmt.close();
		return carros;
	}
		catch(SQLException e){
			throw new RuntimeException(e);
		}

	}
	
}
