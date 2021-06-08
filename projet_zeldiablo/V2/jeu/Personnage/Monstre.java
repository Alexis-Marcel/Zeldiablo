package V2.jeu.Personnage;

import V2.jeu.Personnage.Aventurier;
import V2.jeu.*;

public class Monstre extends Personnage{
    
    /**
     * Constructeur de Monstre prenant en parametre sa position, ses points de vie et ses degats
     * @param x : position en abscisse
     * @param y : position en ordonnee
     * @param pv : points de vie
     * @param degats : degats du monstre
     */
    public Monstre(int pv, int degats, Case pCase){
        super(pv,degats, pCase);
    }
    /**
     * Methode permettant d'infliger des degats
     * @param d : degats à infliger au Monstre
     */
    public void prendreDegat(int d){
        this.pv -= d;
    }

    /**
     * Methode qui permet de deplacer le Monstre
     */
    @Override
    public void seDeplacer(Case[] tabCase) {
        
    }

    public void attaquer(Case c){
        if(c.getOccupant() != null){
            c.getOccupant().prendreDegat(this.degat);
        }
    }


}