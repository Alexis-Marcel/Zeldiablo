package jeu.personnage;
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
