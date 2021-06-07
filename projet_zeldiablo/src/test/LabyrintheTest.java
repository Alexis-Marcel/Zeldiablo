package test;

import static org.junit.Assert.*;
import org.junit.Test;

import jeu.Labyrinthe;
import jeu.cases.*;

import jeu.Jeu;

public class LabyrintheTest{

    @Test
    public void testConstructeurVide(){
        Labyrinthe l = new Labyrinthe();
        Case[][] lc = l.getListeCase();
        boolean res = lc.length == 10 && lc[0].length == 10;
        assertEquals("La taille du labyrinthe devrait être de 10 sur 10", res, true);
    }

    @Test
    public void testSetListeCase(){
        Jeu j = new Jeu("../niveaux/niveau_1.txt");
        Labyrinthe l = j.getLabyrinthe();
        l.setListeCase(0, 0, new CaseVide(0, 0));
        boolean res = l.getListeCase()[0][0] instanceof CaseVide;
        assertEquals("La case devrait être vide", res, true);
    }
}