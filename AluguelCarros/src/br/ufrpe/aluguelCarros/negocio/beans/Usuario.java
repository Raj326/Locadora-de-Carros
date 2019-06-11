package br.ufrpe.aluguelCarros.negocio.beans;

public class Usuario {
	private String nome;
	private String email;
	private String login;
	private String senha;

	// Construtor
	public Usuario(String nome, String email, String login, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	// Gettersn and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
