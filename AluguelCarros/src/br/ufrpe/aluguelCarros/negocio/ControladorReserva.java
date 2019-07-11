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
        // TODO Checar regra de negócio. Uma reserva não pode ser excluída se o tempo o tempo
    	// de alguel não estiver encerrado
    	LocalDate agora = LocalDate.now();
    	if(obj.getFimDoAluguel().isAfter(agora))
    		//Se a data do fim da reserva for depois da data atual, não remove!
    		throw new ReservaNaoEncerrada(obj);
    	else
    		repositorioReservas.remover(obj);
    }*/
    
    // TODO Talvez não seja necessário o levantamento da exceção
    public void atualizar(Reserva newObj) throws ElementoNaoExisteException {
        repositorioReservas.atualizar(newObj);
    }

}

