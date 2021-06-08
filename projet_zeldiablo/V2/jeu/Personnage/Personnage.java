package V2.jeu.Personnage;

import jeu.*;

abstract class Personnage {
    
    private int x,y,pv,degat;
    private char orientation;
    private Case caseOccupe;

    final static char NORD ='N';
    final static char SUD  ='S';
    final static char EST  ='E';
    final static char OUEST='O';


    public Personnage(int px,int py,int ppv,int pdegat,Case pcase){
        this.x = px;
        this.y = py;
        this.pv = ppv;
        this.degat = pdegat;
        this.caseOccupe = pcase;

        this.caseOccupe.setOccupant(this);
    }

    abstract void seDeplacer(Case[]);

    public void attaquer(Case c){

    }

    public void prendreDegat(int degats){
        this.pv -= degats;
    }
}
