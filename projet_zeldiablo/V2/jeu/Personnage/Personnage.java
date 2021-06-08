package V2.jeu.Personnage;

import V2.jeu.*;

public abstract class Personnage {
    /**
     * ATTRIBUTS
     */
    protected int pv,degat;
    private char orientation;
    protected Case caseOccupe;

    public final static char NORD ='N';
    public final static char SUD  ='S';
    public final static char EST  ='E';
    public final static char OUEST='O';


    public Personnage(int ppv,int pdegat,Case pcase){
        this.pv = ppv;
        this.degat = pdegat;
        this.caseOccupe = pcase;

        this.orientation = Personnage.NORD;

        this.caseOccupe.setOccupant(this);
    }

    public abstract void seDeplacer(Case[] tabCase);

    public void attaquer(Case c){
        c.getOccupant().prendreDegat(degat);
    }

    public void prendreDegat(int degats){
        this.pv -= degats;
    }

    public void setOrientation(char c){
        this.orientation = c;
    }

    public char getOrientation(){
        return orientation;
    }

    public boolean etreMort(){
        return this.pv <= 0;
    }
}
