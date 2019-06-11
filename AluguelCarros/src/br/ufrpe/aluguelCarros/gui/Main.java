//criar classe fachada para implementar o padrão de projeto singleton
package br.ufrpe.aluguelCarros.gui;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Main extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		Pane root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void changeScene(String cena) throws IOException{
		Pane root = null;
		root = FXMLLoader.load(Main.class.getResource(cena));
		stage.setScene(new Scene(root));
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
