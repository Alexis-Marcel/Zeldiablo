package jeu;

public class Main {
    
    public static void main(String[] args){

        Jeu j = new  Jeu ("projet_zeldiablo/niveaux/niveau2.txt");

        System.out.println(j.getListeMonstre().size());



    }
}
