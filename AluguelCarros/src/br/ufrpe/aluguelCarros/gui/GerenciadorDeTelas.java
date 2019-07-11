package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TabPane;

public class GerenciadorDeTelas {
	private static GerenciadorDeTelas instance;
    
    private Scene telaLoginScene;
    private TelaLoginController telaLoginController;
    
    private Scene telaClienteCadastroScene;
    
    private Scene telaDetalhesCarroScene;
    
    private Scene telaAdminScene;
    private TelaAdminController telaAdminController;
    
    private Scene telaClienteScene;
    private TelaClienteController telaClienteController;
    
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
            Pane mainPane = fxmlLoader.load(getClass().getResource("TelaLogin.fxml").openStream());            
            this.telaLoginScene = new Scene(mainPane);
            this.telaLoginController = (TelaLoginController) fxmlLoader.getController();
            
            fxmlLoader = new FXMLLoader();
            Pane telaClienteCadastro = fxmlLoader.load(getClass().getResource("TelaClienteCadastro.fxml").openStream());            
            this.telaClienteCadastroScene = new Scene(telaClienteCadastro);
            
            fxmlLoader = new FXMLLoader();
            Pane telaDetalhesCarro = fxmlLoader.load(getClass().getResource("TelaDetalhesCarro.fxml").openStream());            
            this.telaDetalhesCarroScene = new Scene(telaDetalhesCarro);
            
            fxmlLoader = new FXMLLoader();
            TabPane telaAdminPane = fxmlLoader.load(getClass().getResource("TelaAdmin.fxml").openStream());           
            this.telaAdminScene = new Scene(telaAdminPane);
            this.telaAdminController = (TelaAdminController) fxmlLoader.getController();
            
            fxmlLoader = new FXMLLoader();
            Pane telaCadastroCarro = fxmlLoader.load(getClass().getResource("TelaCadastroCarro.fxml").openStream());           
            this.telaCadastroCarroScene = new Scene(telaCadastroCarro);
            
            fxmlLoader = new FXMLLoader();
            TabPane telaCliente = fxmlLoader.load(getClass().getResource("TelaCliente.fxml").openStream());           
            this.telaClienteScene = new Scene(telaCliente);
            this.telaClienteController = (TelaClienteController) fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //getters
    public Scene getTelaLoginScene() {
    	return this.telaLoginScene;
    }
    
    public TelaLoginController getTelaLoginController() {
    	return this.telaLoginController;
    }
    
    public Scene getTelaClienteCadastroScene() {
    	return this.telaClienteCadastroScene;
    }
    
    public Scene getTelaAdmin() {
    	return this.telaAdminScene;
    }
    
    public TelaAdminController getTelaAdminController() {
    	return this.telaAdminController;
    }
    
    public Scene getTelaCadastroCarro() {
    	return this.telaCadastroCarroScene;
    }
    
    public Scene getTelaClienteScene() {
    	return this.telaClienteScene;
    }
    
    public TelaClienteController getTelaClienteController() {
    	return this.telaClienteController;
    }
    
    public Scene getTelaDetalhesCarroScene() {
    	return this.telaDetalhesCarroScene;
    }
}
