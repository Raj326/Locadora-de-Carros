package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;

public interface Cadastro {

	void inserir(Object obj) throws ElementoJaExisteException;
	    
	    List<Object> listar();
	    
	    void remover(Object obj) throws ElementoNaoExisteException;
	
	    void atualizar(Object newObj) throws ElementoNaoExisteException;

}
