package br.ufrpe.aluguelCarros.negocio.beans;

import java.io.Serializable;

public class Cliente extends Usuario implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	private boolean alugandoCarro; //flag para indicar se o cliente está atualmente com um carro alugado 

	public Cliente(String nome, String login, String senha) {
		super(nome, login, senha);
		// TODO Auto-generated constructor stub
		this.alugandoCarro = false;
	}
	
	public boolean isAlugandoCarro() {
		return alugandoCarro;
	}

	public void setAlugandoCarro(boolean alugandoCarro) {
		this.alugandoCarro = alugandoCarro;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (this.getLogin() == null) {
			if (other.getLogin() != null)
				return false;
		} else if (!getLogin().equals(other.getLogin()))
			return false;
		return true;
	}
}
