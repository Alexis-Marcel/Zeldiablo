package test;

import static org.junit.Assert.*;
import org.junit.Test;

import jeu.personnage.Aventurier;

public class AventurierTest {

    @Test
    public void testConstructeur1(){
        Aventurier a = new Aventurier("Johny");
        boolean res = a.getX() == 0 && a.getY() == 0 && a.getNom() == "Johny";
        assertEquals("Le contructeur n'initialise pas les bons attributs.",res, true);
    }

    @Test
    public void testConstructeur2(){
        Aventurier a = new Aventurier(5,5,"Anakin", 5, 5);
        boolean res = a.getX() == 5 && a.getY() == 5 && a.getNom() == "Anakin";
        assertEquals("Le contructeur n'initialise pas les bons attributs.",res, true);
    }

    @Test
    public void testDeplacer(){
        Aventurier a = new Aventurier("Luke");
        a.deplacer(2,2);
        boolean res = a.getX() == 2 && a.getY() == 2;
        assertEquals("Le personnage devrait se trouver en 5;5",res, true);
    }

    

    
    


    

}

