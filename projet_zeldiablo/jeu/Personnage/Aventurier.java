package jeu.Personnage;

import jeu.Case;

/**
 * class Aventurier qui correspond au heros controlé par l'utilisateur
 */
public class Aventurier extends Personnage{

    /**
     * Constructeur
     * @param px position abscisse initiale
     * @param py position ordonnee initiale
     * @param pv pv initaux 
     * @param deg degats initial
     * @param c case sur lequel demarre le personnage
     */
    public Aventurier(int px,int py,int pv,int deg ,Case c){

        super(px,py,pv,deg,c);
        
    }
    
    /**
     * méthode permettant au personnage de se déplacer vers la case c
     * @param c case vers laquelle le personnage va essayer de se deplacer
     */
    public void seDeplacer(Case c){

        if(c.estTraversable()){

            this.caseOccupe.setOccupant(null);
            this.caseOccupe = c;
            this.caseOccupe.setOccupant(this);
            
            switch (this.orientation) {
                case Personnage.NORD:
                    this.y--;
                    break;
                case Personnage.SUD:
                    this.y++;
                    break;
                case Personnage.EST:
                    this.x++;
                    break;
                case Personnage.OUEST:
                    this.x--;
                    break;        
            }

        }

    }


    /**
     * méthode permettant de savoir si le personnage est un aventurier ou pas
     */
    public boolean etreAventurier(){
        return true;
    }
    
}
