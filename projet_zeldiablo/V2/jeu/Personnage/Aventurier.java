package V2.jeu.Personnage;

import V2.jeu.Case;

public class Aventurier extends Personnage{

    public Aventurier(int px,int py,int pv,int deg ,Case c){

        super(px,py,pv,deg,c);
        
    }
    
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

    public boolean etreAventurier(){
        return true;
    }
    
}
