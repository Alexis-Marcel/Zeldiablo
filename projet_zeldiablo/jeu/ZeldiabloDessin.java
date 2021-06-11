package jeu;

import java.awt.*;
import java.awt.image.BufferedImage;

import jeu.Personnage.*;

import moteurJeu.*;
import java.io.*;
import javax.imageio.*;

public class ZeldiabloDessin implements DessinJeu {

    private Donjon dj;
    private static final String cheminPerso = "projet_zeldiablo/png/";

    public ZeldiabloDessin(Donjon j) {

        this.dj = j;
    }

    

    @Override
    public void dessiner(BufferedImage image) {

        Graphics g = image.getGraphics();

        if(this.dj.getNiveauActuel() < this.dj.getListeNiveau().size()){

            Niveau zJeu = dj.getListeNiveau().get(dj.getNiveauActuel());

            Aventurier a = zJeu.getAventurier();

            if(!a.etreMort()){

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int longueurCase = image.getWidth() / 10;
                int largeurCase = image.getHeight() / 10;


                /**
                 * fond du niveau du labyrinthe
                 */
                try {
                    BufferedImage fond = ImageIO.read(new File(zJeu.urlFond));
                    g.drawImage(fond, 0, 0, 800, 800, null);
                } catch (Exception e) {
                
                }
            
                /**
                 * partie graphique de l'aventurier
                 */
                

                int coordX = (int) Math.floor(zJeu.getAventurier().getX() * longueurCase);
                int coordY = (int) Math.floor(zJeu.getAventurier().getY() * largeurCase);

                BufferedImage imgPerso;

                switch (a.getOrientation()) { 


                    case Personnage.NORD:

                        try {
                           
                            imgPerso = ImageIO.read(new File(cheminPerso+"herosDerriere.png"));
                            g.drawImage(imgPerso, coordX+20, coordY-10, 40, 61, null);
                            } catch (Exception e) {
                                System.out.println(e);
                        }
                        
                        break;
                    case Personnage.SUD:
                    
                        try {
                            imgPerso = ImageIO.read(new File(cheminPerso+"herosFace.png"));
                            g.drawImage(imgPerso, coordX+20, coordY-10, 40, 61, null);
                            } catch (Exception e) {
                                System.out.println(e);
                        }
                        break;
                    case Personnage.EST:

                        try {
                            imgPerso = ImageIO.read(new File(cheminPerso+ "herosDroite.png"));
                            g.drawImage(imgPerso, coordX+20, coordY-10, 40, 61, null);
                            } catch (Exception e) {
                                System.out.println(e);
                        }
                    
                        break;
                    case Personnage.OUEST:

                        try {
                            imgPerso = ImageIO.read(new File(cheminPerso+"herosGauche.png"));
                            g.drawImage(imgPerso, coordX+20, coordY-10, 40, 61, null);
                            } catch (Exception e) {
                                System.out.println(e);
                        }
                    
                    
                        break;        
                }
            
                

                /**
                 * partie graphique des monstres
                 */

                for(int i=0;i<zJeu.getListeMonstre().size();i++){
            
                            int coordXMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getX() * longueurCase);
                            int coordYMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getY() * largeurCase);

                            switch (zJeu.getListeMonstre().get(i).getOrientation()) {

                    
                                case Personnage.NORD:
                    
                                    try {
                                        imgPerso = ImageIO.read(new File(cheminPerso+"monstreDerriere.png"));
                                        g.drawImage(imgPerso, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                        } catch (Exception e) {
                                            System.out.println(e);
                                    }
                                    
                                    break;
                                case Personnage.SUD:
                                
                                    try {
                                        imgPerso = ImageIO.read(new File(cheminPerso+"monstreFace.png"));
                                        g.drawImage(imgPerso, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                        } catch (Exception e) {
                                            System.out.println(e);
                                    }
                                    break;
                                case Personnage.EST:
                    
                                    try {
                                        imgPerso = ImageIO.read(new File(cheminPerso+"monstreDroite.png"));
                                        g.drawImage(imgPerso, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                        } catch (Exception e) {
                                            System.out.println(e);
                                    }
                                
                                    break;
                                case Personnage.OUEST:
                    
                                    try {
                                        imgPerso = ImageIO.read(new File(cheminPerso+"monstreGauche.png"));
                                        g.drawImage(imgPerso, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                        } catch (Exception e) {
                                            System.out.println(e);
                                    }
                                
                                    break;        
                            }
                }
            

            }
            else {
                try{
                    BufferedImage fond = ImageIO.read(new File(cheminPerso+"fondMort.jpg"));
                    g.drawImage(fond, 0, 0, 800, 800, null);
                    g.setFont(new Font("Segoe Script",Font.BOLD + Font.ITALIC, 40));
                    g.drawString("Vous êtes mort ! Recommencez.",50, image.getHeight()/2);
                }
                catch (Exception e) {

                }
               
            }

        }
        else {

            try{
                BufferedImage fond = ImageIO.read(new File(cheminPerso+"fondMort.jpg"));
                g.drawImage(fond, 0, 0, 800, 800, null);
                g.setFont(new Font("Segoe Script",Font.BOLD + Font.ITALIC, 40));
                g.drawString("Vous avez gagné !",50, image.getHeight()/2);
            }
            catch (Exception e) {

            }
        }
         
       
    }

    

}
