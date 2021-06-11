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
        int rand = (int)Math.floor(Math.random()*4);
        switch (rand) {
            case 0:
                this.setOrientation(Personnage.NORD);
                break;
            case 1:
                this.setOrientation(Personnage.SUD);
                break;
            case 2:
                this.setOrientation(Personnage.EST);
                break;
            case 3:
                this.setOrientation(Personnage.OUEST);
                break;
        }
    }
 
}
