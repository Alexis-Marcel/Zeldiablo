package V2.jeu;

import V2.moteurJeu.*;

public class Main {

    public static void main(String[] args){

        Niveau jeu = new Niveau("projet_zeldiablo/V2/niveaux/niveau2.txt","projet_zeldiablo/V2/fond/niveau2.png");
        ZeldiabloDessin dess = new ZeldiabloDessin(jeu);
        MoteurGraphique m = new MoteurGraphique(jeu, dess);

        try{

            m.lancerJeu(800, 800);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
