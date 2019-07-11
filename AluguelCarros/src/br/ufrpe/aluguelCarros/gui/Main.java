package br.ufrpe.aluguelCarros.gui;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage stage;
	private GerenciadorDeTelas gerenciador = GerenciadorDeTelas.getInstance();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		//Pane root = FXMLLoader.load(getClass().getResource("TelaAdmin.fxml"));
		primaryStage.setScene(gerenciador.getTelaLoginScene());
		primaryStage.show();
	}
	
	public static void changeScene(Scene cena) throws IOException{
		stage.setScene(cena);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
