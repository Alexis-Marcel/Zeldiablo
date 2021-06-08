package V2.jeu;

//import

import Personnage.*;
/**
 * Niveau
 */
public class Niveau {


    /**
     * Labyrinthe sur lequel va se dérouler le jeu
     */
    private Labyrinthe laby;

    /**
     * Liste des monstres présent sur le labyrinthe
     */
    private ArrayList<Monstre> listeMonstre;

    /**
     * Aventurier qui va etre controler par l'utilisateur
     */
    private Aventurier hero;

    public Niveau(String src){

        this.laby = new Labyrinthe(src);
        this.listeMonstre = new ArrayList<Monstre>();
        
    }

    public void deplacerAventurier()

    
    
} 