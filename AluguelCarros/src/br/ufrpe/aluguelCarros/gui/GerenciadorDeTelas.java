package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TabPane;

public class GerenciadorDeTelas {
	private static GerenciadorDeTelas instance;
    
    private Scene telaInicialScene;
    
    private Scene telaAdminScene;
    private TelaAdminController telaAdminController;
    
    private Scene telaCadastroCarroScene;
    
    private GerenciadorDeTelas() { 
        this.initialize(); 
    }
    
    public static GerenciadorDeTelas getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeTelas();
        }
        return instance;
    }
    
    private void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane mainPane = fxmlLoader.load(getClass().getResource("TelaInicial.fxml").openStream());            
            this.telaInicialScene = new Scene(mainPane);
            
            fxmlLoader = new FXMLLoader();
            TabPane telaAdminPane = fxmlLoader.load(getClass().getResource("TelaAdmin.fxml").openStream());           
            this.telaAdminScene = new Scene(telaAdminPane);
            this.telaAdminController = (TelaAdminController) fxmlLoader.getController();
            
            fxmlLoader = new FXMLLoader();
            Pane telaCadastroCarro = fxmlLoader.load(getClass().getResource("TelaCadastroCarro.fxml").openStream());           
            this.telaCadastroCarroScene = new Scene(telaCadastroCarro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //getters
    public Scene getTelaInicial() {
    	return telaInicialScene;
    }
    
    public Scene getTelaAdmin() {
    	return telaAdminScene;
    }
    
    public TelaAdminController getTelaAdminController() {
    	return this.telaAdminController;
    }
    
    public Scene getTelaCadastroCarro() {
    	return telaCadastroCarroScene;
    }
}
