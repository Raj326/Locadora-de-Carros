package br.ufrpe.aluguelCarros.negocio.beans;

import java.time.*;

public class Reserva {
	private Carro carro;
	private Cliente cliente;
	LocalDateTime inicioDoAluguel;
	LocalDateTime fimDoAluguel;
	
	public Reserva(Carro carro, Cliente cliente, LocalDateTime iniciodoAluguel, LocalDateTime fimDoAluguel) {
		this.carro = carro;
		this.cliente = cliente;
		this.inicioDoAluguel = iniciodoAluguel;
		this.fimDoAluguel = fimDoAluguel;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDateTime getIniciodoAluguel() {
		return inicioDoAluguel;
	}

	public LocalDateTime getFimDoAluguel() {
		return fimDoAluguel;
	}
}
