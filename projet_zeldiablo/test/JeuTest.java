package test;

import static org.junit.Assert.*;
import org.junit.Test;

import jeu.Jeu;

public class JeuTest{
    
    @Test
    public void testConstructeurElementPresent(){
        
        Jeu j = new  Jeu ("../niveaux/niveau2.txt");

        assertEquals("Il devrait y avoir 2 monstres dans la liste",j.getListeMonstre().size(),2);
    }

    
}