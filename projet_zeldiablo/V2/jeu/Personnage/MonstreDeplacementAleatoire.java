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
    public MonstreDeplacementAleatoire(int x, int y, int pv, int degats, Case pCase){
        super(x, y, pv,degats, pCase);
    }

    /**
     * Methode permettant de deplacer le monstre prenant en parametre un tableau de Case
     * @param cases : tableau de de Cases (cases autour du Monstre où il peut se déplacer)
     */
    public void seDeplacer(Case[] cases){
       int rand;
       int i = 0;
       char o;
       Case c;
       do{     
            rand = (int)Math.floor(Math.random() * cases.length);
            switch(rand){
                case 0:
                    o = Personnage.NORD;
                    c = cases[0];
                    break;
                case 1:
                    o = Personnage.SUD;
                    c = cases[1];
                    break;
                case 2:
                    o = Personnage.OUEST;
                    c = cases[2];
                    break;
                case 3:
                    o = Personnage.EST;
                    c = cases[3];
                    break;
                default :
                    o = Personnage.NORD;
                    c = cases[0];
            }
            i++;
       }while(!c.estTraversable() && i<cases.length);
       
        this.setOrientation(o);

       if(i<cases.length){

            this.caseOccupe.setOccupant(null);
            this.caseOccupe = c;
            this.caseOccupe.setOccupant(this);

            switch (super.getOrientation()) {
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


}
