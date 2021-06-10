package test;

import jeu.Personnage.*;
import jeu.Case;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAventurier {

    @Test
    public void testConstructeur(){
        Aventurier a = new Aventurier(0,0,0,0,new Case(true));
        boolean res = a.getX() == 0 && a.getY() == 0;
        assertEquals("Le constructeur n'initialise pas les bonnes coordonnees", res, true);
    }

    @Test
    public void testSeDeplacer(){
        Aventurier a = new Aventurier(0,0,0,0,new Case(true));
        Case c = new Case(true);
        a.seDeplacer(c);
        boolean res = c.getOccupant() == a;
        assertEquals("L'Aventurier ne se deplace pas sur la bonne Case", res, true);
    }

    @Test
    public void testSeDeplacerCasePleine(){
        Aventurier a = new Aventurier(0,0,0,0,new Case(true));
        Case c = new Case(false);
        a.seDeplacer(c);
        boolean res = c.getOccupant() != a;
        assertEquals("L'Aventurier ne devrait pas se deplacer sur cette Case", res, true);
    }

    @Test
    public void testAttaquer(){
        Aventurier a = new Aventurier(0,0,1,1,new Case(true));
        Case c = new Case(true);
        Monstre m = new MonstreImmobile(0,1,1,1,c);
        a.attaquer(c);
        boolean res = m.etreMort();
        assertEquals("Le monstre devrait être mort", res, true);
    }

    @Test
    public void testOrientationDepart(){
        Aventurier a = new Aventurier(0,0,1,1,new Case(true));
        boolean res = Personnage.SUD == a.getOrientation();
        assertEquals("Son orientation de depart devrait être SUD", res, true);
    }

    @Test
    public void testEtreAventurier(){
        Aventurier a = new Aventurier(0,0,1,1,new Case(true));
        boolean res = a.etreAventurier();
        assertEquals("La methode devrait retourner true", res, true);
    }   

}
