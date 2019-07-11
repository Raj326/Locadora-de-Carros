package br.ufrpe.aluguelCarros.exception;

public class UsuarioNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 9156943552906986261L;
	
	private Object elemento;
    
    public UsuarioNaoEncontradoException(Object obj) {
        super("O usuario não foi encontrado no repositório");
        this.elemento = obj;
    }
    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
