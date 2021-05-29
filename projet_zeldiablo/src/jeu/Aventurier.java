package jeu;
/**
 * Aventurier
 */
public class Aventurier implements Personnage {

    /**
     * position x de l'aventurier
     */
    private int x;

    /**
     * position y de l'aventurier
    */
    private int y;

    /**
     * nom de l'aventurier
     */
    private String nom;

     /**
     * points de vie de l'aventurier
     */
    private int pv;

     /**
     * degat de l'aventurier
     */
    private int degat;

    /**
     * constructeur vide de la classe Aventurier, il est initialise a la position 0,0
     */
    public Aventurier(String pNom){
        this.x = 0;
        this.y = 0;
        this.nom = pNom;
        this.pv = 10;
        this.degat = 1;
    }

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public Aventurier(int pX, int pY, String nom, int pPv, int pDegat) {
        this.nom = nom;
        this.x = pX;
        this.y = pY;
        this.pv = pPv;
        this.degat = pDegat;
    }

    /**
     * methode permettant de donner une nouvelle position a l'aventurier
     * @param nx nouvelle position x
     * @param ny nouvelle position y
     */
    public void deplacer(int nx, int ny) {
        this.x += nx;
        this.y += ny;
    }

    /**
     * getter de l'attribut x
     * @return retourne la position x
     */
    public int getX() {
        return this.x;
    }

    /**
     * getter de l'attribut y
     * @return retourne la position y
     */
    public int getY() {
        return this.y;
    }

    /**
     * getter du nom de l'aventurier
     * @return retourne le nom de l'aventurier
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter des points de vie de l'aventurier
     * @return retourne les points de vie de l'aventurier
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * getter des points de vie de l'aventurier
     * @return retourne les points de vie de l'aventurier
     */
    public int getDegat() {
        return this.degat;
    }
}
