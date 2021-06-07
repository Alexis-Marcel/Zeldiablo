package jeu;
import java.util.ArrayList;

public class Donjon {
    
    /**
     * Aventurier
     */
    ArrayList<ZeldiabloJeu> listeNiveau;

    private final static String cheminNiveau = "projet_zeldiablo/niveaux/";
    private final static String cheminFond = "projet_zeldiablo/fond/";


    public Donjon() {
        this.listeNiveau = new ArrayList<ZeldiabloJeu>();
        
        this.listeNiveau.add(new ZeldiabloJeu(Donjon.cheminNiveau + "niveau1.txt",Donjon.cheminFond+"niveau1.png"));
        this.listeNiveau.add(new ZeldiabloJeu(Donjon.cheminNiveau + "niveau2.txt",Donjon.cheminFond+"niveau2.png"));
        

    }

    public ArrayList<ZeldiabloJeu> getListeNiveau(){

        
        return this.listeNiveau;

    }

    
}
