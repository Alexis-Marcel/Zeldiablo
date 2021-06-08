package V2.jeu.Personnage;

import V2.jeu.Case;

public class MonstreImmobile extends Monstre{

    public MonstreImmobile(int pv, int degats, Case pCase) {
        super(pv, degats, pCase);
        //TODO Auto-generated constructor stub
    }

    public void attaquer(Case c){
        if(c.getOccupant() != null){
            c.getOccupant().prendreDegat(this.degat);
        }
    }
 
}
