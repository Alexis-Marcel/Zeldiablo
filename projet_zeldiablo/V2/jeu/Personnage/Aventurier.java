package V2.jeu.Personnage;

import V2.jeu.Case;

public class Aventurier extends Personnage{

    private String nom;

    public Aventurier(int px,int py,String n,int pv,int deg ,Case c){

        super(px,py,pv,deg,c);

        this.nom = n;
        
    }

    public void seDeplacer(Case[] c){

    }
    
}
