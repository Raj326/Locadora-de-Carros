package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ClienteAlugandoCarroException;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Cliente;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

public class ControladorUsuarios {

	private RepositorioGenerico<Usuario> repositorioUsuarios;
	private static ControladorUsuarios instance;

	private ControladorUsuarios() {
		this.repositorioUsuarios = new RepositorioGenerico<>("Usuarios.txt");
	}

	public static ControladorUsuarios getInstance() {
		if (instance == null) {
			instance = new ControladorUsuarios();
		}
		return instance;
	}

	public void inserir(Usuario obj) throws ElementoJaExisteException {
		repositorioUsuarios.inserir(obj);
	}

	public List<Usuario> listar() {
		return repositorioUsuarios.listar();
	}

	public void remover(Usuario obj) throws ElementoNaoExisteException, ClienteAlugandoCarroException {
		// TODO Checar regra de neg�cio. Um Usuario n�o pode ser removido caso ele esteja
		// alugando um carro no momento
		Cliente cl = (Cliente) obj;
		if(cl.isAlugandoCarro())
			throw new ClienteAlugandoCarroException(obj);
		else
			repositorioUsuarios.remover(obj);
	}

	// TODO Talvez n�o seja necess�rio o levantamento da exce��o
	public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
		repositorioUsuarios.atualizar(newObj);
	}

}
