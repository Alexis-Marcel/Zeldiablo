package Niveau;

import Niveau.cases.*;

/**
 * Class créan un Labyrinthe dans lequel un aventurier devra trouver la sorti
 */
public class Labyrinthe {

    //ATTRIBUTSA
    private Case[][] listeCases;


    /** 
     * CONSTRUCTEUR,
     */ 

    public Labyrinthe(){

        this.listeCases = new Case[10][10];
    }

    /**
     * methode permettant de récupérer les coordonnées du millieu du labyrinthe
     * @return un tableau de int ayant la coordonnée en abscisse du millieu en index 0 et la coordonnée des ordonnées en index 1
     */

    public Case[][] getListeCase(){
        return this.listeCases;
    }

    public void setListeCase(int x,int y, Case c){
        
        this.listeCases[x][y] = c;
    }

 
}
