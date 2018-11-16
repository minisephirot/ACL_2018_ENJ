package tests;

import engine.TextureFactory;
import junit.framework.TestCase;
import modele.Hero;
import modele.LabyGenerator;
import modele.Labyrinthe;
import modele.Niveau;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class testLauncher extends TestCase {

    public testLauncher(String testMethodName) {
        super(testMethodName);
        new TextureFactory();
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

    public void testCollisions(){
        Rectangle rec1 = new Rectangle(10,10,10,10);
        Rectangle hero = new Rectangle(15,15,10,10);
        assertTrue(rec1.intersects(hero));
    }

    public void testGenerator(){
        LabyGenerator lg = new LabyGenerator(10,10);
        int[][] grid = lg.getGrid();
        boolean hero = false;
        boolean arrive = false;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]== 2) hero = true;
                if (grid[i][j]== 3) arrive = true;
            }
        }
        assertTrue(hero);
        assertTrue(arrive);
    }

}
