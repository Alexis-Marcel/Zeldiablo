package jeu.cases;
/**
 * Case
 */
public class CaseVide extends Case{


    /**
     * constructeur de la classe Case
     * @param type type de la case
     * @param x position x de la case
     * @param y position y de la case
     */
    public CaseVide(int x, int y) {

        super(x, y);
    }


    /**
     * getter de la position x de la case
     * @return retourne la position x de la case
     */
    public int getX() {
        return super.getX();
    }

    /**
     * getter de la position y de la case
     * @return retourne la position y de la case
     */
    public int getY() {
        return super.getY();
    }
    
}