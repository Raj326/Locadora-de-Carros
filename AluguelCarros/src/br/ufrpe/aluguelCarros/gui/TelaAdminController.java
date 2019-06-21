package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.aluguelCarros.negocio.Fachada;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
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
	@FXML private TableView<Carro> tabela;
	@FXML private TableColumn<Carro, String> modeloCol;
    @FXML private TableColumn<Carro, String> placaCol;
    @FXML private TableColumn<Carro, Boolean> alugadoCol;
    
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
    
    private ObservableList<Carro> listaDeCarros() {
    	ObservableList<Carro> resultado = FXCollections.observableArrayList();
    	resultado.addAll(Fachada.getInstance().listar());
    	return resultado;
    }
    
    public void atualizaTabela() {        
        ObservableList<Carro> result = FXCollections.observableArrayList();
        result.addAll(Fachada.getInstance().listar());        
        tabela.setItems(result);
    }
}
