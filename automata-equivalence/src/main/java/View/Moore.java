package main.java.View;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Controller.MooreController;


public class Moore extends Stage {

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
	
	ArrayList<String> AlphabetStates2;
	ArrayList<String> AlphabetStimulus2;
	ArrayList<String> AlphabetResponses2;
	
	MooreController controller;
	
	
	//Controlador
	
	
	public Moore(ArrayList<String> s,ArrayList<String> st, ArrayList<String> r, ArrayList<String> s2, ArrayList<String> st2, ArrayList<String> r2 ) {
		
		AlphabetResponses = r;
		AlphabetStates = s;
		AlphabetStimulus = st;
		
		AlphabetResponses2 = r2;
		AlphabetStates2 = s2;
		AlphabetStimulus2 = st2;
		
		instrucciones = new Label("Dado un estado inicial y un estimulo responda el estado respuesta y el simbolo de respuesta separados por comas.\n");
		
		Resultado = new Label("Los automatas son: \n\n");
		
		automata1 = new Label("Tabla del automata 1 ");
		automataTable1 = new TextArea();
		insertarLA1 = new Label("Indique el estado de respuesta y la respuesta separados por una coma \nque corresponden a la ultima fila de la tabla \nEj: A,1");
		automataValues1 = new TextField();
		insertarA1 = new Button("Insertar");
		
		automata2 = new Label("Tabla del automata 2 ");
		automataTable2 = new TextArea();
		insertarLA2 = new Label("Indique el estado de respuesta y la respuesta separados por una coma \nque corresponden a la ultima fila de la tabla \nEj: A,1");
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
		c1.getChildren().add(new Label());
		c1.getChildren().add(new Label("Alfabeto de estados 1"));
		c1.getChildren().add(new Label(Arrays.toString(AlphabetStates.toArray())));
		c1.getChildren().add(new Label());
		c1.getChildren().add(new Label("Alfabeto de estimulos 1"));
		c1.getChildren().add(new Label(Arrays.toString(AlphabetStimulus.toArray())));
		c1.getChildren().add(new Label());
		c1.getChildren().add(new Label("Alfabeto de respuestas 1"));
		c1.getChildren().add(new Label(Arrays.toString(AlphabetResponses.toArray())));
		
		
		VBox c2 = new VBox();
		c2.getChildren().add(automata2);
		c2.getChildren().add(automataTable2);
		c2.getChildren().add(insertarLA2);
		c2.getChildren().add(automataValues2);
		c2.getChildren().add(insertarA2);
		c2.getChildren().add(new Label("Alfabeto de estados 2"));
		c2.getChildren().add(new Label(Arrays.toString(AlphabetStates2.toArray())));
		c2.getChildren().add(new Label());
		c2.getChildren().add(new Label("Alfabeto de estimulos 2"));
		c2.getChildren().add(new Label(Arrays.toString(AlphabetStimulus2.toArray())));
		c2.getChildren().add(new Label());
		c2.getChildren().add(new Label("Alfabeto de respuestas 2"));
		c2.getChildren().add(new Label(Arrays.toString(AlphabetResponses2.toArray())));
		
		cG.getChildren().add(c1);
		cG.getChildren().add(c2);
		
		root.getChildren().add(instrucciones);
		root.getChildren().add(Resultado);
		root.getChildren().add(cG);
		root.getChildren().add(new Label());
		root.getChildren().add(comparar);
		root.getChildren().add(new Label());
		root.getChildren().add(nDiccionario);
		
		
		scene = new Scene(root,800,600);
		this.setScene(scene);
		
		controller = new MooreController(this);
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


	public ArrayList<String> getAlphabetStates2() {
		return AlphabetStates2;
	}


	public ArrayList<String> getAlphabetStimulus2() {
		return AlphabetStimulus2;
	}


	public ArrayList<String> getAlphabetResponses2() {
		return AlphabetResponses2;
	}
	
	

	
}
