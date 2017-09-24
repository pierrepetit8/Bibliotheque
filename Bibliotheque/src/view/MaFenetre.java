/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import java.io.IOException;
import java.util.Observable;
import static javafx.application.ConditionalFeature.FXML;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import metier.Bibliotheque;
import metier.Livre;

/**
 *
 * @author pipetit1
 */
public class MaFenetre {
    @FXML private Button modifBtn;
    @FXML private TextField nomLivre;
    @FXML private TextField nomAuteurField;
    @FXML private Text affichage;
    @FXML private Slider pageNumber;
    @FXML private Text description;
    @FXML private ListView<Livre> listeLivre;
    public Stage thisStage;
    
    public Bibliotheque bibli = new Bibliotheque();
    private ListProperty listProperty = new SimpleListProperty();
    
    
    public void initialize() {
        bibli.ajouterLivre(new Livre("djlqjd", "dqod"));
        ObservableList obsList = FXCollections.observableArrayList(bibli.livres);
        /*
        listProperty.set(obsList);
        listeLivre.itemsProperty().bind(listProperty);
        nbPageText.textProperty().bind(pageNumber.valueProperty().asString());*/
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
       // nomLivre.textProperty().bindBidirectional(nomAuteurField.textProperty());
            
       
        
        
        
        
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
    public void modifierLivre() throws IOException {
        Livre selected = listeLivre.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ModifFenetre.fxml"));
        Scene maScene = new Scene(root);
        //maScene.
    }
}
