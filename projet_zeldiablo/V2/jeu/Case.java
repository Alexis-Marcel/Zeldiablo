package V2.jeu;

import V2.jeu.Personnage.*;

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
     */
    public Case(boolean tr, Personnage p){
        this.traversable = tr ;
        this.occupant = p;
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
     * methode 
     */
    public void setOccupant(Personnage p){
       this.occupant = p;
    }

    /**
     * methode qui retourne l'attribut occupant
     * 
     * @return 
     */
    public Personnage getOccupant(){
        return this.occupant;
    }
}
