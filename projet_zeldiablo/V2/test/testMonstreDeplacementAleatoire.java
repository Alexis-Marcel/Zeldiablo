package V2.test;

import V2.jeu.Personnage.*;
import V2.jeu.Case;

import static org.junit.Assert.*;
import org.junit.Test;

public class testMonstreDeplacementAleatoire {

    @Test
    public void testConstructeur(){
        MonstreDeplacementAleatoire m = new MonstreDeplacementAleatoire(0,0,0,0,new Case(true,null));
        boolean res = m.getX() == 0 && m.getY() == 0;
        assertEquals("Le constructeur n'initialise pas les bonnes coordonnees", res, true);
    }

    @Test
    public void testAttaquer(){
        Case c = new Case(true, null);
        Personnage p = new MonstreDeplacementAleatoire(0,0,1,0, c);
        MonstreDeplacementAleatoire m = new MonstreDeplacementAleatoire(0,0,0,1,new Case(true,null));
        m.attaquer(c);
        boolean res = p.etreMort();

        assertEquals("Le monstre n'a pas été actualisé", res, true);
    }

    @Test
    public void testSeDeplacer(){
        Case[] cases = new Case[2];
        cases[0] = new Case(true,null);
        cases[1] = new Case(true,null);

        MonstreDeplacementAleatoire m = new MonstreDeplacementAleatoire(0,0,0,0,new Case(true,null));
        
        m.seDeplacer(cases);
        boolean res = m.getCase() == cases[0] || m.getCase() == cases[1];
        assertEquals("Le monstre n'a pas été actualisé", res, true);
    }
}