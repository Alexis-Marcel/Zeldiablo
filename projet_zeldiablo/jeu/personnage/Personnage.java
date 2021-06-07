package Niveau.personnage;

public abstract class Personnage {

    /**
     * position x du personnage
     */
    protected int x;

    /**
     * position y du personnage
    */
    protected int y;


     /**
     * points de vie du personnage
     */
    private int pv;

     /**
     * degat du personnage
     */
    private int degat;

    public Personnage(int pX, int pY,int pPv, int pDegat) {
        this.x = pX;
        this.y = pY;
        this.pv = pPv;
        this.degat = pDegat;
    }

    public void attaquer(Personnage p){

        p.prendreDegats(this.degat);
    }


    public void prendreDegats(int degat){
        if(this.pv-degat<0){

            this.pv = 0;

        }
        else{

            this.pv -= degat;
        }
       
    }

    public void seDeplacer(int pX, int pY){

        this.x += pX;
        this.y += pY;
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

    public boolean etreMort(){

        if(this.pv == 0){
            return true;
        }

        return false;
    }

    
}
