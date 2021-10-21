package br.com.etec.jdbc.teste;

import br.com.etec.jdbc.dao.CarroDAO;
import br.com.etec.jdbc.modelo.Carros;

public class TestaInsere {

	public static void main(String[] args){
		
		// Instancia classe carro
		Carros carro = new Carros();
				
		// Descrição do carro
		carro.setMarca("Honda");
		carro.setModelo("Civic EXS");
		carro.setAno("2007/2008");
		carro.setPlaca("asd-1234");
		carro.setCor("Cinza");
		
		// Envio do carro ao DAO (Objeto inteiro)
		CarroDAO dao = new CarroDAO();
		
		dao.insere(carro);
				
		System.out.print("Carro Inserido com Sucesso!");
	}

}
