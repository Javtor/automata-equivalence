package main.java.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import main.java.View.Login;
import main.java.View.Mealy;
import main.java.model.Automaton;

public class MealyController {

	
	private Mealy referencia;
	
	private Automaton a1;
	private Automaton a2;
	
	private ArrayList<String> stimulus;
	private ArrayList<String> states;
	private ArrayList<String> responses;
	
	private int t1;
	private int t2;
	
	private boolean Acomplete1;
	private boolean Acomplete2;
	
	
	public MealyController(Mealy referencia) {
		this.referencia = referencia;
		stimulus = referencia.getAlphabetStimulus();
		states = referencia.getAlphabetStates();
		responses = referencia.getAlphabetResponses();
		initView();
	}

	private void initView() {
		
		referencia.getAutomataTable1().setText("Estado Actual  -  Entrada  -  Estado Salida  -  Salida");
		referencia.getAutomataTable2().setText("Estado Actual  -  Entrada  -  Estado Salida  -  Salida");
		t1 = 1;
		t2 = 1;
		Acomplete1 = false;
		Acomplete2 = false;
		
		showNextT(t1,referencia.getAutomataTable1());
		showNextT(t2,referencia.getAutomataTable2());
		
		referencia.getInsertarA1().setOnAction(
				(ActionEvent event) -> {
					if(correctT(referencia.getAutomataValues1())) {
					    completeT(referencia.getAutomataValues1().getText(), referencia.getAutomataTable1());
						if(t1+1>stimulus.size()*states.size()) {
							Acomplete1 = true;
							referencia.getInsertarA1().setDisable(true);
							showAlert("Automata 1 completo!", "Genial!");
						}else {
							t1++;
							showNextT(t1,referencia.getAutomataTable1());
						}
					}else {
						showAlert("Formato incorrecto", "Error");
					}
				});
		
		
		referencia.getInsertarA2().setOnAction(
				(ActionEvent event) -> {
					if(correctT(referencia.getAutomataValues2())) {
					    completeT(referencia.getAutomataValues2().getText(), referencia.getAutomataTable2());
						if(t1+1>stimulus.size()*states.size()) {
							Acomplete2 = true;
							referencia.getInsertarA2().setDisable(true);
							showAlert("Automata 2 completo!", "Genial!");
						}else {
							t2++;
							showNextT(t2,referencia.getAutomataTable2());
						}
					}else {
						showAlert("Formato incorrecto", "Error");
					}
				});
		
		referencia.getComparar().setOnAction(
				(ActionEvent event) -> {
					if(Acomplete1 && Acomplete2) {
						
					}else {
						
					}
				});
		
		
		referencia.getnDiccionario().setOnAction(
				(ActionEvent event) -> {
					Login login = new Login();
					login.show();
					referencia.close();
				});
		
	}
	
	public void showAlert(String message1, String message2) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(message2);
		alert.setContentText(message1);
		alert.showAndWait();
	}

	private boolean correctT(TextField automataValues) {
		boolean work = true;
		String info[] = automataValues.getText().split(",");
		if(info.length != 2)return false;
		for (int i = 0; i < info.length && work; i++) {
			if(i == 0 && !states.contains(info[i])){
				work = false;
			}else if(i == 1 && !responses.contains(info[i])){
				work = false;
			}
		}
		return work;
	}

	private void showNextT(int t, TextArea textArea) {
		String a = states.get((t-1)%states.size());
		String b = stimulus.get((t-1)/states.size());
		textArea.setText(textArea.getText()+"\n"+a+"            |            "+b+"            |            ");
	}
	
	private void completeT(String val, TextArea textArea) {
		String info[] = val.split(",");
		textArea.setText(textArea.getText()+info[0]+"            |            "+info[1]);
	}
	

}
