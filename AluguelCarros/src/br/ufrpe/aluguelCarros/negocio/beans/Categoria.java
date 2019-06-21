package br.ufrpe.aluguelCarros.negocio.beans;

public enum Categoria {
	SUV ("SUV"),
	SW ("SW"),
	SEDAN ("SEDAN"),
	PICK_UP ("PICK UP"),
	MINIVAN ("MINIVAN");
	
	private String categoria;
	
	Categoria (String categoria) {
        this.setCategoria(categoria);
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
    public String toString() {
        return this.categoria;
    }
	
}
