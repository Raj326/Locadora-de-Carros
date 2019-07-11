package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.negocio.Fachada;
import br.ufrpe.aluguelCarros.negocio.beans.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaClienteCadastroController {
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
	private Button voltar;
	@FXML
	private Label mensagem;
	
	
	public void cadastrar() {
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || email.getText().isEmpty() || senha.getText().isEmpty() || senharep.getText().isEmpty()) {
			mensagem.setText("Não deixe campos vazios");
		}
		else if(!senha.getText().equals(senharep.getText())) {
			mensagem.setText("Senhas não batem");
		}
		else {
			Cliente cliente = new Cliente(nome.getText(), cpf.getText(), senha.getText());
			try {
				Fachada.getInstance().inserir(cliente);
				Main.changeScene(GerenciadorDeTelas.getInstance().getTelaLoginScene());
				
			} catch (ElementoJaExisteException e) {
				mensagem.setText("Exite um usuário atualmente cadastrado com este cpf");
			} catch (IOException i) {}
		}
	}
	
	public void voltar() {
		try {
			Main.changeScene(GerenciadorDeTelas.getInstance().getTelaLoginScene());
		} catch (IOException e) {
			
		}
	}
}
