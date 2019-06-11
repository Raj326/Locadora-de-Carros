package br.ufrpe.aluguelCarros.gui;

import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TelaCadastroCarroController {
	@FXML
	private CheckBox checa_ar;
	@FXML
	private CheckBox checa_airbag;
	@FXML
	private CheckBox checa_cambio;
	@FXML
	private CheckBox checa_direcao;
	@FXML
	private CheckBox checa_freio;
	@FXML
	private CheckBox checa_trava;
	@FXML
	private TextField modelo;
	@FXML
	private TextField assentos;
	@FXML
	private TextField motor;
	@FXML
	private TextField preco;
	@FXML
	private Button confirma;
	@FXML 
	private Button voltar;
	@FXML
	private Label mensagem;
	
	public void salvarCarro() {
		if(modelo.getText().isEmpty() || assentos.getText().isEmpty() || motor.getText().isEmpty()) {
			mensagem.setText("N�o deixe os campos de texto em vazio");
		}
		else {
			Carro carro = new Carro(modelo.getText(), motor.getText(), Integer.parseInt(assentos.getText()), checa_ar.isSelected(), 
					checa_airbag.isSelected(), checa_cambio.isSelected(), checa_direcao.isSelected(), checa_freio.isSelected(),
					checa_trava.isSelected(), Float.parseFloat(preco.getText()));
			
		}
	}
	
}
