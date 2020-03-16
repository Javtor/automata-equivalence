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
	
	private Label estadosLabel2;
	private TextField estadoTF2;
	private Label estimulosLabel2;
	private TextField estimulosTF2;
	private Label respuestaLabel2;
	private TextField respuestaTF2;
	
	private Button conectMealy;
	private Button conectMoore;
	
	LoginController controller;
	
	
	//Controlador
	
	
	public Login() {
		
		estadosLabel = new Label("Estados del automata 1");
		estimulosLabel = new Label("Estimulos del automata 1");
		respuestaLabel = new Label("Respuestas del automata 1");
		
		estadoTF = new TextField("A,B,C");
		estimulosTF = new TextField("1,0,2");
		respuestaTF = new TextField("a,b,c");
		
		estadosLabel2 = new Label("Estados del automata 2");
		estimulosLabel2 = new Label("Estimulos del automata 2");
		respuestaLabel2 = new Label("Respuestas del automata 2");
		
		estadoTF2 = new TextField("D,E,F");
		estimulosTF2 = new TextField("4,5");
		respuestaTF2 = new TextField("2,1,3");
		
		instruccionesL = new Label("Por favor ingrese simbolos alfanumericos distintos de tamaño 1 que compongan los alfabetos, separados por una coma \nEj: A,B,C ó 1,2,3,4 \n ");

		conectMealy = new Button("Construir autómatas de Mealy");
		conectMoore = new Button("Construir autómatas de Moore");
		
		VBox root = new VBox();
		root.getChildren().add(instruccionesL);
		root.getChildren().add(estadosLabel);
		root.getChildren().add(estadoTF);
		root.getChildren().add(estimulosLabel);
		root.getChildren().add(estimulosTF);
		root.getChildren().add(respuestaLabel);
		root.getChildren().add(respuestaTF);
		
		root.getChildren().add(estadosLabel2);
		root.getChildren().add(estadoTF2);
		root.getChildren().add(estimulosLabel2);
		root.getChildren().add(estimulosTF2);
		root.getChildren().add(respuestaLabel2);
		root.getChildren().add(respuestaTF2);
		
		root.getChildren().add(new Label());
		root.getChildren().add(conectMealy);
		root.getChildren().add(new Label());
		root.getChildren().add(conectMoore);
		scene = new Scene(root,800,400);
		this.setScene(scene);
		controller = new LoginController(this);
	}

	public Label getEstadosLabel2() {
		return estadosLabel2;
	}


	public TextField getEstadoTF2() {
		return estadoTF2;
	}


	public Label getEstimulosLabel2() {
		return estimulosLabel2;
	}


	public TextField getEstimulosTF2() {
		return estimulosTF2;
	}


	public Label getRespuestaLabel2() {
		return respuestaLabel2;
	}


	public TextField getRespuestaTF2() {
		return respuestaTF2;
	}


	public LoginController getController() {
		return controller;
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
