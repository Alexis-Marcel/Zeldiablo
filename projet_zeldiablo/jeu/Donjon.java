package jeu;
import java.util.ArrayList;

public class Donjon {
    
    /**
     * Aventurier
     */
    ArrayList<Niveau> listeNiveau;

    private final static String chemin = "projet_zeldiablo/niveaux/";


    public Donjon() {
        this.listeNiveau = new ArrayList<Niveau>();
        /*
        this.listeNiveau.add(new Niveau(Donjon.chemin + "niveau1.txt"));
        this.listeNiveau.add(new Niveau(Donjon.chemin + "niveau2.txt"));
        */

    }

    public ArrayList<Niveau> getListeNiveau(){

        
        return this.listeNiveau;

    }

    
}
