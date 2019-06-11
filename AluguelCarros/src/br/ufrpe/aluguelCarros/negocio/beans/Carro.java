package br.ufrpe.aluguelCarros.negocio.beans;

public class Carro {

	private String modelo, motor; // modelo do carro e cilindradas do motor (1.0, 1.4 ...)
	private int passageiros;
	// indica se o carro possui ou n�o arcondicionado, airbag, cambio autom�tico
	// freios abs, trava el�trica e dire��o hidr�ulica.
	private boolean ar, airbag, cambio, direcao, freio, trava;
	private float preco; // pre�o a ser cobrado por dia
	private boolean emUso; // flag para determinar se carro est� em uso; 

	public Carro(String modelo,String motor, int passageiros, boolean ar, boolean airbag,
			boolean cambio, boolean direcao, boolean freio, boolean trava, float preco) {
		this.modelo = modelo;
		this.motor = motor;
		this.passageiros = passageiros;
		this.ar = ar;
		this.airbag = airbag;
		this.cambio = cambio;
		this.direcao = direcao;
		this.freio = freio;
		this.trava = trava;
		this.preco = preco;
	}

	//Getters and setters
	
	public boolean isEmUso() {
		return emUso;
	}

	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}


	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	public boolean isAr() {
		return ar;
	}

	public void setAr(boolean ar) {
		this.ar = ar;
	}

	public boolean isAirbag() {
		return airbag;
	}

	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}

	public boolean isCambio() {
		return cambio;
	}

	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}

	public boolean isDirecao() {
		return direcao;
	}

	public void setDirecao(boolean direcao) {
		this.direcao = direcao;
	}

	public boolean isFreio() {
		return freio;
	}

	public void setFreio(boolean freio) {
		this.freio = freio;
	}

	public boolean isTrava() {
		return trava;
	}

	public void setTrava(boolean trava) {
		this.trava = trava;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
