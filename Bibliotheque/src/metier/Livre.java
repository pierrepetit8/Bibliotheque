/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pipetit1
 */
public class Livre {

    @Override
    public String toString() {
        return String.format("Le nom du livre est %s et l'auteur est %s (%s)", name, auteur, nbPage.asString());
    }


   
    private DoubleProperty nbPage = new SimpleDoubleProperty(); 
    public Double getNbPage() { return nbPage.get(); }
    public void setNbPage(Double n) { nbPage.set(n); }
    public DoubleProperty nbPageProperty (){ return nbPage; }
    
    private StringProperty name = new SimpleStringProperty();    
    public StringProperty nameProperty() {
        return name;
    }
    
    private StringProperty auteur = new SimpleStringProperty();
    
    public Livre(String auteur, String nom) {
        this.name = new SimpleStringProperty(nom);
        this.auteur = new SimpleStringProperty(auteur);

    }
    
}
