package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ClienteAlugandoCarroException;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.exception.SenhaIncorretaException;
import br.ufrpe.aluguelCarros.exception.UsuarioNaoEncontradoException;
import br.ufrpe.aluguelCarros.negocio.beans.Cliente;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

public class ControladorUsuarios {

	private RepositorioGenerico<Usuario> repositorioUsuarios;
	private static ControladorUsuarios instance;

	private ControladorUsuarios() {
		this.repositorioUsuarios = new RepositorioGenerico<>("Usuario.txt");
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
		// TODO Checar regra de negócio. Um Usuario não pode ser removido caso ele esteja
		// alugando um carro no momento
		Cliente cl = (Cliente) obj;
		if(cl.isAlugandoCarro())
			throw new ClienteAlugandoCarroException(obj);
		else
			repositorioUsuarios.remover(obj);
	}

	// TODO Talvez não seja necessário o levantamento da exceção
	public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
		repositorioUsuarios.atualizar(newObj);
	}
	
	public Usuario login(String login, String senha) throws SenhaIncorretaException, UsuarioNaoEncontradoException {
		List<Usuario> usuarios = repositorioUsuarios.listar();
		for(Usuario u: usuarios) {
			if(u.getLogin().equals(login)) {
				if(u.getSenha().equals(senha)) {
					return u;
				}
				else throw new SenhaIncorretaException(u);
			}
		}
		throw new UsuarioNaoEncontradoException(login);
	}

}
