package br.ufrpe.aluguelCarros.gui;

import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Categoria;

import java.io.IOException;

import br.ufrpe.aluguelCarros.exception.ElementoJaExisteException;
import br.ufrpe.aluguelCarros.negocio.Fachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TelaCadastroCarroController {
	private Fachada fachada = Fachada.getInstance();
	private GerenciadorDeTelas gerenciador;
	
	@FXML
	private CheckBox checa_ar;
	@FXML
	private CheckBox checa_airbag;
	@FXML
	private CheckBox checa_cambio;
	@FXML
	private CheckBox checa_direcao;
	@FXML
	private CheckBox checa_freio;
	@FXML
	private CheckBox checa_trava;
	@FXML
	private TextField modelo;
	@FXML
	private TextField assentos;
	@FXML
	private TextField motor;
	@FXML
	private TextField preco;
	@FXML 
	private TextField placa;
	@FXML
	private Button confirma;
	@FXML 
	private Button voltar;
	@FXML
	private Label mensagem;
	@FXML
	private ChoiceBox<Categoria> categoria;
	
	
	@FXML
	public void initialize() {
		ObservableList<Categoria> itens = FXCollections.observableArrayList();
		itens.addAll(Categoria.values());
		this.categoria.setItems(itens);
	}
	
	public void salvarCarro() {
		if(modelo.getText().isEmpty() || assentos.getText().isEmpty() || motor.getText().isEmpty() || placa.getText().isEmpty()) {
			mensagem.setText("Não deixe os campos de texto em vazio");
		}
		else {
			try {
				int numAssentos = Integer.parseInt(assentos.getText());
				Carro carro = new Carro(modelo.getText(), placa.getText(), motor.getText(), numAssentos, checa_ar.isSelected(), 
						checa_airbag.isSelected(), checa_cambio.isSelected(), checa_direcao.isSelected(), checa_freio.isSelected(),
						checa_trava.isSelected(), Float.parseFloat(preco.getText()), categoria.getValue());
				fachada.inserir(carro);
				gerenciador = GerenciadorDeTelas.getInstance();
				Main.changeScene(gerenciador.getTelaAdmin());
			} catch (NumberFormatException e) {
				mensagem.setText("Número de assentos inválido");
			} catch (ElementoJaExisteException i) {
				mensagem.setText("Carro com placa igual já joi cadastrado");
			} catch (IOException o) {
				mensagem.setText("Erro ao carregar nova tela");
			}
			finally {
				GerenciadorDeTelas.getInstance().getTelaAdminController().atualizaTabela();
				this.limparCampos();
			}
		}
	}
	
	private void limparCampos() {
		modelo.setText("");
		placa.setText("");
		motor.setText("");
		assentos.setText("");
		preco.setText("");
		checa_ar.setSelected(false);
		checa_airbag.setSelected(false);
		checa_cambio.setSelected(false);
		checa_direcao.setSelected(false);
		checa_freio.setSelected(false);
		checa_trava.setSelected(false);
		categoria.getItems().clear();
	}
	
	public void voltar()  {
		gerenciador = GerenciadorDeTelas.getInstance();
		try {
		Main.changeScene(gerenciador.getTelaAdmin());
		} catch (IOException e) {
			mensagem.setText("Erro ao carregar nova tela");
		}
	}
}
