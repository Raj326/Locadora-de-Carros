package br.ufrpe.aluguelCarros.dados;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RepositorioGenerico<E> {
	protected List<E> elements;

	public RepositorioGenerico() {
		this.elements = new ArrayList<>();
	}

	public void cadastrar(E el) {
		if (!this.elements.contains(el)) {
			this.elements.add(el);
		}
	}

	public List<E> retorna() {
		return Collections.unmodifiableList(this.elements);
	}

	public boolean atualizar(E el) {
		int indice = this.elements.indexOf(el);
		if (indice >= 0) {
			this.elements.set(indice, el);
			return true;
		} else {
			return false;
		}
	}

	public boolean remover(E el) {
		int indice = this.elements.indexOf(el);
		if(indice >= 0)
		{
			this.elements.remove(indice);
			return true;
		}
		else
		{
			return false;
		}
	}
}