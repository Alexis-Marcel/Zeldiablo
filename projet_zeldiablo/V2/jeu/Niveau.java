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
     * Url du fond du labyrinthe
     */
    public String urlFond;

    private int itearation = 0;


    /**
     * Constructeur permettant d'initialiser le labyrithe, l'aventurier et la liste des monstres grâce à un fichier texte
     * @param src source du fichier texte initialisant le jeu
     */
    public Niveau(String src,String url){

        this.laby = new Labyrinthe();
        this.listeMonstre = new ArrayList<Monstre>();

        this.urlFond = url;

        chargerNiveau(src);
        
    }

    /**
     * méthode permettant de mofiier les objets composants le jeu 
     */
    public void evoluer(Commande commandeUser){

            deplacerAventurier(commandeUser);
            aventurierAttaque(commandeUser);

            
            if(itearation == 8){

                itearation=0;
                monstreAttaque();
                deplacerMonstre();

            }

            itearation++;
                
       
            

    }

    /**
     * méthode permettant d'indiquer si le jeu est fini
     */
    public boolean etreFini(){

        if(this.heros.etreMort() || this.laby.checkHeroSortie(this.heros.getX(), this.heros.getY())){
            return true;
        }
        return false;
    }

    /**
     * méthode permettant de déplacer l'aventurier
     * @param c commande envoyé par l'utilisateur pour controler l'aventurier
     */
    public void deplacerAventurier(Commande c){

        if (c.haut) {

            this.heros.setOrientation(Personnage.NORD);
            Case caseDep = this.laby.getCase(this.heros.getX(),this.heros.getY(), Personnage.NORD);
            this.heros.seDeplacer(caseDep);

        } else if (c.bas) {

            this.heros.setOrientation(Personnage.SUD);
            Case caseDep = this.laby.getCase(this.heros.getX(),this.heros.getY(), Personnage.SUD);
            this.heros.seDeplacer(caseDep);

        } else if (c.gauche) {

            this.heros.setOrientation(Personnage.OUEST);
            Case caseDep = this.laby.getCase(this.heros.getX(),this.heros.getY(), Personnage.OUEST);
            this.heros.seDeplacer(caseDep);

        } else if (c.droite) {

            this.heros.setOrientation(Personnage.EST);
            Case caseDep = this.laby.getCase(this.heros.getX(),this.heros.getY(), Personnage.EST);
            this.heros.seDeplacer(caseDep);

        }

        

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

           
            Case caseDevant = this.laby.getCase(this.heros.getX(),this.heros.getY(), this.heros.getOrientation());

            this.heros.attaquer(caseDevant);

            personnageMort(caseDevant.getOccupant());

        }

    }

    /**
     * méthode permettant de supprimer un personnage quand il est mort
     * @param m Personnage a supprimer
     */
    public void personnageMort(Personnage m){

        if(m != null){

            if(m.etreMort()){

                System.out.println("aie");
                m.getCase().setOccupant(null);
                this.listeMonstre.remove(m);
                
    
            }
        }

    }

    /**
     * méthode permettant à tous les monstres d'attaquer devant eux
     */
    public void monstreAttaque(){
        
        for(int i = 0; i < this.listeMonstre.size(); i++){

            Monstre m = this.listeMonstre.get(i);

                Case caseDevant= this.laby.getCase(m.getX(),m.getY(),m.getOrientation());
                m.attaquer(caseDevant);
            
        }
    }

    public Aventurier getAventurier(){
        return this.heros;
    }

    public ArrayList<Monstre> getListeMonstre(){
        return this.listeMonstre;
    }

    public void passeNiveauSuivant(String src,String uf){

        this.listeMonstre.clear();
        chargerNiveau(src);
        this.urlFond = uf;

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

                        this.laby.setListeCase(i, ord, new Case(false, null));
                    } else if (tempLigne.charAt(i) == ' ') {

                        this.laby.setListeCase(i, ord, new Case(true, null));
                    } else if (tempLigne.charAt(i) == 'D') {

                        Case c = new  Case (true,null);
                        this.heros = new Aventurier(i, ord, 10, 1,c);
                        this.laby.setListeCase(i, ord,c);

                    } else if (tempLigne.charAt(i) == 'S') {

                        this.laby.setListeCase(i, ord, new Case(true, null));
                        this.laby.setSortie(i,ord);
                    } else if (tempLigne.charAt(i) == 'M') {

                        Case c = new  Case (true,null);
                        Monstre m = new MonstreImmobile(i, ord, 10, 1,c);
                        this.laby.setListeCase(i, ord,c);
                        this.listeMonstre.add(m);
                        
                    } else if (tempLigne.charAt(i) == 'A') {

                        Case c = new  Case (true,null);
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

