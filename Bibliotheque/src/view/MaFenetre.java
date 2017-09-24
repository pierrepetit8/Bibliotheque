/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import static javafx.application.ConditionalFeature.FXML;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;
import metier.Bibliotheque;
import metier.Livre;

/**
 *
 * @author pipetit1
 */
public class MaFenetre {
    @FXML private Button addButton;
    @FXML private TextField nomLivre;
    @FXML private TextField nomAuteurField;
    @FXML private Text affichage;
    @FXML private Slider pageNumber;
    @FXML private Text nbPageText;
    @FXML private ListView<Livre> listeLivre;
    public Bibliotheque bibli = new Bibliotheque();
    private ListProperty listProperty = new SimpleListProperty();
    
    
    public void initialize() {
        bibli.ajouterLivre(new Livre("djlqjd", "dqod"));
        listProperty.set(FXCollections.observableArrayList(bibli.livres));
        listeLivre.itemsProperty().bind(listProperty);
        nbPageText.textProperty().bind(pageNumber.valueProperty().asString());
        //ObservableList<Livre> livres = FXCollections.observableArrayList(bibli.livres);
        listeLivre.setCellFactory(l->new ListCell<Livre>() {
            @Override
            protected void updateItem(Livre item, boolean empty) {
                super.updateItem(item, empty); 
                if (empty) {
                    textProperty().unbind();
                    setText(null);
                } else {
                    textProperty().bind(item.nameProperty());

                }
            }
        });
        playlistsList.setItems(obsPlaylists);
         
    }
    public void ajouterLivre() {
        String nomDuLivre = nomLivre.getText();
        String nomAuteur = nomAuteurField.getText();
        //pageNumber.valueProperty().addListener(new Listenner);
        
        
        
        
        Livre livre = new Livre(nomAuteur, nomDuLivre);
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setTitle("Confirmation de création");
        a.setHeaderText("Confirmez vous la création de ce livre?");
        a.setContentText(livre.toString());
        a.showAndWait();
        bibli.ajouterLivre(livre);
        System.out.println(livre);
        

    }
}
