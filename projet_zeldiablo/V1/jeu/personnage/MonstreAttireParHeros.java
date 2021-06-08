package jeu.personnage;

public class MonstreAttireParHeros extends Monstre{
     

    /**
     * constructeur avec parametre de la classe Aventurier
     * @param x position x initial de l'aventurier
     * @param y position y initial de l'aventurier
     * @param nom nom de l'aventurier
     */
    public MonstreAttireParHeros(int pX, int pY, int pPv, int pDegat) {

        super(pX, pY,pPv,pDegat);
           
    }


    public int[] verifierCoord(Aventurier a){

        int[] l = {0,0};

        if(distance(a.getX(),this.x)>distance(a.getY(), this.y)){
            if(a.getX() > this.x){
                l[0]++;
            }else{
                l[0]--;
            }
        }else{
            if(a.getY() > this.y){
                l[1]++;
            }else{
                l[1]--;
            }

        }  

        return l;
    }


    private int distance(int a, int b){
        if(a>b){
            return a-b;
        }else{
            return b-a;
        }
    }



    public String toString() {

        return super.toString() + " attire par le heros";
    }

}
