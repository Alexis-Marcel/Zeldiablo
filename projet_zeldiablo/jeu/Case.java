package jeu;

import jeu.Personnage.*;

public class Case {
    
     /**
     * boolean traversable pour savoir si la case est traversable ou pas
     */
    private boolean traversable;

    /**
     * boolean occupe pour savoir si la case est occupe par un personnage 
     */
    private Personnage occupant;

    /**
     * CONSTRUCTEUR
     * 
     * @param tr
     * @param p
     */
    public Case(boolean tr){
        this.traversable = tr ;
        this.occupant = null;
    }

    /**
     * methode qui rend une case traversable
     * 
     * @return l'attibut traversable a true
     */
    public boolean estTraversable(){
        boolean res;
        if (traversable && occupant == null){
            res = true;
        }else{
            res = false;
        }
        return res;
    }

    /**
     * methode  qui donne un personnage a la case
     * 
     * @param p le personnage qui est donne a la case
     */
    public void setOccupant(Personnage p){
       this.occupant = p;
    }

    /**
     * methode qui retourne  occupant de la case
     * 
     * @return Personnage qui est sur la case
     */
    public Personnage getOccupant(){
        return this.occupant;
    }
}
