package br.ufrpe.aluguelCarros.negocio;

import java.util.List;
import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;


public class ControladorCarros{
	private RepositorioGenerico<Carro> repositorioCarros;
    private static ControladorCarros instance;
    
    private ControladorCarros() {
        this.repositorioCarros = new RepositorioGenerico<>("Carros.txt");
    }
    
    public static ControladorCarros getInstance() {
        if (instance == null) {
            instance = new ControladorCarros();
        }
        return instance;
    }
    
    public void inserir(Carro obj) throws ElementoJaExisteException {
        repositorioCarros.inserir(obj);
    }
    
    public List<Carro> listar() {
        return repositorioCarros.listar();
    }
    
    public void remover(Carro obj) throws ElementoNaoExisteException {
        // TODO Checar regra de negócio. Um carro não pode ser removido caso ele esteja sendo
    	// alugado no momento
        repositorioCarros.remover(obj);
    }
    
    // TODO Talvez não seja necessário o levantamento da exceção
    public void atualizar(Carro newObj) throws ElementoNaoExisteException {
        repositorioCarros.atualizar(newObj);
    }

}
