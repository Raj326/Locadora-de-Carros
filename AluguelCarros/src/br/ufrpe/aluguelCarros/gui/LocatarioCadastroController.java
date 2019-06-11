package br.ufrpe.aluguelCarros.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LocatarioCadastroController {
	@FXML
	private TextField nome;
	@FXML 
	private TextField cpf;
	@FXML
	private TextField email;
	@FXML
	private PasswordField senha;
	@FXML
	private PasswordField senharep;
	@FXML
	private Button cadastrar;
	@FXML
	private Button votar;
	@FXML
	private Label mensagem;
	
	
	public void cadastrar() {
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || email.getText().isEmpty() || senha.getText().isEmpty() || senharep.getText().isEmpty()) {
			mensagem.setText("Não deixe campos vazios");
		}
		else if(!senha.equals(senharep)) {
			mensagem.setText("Senhas não batem");
		}
	}
}
