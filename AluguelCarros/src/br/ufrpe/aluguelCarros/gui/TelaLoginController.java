package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import br.ufrpe.aluguelCarros.exception.SenhaIncorretaException;
import br.ufrpe.aluguelCarros.exception.UsuarioNaoEncontradoException;
import br.ufrpe.aluguelCarros.negocio.Fachada;
import br.ufrpe.aluguelCarros.negocio.beans.Administrador;
import br.ufrpe.aluguelCarros.negocio.beans.Cliente;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginController {
	private Usuario usuario;
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Button entra;
	@FXML
	private Button cadastra;
	@FXML Label mensagem;
	
	public void login() {
		if(login.getText().isEmpty() || senha.getText().isEmpty()) {
			mensagem.setText("Não deixe campos vazios");
		}
		else {
			try {
				Usuario u = Fachada.getInstance().login(login.getText(), senha.getText());
				this.usuario = u;
				if(u instanceof Administrador) {
					Main.changeScene(GerenciadorDeTelas.getInstance().getTelaAdmin());
				} 
				else if (u instanceof Cliente) {
					Main.changeScene(GerenciadorDeTelas.getInstance().getTelaClienteScene());
				}
			}
			catch (SenhaIncorretaException e) {
				mensagem.setText("Senha incorreta");
			}
			catch(UsuarioNaoEncontradoException i) {
				mensagem.setText("Usuario não encontrado");
			} catch(IOException e) {}
		}
	}
	
	public void cadastrar() {
		try {
			Main.changeScene(GerenciadorDeTelas.getInstance().getTelaClienteCadastroScene());
		} catch (IOException e) {}
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}
