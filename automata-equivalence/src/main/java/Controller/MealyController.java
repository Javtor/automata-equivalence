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
import main.java.model.AutomataComparator;
import main.java.model.Automaton;
import main.java.model.MealyAutomaton;

public class MealyController {

	
	private Mealy referencia;
	
	private MealyAutomaton a1;
	private MealyAutomaton a2;
	
	private ArrayList<String> stimulus;
	private ArrayList<String> states;
	private ArrayList<String> responses;
	
	private ArrayList<String> stimulus2;
	private ArrayList<String> states2;
	private ArrayList<String> responses2;
	
	private int t1;
	private int t2;
	
	private boolean Acomplete1;
	private boolean Acomplete2;
	
	
	public MealyController(Mealy referencia) {
		this.referencia = referencia;
		stimulus = referencia.getAlphabetStimulus();
		states = referencia.getAlphabetStates();
		responses = referencia.getAlphabetResponses();
		
		stimulus2 = referencia.getAlphabetStimulus2();
		states2 = referencia.getAlphabetStates2();
		responses2 = referencia.getAlphabetResponses2();
		initView();
	}

	private void initView() {
		
		a2 = new MealyAutomaton(toArray(states.toArray()),toArray(stimulus.toArray()),toArray(responses.toArray()),states.get(0));
		a1 = new MealyAutomaton(toArray(states.toArray()),toArray(stimulus.toArray()),toArray(responses.toArray()),states.get(0));
		
		referencia.getAutomataTable1().setText("Estado Actual  -  Entrada  -  Estado Salida  -  Salida");
		referencia.getAutomataTable2().setText("Estado Actual  -  Entrada  -  Estado Salida  -  Salida");
		t1 = 1;
		t2 = 1;
		Acomplete1 = false;
		Acomplete2 = false;
		
		showNextT(t1,referencia.getAutomataTable1(),states,stimulus);
		showNextT(t2,referencia.getAutomataTable2(),states2,stimulus2);
		
		referencia.getInsertarA1().setOnAction(
				(ActionEvent event) -> {
					
					if(correctT(referencia.getAutomataValues1(),states,responses) || t1+1 > stimulus.size()*states.size()) {
					    
					    
					    if(t1 > stimulus.size()*states.size()) {
					    	//System.out.println(Arrays.toString(states.toArray())+ " - " +referencia.getAutomataValues1().getText());
					    	
					    	if(states.contains(referencia.getAutomataValues1().getText())){
					    		a1.setInitialState(referencia.getAutomataValues1().getText());
					    		Acomplete1 = true;
					    		referencia.getInsertarA1().setDisable(true);
								showAlert("Automata 1 completo!", "Genial!");
					    	}else {
					    		showAlert("Formato de simbolo inicial incorrecto", "Error");
					    	}
						}else if(t1<=stimulus.size()*states.size()) {
							completeT(referencia.getAutomataValues1().getText(), referencia.getAutomataTable1(),a1,t1,states,stimulus);
							t1++;
							if(t1<=stimulus.size()*states.size()) {
								showNextT(t1,referencia.getAutomataTable1(),states,stimulus);
							}else {
								referencia.getInsertarLA1().setText("Inserte el simbolo que reepresente el estado inicial \nEj: A");
							}
						}
					}else {
						showAlert("Formato incorrecto", "Error");
					}
				});
		
		
		referencia.getInsertarA2().setOnAction(
				(ActionEvent event) -> {
					if(correctT(referencia.getAutomataValues2(),states2,responses2) || t2+1 > stimulus2.size()*states2.size()) {
					   
						if(t2 > stimulus2.size()*states2.size()) {
					    	//System.out.println(Arrays.toString(states.toArray())+ " - " +referencia.getAutomataValues1().getText());
					    	
					    	if(states2.contains(referencia.getAutomataValues2().getText())){
					    		a2.setInitialState(referencia.getAutomataValues2().getText());
					    		Acomplete2 = true;
					    		referencia.getInsertarA2().setDisable(true);
								showAlert("Automata 2 completo!", "Genial!");
					    	}else {
					    		showAlert("Formato de simbolo inicial incorrecto", "Error");
					    	}
						}else if(t2<=stimulus2.size()*states2.size()) {
							completeT(referencia.getAutomataValues2().getText(), referencia.getAutomataTable2(),a2,t2,states2,stimulus2);
							t2++;
							if(t2<=stimulus2.size()*states2.size()) {
								showNextT(t2,referencia.getAutomataTable2(),states2,stimulus2);
							}else {
								referencia.getInsertarLA2().setText("Inserte el simbolo que reepresente el estado inicial \nEj: A");
							}
						}
					}else {
						showAlert("Formato incorrecto", "Error");
					}
				});
		
		referencia.getComparar().setOnAction(
				(ActionEvent event) -> {
					if(Acomplete1 && Acomplete2) {
						boolean ref = AutomataComparator.equals(a1, a2);
						showAlert("Los dos automatas son: " + (ref?"Iguales":"Diferentes"), "Resultado: ");
					}else {
						showAlert("Completa los automatas", "Error");
					}
				});
		
		
		referencia.getnDiccionario().setOnAction(
				(ActionEvent event) -> {
					Login login = new Login();
					login.show();
					referencia.close();
				});
		
	}
	
	private String[] toArray(Object[] array) {
		String out[] = new String[array.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = (String)array[i];
		}
		return out;
	}

	public void showAlert(String message1, String message2) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(message2);
		alert.setContentText(message1);
		alert.showAndWait();
	}

	private boolean correctT(TextField automataValues, ArrayList<String> states3, ArrayList<String> responses3) {
		boolean work = true;
		String info[] = automataValues.getText().split(",");
		if(info.length != 2)return false;
		for (int i = 0; i < info.length && work; i++) {
			if(i == 0 && !states3.contains(info[i])){
				work = false;
			}else if(i == 1 && !responses3.contains(info[i])){
				work = false;
			}
		}
		return work;
	}

	private void showNextT(int t, TextArea textArea,ArrayList<String> s,ArrayList<String> st) {
		String a = s.get((t-1)/s.size());
		String b = st.get((t-1)%s.size());
		textArea.setText(textArea.getText()+"\n"+a+"            |            "+b+"            |            ");
	}
	
	private void completeT(String val, TextArea textArea,MealyAutomaton a,int t,ArrayList<String> s,ArrayList<String> st) {
		String info[] = val.split(",");
		textArea.setText(textArea.getText()+info[0]+"            |            "+info[1]);
		a.addConection(st.get((t-1)%s.size()),s.get((t-1)/s.size()),info[0],info[1]);
	}
	

}
