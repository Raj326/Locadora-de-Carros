package br.ufrpe.aluguelCarros.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LocatarioLoginController {
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Button entra;
	@FXML
	private Button Cadastra;
	@FXML Label mensagem;
	
	public void entra() {
		if(login.getText().isEmpty() || senha.getText().isEmpty()) {
			mensagem.setText("Não deixe campos vazios");
		}
		else {
			String entrada = login.getText();
			String entradaSenha = senha.getText();
		}
	}
}
