package V2.jeu.Personnage;

import V2.jeu.*;

public abstract class Personnage {
    /**
     * ATTRIBUTS
     */

    protected int x,y,pv,degat;
    protected char orientation;

    protected Case caseOccupe;

    public final static char NORD ='N';
    public final static char SUD  ='S';
    public final static char EST  ='E';
    public final static char OUEST='O';


    public Personnage(int px,int py,int ppv,int pdegat,Case pcase){
        this.x = px;
        this.y = py;
        this.pv = ppv;
        this.degat = pdegat;
        this.caseOccupe = pcase;

        this.orientation = Personnage.SUD;

        this.caseOccupe.setOccupant(this);
    }

    public void attaquer(Case c){

        Personnage cible = c.getOccupant();

        if(cible != null){

            if (cible.etreAventurier() != this.etreAventurier()) {
                cible.prendreDegat(this.degat);
                System.out.println("Donne ton gouter");
            }
        }   
    }

    public void prendreDegat(int degats){
        this.pv -= degats;

    }

    public abstract boolean etreAventurier();

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setOrientation(char c){
        this.orientation = c;
    }

    public char getOrientation(){
        return orientation;
    }

    public Case getCase(){
        return caseOccupe;
    }

    public boolean etreMort(){
        return this.pv <= 0;
    }
}
