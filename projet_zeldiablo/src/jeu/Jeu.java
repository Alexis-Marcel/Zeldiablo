package jeu;
import java.util.ArrayList;

/**
 * Main
 */

import jeu.cases.*;

public class Jeu {

    /**
     * Aventurier
     */
    ArrayList<Personnage> listePersonnage;

    /**
     * Aventurier
     */
    Labyrinthe labyrinthe;

    /** 
     * CONSTRUCTEUR
     */ 
    public Jeu(){

        this.labyrinthe = new Labyrinthe();
        this.listePersonnage = new ArrayList<Personnage>();
        
    }

    public void deplacerPersonnage(int n,int deplacementX, int deplacementY){

        Personnage p = this.listePersonnage.get(n);

        if(verificationDeplacement(p,deplacementX,deplacementY)){
            p.deplacer(deplacementX, deplacementY);
        }
    }

    public boolean verificationDeplacement(Personnage p,int nx, int ny){ 

        Case c = this.labyrinthe.getListeCase()[p.getX()+nx][p.getY()+ny];

        if(c instanceof CasePleine ){
                return false;
        }


        return true;
    }

    public boolean gagner(){
        return true;
    }


}