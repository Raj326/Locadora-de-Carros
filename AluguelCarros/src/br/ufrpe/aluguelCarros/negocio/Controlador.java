package br.ufrpe.aluguelCarros.negocio;


import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;

public interface Controlador {

	void inserir(Object obj) throws ElementoJaExisteException;
	    
	void remover(Object obj) throws ElementoNaoExisteException;
	
	void atualizar(Object newObj) throws ElementoNaoExisteException;

}
