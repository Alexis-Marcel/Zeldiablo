package V2.jeu;

import V2.moteurJeu.*;

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
