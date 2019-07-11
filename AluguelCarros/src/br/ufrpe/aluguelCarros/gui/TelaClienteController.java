package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.aluguelCarros.negocio.Fachada;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaClienteController implements Initializable {
    private Carro carroSelecionado; // Atributo para guardar carro selecionado na tabela 
	
	@FXML
    private CheckBox ar;

    @FXML
    private CheckBox airbag;

    @FXML
    private CheckBox cambio;

    @FXML
    private CheckBox direcao;

    @FXML
    private CheckBox freio;

    @FXML
    private CheckBox trava;
    
    @FXML
    private Button filtrar;
    
    @FXML
    private Button selecionar;

    @FXML
    private TableView<Carro> tabela;

    @FXML
    private TableColumn<Carro, String> modeloCol;

    @FXML
    private TableColumn<Carro, Float> precoCol;

    @FXML
    private TableColumn<Carro, Integer> assentosCol;

    @FXML
    private TableColumn<Carro, String> cilindradasCol;
    
    public void initialize(URL location, ResourceBundle resources) {
    	modeloCol.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		precoCol.setCellValueFactory(new PropertyValueFactory <>("preco"));
		assentosCol.setCellValueFactory(new PropertyValueFactory<>("passageiros"));
		cilindradasCol.setCellValueFactory(new PropertyValueFactory<>("motor"));
		tabela.setItems(listaDeCarros());
	}
    
    private ObservableList<Carro> listaDeCarros() {
    	ObservableList<Carro> resultado = FXCollections.observableArrayList();
    	resultado.addAll(Fachada.getInstance().listarCarros());
    	return resultado;
    }
    
    public void filtrar() {
    	ObservableList<Carro> resultado = FXCollections.observableArrayList();
    	List<Carro> carros = Fachada.getInstance().filtrar(ar.isSelected(), airbag.isSelected(), cambio.isSelected(), 
    			direcao.isSelected(), freio.isSelected(), trava.isSelected());
    	resultado.addAll(carros);
    	tabela.setItems(resultado);
    }
    
    public void selecionar() {
    	this.carroSelecionado = tabela.getSelectionModel().getSelectedItem();
    	if (carroSelecionado != null) {
    		try {
    			Main.changeScene(GerenciadorDeTelas.getInstance().getTelaDetalhesCarroScene());
    		} catch (IOException e) {}
    	}
    	else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setTitle("Aviso");
            alert.setContentText("Selecione um carro na tabela");
            alert.show();
        }
    }
    
    public Carro getCarroSelecionado() {
    	return this.carroSelecionado;
    }
    
}
