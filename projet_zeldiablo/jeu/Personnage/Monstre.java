package jeu.Personnage;

import jeu.*;

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
     * 
     * @param cases 
     */
    public abstract void seDeplacer(Case[] cases);

    /**
     * methode permettant de savoir si monstre est un aventurier ou non
     * 
     * @return un boolean false
     */
    public boolean etreAventurier(){
        return false;
    }



}