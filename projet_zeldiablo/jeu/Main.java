package jeu;

import moteurJeu.*;

public class Main {
    
    public static void main(String[] args){

        ZeldiabloJeu jeu = new ZeldiabloJeu();
        ZeldiabloDessin dess = new ZeldiabloDessin(jeu);
        MoteurGraphique m = new MoteurGraphique(jeu, dess);
        try{
            m.lancerJeu(500, 500);
        }
        catch(Exception e){
            System.out.println(e);
        }
        



    }
}
