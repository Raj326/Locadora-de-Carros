package br.ufrpe.aluguelCarros.negocio.beans;

import java.io.Serializable;

public class Carro implements Serializable {

	private static final long serialVersionUID = 2189943021721966218L;
	
	private String modelo, placa, motor; // modelo do carro e cilindradas do motor (1.0, 1.4 ...)
	private int passageiros;
	// indica se o carro possui ou não arcondicionado, airbag, cambio automático
	// freios abs, trava elétrica e direção hidráulica.
	private boolean ar, airbag, cambio, direcao, freio, trava;
	private boolean alugado; //flag que indica se o carro está atualmente em uso 
	private float preco; // preço a ser cobrado por dia 

	public Carro(String modelo, String placa, String motor, int passageiros, boolean ar, boolean airbag,
			boolean cambio, boolean direcao, boolean freio, boolean trava, float preco) {
		this.modelo = modelo;
		this.motor = motor;
		this.placa = placa;
		this.passageiros = passageiros;
		this.ar = ar;
		this.airbag = airbag;
		this.cambio = cambio;
		this.direcao = direcao;
		this.freio = freio;
		this.trava = trava;
		this.preco = preco;
		this.alugado = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	//Apenas para testes
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", placa=" + placa + ", motor=" + motor + ", passageiros=" + passageiros
				+ ", ar=" + ar + ", airbag=" + airbag + ", cambio=" + cambio + ", direcao=" + direcao + ", freio="
				+ freio + ", trava=" + trava + ", alugado=" + alugado + ", preco=" + preco + "]";
	}
	
	//Getters and setters

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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
}
