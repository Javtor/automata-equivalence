package main.java.View;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Controller.LoginController;


public class Login extends Stage {

	private Scene scene;
	private Label instruccionesL;
	
	
	private Label estadosLabel;
	private TextField estadoTF;
	private Label estimulosLabel;
	private TextField estimulosTF;
	private Label respuestaLabel;
	private TextField respuestaTF;
	private Button conectMealy;
	private Button conectMoore;
	
	LoginController controller;
	
	
	//Controlador
	
	
	public Login() {
		
		estadosLabel = new Label("Estados");
		estimulosLabel = new Label("Estimulos");
		respuestaLabel = new Label("Respuestas");
		
		estadoTF = new TextField("A,B,C");
		estimulosTF = new TextField("1,0,2");
		respuestaTF = new TextField("2,1,3");
		
		instruccionesL = new Label("Por favor ingrese simbolos alfanumericos distintos de tamaño 1 que compongan los abecedarios separados por una coma \nEj: A,B,C ó 1,2,3,4 \n ");

		conectMealy = new Button("Construir maquinas de Mealy");
		conectMoore = new Button("Construir maquinas de Moore");
		
		VBox root = new VBox();
		root.getChildren().add(instruccionesL);
		root.getChildren().add(estadosLabel);
		root.getChildren().add(estadoTF);
		root.getChildren().add(estimulosLabel);
		root.getChildren().add(estimulosTF);
		root.getChildren().add(respuestaLabel);
		root.getChildren().add(respuestaTF);
		root.getChildren().add(conectMealy);
		root.getChildren().add(conectMoore);
		scene = new Scene(root,800,400);
		this.setScene(scene);
		controller = new LoginController(this);
	}


	public Label getEstadosLabel() {
		return estadosLabel;
	}


	public TextField getEstadoTF() {
		return estadoTF;
	}


	public Label getEstimulosLabel() {
		return estimulosLabel;
	}


	public TextField getEstimulosTF() {
		return estimulosTF;
	}


	public Button getConectMealy() {
		return conectMealy;
	}


	public Button getConectMoore() {
		return conectMoore;
	}


	public void setInstruccionesL(Label instruccionesL) {
		this.instruccionesL = instruccionesL;
	}


	public void setRespuestaLabel(Label respuestaLabel) {
		this.respuestaLabel = respuestaLabel;
	}


	public void setRespuestaTF(TextField respuestaTF) {
		this.respuestaTF = respuestaTF;
	}
	

	public Label getInstruccionesL() {
		return instruccionesL;
	}


	public Label getRespuestaLabel() {
		return respuestaLabel;
	}


	public TextField getRespuestaTF() {
		return respuestaTF;
	}

	
}
