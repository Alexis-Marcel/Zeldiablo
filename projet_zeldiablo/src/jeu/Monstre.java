package jeu;

public class Monstre implements Personnage{
     /**
     * position x du monstre
     */
    private int x;

    /**
     * position y du monstre
    */
    private int y;

    /**
     * points de vie du monstre
    */
    private int pv;

    /**
     * degat du monstre
    */
    private int degat;


    /**
     * constructeur vide de la classe Aventurier, il est initialise a la position 0,0
     */
    public Monstre(){
        this.x = 0;
        this.y = 0;
        this.pv = 1;
        this.degat =1;
    }

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public Monstre(int x, int y, int pPv, int pDegat) {
        this.x = x;
        this.y = y;
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
     * getter des points de vie du monstre
     * @return retourne les points de vie du monstre
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * getter des points de vie du monstre
     * @return retourne les points de vie du monstre
     */
    public int getDegat() {
        return this.degat;
    }

}
