package br.ufrpe.aluguelCarros.dados;

import java.util.List;

import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;



public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ElementoJaExisteException;
    
    List<T> listar();
    
    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;

}
