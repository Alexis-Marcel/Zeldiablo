package V2.jeu;

//import

import V2.jeu.Personnage.*;
import V2.moteurJeu.*;

import java.util.ArrayList;
import java.io.*;

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
    private Aventurier heros;


    /**
     * Constructeur permettant d'initialiser le labyrithe, l'aventurier et la liste des monstres grâce à un fichier texte
     * @param src source du fichier texte initialisant le jeu
     */
    public Niveau(String src){

        this.laby = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        chargerNiveau(src);
        
    }

    /**
     * méthode permettant de mofiier les objets composants le jeu 
     */
    public void evoluer(Commande commandeUser){

    }

    /**
     * méthode permettant d'indiquer si le jeu est fini
     */
    public boolean etreFini(){
        return false;
    }

    /**
     * méthode permettant de déplacer l'aventurier
     * @param c commande envoyé par l'utilisateur pour controler l'aventurier
     */
    public void deplacerAventurier(Commande c){

        Case[] c = new Case[1];

        if (c.haut) {

            c[0] = this.laby.getCase(this.heros.getX(),this.heros.getY()-1);
        } else if (c.bas) {

            c[0] = this.laby.getCase(this.heros.getX(),this.heros.getY()+1);

        } else if (c.gauche) {

            c[0] = this.laby.getCase(this.heros.getX()-1,this.heros.getY());
        } else if (c.droite) {

            c[0] = this.laby.getCase(this.heros.getX()+1,this.heros.getY()-1);

        }

        this.heros.seDeplacer(c);

    }


    /**
     * méthode permettant de déplacer tout les monstres 
     */
    public void deplacerMonstre(){

        for(int i=0; i < this.listeMonstre.size(); i++){

            Monstre m = this.listeMonstre.get(i);

            Case[] listeCaseAdjacentes = this.laby.casesAdjacentes(m.getX(),m.getY());

            m.seDeplacer(listeCaseAdjacentes);
        }

    }

    /**
     * méthode permettant à l'aventurier d'attaquer un monstre devant lui selon la commande envoyé par l'utlisateur
     * @param c commande envoyé par l'utilisateur
     */
    public void aventurierAttaque(Commande c){

        if(c.attaque){

            this.heros.attaquer();
        }

    }

    /**
     * méthode permettant à tous les monstres d'attaquer devant eux
     */
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

                        this.laby.setListeCase(i, ord, new Case(true));
                    } else if (tempLigne.charAt(i) == ' ') {

                        this.laby.setListeCase(i, ord, new Case(false));
                    } else if (tempLigne.charAt(i) == 'D') {

                        Case c = new  Case (false);
                        this.heros = new Aventurier(i, ord, "Anakin", 10, 1,c);
                        this.laby.setListeCase(i, ord,c);

                    } else if (tempLigne.charAt(i) == 'S') {

                        this.laby.setListeCase(i, ord, new Case(false));
                        this.laby.setSortie(i,ord);
                    } else if (tempLigne.charAt(i) == 'M') {

                        Case c = new  Case (false);
                        Monstre m = new MonstreImmobile(i, ord, 10, 1,c);
                        this.laby.setListeCase(i, ord,c);
                        this.listeMonstre.add(m);
                        
                    } else if (tempLigne.charAt(i) == 'A') {

                        Case c = new  Case (false);
                        Monstre m = new MonstreDeplacementAleatoire(i, ord, 10, 1,c);
                        this.laby.setListeCase(i, ord,c);
                        this.listeMonstre.add(m);
                    }

                }
                ord++; // passe à la ligne suivante
                tempLigne = bfr.readLine(); // on lit la prochaine ligne à traiter
            }

            bfr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        

    }


}
