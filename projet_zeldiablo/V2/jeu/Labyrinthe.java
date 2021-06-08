package V2.jeu;

public class Labyrinthe{

    private Case[][] listeCases;

    private int[] sortie;

    public Labyrinthe(){

    }

    /**
     * méthode permattant de récuprer les 4 cases adjacents à un personnage de coordonées x et y
     * @param x abscisse autour duquel il va falloir récupérer les caes adjacentes
     * @param y ordonnée autour duquel il va falloir récupérer les caes adjacentes
     */
    public Case[] casesAdjacentes(int x,int y){

    }

    /**
     * méthode permattant de récuprer la case devant un personnage de coordonées x et y
     * @param x abscisse du personnage 
     * @param y ordonnée du personnage
     * @param orientation orientation du personnage
     */
    public Case[] getCase(int x,int y,char orientation){

    }

    /**
     * méthode permattantd'ajouter une case à la liste des cases 
     * @param x indice du tableau liste case
     * @param y indice du tableau liste case en fonction de x
     * @param c la case a ajouter au tableau
     */
    public void setListeCase(int x,int y,Case c){

    }

    /**
     * méthode permettant de définir la sortie du niveau
     * @param x abscisse de la sortie
     * @param y ordonnée de la sortie
    */
    public void setSortie(int x,int y){

    }
}