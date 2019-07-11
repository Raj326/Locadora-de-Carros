package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.exception.ClienteAlugandoCarroException;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.exception.ElementoNaoExisteException;
import br.ufrpe.aluguelCarros.exception.SenhaIncorretaException;
import br.ufrpe.aluguelCarros.exception.UsuarioNaoEncontradoException;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

public class Fachada {
	private static Fachada instance;
	private ControladorCarros controladorCarros;
	private ControladorUsuarios controladorUsuarios;
	
	private Fachada() {
		this.controladorCarros = ControladorCarros.getInstance();
		this.controladorUsuarios = ControladorUsuarios.getInstance();
    }
	
	public static Fachada getInstance() {
		if (instance == null) {
            instance = new Fachada();
        }
        return instance;
	}
	
	//Operações do controlador de Carros
	//Inclui operações de CRUD e de busca por categoria e caracteristicas do carro
	public void inserir(Carro carro) throws ElementoJaExisteException {
		this.controladorCarros.inserir(carro);
	}
	
	public List<Carro> listarCarros() {
        return this.controladorCarros.listar();
    }
	
	public void remover(Carro carro) throws ElementoNaoExisteException {
        this.controladorCarros.remover(carro);
    }
	
	public void atualizar(Carro novoCarro) throws ElementoNaoExisteException {
        this.controladorCarros.atualizar(novoCarro);
    }
	
	public List<Carro> filtrar(Boolean ar, Boolean airbag, Boolean cambio, Boolean direcao, Boolean freio, Boolean trava) {
		return this.controladorCarros.filtrar(ar, airbag, cambio, direcao, freio, trava);
	}
	
	//Operações do controlador de Usuarios
	//Inclui operações de crud e login
	public void inserir(Usuario usuario) throws ElementoJaExisteException {
		this.controladorUsuarios.inserir(usuario);
	}
	
	public List<Usuario> listarUsuarios() {
		return this.controladorUsuarios.listar();
	}
	
	public void remover (Usuario usuario) throws ElementoNaoExisteException, ClienteAlugandoCarroException {
		this.controladorUsuarios.remover(usuario);
	}
	
	public void atualizar (Usuario usuario) throws ElementoNaoExisteException {
		this.controladorUsuarios.atualizar(usuario);
	}
	
	public Usuario login(String login, String senha) throws SenhaIncorretaException, UsuarioNaoEncontradoException {
		return this.controladorUsuarios.login(login, senha);
	}
}
