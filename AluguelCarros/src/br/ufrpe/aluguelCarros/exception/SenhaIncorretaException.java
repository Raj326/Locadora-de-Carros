package br.ufrpe.aluguelCarros.exception;

public class SenhaIncorretaException extends Exception {

	private static final long serialVersionUID = 3100366343120683816L;
	
	private Object elemento;
    
    public SenhaIncorretaException(Object obj) {
        super("A senha não confere");
        this.elemento = obj;
    }
    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
