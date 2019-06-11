package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;

public class Fachada {
	private static Fachada instance;
	private ControladorCarros controladorCarros;
	
	private Fachada() {
		this.controladorCarros = ControladorCarros.getInstance();
    }
	
	public static Fachada getInstance() {
		if (instance == null) {
            instance = new Fachada();
        }
        return instance;
	}
	
	//Operações do controlador de Carros
	//Inclui operações de CRUD e de busca por categoria e caracteristicas do carro
	public void inserir(Carro carro) throws ElementoJaExisteException {
		controladorCarros.inserir(carro);
	}
	
	public List<Carro> listar() {
        return controladorCarros.listar();
    }
	
	public void remover(Carro carro) throws ElementoNaoExisteException {
        controladorCarros.remover(carro);
    }
	
	public void atualizar(Carro novoCarro) throws ElementoNaoExisteException {
        controladorCarros.atualizar(novoCarro);
    }
}
