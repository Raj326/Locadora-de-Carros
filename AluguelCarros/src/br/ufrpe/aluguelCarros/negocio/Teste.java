package br.ufrpe.aluguelCarros.negocio;

import java.util.List;
import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Administrador;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Categoria;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

public class Teste {
	private static ControladorUsuarios controladorUsuarios;
	private static RepositorioGenerico<Carro> repositorioCarros;
	
	public static void main(String[] args) {
		controladorUsuarios = ControladorUsuarios.getInstance();
		repositorioCarros = new RepositorioGenerico<>("Carros.txt");
		
		
		/*Carro carro = new Carro("Fusca", "BR666", "1.0", 5, true, true, true, true, true, true, 2.00f, Categoria.SW);
		try{
			repositorioCarros.inserir(carro);
			System.out.println("Carro cadastrado com sucesso");
		} catch(ElementoJaExisteException e) {
			System.out.println("Carro já cadastrado");
		} catch (NullPointerException i) {
			System.out.println("Null Pointer");
		}
		*/
		
		
		List<Carro> listaCarros = repositorioCarros.listar();
		if(listaCarros.isEmpty()) {
			System.out.println("Nenhum carro cadastrado no repositório");
		} else {
			System.out.println(listaCarros.toString());
		}
		
		
		/*List<Carro> carros = Fachada.getInstance().filtrar(true, false, false, 
    			false, false, false);
		System.out.println(carros);*/
		
		//Stream<Carro> carros = listaCarros.stream();
		//carros.filter(carro -> carro.getModelo().equals("Fusca"));
		//carros.forEach(carro -> System.out.println(carro.getModelo()));
		//System.out.println(Categoria.values());
		
		
		Administrador admin = new Administrador("Administrador", "admin", "admin");
		try {
			Fachada.getInstance().inserir(admin);;
		} catch(ElementoJaExisteException e) {
			System.out.println("Usuario já existe");
		}
		
		List<Usuario> usuarios = Fachada.getInstance().listarUsuarios();
		System.out.println(usuarios);
		
	}
}
