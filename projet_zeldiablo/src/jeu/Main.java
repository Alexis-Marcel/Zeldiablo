package jeu;

public class Main {
    
    public static void main(String[] args){

        Donjon j = new Donjon();

        Jeu jeu = j.getListeJeu().get(1);

        for(int i=0; i< jeu.getListeMontre().size();i++){

            System.out.println(jeu.getListeMontre().get(i));
        }
    }
}
