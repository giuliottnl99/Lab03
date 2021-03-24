package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	Dictionary englishDictionary=new Dictionary();
	Dictionary italianDictionary=new Dictionary();
	String dictionarySetted = "English";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea areaDaCoreggere;

    @FXML
    private TextArea wrongWordsList;

    @FXML
    private Label labelErrori;

    @FXML
    private Label labelTimeUsed;

    @FXML
    void check(ActionEvent event) {
    	String toBeCorrected = areaDaCoreggere.getText().toLowerCase();
    	if(dictionarySetted.equals("English")) {
    		String corrected = englishDictionary.printableWrongWords(toBeCorrected);
    		wrongWordsList.setText(corrected);
    		labelErrori.setText(String.valueOf(englishDictionary.numberWrongWords(toBeCorrected)));
    	}
    	if(dictionarySetted.equals("Italian")) {
    		String corrected = italianDictionary.printableWrongWords(toBeCorrected);
    		wrongWordsList.setText(corrected);
    		labelErrori.setText(String.valueOf(italianDictionary.numberWrongWords(toBeCorrected)));
    	}
    	
    	

    }

    @FXML
    void choosedEnglish(ActionEvent event) throws IOException {
    	if(englishDictionary.getAllowedWords()==null) {
    		englishDictionary.loadDictionary("English.txt");
    	}
    	dictionarySetted="English";
    }

    @FXML
    void choosedItalian(ActionEvent event) throws IOException {
    	if(italianDictionary.getAllowedWords()==null) {
    		italianDictionary.loadDictionary("English.txt");
    	}
    	dictionarySetted="Italian";
    }

    @FXML
    void clear(ActionEvent event) {
    	labelErrori.setText("0");
    	wrongWordsList.setText("");
    	

    }

    @FXML
    void initialize() {
        assert areaDaCoreggere != null : "fx:id=\"areaDaCoreggere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert wrongWordsList != null : "fx:id=\"wrongWordsList\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelErrori != null : "fx:id=\"labelErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelTimeUsed != null : "fx:id=\"labelTimeUsed\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
