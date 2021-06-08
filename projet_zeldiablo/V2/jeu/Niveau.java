package V2.jeu;

//import

import V2.jeu.Personnage.*;
import V2.moteurJeu.*;

import java.util.ArrayList;

/**
 * Niveau
 */

public class Niveau implements Jeu{ 

    /**
     * Labyrinthe sur lequel va se dérouler le jeu
     */
    private Labyrinthe laby;

    /**
     * Liste des monstres présent sur le labyrinthe
     */
    private ArrayList<Monstre> listeMonstre;

    /**
     * Aventurier qui va etre controler par l'utilisateur
     */
    private Aventurier hero;

    public Niveau(String src){

        this.laby = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        chargerNiveau(src);
        
    }

    public void evoluer(Commande commandeUser){

    }

    public boolean etreFini(){
        return false;
    }

    public void deplacerAventurier(Commande c){

        Case[] c = new Case[1];

        if (c.haut) {

            c[0] = this.laby.getCase(this.aventurier.getX(),this.aventurier.getY()-1);
        } else if (c.bas) {

            c[0] = this.laby.getCase(this.aventurier.getX(),this.aventurier.getY()+1);

        } else if (c.gauche) {

            c[0] = this.laby.getCase(this.aventurier.getX()-1,this.aventurier.getY());
        } else if (c.droite) {

            c[0] = this.laby.getCase(this.aventurier.getX()+1,this.aventurier.getY()-1);

        }

        this.aventurier.seDeplacer(c);

    }

    public void deplacerMonstre(){

        for(int i=0; i < this.listeMonstre.size(); i++){

            Monstre m = this.listeMonstre.get(i);

            Case[] listeCaseAdjacentes = this.laby.casesAdjacentes(m.getX(),m.getY());

            m.seDeplacer(listeCaseAdjacentes);
        }

    }

    public void aventurierAttaque(Commande c){

        if(c.attaque){

            this.aventurier.attaquer();
        }

    }

    public void monstreAttaque(){

        for(int i = 0; i < this.listeMonstre.size(); i++){

            Monstre m = this.listeMonstre.get(i);

            m.attaquer();
        }
    }


    /**
     * méthode permettant de charger un fichier .txt du Niveau fait préalablement
     * 
     * @param src source à laquelle charger le fichier texte
     */
    private void chargerNiveau(String src) {

        try {

            int ord = 0;

            BufferedReader bfr = new BufferedReader(new FileReader(new File(src)));

            String tempLigne = bfr.readLine(); // création d'une variable temporaire stockant la ligne actuellement en
                                               // lecture
            while (tempLigne != null) { // tant que la lecture du fichier n'est pas fini
                for (int i = 0; i < tempLigne.length(); i++) { // pour chaque caractère de la ligne

                    if (tempLigne.charAt(i) == '#') {

                        this.labyrinthe.setListeCase(i, ord, new CasePleine(i, ord));
                    } else if (tempLigne.charAt(i) == ' ') {

                        this.labyrinthe.setListeCase(i, ord, new CaseVide(i, ord));
                    } else if (tempLigne.charAt(i) == 'D') {

                        this.labyrinthe.setListeCase(i, ord, new CaseDepart(i, ord));
                        this.aventurier = new Aventurier(i, ord, "Anakin", 10, 1);
                    } else if (tempLigne.charAt(i) == 'S') {

                        this.labyrinthe.setListeCase(i, ord, new CaseFin(i, ord));
                    } else if (tempLigne.charAt(i) == 'M') {

                        this.labyrinthe.setListeCase(i, ord, new CaseVide(i, ord));
                        this.listeMonstre.add(new MonstreImmobile(i, ord, 10, 1));
                    } else if (tempLigne.charAt(i) == 'A') {

                        this.labyrinthe.setListeCase(i, ord, new CaseVide(i, ord));
                        this.listeMonstre.add(new MonstreAttireParHeros(i, ord, 10, 1));
                    }

                }
                ord++; // passe à la ligne suivante
                tempLigne = bfr.readLine(); // on lit la prochaine ligne à traiter
            }

            bfr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        ;

    }


}

