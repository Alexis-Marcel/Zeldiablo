package jeu;
import java.util.ArrayList;
import java.io.*;

/**
 * Main
 */

import jeu.cases.*;

public class Jeu {

    /**
     * Aventurier
     */
    ArrayList<Personnage> listePersonnage;

    /**
     * Aventurier
     */
    Labyrinthe labyrinthe;

    /** 
     * CONSTRUCTEUR
     */ 
    public Jeu(String src){

        this.labyrinthe = new Labyrinthe();
        this.listePersonnage = new ArrayList<Personnage>();

        chargerJeu(src);
        
    }

    public void deplacerPersonnage(int n,int deplacementX, int deplacementY){

        Personnage p = this.listePersonnage.get(n);

        if(verificationDeplacement(p,deplacementX,deplacementY)){
            p.deplacer(deplacementX, deplacementY);
        }
    }

    public boolean verificationDeplacement(Personnage p,int nx, int ny){ 

        Case c = this.labyrinthe.getListeCase()[p.getX()+nx][p.getY()+ny];

        if(c instanceof CasePleine ){
                return false;
        }


        return true;
    }

     /**
    * méthode permettant de charger une sauvegarde du jeu fait préalablement
    * @param src source à laquelle charger le fichier de sauvegarde
	*/
    public void chargerJeu(String src) {

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
                        this.listePersonnage.add(new Aventurier(i,ord,"Bebert",10,1));
                    }
                    else if (tempLigne.charAt(i) == 'S'){
                        this.labyrinthe.setListeCase(ord, i,new CaseFin(i, ord));
                    }
                    else if (tempLigne.charAt(i) == 'M'){
                        this.listePersonnage.add(new Monstre());
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