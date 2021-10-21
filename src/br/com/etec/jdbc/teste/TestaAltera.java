package br.com.etec.jdbc.teste;

import br.com.etec.jdbc.dao.CarroDAO;
import br.com.etec.jdbc.modelo.Carros;

public class TestaAltera {

	public static void main(String[] args){
		
		Carros carro = new Carros();
		
		carro.setId(2);  // Necessario passar a chave do que será alterado.
		carro.setMarca("Ford");
		carro.setModelo("Focus");
		carro.setAno("2006/2007");
		carro.setPlaca("asd-1234");
		carro.setCor("Vermelho");
		
		CarroDAO dao = new CarroDAO();
		
		dao.altera(carro);
		
		System.out.print("Carro Alterado com Sucesso!");
	}

}
