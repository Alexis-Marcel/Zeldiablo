<package jeu.personnage;

public class MonstreImmobile extends Monstre{
     

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public MonstreImmobile(int pX, int pY, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
           
    }


    public void seDeplacer(Aventurier a){

        
    }



    public String toString() {

        return super.toString() + "immobile";
    }

}
