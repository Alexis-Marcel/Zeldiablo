/**
 * Aventurier
 */
public class Aventurier {

    /**
     * position x de l'aventurier
     */
    private int x;

    /**
     * position y de l'aventurier
     */
    private int y;

    /**
     *nom du personnage
     */
     private String nom;

    /**
     * constructeur vide de la classe Aventurier, il est initialise a la position 0,0
     */
    public Aventurier(String pNom){
        this.x = 0;
        this.y = 0;
        this.nom = pNom;
    }

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     */
    public Aventurier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * methode permettant de donner une nouvelle position a l'aventurier
     * @param nx nouvelle position x
     * @param ny nouvelle position y
     */
    public void nouvellePosition(int nx, int ny) {
        this.x = nx;
        this.y = ny;
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
}
