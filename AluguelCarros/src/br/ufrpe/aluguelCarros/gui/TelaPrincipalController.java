package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPrincipalController {
	//private GerenciadorDeTelas gerenciador = GerenciadorDeTelas.getInstance(); 
	@FXML
	private Button locador;
	@FXML
	private Button locatario;
	
	public void showLocatarioLogin() {
		/*try{
			Main.changeScene(gerenciador.getTelaAdmin());
		}catch(IOException e) {
			System.out.println("Erro ao tentar carregar nova tela");
		}*/
	}
}