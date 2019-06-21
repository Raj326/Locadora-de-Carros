package br.ufrpe.aluguelCarros.negocio;

import java.util.List;

import br.ufrpe.aluguelCarros.dados.RepositorioGenerico;
import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Categoria;

public class Teste {
	private static RepositorioGenerico<Carro> repositorioCarros;
	
	public static void main(String[] args) {
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
		//System.out.println(Categoria.values());
	}
}
