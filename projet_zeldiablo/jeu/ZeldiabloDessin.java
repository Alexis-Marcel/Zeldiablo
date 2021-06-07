package jeu;

import java.awt.*;
import java.awt.image.BufferedImage;

import jeu.cases.*;
import moteurJeu.*;

public class ZeldiabloDessin implements DessinJeu {

    private ZeldiabloJeu zJeu;

    public ZeldiabloDessin(ZeldiabloJeu j) {

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

        g.setColor(Color.RED);
        int coordX = (int) Math.floor(zJeu.getAventurier().getX() * longueurCase);
        int coordY = (int) Math.floor(zJeu.getAventurier().getY() * largeurCase);

        g.fillOval(coordX + 5, coordY + 5, longueurCase - 10, largeurCase - 10);

        g.setColor(Color.BLUE);

        for(int i=0;i<zJeu.getListeMonstre().size();i++){

           
                int coordXMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getX() * longueurCase);
                int coordYMonstre = (int) Math.floor(zJeu.getListeMonstre().get(i).getY() * largeurCase);
                g.fillOval(coordXMonstre + 5, coordYMonstre + 5, longueurCase - 10, largeurCase - 10);
            

        }



         
    }

}