package jeu;

import moteurJeu.*;

/**
 * class permettant de lancer le jeu
 */
public class Main {

    public static void main(String[] args){

        Donjon dj = new Donjon();
        ZeldiabloDessin dess = new ZeldiabloDessin(dj);
        MoteurGraphique m = new MoteurGraphique(dj, dess);


        try{

            m.lancerJeu(800, 800);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
