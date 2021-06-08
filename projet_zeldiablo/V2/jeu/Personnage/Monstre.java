package V2.jeu.Personnage;

import V2.jeu.*;

public abstract class Monstre extends Personnage{
    
    /**
     * Constructeur de Monstre prenant en parametre sa position, ses points de vie et ses degats
     * @param x : position en abscisse
     * @param y : position en ordonnee
     * @param pv : points de vie
     * @param degats : degats du monstre
     */
    public Monstre(int x, int y, int pv, int degats, Case pCase){
        super(x, y, pv,degats, pCase);
    }
    
    /**
     * Methode qui permet de deplacer le Monstre
     */

    public abstract void seDeplacer(Case[] cases);



}