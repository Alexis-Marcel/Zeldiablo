package jeu.Personnage;

import jeu.*;

public abstract class Personnage {

    /**
     * ATTRIBUTS
     */

    protected int x,y,pv,degat;

    /**
     * attribut permettant de définir de quel coté est tourné le personnage
     */
    protected char orientation;

    /**
     * case sur lequel est le personnage
     */
    protected Case caseOccupe;

    /**
     * different orientation possible du personnage
     */
    public final static char NORD ='N';
    public final static char SUD  ='S';
    public final static char EST  ='E';
    public final static char OUEST='O';


    /**
     * Constructeur
     * @param px position abscisse initiale
     * @param py position ordonnee initiale
     * @param pv pv initaux 
     * @param deg degats initial
     * @param c case sur lequel demarre le personnage
     */
    public Personnage(int px,int py,int ppv,int pdegat,Case pcase){
        this.x = px;
        this.y = py;
        this.pv = ppv;
        this.degat = pdegat;
        this.caseOccupe = pcase;

        this.orientation = Personnage.SUD;

        this.caseOccupe.setOccupant(this);
    }

    /**
     * méthode permettant d'attaquer l'occupant d'une case
     * @param c sur laquel va etre attaqué son occupant
     */
    public void attaquer(Case c){

        Personnage cible = c.getOccupant();

        if(cible != null){

            if (cible.etreAventurier() != this.etreAventurier()) {
                cible.prendreDegat(this.degat);
                System.out.println("attaque");
            }
        }   
    }

    /**
     * méthode permettant à un personnage de prendre des degats
     * @param degats nombre de points de vie qui va lui etre enlevé
     */
    public void prendreDegat(int degats){
        this.pv -= degats;

    }

    /**
     * méthode permettant de avoir si un personnage est un aventurier ou non
     * @return true si le personnage est un aventurier
     */
    public abstract boolean etreAventurier();

    /**
     * méthode permettant de definir l'orientation du personnage
     * @param c char correspondant à son orientation (Nord,Sud,Est,Ouest)
     */
    public void setOrientation(char c){
        this.orientation = c;
    }

    /**
     * méthode permettant de savoir si un personnage est mort ou pas
     * @return true si le personnage est mort
     */
    public boolean etreMort(){
        return this.pv <= 0;
    }


    // ------- GETTERS ------- //

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public char getOrientation(){
        return orientation;
    }

    public Case getCase(){
        return caseOccupe;
    }
}
