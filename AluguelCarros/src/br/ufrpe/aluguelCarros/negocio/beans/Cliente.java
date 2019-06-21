package br.ufrpe.aluguelCarros.negocio.beans;

public class Cliente extends Usuario{
	private String cpf;
	private boolean alugandoCarro; //flag para indicar se o cliente está atualmente com um carro alugado 

	public Cliente(String nome, String email, String senha, String cpf) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.alugandoCarro = false;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
