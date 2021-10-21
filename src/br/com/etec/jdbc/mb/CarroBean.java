package br.com.etec.jdbc.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.etec.jdbc.dao.CarroDAO;
import br.com.etec.jdbc.modelo.Carros;

@ManagedBean(name="carroBean")
@SessionScoped
public class CarroBean {
	
	private Carros carro = new Carros();
	CarroDAO dao = new CarroDAO();
	
	private List<Carros> carros;
	
	public Carros getCarro() {
		return carro;
	}

	public void setCarro(Carros carro) {
		this.carro = carro;
	}
	
	public List<Carros> getCarros(){
		if(carros == null){
			carros = dao.getLista();
		}
		return carros;
	}
	
	// A alteração está contida neste metodo
	public String grava() throws ClassNotFoundException{
		if(carro.getId() == 0){
			dao.insere(carro);
			this.carro = new Carros();
			this.carros = dao.getLista();
		}
		else{
			dao.altera(carro); //alteração
			this.carro = new Carros();
			this.carros = dao.getLista();
		}
		return "listarCarros?faces-redirect=true";
	}
	
	public void remove() throws ClassNotFoundException{
		dao.remove(carro);
		this.carro = new Carros();
		this.carros = dao.getLista();
	}
	
	public String redireciona(){
		return "preencherCarros?faces-redirect=true";
	}
	
}
