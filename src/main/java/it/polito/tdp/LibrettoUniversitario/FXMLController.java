package it.polito.tdp.LibrettoUniversitario;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.LibrettoUniversitario.model.Libretto;
import it.polito.tdp.LibrettoUniversitario.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) 
    {
    	String nome = txtNome.getText();
    	int punti = cmbPunti.getValue();
    	//restituisce il valore attualmente 
    	//scelto dall'utente
    	
    	//controlli di validittà
    	
    	model.add(new Voto(nome, punti));
    	
    	String contenutoLibretto = model.toString();
    	txtVoti.setText(contenutoLibretto);
    }
    
    public void setModel(Libretto model)
    {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbPunti.getItems().clear();
        for(int p=18; p<=30; p++)
        {
        	cmbPunti.getItems().add(p);
        }

    }

}
