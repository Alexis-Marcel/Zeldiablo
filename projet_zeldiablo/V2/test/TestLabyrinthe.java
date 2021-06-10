package V2.test;

import V2.jeu.Labyrinthe;
import V2.jeu.Case;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLabyrinthe {
    @Test
    public void testCasesAdjacentes(){
        Labyrinthe l = new Labyrinthe();
        Case[][] cTab = new Case[3][3];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                l.setListeCase(i, j, cTab[i][j]);
            }
        }

        Case[] c = l.casesAdjacentes(1, 1);
        boolean testCoord1 = c[0] == cTab[1][0];
        boolean testCoord2 = c[1] == cTab[1][2];
        boolean testCoord3 = c[2] == cTab[2][1];
        boolean testCoord4 = c[3] == cTab[0][1];

        boolean res = testCoord1 && testCoord2 && testCoord3 && testCoord4;
        assertTrue("Les cases adjacentes ne sont pas les bonnes", res);
    }

    @Test
    public void testSortie(){
        Labyrinthe l = new Labyrinthe();
        l.setSortie(5, 5);
        boolean res = l.checkHeroSortie(5, 5);
        assertTrue("La methode devrait indiquer que le Hero est sortie", res);
    }
}
