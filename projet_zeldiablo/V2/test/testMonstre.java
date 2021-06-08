package V2.test;

import V2.jeu.Personnage.*;
import V2.jeu.Case;
import V2.jeu.Labyrinthe;

import static org.junit.Assert.*;
import org.junit.Test;

public class testMonstre {
    
    @Test
    public void testConstructeur(){
        Monstre m = new Monstre(0,0,0,0,new Case(true));
        boolean res = m.getX() == 0 && m.getY() == 0;
        assertEquals("Le constructeur n'initialise pas les bonnes coordonnees", res, true);
    }

    @Test
    public void testAttaquer(){
        Case c = new Case(true);
        Personnage p = new Monstre(0,0,1,0, c);
        Monstre m = new Monstre(0,0,0,1,new Case(true));
        m.attaquer(c);
        boolean res = p.etreMort();

        assertEquals("Le monstre n'a pas été actualisé", res, true);
    }

}
