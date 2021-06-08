package V2.jeu.Personnage;

import jeu.*;

abstract class Personnage {
    
    private int x,y,pv,degat;
    private char orientation;
    private Case caseOccupe;

    public Personnage(int px,int py,int ppv,int pdegat,Case pcase){
        this.x = px;
        this.y = py;
        this.pv = ppv;
        this.degat = pdegat;
        this.caseOccupe = pcase;

        this.caseOccupe.setOccupant(this);
    }
}
