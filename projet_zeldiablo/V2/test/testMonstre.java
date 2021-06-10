package V2.test;

import V2.jeu.Personnage.*;
import V2.jeu.Case;


import static org.junit.Assert.*;
import org.junit.Test;

public class testMonstre {
    
    @Test
    public void testConstructeurImmobile(){
        Monstre m = new MonstreImmobile(0,0,0,0,new Case(true));
        boolean res = m.getX() == 0 && m.getY() == 0;
        assertTrue("Le constructeur n'initialise pas les bonnes coordonnees", res);
    }

    @Test
    public void testMonstreImmobileAttaqueAventurier(){
        Case c = new Case(true);
        Personnage p = new Aventurier(0,0,1,0, c);
        Monstre m = new MonstreImmobile(0,0,0,1,new Case(true));
        m.attaquer(c);
        boolean res = p.etreMort();

        assertTrue("L'aventurier devrait etre mort", res);
    }

    @Test
    public void testMonstreImmobileAttaqueMonstre(){
        Case c = new Case(true);
        Personnage p = new MonstreImmobile(0,0,1,0, c);
        Monstre m = new MonstreImmobile(0,0,0,1,new Case(true));
        m.attaquer(c);
        boolean res = p.etreMort();

        assertTrue("Le monstre ne devrait pas etre mort", !res);
    }

    @Test
    public void testMonstresEstAttaque(){
        Case c = new Case(true);
        Monstre m = new MonstreImmobile(0,0,1,0, c);
        Aventurier a = new Aventurier(0,0,0,1,new Case(true));
        a.attaquer(c);
        boolean res = m.etreMort();

        assertTrue("Le monstre devrait etre mort", res);
    }

    @Test
    public void testMonstreImmobileDeplacer(){
        Case[] c = { new Case(true),new Case(true),new Case(true),new Case(true)};
        Monstre m = new MonstreImmobile(0,0,0,1,new Case(true));
        m.seDeplacer(c);

        assertEquals("Le monstre ne devrait pas avoir bouger",m.getX(),0 );
        assertEquals("Le monstre ne devrait pas avoir bouger",m.getX(),0 );
    }

}
