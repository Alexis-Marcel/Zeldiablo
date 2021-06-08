package V2.jeu.Personnage;

import V2.jeu.Case;

public class Aventurier extends Personnage{

    private String nom;

    public Aventurier(int px,int py,String n,int pv,int deg ,Case c){

        super(px,py,pv,deg,c);

        this.nom = n;
        
    }

    public void seDeplacer(Case[] c){

        if(c[0].estTraversable()){

            this.caseOccupe.setOccupant(null);
            this.caseOccupe = c[0];
            this.caseOccupe.setOccupant(this);
            
            switch (super.getOrientation()) {
                case Personnage.NORD:
                    this.y--;
                    break;
                case Personnage.SUD:
                    this.y++;
                    break;
                case Personnage.EST:
                    this.x++;
                    break;
                case Personnage.OUEST:
                    this.x--;
                    break;        
            }

        }

    }
    
}
