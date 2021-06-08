package jeu.cases;
/**
 * Case
 */
public abstract class Case {


    /**
     * position x de la case
     */
    private int x;
    /**
     * position y de la case
     */
    private int y;

    /**
     * constructeur de la classe Case
     * @param x position x de la case
     * @param y position y de la case
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * getter de la position x de la case
     * @return retourne la position x de la case
     */
    public int getX() {
        return this.x;
    }

    /**
     * getter de la position y de la case
     * @return retourne la position y de la case
     */
    public int getY() {
        return this.y;
    }
    
} 