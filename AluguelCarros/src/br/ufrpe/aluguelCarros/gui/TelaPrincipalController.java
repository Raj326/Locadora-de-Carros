package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPrincipalController {
	@FXML
	private Button locador;
	@FXML
	private Button locatario;
	private Main main;
	
	public void setMain(Main main) {
        this.main = main;
	}
	
	public void showLocatarioLogin() throws IOException {
		Main.changeScene("LocatarioLogin.fxml");
	}
}