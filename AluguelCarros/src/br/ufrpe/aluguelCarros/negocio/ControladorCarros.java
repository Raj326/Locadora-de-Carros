package br.ufrpe.aluguelCarros.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;


public class ControladorCarros implements Controlador{
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
    
    public void inserir(Object obj) throws ElementoJaExisteException {
        repositorioCarros.inserir((Carro)obj);
    }
    
    public List<Carro> listar() {
        return repositorioCarros.listar();
    }
    
    public void remover(Object obj) throws ElementoNaoExisteException {
        // TODO Checar regra de negócio. Um carro não pode ser removido caso ele esteja sendo
    	// alugado no momento
        repositorioCarros.remover((Carro)obj);
    }
    
    // TODO Talvez não seja necessário o levantamento da exceção
    public void atualizar(Object newObj) throws ElementoNaoExisteException {
        repositorioCarros.atualizar((Carro)newObj);
    }
    
    public List<Carro> filtrar(Boolean ar, Boolean airbag, Boolean cambio, Boolean direcao, Boolean freio, Boolean trava) {
    	List<Carro> auxiliar = this.listar();
    	List<Carro> carros = new ArrayList<Carro>();
    	carros.addAll(auxiliar);
    	
    	if(ar == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isAr() == false) i.remove();
    		}
    	}
    	if(airbag == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isAirbag() == false) i.remove();
    		}
    	}
    	if(cambio == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isCambio() == false) i.remove();
    		}
    	}
    	if(direcao == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isDirecao() == false) i.remove();
    		}
    	}
    	if(freio == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isFreio() == false) i.remove();
    		}
    	}
    	if(trava == true) {
    		for(Iterator <Carro> i = carros.iterator(); i.hasNext();) {
    			Carro c = i.next(); 
    			if (c.isTrava() == false) i.remove();
    		}
    	}
    	return carros;
    }

}
