package main.java.Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import main.java.View.Login;
import main.java.View.Mealy;
import main.java.View.Moore;

public class LoginController{

	private Login referencia;
	
	ArrayList<String> AlphabetStatesA1;
	ArrayList<String> AlphabetStimulusA1;
	ArrayList<String> AlphabetResponsesA1;
	
	ArrayList<String> AlphabetStatesA2;
	ArrayList<String> AlphabetStimulusA2;
	ArrayList<String> AlphabetResponsesA2;
	
	public LoginController(Login referencia) {
		this.referencia = referencia;
		initView();
	}
	
	
	
	private void initView() {
		referencia.getConectMealy().setOnAction(
				(ActionEvent event) -> {
					AlphabetResponsesA1 = new ArrayList();
					AlphabetStimulusA1 = new ArrayList();
					AlphabetStatesA1 = new ArrayList();
					AlphabetResponsesA2 = new ArrayList();
					AlphabetStimulusA2 = new ArrayList();
					AlphabetStatesA2 = new ArrayList();
					boolean work1 = checkAlphabet(referencia.getEstadoTF().getText(),AlphabetStatesA1);
					boolean work2 = checkAlphabet(referencia.getEstimulosTF().getText(), AlphabetStimulusA1);
					boolean work3 = checkAlphabet(referencia.getRespuestaTF().getText(), AlphabetResponsesA1);
					
					boolean work4 = checkAlphabet(referencia.getEstadoTF2().getText(),AlphabetStatesA2);
					boolean work5 = checkAlphabet(referencia.getEstimulosTF2().getText(), AlphabetStimulusA2);
					boolean work6 = checkAlphabet(referencia.getRespuestaTF2().getText(), AlphabetResponsesA2);
					if(!work1){
						showAlert("El alfabeto de estados del automata 1 no tiene el formato correcto");
					}
					if(!work2){
						showAlert("El alfabeto de estimulos del automata 1 no tiene el formato correcto");
					}
					if(!work3){
						showAlert("El alfabeto de respuestas del automata 1 no tiene el formato correcto");
					}
					
					if(!work4){
						showAlert("El alfabeto de estados del automata 2 no tiene el formato correcto");
					}
					if(!work5){
						showAlert("El alfabeto de estimulos del automata 2 no tiene el formato correcto");
					}
					if(!work6){
						showAlert("El alfabeto de respuestas del automata 2 no tiene el formato correcto");
					}
					
					if(work1 && work2 && work3 && work4 && work5 && work6) {
						Mealy mealy = new Mealy(AlphabetStatesA1,AlphabetStimulusA1,AlphabetResponsesA1,AlphabetStatesA2,AlphabetStimulusA2,AlphabetResponsesA2);
						mealy.show();
						referencia.close();
					}
				});
		
		referencia.getConectMoore().setOnAction(
				(ActionEvent event) -> {
					AlphabetResponsesA1 = new ArrayList();
					AlphabetStimulusA1 = new ArrayList();
					AlphabetStatesA1 = new ArrayList();
					AlphabetResponsesA2 = new ArrayList();
					AlphabetStimulusA2 = new ArrayList();
					AlphabetStatesA2 = new ArrayList();
					
					boolean work1 = checkAlphabet(referencia.getEstadoTF().getText(),AlphabetStatesA1);
					boolean work2 = checkAlphabet(referencia.getEstimulosTF().getText(), AlphabetStimulusA1);
					boolean work3 = checkAlphabet(referencia.getRespuestaTF().getText(), AlphabetResponsesA1);
					
					boolean work4 = checkAlphabet(referencia.getEstadoTF2().getText(),AlphabetStatesA2);
					boolean work5 = checkAlphabet(referencia.getEstimulosTF2().getText(), AlphabetStimulusA2);
					boolean work6 = checkAlphabet(referencia.getRespuestaTF2().getText(), AlphabetResponsesA2);
					if(!work1){
						showAlert("El alfabeto de estados del automata 1 no tiene el formato correcto");
					}
					if(!work2){
						showAlert("El alfabeto de estimulos del automata 1 no tiene el formato correcto");
					}
					if(!work3){
						showAlert("El alfabeto de respuestas del automata 1 no tiene el formato correcto");
					}
					
					if(!work4){
						showAlert("El alfabeto de estados del automata 2 no tiene el formato correcto");
					}
					if(!work5){
						showAlert("El alfabeto de estimulos del automata 2 no tiene el formato correcto");
					}
					if(!work6){
						showAlert("El alfabeto de respuestas del automata 2 no tiene el formato correcto");
					}
					
					if(work1 && work2 && work3 && work4 && work5 && work6) {
						Moore moore = new Moore(AlphabetStatesA1,AlphabetStimulusA1,AlphabetResponsesA1,AlphabetStatesA2,AlphabetStimulusA2,AlphabetResponsesA2);
						moore.show();
						referencia.close();
					}
					
					
				});
		
		referencia.setOnCloseRequest(
				(event)->{
					Platform.exit();
			        System.exit(0);
				}
				);
	}
	
	public void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText("Sigue las instrucciones");
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	
	public boolean checkAlphabet(String value,ArrayList<String> ref) {
		HashSet<String> rep = new HashSet<>();
		boolean works = true;
		String elements[] = value.split(",");
		for (int i = 0; i < elements.length && works; i++) {
			if(!elements[i].matches("[a-zA-Z0-9]+") || rep.contains(elements[i])) {
				works = false;
			}else {
				ref.add(elements[i]);
				rep.add(elements[i]);
				//System.out.println(elements[i]+" - "+rep.contains(elements[i]));
			}
		}
		return works;
	}

}
