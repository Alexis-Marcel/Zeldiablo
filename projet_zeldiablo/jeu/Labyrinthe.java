package jeu;

import jeu.Personnage.*;

public class Labyrinthe{

    private Case[][] listeCases;

    private int[] sortie;

    public Labyrinthe(){

        this.listeCases = new Case[10][10];
        this.sortie = new int[2];
    }



    /**
     * méthode permattant de récuprer les 4 cases adjacents à un personnage de coordonées x et y
     * @param x abscisse autour duquel il va falloir récupérer les caes adjacentes
     * @param y ordonnée autour duquel il va falloir récupérer les caes adjacentes
     */
    public Case[] casesAdjacentes(int x,int y){
        Case [] l = new Case[4];

        l[0] = this.listeCases[x][y-1];
        l[1] = this.listeCases[x][y+1];
        l[2] = this.listeCases[x-1][y];
        l[3] = this.listeCases[x+1][y];

        return l;
    }

    /**
     * méthode permattant de récuprer la case devant un personnage de coordonées x et y
     * @param x abscisse du personnage 
     * @param y ordonnée du personnage
     * @param orientation orientation du personnage
     */
    public Case getCase(int x,int y,char orientation){
        Case l;

        switch(orientation){
        case Personnage.NORD:
           l = this.listeCases[x][y-1];
           break;
        case Personnage.SUD:
           l = this.listeCases[x][y+1];
           break;
        case Personnage.EST:
           l = this.listeCases[x+1][y];
           break;
        case Personnage.OUEST:
           l = this.listeCases[x-1][y];
           break;
        default : 
            
            l = this.listeCases[x][y-1];
            break;
        }

        return l;
    }

    /**
     * méthode permattantd'ajouter une case à la liste des cases 
     * @param x indice du tableau liste case
     * @param y indice du tableau liste case en fonction de x
     * @param c la case a ajouter au tableau
     */
    public void setListeCase(int x,int y,Case c){
        this.listeCases[x][y] = c;
    }

    /**
     * méthode permettant de définir la sortie du niveau
     * @param x abscisse de la sortie
     * @param y ordonnée de la sortie
    */
    public void setSortie(int x,int y){
        this.sortie[0] = x;
        this.sortie[1] = y;
    }

    /**
     * méthode permettant de verifier si une personnage de coordonée x et y sont à la sortie du niveau
     * @param x abscisse du personnage
     * @param y ordonnée du personnage
     * @return true si le personnage est à la sortie
     */
    public boolean checkHeroSortie(int x, int y){

        if(x == this.sortie[0] && y == this.sortie[1]){
            return true;
        }

        return false;
    }
}