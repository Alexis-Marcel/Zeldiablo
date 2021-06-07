package jeu.personnage;

public class MonstreAttireParHeros implements Monstre{
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
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public MonstreAttireParHeros(int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    /**
     * methode permettant de donner une nouvelle position a l'aventurier
     * @param nx nouvelle position x
     */
    public void seDeplacer(Aventurier a){

        

    }

    public void attaquer(Aventurier a){

        a.prendreDegats(this.degat);

    }

    public void prendreDegats(int deg){

        if(this.pv-degat<0){

            this.pv = 0;

        }
        else{

            this.pv -= degat;
        }
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

    public String toString() {

        return "Bonjour, je suis un monstre immobile. Je suis la pour empecher l'aventurier d'arriver à la fin du labyrithe  car il s'y trouve un trésor.";
    }

}
