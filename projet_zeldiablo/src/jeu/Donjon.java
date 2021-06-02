package jeu;
import java.util.ArrayList;

public class Donjon {
    
    /**
     * Aventurier
     */
    ArrayList<Jeu> listeJeu;

    public Donjon() {
        listeJeu = new ArrayList<Jeu>();
        this.listeJeu.add(new Jeu("niveau1.txt"));
        this.listeJeu.add(new Jeu("niveau2.txt"));

    }

    
}
