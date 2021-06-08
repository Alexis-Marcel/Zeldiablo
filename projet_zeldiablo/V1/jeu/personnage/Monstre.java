package jeu.personnage;

public abstract class Monstre extends Personnage{


    public Monstre(int pX, int pY, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
           
    }
    
    public abstract int[] verifierCoord(Aventurier a);

    public String toString() {

        return "Bonjour, je suis un monstre";
    }

    public void attaquer(Aventurier a){

        int distanceX = Math.abs(this.x-a.getX());
        int distanceY = Math.abs(this.y-a.getY());

                
        if((distanceX == 1 && distanceY == 0) ||(distanceX == 0 && distanceY == 1)){
                    
            a.prendreDegats(this.degat);
                    
        }
        
    
    }

    
}
