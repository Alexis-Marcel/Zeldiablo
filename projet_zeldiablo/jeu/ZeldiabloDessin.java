package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jeu.cases.Case;
import jeu.cases.CasePleine;
import moteurJeu.*;

public class ZeldiabloDessin implements DessinJeu{

    private ZeldiabloJeu zJeu;

    public ZeldiabloDessin(ZeldiabloJeu j){
        
        this.zJeu = j;
    }
    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();

        

        int longueurCase = image.getWidth()/10;
        int largeurCase = image.getHeight()/10;

        g.setColor(Color.BLACK);
        
        Case[][] lC = zJeu.getLabyrinthe().getListeCase();
        for(int i = 0; i < lC.length; i++){
            for(int j = 0; j < lC[i].length; j++){

                if(lC[i][j] instanceof CasePleine){
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(Color.GRAY);
                }

                g.fillRect(i*longueurCase, j*largeurCase, longueurCase, largeurCase);    
            }
            g.setColor(Color.RED);
            int coordX = (int) Math.floor(zJeu.getAventurier().getX()*longueurCase);
            int coordY = (int) Math.floor(zJeu.getAventurier().getY()*largeurCase);
            

            g.fillOval(coordX+5,coordY+5, longueurCase-10, largeurCase-10);
        }
        
    }
    
    
}