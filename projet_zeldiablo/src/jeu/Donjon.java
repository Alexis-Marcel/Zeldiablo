package jeu;
import java.util.ArrayList;

public class Donjon {
    
    /**
     * Aventurier
     */
    ArrayList<Jeu> listeJeu;

    private final static String chemin = "projet_zeldiablo/src/niveaux/";


    public Donjon() {
        this.listeJeu = new ArrayList<Jeu>();
        this.listeJeu.add(new Jeu(Donjon.chemin + "niveau1.txt"));
        this.listeJeu.add(new Jeu(Donjon.chemin + "niveau2.txt"));

    }

    public ArrayList<Jeu> getListeJeu(){

        
        return this.listeJeu;

    }

    
}
