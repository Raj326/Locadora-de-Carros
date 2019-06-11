//adicionar exceptions e modificar metodo login
package br.ufrpe.aluguelCarros.negocio;

import java.util.ArrayList;

import br.ufrpe.aluguelCarros.dados.RepositorioClientes;
import br.ufrpe.aluguelCarros.negocio.beans.Cliente;



public class Login {
	private static RepositorioClientes repositorioLocatarios = Cadastro.getRepositorioClientes();
	
	public static Boolean locadorLogin(String login, String senha) {
		ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) repositorioClientes.retorna();
		for(Cliente c: listaClientes) {
			if(c.getLogin().equals(login)) {
				if(c.getSenha().equals(senha)) return true;
			}
		}
		return false;
	}
}
