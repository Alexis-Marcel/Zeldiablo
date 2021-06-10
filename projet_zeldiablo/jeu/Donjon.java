package jeu;
import java.util.ArrayList;

import moteurJeu.*;

public class Donjon implements Jeu{
    
    /**
     * liste des différents niveau
     */
    ArrayList<Niveau> listeNiveau;

    /**
     * entier correspondant au niveau actuel dans la liste des niveaux
     */
    private int niveauActuelle;

    /**
     * entier permettant de regler la vitesse d'action des monstres
     */
    private int iteration;

    /**
     * attributs correspondant aux chemins pour aller jusqu'au fichiers
     */
    private final static String cheminNiveau = "projet_zeldiablo/V2/niveaux/";
    private final static String cheminFond = "projet_zeldiablo/V2/fond/";
    private final static int NOMBRENIVEAUX = 4;


    public Donjon() {
        this.listeNiveau = new ArrayList<Niveau>();
        this.niveauActuelle = 0;

        for(int i=1; i<=NOMBRENIVEAUX;i++){
            this.listeNiveau.add(new Niveau(Donjon.cheminNiveau + "niveau" +i+".txt",Donjon.cheminFond+"niveau"+i+".png"));
        }      

    }

    /**
     * méthode permettant de faire évoluer le jeu
     * @param commandeUser permet de récuperer les commandes envoyés par l'utilisateur
     */
    public void evoluer(Commande commandeUser){

        if(this.niveauActuelle < this.listeNiveau.size()){


            Niveau nivAct = this.listeNiveau.get(niveauActuelle);

            nivAct.deplacerAventurier(commandeUser);
            nivAct.aventurierAttaque(commandeUser);
        
            
            if(iteration == 8){
        
                iteration=0;
                nivAct.monstreAttaque();
                nivAct.deplacerMonstre();
        
            }
        
            iteration++;


            passeNiveauSuivant();

        
        }
            
    }
    
    /**
    * méthode permettant d'indiquer si le jeu est fini
    *@return true si le jeu doit etre arrete
    */
    public boolean etreFini(){
        
    
    if(this.niveauActuelle >= this.listeNiveau.size()){
        return true;
    }
    else if(this.listeNiveau.get(niveauActuelle).getAventurier().etreMort()){

        return true;
    }
    return false;
    }


    /**
     * méthode permettant de passer au niveau suivant en fonction de ou est le personnage
     */
    public void passeNiveauSuivant(){

            Niveau nivAct = this.listeNiveau.get(niveauActuelle);

            if(nivAct.getLabyrinthe().checkHeroSortie(nivAct.getAventurier().getX(),nivAct.getAventurier().getY())){

                  this.niveauActuelle++;
            }
        

    }

     // -------- GETTERS --------- //
     public ArrayList<Niveau> getListeNiveau(){

        
        return this.listeNiveau;

    }

    public int getNiveauActuel(){

        return this.niveauActuelle;
    }

    
}

