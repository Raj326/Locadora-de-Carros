package br.ufrpe.aluguelCarros.negocio.beans;

public class Cliente extends Usuario{
	private String cpf;

	public Cliente(String nome, String email, String login, String senha, String cpf) {
		super(nome, email, login, senha);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
