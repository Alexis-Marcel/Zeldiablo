package jeu.personnage;

import java.util.Random;

public class MonstreDeplacementAleatoire extends Monstre{
     

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public MonstreDeplacementAleatoire(int pX, int pY, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
           
    }


    public int[] verifierCoord(Aventurier a){

        int[] l = new int[2];

        Random rand = new Random();

        switch (rand.nextInt(4)) {

            case 1:
                l[0] = 1;
                l[1] = 0;
                break;

            case 2:
                
                l[0] = -1;
                l[1] = 0;
                break;

            case 3:
                l[0] = 0;
                l[1] = 1;
                break;

            case 4:

                l[0] = 0;
                l[1] = -1;
                break;
        
            default:
                l[0] = 0;
                l[1] = 0;
                break;
        }
        
        

        return l;
    }


    public String toString() {

        return super.toString() + " attire par le heros";
    }

}
