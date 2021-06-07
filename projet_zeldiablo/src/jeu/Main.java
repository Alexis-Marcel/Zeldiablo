package jeu;

public class Main {
    
    public static void main(String[] args){

        Donjon j = new Donjon();

        Jeu jeu = j.getListeJeu().get(0);

        

            System.out.println(jeu.getListeMontre().get(0));
        
        

        
        System.out.println("Monstre Avant");
        System.out.println(jeu.getListeMontre().get(0).getX());
        System.out.println(jeu.getListeMontre().get(0).getY());

        System.out.println("deplace");
        jeu.deplacerToutMonstre();

        System.out.println("Monstre apres");
        System.out.println(jeu.getListeMontre().get(0).getX());
        System.out.println(jeu.getListeMontre().get(0).getY());

        System.out.println("Aventurier");
        System.out.println(jeu.getAventurier().getX());
        System.out.println(jeu.getAventurier().getY());
        

        


    }
}
