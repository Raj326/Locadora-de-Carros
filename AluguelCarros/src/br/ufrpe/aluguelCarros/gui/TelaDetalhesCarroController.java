package br.ufrpe.aluguelCarros.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaDetalhesCarroController implements Initializable{
	@FXML 
	private Label modelo;
	@FXML 
	private Label informacoes;
	@FXML 
	private Label preco;
	@FXML 
	private Button alugar;
	@FXML 
	private Button voltar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Carro carro = GerenciadorDeTelas.getInstance().getTelaClienteController().getCarroSelecionado();
		/*modelo.setText(carro.getModelo());
		String info = "Categoria: " + carro.getCategoria() + "\nPossui: ";
		if(carro.isAr() == true) info += "\nAr condicionado ";
		if(carro.isAirbag() == true) info += "\nAirbag";
		if(carro.isCambio() == true) info += "\nCâmbio automático";
		if(carro.isDirecao() == true) info += "\nDireção hidráulica";
		if(carro.isFreio() == true) info += "\nFreios ABS";
		if(carro.isTrava() == true) info += "\nTrava elétrica";
		informacoes.setText(info); */
		//preco.setText("Preço cobrado por dia em reais: R$ " + carro.getPreco());
	}
	
	public void alugar() {
		
	}
	
	public void voltar()  {
		try {
		Main.changeScene(GerenciadorDeTelas.getInstance().getTelaClienteScene());
		} catch (IOException e) {
		}
	}

	
}
