package br.ufrpe.aluguelCarros.negocio;

import java.time.*;
import java.util.List;
import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ClienteAlugandoCarroException;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Reserva;

public class ControladorReserva {
	
	private RepositorioGenerico<Reserva> repositorioReservas;
    private static ControladorReserva instance;
    
    private ControladorReserva() {
        this.repositorioReservas = new RepositorioGenerico<>("Reserva.txt");
    }
    
    public static ControladorReserva getInstance() {
        if (instance == null) {
            instance = new ControladorReserva();
        }
        return instance;
    }
    
    public void inserir(Reserva obj) throws ElementoJaExisteException, ClienteAlugandoCarroException {
        if(obj.getCliente().isAlugandoCarro())
        	throw new ClienteAlugandoCarroException(obj);
        else
        	repositorioReservas.inserir(obj);
    }
    
    public List<Reserva> listar() {
        return repositorioReservas.listar();
    }
    
    /*
    public void remover(Reserva obj) throws ElementoNaoExisteException, ReservaNaoEncerrada {
        // TODO Checar regra de neg�cio. Uma reserva n�o pode ser exclu�da se o tempo o tempo
    	// de alguel n�o estiver encerrado
    	LocalDate agora = LocalDate.now();
    	if(obj.getFimDoAluguel().isAfter(agora))
    		//Se a data do fim da reserva for depois da data atual, n�o remove!
    		throw new ReservaNaoEncerrada(obj);
    	else
    		repositorioReservas.remover(obj);
    }*/
    
    // TODO Talvez n�o seja necess�rio o levantamento da exce��o
    public void atualizar(Reserva newObj) throws ElementoNaoExisteException {
        repositorioReservas.atualizar(newObj);
    }

}

