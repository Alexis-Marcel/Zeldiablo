package jeu;
import java.util.ArrayList;

public class Donjon {
    
    /**
     * Aventurier
     */
    ArrayList<ZeldiabloJeu> listeNiveau;

    private final static String chemin = "niveaux/";


    public Donjon() {
        this.listeNiveau = new ArrayList<ZeldiabloJeu>();
        
        this.listeNiveau.add(new ZeldiabloJeu(Donjon.chemin + "niveau1.txt"));
        this.listeNiveau.add(new ZeldiabloJeu(Donjon.chemin + "niveau2.txt"));
        

    }

    public ArrayList<ZeldiabloJeu> getListeNiveau(){

        
        return this.listeNiveau;

    }

    
}
