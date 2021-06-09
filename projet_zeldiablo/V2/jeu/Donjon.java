package V2.jeu;
import java.util.ArrayList;

import V2.moteurJeu.*;

public class Donjon implements Jeu{
    
    /**
     * Aventurier
     */
    ArrayList<Niveau> listeNiveau;
    private int niveauActuelle;
    private int iteration;

    private final static String cheminNiveau = "V2/niveaux/";
    private final static String cheminFond = "V2/fond/";


    public Donjon() {
        this.listeNiveau = new ArrayList<Niveau>();
        this.niveauActuelle = 0;
        
        this.listeNiveau.add(new Niveau(Donjon.cheminNiveau + "niveau1.txt",Donjon.cheminFond+"niveau1.png"));
        this.listeNiveau.add(new Niveau(Donjon.cheminNiveau + "niveau2.txt",Donjon.cheminFond+"niveau2.png"));
        

    }

    public ArrayList<Niveau> getListeNiveau(){

        
        return this.listeNiveau;

    }

    public int getNiveauActuel(){

        return this.niveauActuelle;
    }

    public void evoluer(Commande commandeUser){

        if(this.niveauActuelle < this.listeNiveau.size()){

            passeNiveauSuivant();

            Niveau nivAct = this.listeNiveau.get(niveauActuelle);

            nivAct.deplacerAventurier(commandeUser);
            nivAct.aventurierAttaque(commandeUser);
        
            
            if(iteration == 8){
        
                iteration=0;
                nivAct.monstreAttaque();
                nivAct.deplacerMonstre();
        
            }
        
            iteration++;

        
        }
            
    }
    
    /**
    * méthode permettant d'indiquer si le jeu est fini
    */
    public boolean etreFini(){
    
    if(this.niveauActuelle >= this.listeNiveau.size()){
        return true;
    }
    else if(this.listeNiveau.get(niveauActuelle).getAventurier().etreMort()){

        System.out.println("fin");
        return true;
    }
    return false;
    }


    public void passeNiveauSuivant(){

            Niveau nivAct = this.listeNiveau.get(niveauActuelle);

            if(nivAct.getLabyrinthe().checkHeroSortie(nivAct.getAventurier().getX(),nivAct.getAventurier().getY())){

        
                  this.niveauActuelle++;
            }
        

    }

    
}

