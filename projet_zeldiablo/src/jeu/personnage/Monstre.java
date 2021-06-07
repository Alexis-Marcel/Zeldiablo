package jeu.personnage;

public interface Monstre{


    /**
     * methode permettant de donner une nouvelle position a l'aventurier
     * @param nx nouvelle position x
     * @param ny nouvelle position y
     */
    public void seDeplacer(Aventurier a);

    public void attaquer(Aventurier a);

    public void prendreDegats(int deg);

    /**
     * getter de l'attribut x
     * @return retourne la position x
     */
    public int getX();

    /**
     * getter de l'attribut y
     * @return retourne la position y
     */
    public int getY();



    /**
     * getter des points de vie du monstre
     * @return retourne les points de vie du monstre
     */
    public int getPv();

    /**
     * getter des points de vie du monstre
     * @return retourne les points de vie du monstre
     */
    public int getDegat();

}
