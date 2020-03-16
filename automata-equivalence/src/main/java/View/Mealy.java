package main.java.View;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Controller.LoginController;
import main.java.Controller.MealyController;


public class Mealy extends Stage {

	private Scene scene;
	
	private Label instrucciones;
	
	private Label automata1;
	private Label automata2;
	private Label Resultado;
	private Label insertarLA1;
	private Label insertarLA2;
	
	private TextArea automataTable1;
	private TextField automataValues1;
	private TextArea automataTable2;
	private TextField automataValues2;
	
	
	private Button insertarA1;
	private Button insertarA2;
	private Button comparar;
	private Button nDiccionario;
	
	ArrayList<String> AlphabetStates;
	ArrayList<String> AlphabetStimulus;
	ArrayList<String> AlphabetResponses;
	
	MealyController controller;
	
	
	//Controlador
	
	
	public Mealy(ArrayList<String> s,ArrayList<String> st, ArrayList<String> r ) {
		
		AlphabetResponses = r;
		AlphabetStates = s;
		AlphabetStimulus = st;
		
		instrucciones = new Label("Dado un estado inicial y un estimulo responda el estado respuesta y el simbolo de respuesta separados por comas.\n");
		
		Resultado = new Label("Los automatas son: \n\n");
		
		automata1 = new Label("Tabla del automata 1 ");
		automataTable1 = new TextArea();
		insertarLA1 = new Label("Indique el estado de salida y la respuesta separados por coma \nque corresponden a la ultima fila de la tabla");
		automataValues1 = new TextField();
		insertarA1 = new Button("Insertar");
		
		automata2 = new Label("Tabla del automata 2 ");
		automataTable2 = new TextArea();
		insertarLA2 = new Label("Indique el estado de salida y la respuesta separados por coma \nque corresponden a la ultima fila de la tabla");
		automataValues2 = new TextField();
		insertarA2 = new Button("Insertar");
		
		nDiccionario = new Button("Cambiar Diccionarios");
		comparar = new Button("COMPARAR AUTOMATAS!");

		
		VBox root = new VBox();
		
		HBox cG = new HBox();
		
		VBox c1 = new VBox();
		c1.getChildren().add(automata1);
		c1.getChildren().add(automataTable1);
		c1.getChildren().add(insertarLA1);
		c1.getChildren().add(automataValues1);
		c1.getChildren().add(insertarA1);
		
		VBox c2 = new VBox();
		c2.getChildren().add(automata2);
		c2.getChildren().add(automataTable2);
		c2.getChildren().add(insertarLA2);
		c2.getChildren().add(automataValues2);
		c2.getChildren().add(insertarA2);
		
		cG.getChildren().add(c1);
		cG.getChildren().add(c2);
		
		root.getChildren().add(instrucciones);
		root.getChildren().add(Resultado);
		root.getChildren().add(cG);
		root.getChildren().add(comparar);
		root.getChildren().add(nDiccionario);
		
		scene = new Scene(root,700,500);
		this.setScene(scene);
		
		controller = new MealyController(this);
	}
	

	public Label getInstrucciones() {
		return instrucciones;
	}


	public Label getAutomata1() {
		return automata1;
	}


	public Label getAutomata2() {
		return automata2;
	}


	public Label getResultado() {
		return Resultado;
	}


	public Label getInsertarLA1() {
		return insertarLA1;
	}


	public Label getInsertarLA2() {
		return insertarLA2;
	}


	public TextArea getAutomataTable1() {
		return automataTable1;
	}


	public TextField getAutomataValues1() {
		return automataValues1;
	}


	public TextArea getAutomataTable2() {
		return automataTable2;
	}


	public TextField getAutomataValues2() {
		return automataValues2;
	}


	public Button getInsertarA1() {
		return insertarA1;
	}


	public Button getInsertarA2() {
		return insertarA2;
	}


	public Button getComparar() {
		return comparar;
	}


	public Button getnDiccionario() {
		return nDiccionario;
	}


	public ArrayList<String> getAlphabetStates() {
		return AlphabetStates;
	}


	public ArrayList<String> getAlphabetStimulus() {
		return AlphabetStimulus;
	}


	public ArrayList<String> getAlphabetResponses() {
		return AlphabetResponses;
	}


	public MealyController getController() {
		return controller;
	}
	
	

	
}
