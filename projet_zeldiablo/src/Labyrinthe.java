/**
 * Class créan un Labyrinthe dans lequel un aventurier devra trouver la sorti
 */
public class Labyrinthe {

    //ATTRIBUTS
    private Case[][] listeCases;


    /** 
     * CONSTRUCTEUR
     */ 
    //Constructeur Vide
    public Labyrinthe(){
        this.listeCases = new Case[10][10];
        for(int i = 0; i<10; i++){
            for(int j = 0; i<10; i++){
                listeCases[i][j] = new Case("vide",i,j);
            }
        }
    }

    /**
     * Constructeur
     * @param tailleX : taille en abscisse du Labyrinthe
     * @param tailleY : taille en ordonnee du Labyrinthe
     */
    public Labyrinthe(int tailleX, int tailleY){
        this.listeCases = new Case[tailleX][tailleY];
        for(int i = 0; i<tailleX; i++){
            for(int j = 0; i<tailleY; i++){
                listeCases[i][j] = new Case("vide",i,j);
            }
        }
    }

    /**
     * methode permettant de récupérer les coordonnées du millieu du labyrinthe
     * @return un tableau de int ayant la coordonnée en abscisse du millieu en index 0 et la coordonnée des ordonnées en index 1
     */
    public int[] donnerCoordonneesMillieu(){
        int[] res = new int[2];
        res[0] = this.listeCases.length/2;
        res[1] = this.listeCases[0].length/2;
        return res;
    }



    
}
