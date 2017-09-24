/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;

/**
 *
 * @author pipetit1
 */
public class Bibliotheque {
    public ArrayList<Livre> livres = new ArrayList();
    
    public void ajouterLivre(Livre l) {
        livres.add(l);
    }
}
