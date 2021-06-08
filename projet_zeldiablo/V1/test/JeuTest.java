package test;

import static org.junit.Assert.*;
import org.junit.Test;

import jeu.Niveau;

public class JeuTest{
    
    @Test
    public void testConstructeurElementPresent(){
        
        Niveau j = new  Niveau();

        assertEquals("Il devrait y avoir 2 monstres dans la liste",j.getListeMonstre().size(),2);
    }
       
}