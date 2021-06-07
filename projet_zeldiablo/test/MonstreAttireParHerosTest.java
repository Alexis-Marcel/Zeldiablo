package test;

import static org.junit.Assert.*;
import org.junit.Test;


import Niveau.personnage.*;

public class MonstreAttireParHerosTest {

    @Test
    public void testConstructeur(){

        MonstreAttireParHeros m = new  MonstreAttireParHeros (1,1,10,5);
        boolean res = m.getX() == 1 && m.getY() == 1 && m.getPv() == 10 && m.getDegat() == 5 ;
        assertTrue("Le contructeur n'initialise pas les bons attributs.",res);
    }


    @Test 
    public void testAttaquer(){
        MonstreAttireParHeros m = new  MonstreAttireParHeros (1,1,10,5);
        Aventurier a = new Aventurier(1,1,"Billel",10,5);

        m.attaquer(a);

        assertEquals("L'aventurier devrait avoir 5pv", a.getPv(),5);

        m.attaquer(a);

        assertEquals("L'aventurier devrait avoir 0 pv ",a.getPv(),0);
        assertTrue("L'aventurier devrait etre mort(0 pv)",a.etreMort());
    }

    @Test 
    public void testPrendreDegats(){

        MonstreAttireParHeros m = new  MonstreAttireParHeros (1,1,10,5);
        Aventurier a = new Aventurier(1,1,"Billel",10,7);

        a.attaquer(m);

        assertEquals("Le monstre devrait avoir 3pv", m.getPv(),3);

        a.attaquer(m);

        assertEquals("Le monstre  devrait avoir 0 pv ",m.getPv(),0);
        assertTrue("Le monstre devrait etre mort(0 pv)",m.etreMort());
    }

    @Test 
    public void testDeplacer(){

        MonstreAttireParHeros m = new  MonstreAttireParHeros (1,2,10,5);
        Aventurier a = new Aventurier(7,2,"Billel",10,7);

        int[] l = m.verifierCoord(a);
       
        m.seDeplacer(l[0], l[1]);

        assertEquals("Le monstre devrait avoir 2 en X", m.getX(),2);
        assertEquals("Le monstre ne devrait pas avoir bouger en Y", m.getY(),2);

    }
}