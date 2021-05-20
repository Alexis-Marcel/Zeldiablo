/**
 * Case
 */
public class Case {

    /**
     * type de la case
     */
    private String type;

    public static String VIDE = "vide";
    public static String PLEIN = "plein";
    public static String DEPART = "depart";

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
     * @param type type de la case
     * @param x position x de la case
     * @param y position y de la case
     */
    public Case(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * getter du type de la case
     * @return retourne le type de la case
     */
    public String getType() {
        return this.type;
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