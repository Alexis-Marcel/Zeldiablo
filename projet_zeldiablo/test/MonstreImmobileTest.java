package test;

import static org.junit.Assert.*;
import org.junit.Test;


import jeu.personnage.MonstreImmobile;

public class MonstreImmobileTest {


    @Test
    public void testConstructeur1(){
        MonstreImmobile a = new  MonstreImmobile ("5,5");
        boolean res = a.getX() == 5 && a.getY() == 5 && a.getPv() == 50 ;
        assertEquals("Le contructeur n'initialise pas les bons attributs.",res, true);
    }


    @Test 
    public void testPrendreDegats(){
        MonstreImmobile a = new  MonstreImmobile ("5,5");
         a.prendreDegats(10);
         boolean res = a.getPv() == 40;
        assertEquals("il devrait avoir 40 pv", res, true);
    }

    @Test 
    public void testPrendreDegats2(){
        MonstreImmobile a = new  MonstreImmobile ("5,5");
        a.prendreDegats(51);
        boolean res = a.getPv() == 0;
        assertEquals("il devrait avoir 0 pv", res, true);
    }
}