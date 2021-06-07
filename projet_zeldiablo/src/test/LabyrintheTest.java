package test;

import static org.junit.Assert.*;
import org.junit.Test;

import jeu.Labyrinthe;
import jeu.cases.*;

public class LabyrintheTest{

    @Test
    public void testConstructeurVide(){
        Labyrinthe l = new Labyrinthe();
        Case[][] lc = l.getListeCase();
        boolean res = lc.length == 10 && lc[0].length == 10;
        assertEquals("La taille du labyrinthe devrait être de 10 sur 10", res, true);
    }

    @Test
    public void testConstructeur2(){
        Labyrinthe l = new Labyrinthe(5,4);
        Case[][] lC = l.getListeCase();
        boolean res = lC.length == 5 && lC[0].length == 4;
        assertEquals("La taille du labyrinthe devrait être de 5 sur 4", res, true);
    }

    @Test
    public void testcoordonneeCaseDepart(){
        Labyrinthe l = new Labyrinthe();
        int[] coords = l.coordonneeCaseDepart();
        boolean res = coords[0] == 4 && coords[1] == 4;
        assertEquals("Les coordonnees du millieu devrait etre 4;4", res, true);
    }
}