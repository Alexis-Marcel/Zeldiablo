package jeu;

import jeu.cases.*;

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
    public int[] coordonneeCaseDepart(){
        int[] res = new int[2];
        res[0] = (this.listeCases.length/2)-1;
        res[1] = (this.listeCases[0].length/2)-1;
        return res;
    }

    public Case[][] getListeCase(){
        return this.listeCases;
    }

    public void setListeCase(int x,int y, Case c){
        
        this.listeCases[x][y] = c;
    }

 
}
