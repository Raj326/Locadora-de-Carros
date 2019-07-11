package br.ufrpe.aluguelCarros.negocio.beans;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String login;
	private String senha;

	public Usuario(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	// Getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setEmail(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	//Apenas para testes
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}
	
}
