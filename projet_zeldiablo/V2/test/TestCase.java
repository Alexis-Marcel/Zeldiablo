package V2.test;

import V2.jeu.Personnage.*;
import V2.jeu.Personnage.MonstreImmobile;
import V2.jeu.Case;


import static org.junit.Assert.*;
import org.junit.Test;

public class TestCase {
    

    @Test
    public void testEstTraversable(){
        boolean tr = true ;
        Case c = new Case(tr);
        c.estTraversable();
        assertTrue("la case devrait etre travaersable", c.estTraversable());
    }

    @Test
    public void testPasTraversable(){
        boolean tr = true;
        Case c = new Case(tr);
        Personnage p = new MonstreImmobile(1,2,44,55,c);
        c.setOccupant(p);
        c.estTraversable();
        assertTrue("la case devrait etre travaersable", ! c.estTraversable());
    }

    @Test
    public void testPasTraversable2(){
        boolean tr = false;
        Case c = new Case(tr);
        c.estTraversable();
        assertTrue("la case devrait etre travaersable", ! c.estTraversable());
    }
}
