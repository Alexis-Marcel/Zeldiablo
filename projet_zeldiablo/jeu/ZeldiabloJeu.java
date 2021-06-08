package jeu;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import jeu.personnage.*;
import jeu.cases.*;


import moteurJeu.*;

public class ZeldiabloJeu {

    /**
     * liste des monstres présent dans le niveau
     */
    private ArrayList<Monstre> listeMonstre;

    /**
     * Aventurier controlable par le joueur
     */
    private Aventurier aventurier;

    /**
     * labyrinthe sur lequel se deplaceront et attaqueront les monstres et
     * l'aventurier
     */
    private Labyrinthe labyrinthe;

    private String urlFond;

    /**
     * CONSTRUCTEUR
     */
    public ZeldiabloJeu(String src,String url ) {

        this.labyrinthe = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        chargerNiveau(src);

        this.urlFond = url;

    }

    

    /**
     * methode permettant deplacer tout les monstres de la liste selon le methode verifierCoord respectif
     */
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

    
    /**
     * methode permettant deplacer un monstre aleatoirement
     */
    public void deplacerUnMonstreAleatoire() {

        Random rand = new Random();

        Monstre m = this.listeMonstre.get(rand.nextInt(this.listeMonstre.size()));

        int[] l = m.verifierCoord(this.aventurier);

        if (verificationMur(m.getX() + l[0], m.getY() + l[1]) // permet de vérifier que le deplacement ne se fasse pas sur les murs
                && verificationPersonnage(m.getX() + l[0], m.getY() + l[1])) { // permet de vérifier que le deplacement ne se fasse pas à travers les personnages

            m.seDeplacer(l[0], l[1]);
        }

    }

    /**
     * methode permettant deplacer l'aventurier selon la commande
     */
    public void deplacerAvtenturier(Commande c) {

        int deplacementX = 0;
        int deplacementY = 0;

        if (c.haut) {

            deplacementX = 0;
            deplacementY = -1;

        } else if (c.bas) {

            deplacementX = 0;
            deplacementY = 1;

        } else if (c.gauche) {

            deplacementX = -1;
            deplacementY = 0;

        } else if (c.droite) {

            deplacementX = 1;
            deplacementY = 0;

        }

        if (verificationMur(this.aventurier.getX() + deplacementX, this.aventurier.getY() + deplacementY) // permet de vérifier que le deplacement ne se fasse pas sur les murs
            && verificationPersonnage(this.aventurier.getX() + deplacementX, // permet de vérifier que le deplacement ne se fasse pas à travers les personnages
                       this.aventurier.getY() + deplacementY)) {

            this.aventurier.seDeplacer(deplacementX, deplacementY);

        }

    }

    /**
     * Methode permettant de vérifier que le deplacement ne se fasse pas sur les murs
     * @param x
     * @param y
     * @return un boolean indiquant si le déplacement peut etre réalisé
     */

    public boolean verificationMur(int x, int y) {

        Case[][] tC = this.labyrinthe.getListeCase();
        Case c = tC[x][y];

        if (c instanceof CasePleine) {
            
            return false;
        }

        return true;
    }

    /**
     * Methode permettant de vérifier que le deplacement ne se fasse pas à travers les personnages
     * @param x
     * @param y
     * @return un boolean indiquant si le déplacement peut etre réalisé
     */
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

    // ---------------- GETTER ------------------  //

    public ArrayList<Monstre> getListeMonstre() {

        return this.listeMonstre;
    }

    public Aventurier getAventurier() {

        return this.aventurier;
    }

    public Labyrinthe getLabyrinthe() {

        return this.labyrinthe;
    }

    public String getUrlFond(){

        return this.urlFond;
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