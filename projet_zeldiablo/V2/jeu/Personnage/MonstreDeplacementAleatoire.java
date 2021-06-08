package V2.jeu.Personnage;

import V2.jeu.*;

public class MonstreDeplacementAleatoire extends Monstre{
    /**
     * Constructeur de Monstre prenant en parametre sa position, ses points de vie et ses degats
     * @param x : position en abscisse
     * @param y : position en ordonnee
     * @param pv : points de vie
     * @param degats : degats du monstre
     */
    public MonstreDeplacementAleatoire(int pv, int degats, Case pCase){
        super(pv,degats, pCase);
    }

    /**
     * Methode permettant de deplacer le monstre prenant en parametre un tableau de Case
     * @param cases : tableau de de Cases (cases autour du Monstre où il peut se déplacer)
     */
    public void seDeplacer(Case[] cases){
       int rand;
       do{
            rand = (int)Math.floor(Math.random() * cases.length);
       }while(!cases[rand].estTraversable());

        this.caseOccupe.setOccupant(null);
        this.caseOccupe = cases[rand];
        this.caseOccupe.setOccupant(this);
    }

    /**
     * Methode permettant d'infliger des degats
     * @param d : degats à infliger au Monstre
     */
    public void prendreDegat(int d){
        this.pv-=d;
    }
}
