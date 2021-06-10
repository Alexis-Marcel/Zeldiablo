package jeu.Personnage;

import jeu.Case;

/**
 * class permettant ce créer un monstre immobile
 */
public class MonstreImmobile extends Monstre{

    /**
     * Constructeur
     * @param px position abscisse initiale
     * @param py position ordonnee initiale
     * @param pv pv initaux 
     * @param deg degats initial
     * @param c case sur lequel demarre le monstre
     */
    public MonstreImmobile(int x, int y, int pv, int degats, Case pCase) {
        super(x, y, pv, degats, pCase);
        //TODO Auto-generated constructor stub
    }


    /**
     * Methode permettant de deplacer le monstre prenant en parametre un tableau de Case
     * @param cases : tableau de de Cases (cases autour du Monstre où il peut se déplacer)
     */
    public void seDeplacer(Case[] c){
        //ici le monstre est immabolie donc il ne se déplace pas
    }
 
}
