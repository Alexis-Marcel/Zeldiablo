package jeu;

import moteurJeu.*;

public class Main {
    
    public static void main(String[] args){

        Donjon dj = new Donjon();

        int i = 0;
        while(i< dj.getListeNiveau().size()){

            while(! dj.getListeNiveau().get(i).etreFini()){

                ZeldiabloJeu jeu = dj.getListeNiveau().get(i);
                ZeldiabloDessin dess = new ZeldiabloDessin(jeu);
                MoteurGraphique m = new MoteurGraphique(jeu, dess);
                try{
                    m.lancerJeu(800, 800);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

            i++;
            

            
        }
       
        



    }
}
