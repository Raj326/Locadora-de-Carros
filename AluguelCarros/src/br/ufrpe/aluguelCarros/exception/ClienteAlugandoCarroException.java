package br.ufrpe.aluguelCarros.exception;

public class ClienteAlugandoCarroException extends Exception {

	private static final long serialVersionUID = 4333856275501968945L;
	private Object elemento;

	public ClienteAlugandoCarroException(Object obj) {
        super("O cliente está alugando um carro no momento e não pode ser removido. ");
        this.elemento = obj;        
    }

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

}
