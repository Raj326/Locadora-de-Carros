package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaAdminController implements Initializable{
	private GerenciadorDeTelas gerenciador;
	@FXML private Button cadastraCarro;
	@FXML private TableView<Car> tabela;
	@FXML private TableColumn<Car, String> modeloCol;
    @FXML private TableColumn<Car, String> placaCol;
    @FXML private TableColumn<Car, Boolean> alugadoCol;
    
    public void cadastraCarro() {
    	this.gerenciador = GerenciadorDeTelas.getInstance();
    	try {
    	Main.changeScene(gerenciador.getTelaCadastroCarro());
    	} catch(IOException e) {
    		System.out.println("Erro ao tentar carregar tela de cadastro");
    	}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	modeloCol.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		placaCol.setCellValueFactory(new PropertyValueFactory <>("placa"));
		alugadoCol.setCellValueFactory(new PropertyValueFactory<>("alugado"));
		tabela.setItems(listaDeCarros());
	}
    
    private ObservableList<Car> listaDeCarros() {
    	return FXCollections.observableArrayList(new Car("Fusca", "BR 666", true));
    }
    
    //Classe modelo para o preenchimento da tabela
    public static class Car {
    	private final SimpleStringProperty modelo;
    	private final SimpleStringProperty placa;
    	private final SimpleBooleanProperty alugado;
    	
    	public Car(String modelo, String placa, Boolean alugado) {
    		this.modelo = new SimpleStringProperty(modelo);
    		this.placa = new SimpleStringProperty(placa);
    		this.alugado = new SimpleBooleanProperty(alugado);
    	}
    	
    	public String getModelo() {
    		return modelo.get();
    	}
    	
		public SimpleStringProperty modeloProperty() {
			return modelo;
		}
		
		public String getPlaca() {
			return placa.get();
		}

		public SimpleStringProperty placaProperty() {
			return placa;
		}
		
		public Boolean isAlugado() {
			return alugado.getValue();
		}

		public SimpleBooleanProperty alugadoProperty() {
			return alugado;
		}
    }

}
