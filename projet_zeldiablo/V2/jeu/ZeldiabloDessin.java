package V2.jeu;

import java.awt.*;
import java.awt.image.BufferedImage;

import V2.jeu.Personnage.*;

import V2.moteurJeu.*;
import java.io.*;
import javax.imageio.*;

public class ZeldiabloDessin implements DessinJeu {

    private Niveau zJeu;

    public ZeldiabloDessin(Niveau j) {

        this.zJeu = j;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rhints = g2d.getRenderingHints();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int longueurCase = image.getWidth() / 10;
        int largeurCase = image.getHeight() / 10;


        /*
        g.setColor(Color.BLACK);

        Case[][] lC = zJeu.getLabyrinthe().getListeCase();
        for (int i = 0; i < lC.length; i++) {
            for (int j = 0; j < lC[i].length; j++) {

                if (lC[i][j] instanceof CasePleine) {
                    g.setColor(Color.BLACK);
                } else if(lC[i][j] instanceof CaseFin){
                    g.setColor(Color.GREEN);
                }else{
                    g.setColor(Color.GRAY);
                }

                g.fillRect(i * longueurCase, j * largeurCase, longueurCase, largeurCase);
            }
            
        }
        */
        

        try {
            BufferedImage fond = ImageIO.read(new File(zJeu.urlFond));
            g.drawImage(fond, 0, 0, 800, 800, null);
        } catch (Exception e) {
           
        }
    
        Aventurier a = zJeu.getAventurier();

        int coordX = (int) Math.floor(zJeu.getAventurier().getX() * longueurCase);
        int coordY = (int) Math.floor(zJeu.getAventurier().getY() * largeurCase);

        switch (a.getOrientation()) {

            
            case Personnage.NORD:

                try {
                    BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/herosDerriere.png"));
                    g.drawImage(fond, coordX+20, coordY-10, 40, 61, null);
                    } catch (Exception e) {
                        System.out.println(e);
                }
                
                break;
            case Personnage.SUD:
               
                try {
                    BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/herosFace.png"));
                    g.drawImage(fond, coordX+20, coordY-10, 40, 61, null);
                    } catch (Exception e) {
                        System.out.println(e);
                }
                break;
            case Personnage.EST:

                try {
                    BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/herosDroite.png"));
                    g.drawImage(fond, coordX+20, coordY-10, 40, 61, null);
                    } catch (Exception e) {
                        System.out.println(e);
                }
               
                break;
            case Personnage.OUEST:

                try {
                    BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/herosGauche.png"));
                    g.drawImage(fond, coordX+20, coordY-10, 40, 61, null);
                    } catch (Exception e) {
                        System.out.println(e);
                }
               
                break;        
        }
        

            
           
            //g.fillOval(coordX + 5, coordY + 5, longueurCase - 10, largeurCase - 10);
        

        

        g.setColor(Color.BLUE);

        for(int i=0;i<zJeu.getListeMonstre().size();i++){
      
                    int coordXMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getX() * longueurCase);
                    int coordYMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getY() * largeurCase);

                    switch (zJeu.getListeMonstre().get(i).getOrientation()) {

            
                        case Personnage.NORD:
            
                            try {
                                BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/monstreDerriere.png"));
                                g.drawImage(fond, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                } catch (Exception e) {
                                    System.out.println(e);
                            }
                            
                            break;
                        case Personnage.SUD:
                           
                            try {
                                BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/monstreFace.png"));
                                g.drawImage(fond, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                } catch (Exception e) {
                                    System.out.println(e);
                            }
                            break;
                        case Personnage.EST:
            
                            try {
                                BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/monstreDroite.png"));
                                g.drawImage(fond, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                } catch (Exception e) {
                                    System.out.println(e);
                            }
                           
                            break;
                        case Personnage.OUEST:
            
                            try {
                                BufferedImage fond = ImageIO.read(new File("projet_zeldiablo/V2/fond/monstreGauche.png"));
                                g.drawImage(fond, coordXMonstre+13, coordYMonstre-8, 54, 65, null);
                                } catch (Exception e) {
                                    System.out.println(e);
                            }
                           
                            break;        
                    }
                    

        }



         
    }

}
