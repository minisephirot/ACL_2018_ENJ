/*package tests;

import junit.framework.TestCase;
import modele.Hero;
import modele.Labyrinthe;
import modele.Niveau;

import java.util.Arrays;
import java.util.Collections;

public class testLauncher extends TestCase {

    public testLauncher(String testMethodName) {
        super(testMethodName);
    }

    public void testHero() throws Exception { //Teste la classe héro : ses déplacements et ses pv
        Hero julien = new Hero(); // en vie
        assertEquals(false,julien.isDead());
        julien.setPv(-666); // On le tue
        assertEquals(true,julien.isDead());
        julien.setX(3);
        julien.setY(42);
        assertEquals(3,julien.getX());
        assertEquals(42,julien.getY());
    }

    public void testLabyrinthe() throws Exception { //Teste la classe Labyrinthe : les deplacements authorisé et le chargement de fichier
        Labyrinthe lab = new Labyrinthe(); // en vie
        int[][] token = {{1,1,1},{1,0,1},{1,0,1}};
        lab.setLabyrinthe(token);

        Niveau niveau = new Niveau();
        niveau.chargerNiveau("Labyrinthe1");
        int[][] tokenbis = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int[][] res = niveau.getLabyrinthe();
        assertFalse(Arrays.deepEquals(res,tokenbis));
    }

}*/
