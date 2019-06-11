// Modicar classe para fazer todas as operações de CRUD
package br.ufrpe.aluguelCarros.negocio;

import br.ufrpe.aluguelCarros.dados.RepositorioLocatarios;
import br.ufrpe.aluguelCarros.negocio.beans.Locatario;

public class Cadastro {
	private static RepositorioLocatarios repositorioLocatarios = new RepositorioLocatarios();
	
	public static void cadastraLocatario(Locatario locatario ) {
		repositorioLocatarios.cadastrar(locatario);
	}
	
	
	public static RepositorioLocatarios getRepositorioLocatarios() {
		return repositorioLocatarios;
	}
}
