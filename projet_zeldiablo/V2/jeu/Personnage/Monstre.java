package V2.jeu.Personnage;

import jeu.Personnage.Aventurier;

public class Monstre extends Personnage{
    
    public Monstre(int x, int y, int pv, int degats){
        super(x,y,pv,degats);
    }

    public void seDeplacer(Case[] c){

    }

    public void prendreDegat(int d){
        this.pv-=d;
    }


}