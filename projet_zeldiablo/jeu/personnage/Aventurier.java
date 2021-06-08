package jeu.personnage;

import moteurJeu.Commande;
import java.util.ArrayList;
/**
 * Aventurier
 */
public class Aventurier extends Personnage{


    /**
     * nom de l'aventurier
     */
    private String nom;


    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public Aventurier(int pX, int pY, String nom, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
        this.nom = nom;
        
    }

    public void attaquer(ArrayList<Monstre> l,Commande c){

        if(c.attaque){

            for(int i=0; i<l.size();i++){

                int distanceX = Math.abs(this.x-l.get(i).getX());
                int distanceY = Math.abs(this.y-l.get(i).getY());

                
                if((distanceX == 1 && distanceY == 0) ||(distanceX == 0 && distanceY == 1)){
                    
                    l.get(i).prendreDegats(this.degat);
                    if(l.get(i).etreMort()){
                        l.remove(i);
                    }
                }
            }
        }
    }


     /**
     * getter du nom de l'aventurier
     * @return retourne le nom de l'aventurier
     */
    public String getNom() {
        return nom;
    }


    public String toString() {

        return "Bonjour, je suis l'aventurier " + this.nom + ". Je suis perdu dans un labyrithe est ce que vous pouvez m'aider à sortir ?";
    }
}
