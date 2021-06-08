package jeu;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import jeu.personnage.*;
import moteurJeu.*;
import jeu.cases.*;

public class Niveau {

    /**
     * liseMonstre
     */
    private ArrayList<Monstre> listeMonstre;

    /**
     * Aventurier controlable par le joueur
     */
    private Aventurier aventurier;

    /**
     * labyrinthe sur lequel se deplaceront et attaqueront les monstres et
     * l'acventurier
     */
    private Labyrinthe labyrinthe;

    /**
     * CONSTRUCTEUR
     */
    public Niveau() {

        this.labyrinthe = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        chargerNiveau("niveaux/niveau1.txt");

    }

    public void deplacerToutMonstre() {

        for (int i = 0; i < this.listeMonstre.size(); i++) {

            Monstre m = this.listeMonstre.get(i);

            int[] l = m.verifierCoord(this.aventurier);

            if (verificationMur(m.getX() + l[0], m.getY() + l[1])
                    && verificationPersonnage(m.getX() + l[0], m.getY() + l[1])) {

                m.seDeplacer(l[0], l[1]);
            }

        }

    }

    public void deplacerUnMonstreAleatoire() {

        Random rand = new Random();

        Monstre m = this.listeMonstre.get(rand.nextInt(this.listeMonstre.size()));

        int[] l = m.verifierCoord(this.aventurier);

        if (verificationMur(m.getX() + l[0], m.getY() + l[1])
                && verificationPersonnage(m.getX() + l[0], m.getY() + l[1])) {

            m.seDeplacer(l[0], l[1]);
        }

    }

    public void deplacerAvtenturier(Commande c) {

        int deplacementX;
        int deplacementY;

        if (c.haut) {

        } else if (c.bas) {

        } else if (c.gauche) {

        } else if (c.droite) {

        }

        /*
         * if(verificationMur(this.aventurier.getX()+deplacementX,this.aventurier.getY()
         * +deplacementY) &&
         * verificationPersonnage(this.aventurier.getX()+deplacementX,this.aventurier.
         * getY()+deplacementY)){
         * 
         * this.aventurier.seDeplacer(deplacementX, deplacementY);
         * 
         */

    }

    public boolean verificationMur(int x, int y) {

        Case c = this.labyrinthe.getListeCase()[x][y];

        if (c instanceof CasePleine) {
            System.out.println("plein");
            return false;
        }

        return true;
    }

    public boolean verificationPersonnage(int x, int y) {

        for (int i = 0; i < this.listeMonstre.size(); i++) {

            Monstre m = this.listeMonstre.get(i);

            if (m.getX() == x && m.getY() == y) {
                return false;
            }

        }

        if (this.aventurier.getX() == x && this.aventurier.getY() == y) {
            return false;
        }

        return true;

    }

    public ArrayList<Monstre> getListeMonstre() {

        return this.listeMonstre;
    }

    public Aventurier getAventurier() {

        return this.aventurier;
    }

    public Labyrinthe getLabyrinthe() {

        return this.labyrinthe;
    }

    /**
     * méthode permettant de charger une sauvegarde du Niveau fait préalablement
     * 
     * @param src source à laquelle charger le fichier de sauvegarde
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
                        this.aventurier = new Aventurier(i, ord, "Bebert", 10, 1);
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