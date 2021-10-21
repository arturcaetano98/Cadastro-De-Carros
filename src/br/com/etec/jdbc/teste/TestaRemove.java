package br.com.etec.jdbc.teste;

import br.com.etec.jdbc.dao.CarroDAO;
import br.com.etec.jdbc.modelo.Carros;

public class TestaRemove {

	public static void main(String[] args){
		
		// Instancia classe produto
		Carros carro = new Carros();
		
		// Descrição do Produto
		carro.setId(3);  // Necessario passar a chave do que será removido.
		
		// Envio do produto ao DAO (Objeto inteiro)
		CarroDAO dao = new CarroDAO();
		
		dao.remove(carro);
		
		System.out.print("Produto Removido com Sucesso!");
	}

}
