package V2.jeu.Personnage;

import V2.jeu.Personnage.Aventurier;
import V2.jeu.*;

public class Monstre extends Personnage{
    
    /**
     * Constructeur de Monstre prenant en parametre sa position, ses points de vie et ses degats
     * @param x : position en abscisse
     * @param y : position en ordonnee
     * @param pv : points de vie
     * @param degats : degats du monstre
     */
    public Monstre(int x, int y, int pv, int degats, Case pCase){
        super(x,y,pv,degats, pCase);
    }
    /**
     * Methode permettant d'infliger des degats
     * @param d : degats à infliger au Monstre
     */
    public void prendreDegat(int d){
        this.pv -= d;
    }

    @Override
    void seDeplacer() {
        // TODO Auto-generated method stub
        
    }


}