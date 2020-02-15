package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alertas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemVendedor;
	
	@FXML
	private MenuItem menuItemDepartamento;
	
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemVendedorAcction() {
		System.out.println("onMenuItemVendedorAcction");

	}
	
	@FXML
	public void onMenuItemDepartamentoAcction() {
		System.out.println("onMenuItemDepartamentoAcction");

	}
	
	@FXML
	public void onMenuItemSobreAcction() {
		LoadView("/gui/Sobre.fxml");

	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	private synchronized void LoadView (String absoluto) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluto));
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());
		}
		catch (IOException e) {
			Alertas.showAlert("IOException", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}
}
