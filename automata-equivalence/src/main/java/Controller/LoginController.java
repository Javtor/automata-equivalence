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
	
	ArrayList<String> AlphabetStates;
	ArrayList<String> AlphabetStimulus;
	ArrayList<String> AlphabetResponses;
	
	public LoginController(Login referencia) {
		this.referencia = referencia;
		initView();
	}
	
	
	
	private void initView() {
		referencia.getConectMealy().setOnAction(
				(ActionEvent event) -> {
					AlphabetResponses = new ArrayList();
					AlphabetStimulus = new ArrayList();
					AlphabetStates = new ArrayList();
					boolean work1 = checkAlphabet(referencia.getEstadoTF().getText(),AlphabetStates);
					boolean work2 = checkAlphabet(referencia.getEstimulosTF().getText(), AlphabetStimulus);
					boolean work3 = checkAlphabet(referencia.getRespuestaTF().getText(), AlphabetResponses);
					if(!work1){
						showAlert("El alfabeto de estados no tiene el formato correcto");
					}
					if(!work2){
						showAlert("El alfabeto de estimulos no tiene el formato correcto");
					}
					if(!work3){
						showAlert("El alfabeto de respuestas no tiene el formato correcto");
					}
					if(work1 && work2 && work3) {
						System.out.println(Arrays.toString(AlphabetResponses.toArray()));
						Mealy mealy = new Mealy(AlphabetStates,AlphabetStimulus,AlphabetResponses);
						mealy.show();
						referencia.close();
					}
				});
		
		referencia.getConectMoore().setOnAction(
				(ActionEvent event) -> {
					AlphabetResponses = new ArrayList();
					AlphabetStimulus = new ArrayList();
					AlphabetStates = new ArrayList();
					boolean work1 = checkAlphabet(referencia.getEstadoTF().getText(),AlphabetStates);
					boolean work2 = checkAlphabet(referencia.getEstimulosTF().getText(), AlphabetStimulus);
					boolean work3 = checkAlphabet(referencia.getRespuestaTF().getText(), AlphabetResponses);
					if(!work1){
						showAlert("El alfabeto de estados no tiene el formato correcto");
					}
					if(!work2){
						showAlert("El alfabeto de estimulos no tiene el formato correcto");
					}
					if(!work3){
						showAlert("El alfabeto de respuestas no tiene el formato correcto");
					}
					if(work1 && work2 && work3) {
						Moore moore = new Moore(AlphabetStates,AlphabetStimulus,AlphabetResponses);
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
