package jeu.personnage;

public abstract class Monstre extends Personnage{


    public Monstre(int pX, int pY, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
           
    }
    
    public abstract void seDeplacer(Aventurier a);

    public String toString() {

        return "Bonjour, je suis un monstre";
    }

    
}
