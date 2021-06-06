package jeu;
import java.util.ArrayList;
import java.io.*;

import jeu.personnage.*;

/**
 * Main
 */

import jeu.cases.*;

public class Jeu {

    /**
     * Aventurier
     */
    private ArrayList<Monstre> listeMonstre;

    private Aventurier aventurier;

    /**
     * Aventurier
     */
    private Labyrinthe labyrinthe;

    /** 
     * CONSTRUCTEUR
     */ 
    public Jeu(String src){

        

        this.labyrinthe = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        chargerJeu(src);
        
    }

    public void deplacerToutMonstre(){

        
        for(int i=0; i<this.listeMonstre.size();i++){

            Monstre m = this.listeMonstre.get(i);

        }

    }
        

    public void deplacerUnMonstreAleatoire(){

    }


    public void deplacerAvtenturier(int deplacementX, int deplacementY){

        if(verificationMur(this.aventurier.getX()+deplacementX,this.aventurier.getY()+deplacementY) && 
           verificationPersonnage(this.aventurier.getX()+deplacementX,this.aventurier.getY()+deplacementY)){
            this.aventurier.deplacer(deplacementX, deplacementY);

            this.aventurier.deplacer(deplacementX,deplacementY);
        }
    }

    public boolean verificationMur(int x,int y){ 

        Case c = this.labyrinthe.getListeCase()[x][y];

        if(c instanceof CasePleine ){
                return false;
        }


        return true;
    }

    public boolean verificationPersonnage(int x,int y){ 

        for(int i=0; i<this.listeMonstre.size();i++){

            Monstre m = this.listeMonstre.get(i);

            if(m.getX() == x && m.getY() == y){
                return false;
            }

        }

        if(this.aventurier.getX() == x && this.aventurier.getY() == y){
            return false;
        }

        return true;
       
    }

    public ArrayList<Monstre> getListeMontre(){

        return this.listeMonstre;
    }

    public Aventurier getAventurier(){

        return this.aventurier;
    }

    public Labyrinthe getLabyrinthe(){

        return this.labyrinthe;
    }

     /**
    * méthode permettant de charger une sauvegarde du jeu fait préalablement
    * @param src source à laquelle charger le fichier de sauvegarde
	*/
    private void chargerJeu(String src) {

        try {

            int ord = 0;
    
            BufferedReader bfr = new BufferedReader(new FileReader(new File(src)));
                        
            String tempLigne = bfr.readLine(); //création d'une variable temporaire stockant la ligne actuellement en lecture
            while(tempLigne != null) { //tant que la lecture du fichier n'est pas fini
                for(int i = 0; i<tempLigne.length(); i++) { // pour chaque caractère de la ligne
                    
                    if(tempLigne.charAt(i) == '#') { 
                        this.labyrinthe.setListeCase(ord, i, new CasePleine(i, ord));
                    }
                    else if (tempLigne.charAt(i) == ' '){
                        this.labyrinthe.setListeCase(ord, i,new CaseVide(i, ord));
                    }	
                    else if (tempLigne.charAt(i) == 'D'){
                        this.labyrinthe.setListeCase(ord, i, new CaseDepart(i, ord));
                        this.aventurier = new Aventurier(i,ord,"Bebert",10,1);
                    }
                    else if (tempLigne.charAt(i) == 'S'){
                        this.labyrinthe.setListeCase(ord, i,new CaseFin(i, ord));
                    }
                    else if (tempLigne.charAt(i) == 'M'){
                        this.listeMonstre.add( new MonstreImmobile(i,ord));
                    }

                }
                ord++; // passe à la ligne suivante
                tempLigne = bfr.readLine(); //on lit la prochaine ligne à traiter
            }
    
            bfr.close();
                   
            }catch(IOException e) {
                System.out.println(e.getMessage());
                
            };

    }






}