package tests;

import engine.TextureFactory;
import junit.framework.TestCase;
import modele.Hero;
import modele.LabyGenerator;
import modele.Labyrinthe;
import modele.Niveau;
import modele.elements.Magique;
import modele.elements.Piege;
import modele.elements.Teleporteur;

import java.awt.*;
import java.util.Arrays;

/**
 * The type Test launcher.
 */
public class testLauncher extends TestCase {

    /**
     * Instantiates a new Test launcher.
     *
     * @param testMethodName the test method name
     */
    public testLauncher(String testMethodName) {
        super(testMethodName);
        new TextureFactory();
    }

    /**
     * Test hero.
     *
     * @throws Exception the exception
     */
    public void testHero() throws Exception { //Teste la classe héro : ses déplacements et ses pv
        Hero julien = new Hero(); // en vie
        assertFalse(julien.isDead());
        julien.setPv(-666); // On le tue
        assertTrue(julien.isDead());
        julien.setX(3);
        julien.setY(42);
        assertEquals(3,julien.getX());
        assertEquals(42,julien.getY());
    }

    /**
     * Test labyrinthe.
     *
     * @throws Exception the exception
     */
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

    /**
     * Test collisions.
     */
    public void testCollisions(){
        Rectangle rec1 = new Rectangle(10,10,10,10);
        Rectangle hero = new Rectangle(15,15,10,10);
        assertTrue(rec1.intersects(hero));
    }

    /**
     * Test stamina.
     */
    public void testStamina() {
        Hero julien = new Hero();
        julien.handleStamina(true);
        assertTrue(julien.getStamina() < 200);
        for (int i=0 ; i < 200 ; i++){
            julien.handleStamina(true);
        }
        assertFalse(julien.canSprint());
    }

    /**
     * Test generator.
     */
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

    /**
     * Test teleporteur.
     */
    public void testTeleporteur(){
        Hero julien = new Hero();
        Teleporteur tp1 = new Teleporteur(10, 10, null);
        Teleporteur tp2 = new Teleporteur(90, 90, tp1);
        tp1.setTpjumele(tp2);
        tp1.handleSpecialEffect(julien);
        assertEquals(julien.getX(), tp2.getX());
        assertEquals(julien.getY(), tp2.getY());
    }

    /**
     * Test piege.
     */
    public void testPiege(){
        Hero julien = new Hero();
        assertEquals(julien.getPv(),3);
        Piege piege = new Piege(10, 10);
        piege.handleSpecialEffect(julien);
        assertEquals(julien.getPv(),2);
    }

    /**
     * Test magie.
     */
    public void testMagie(){
        Hero julien = new Hero();
        assertEquals(julien.getPv(),3);
        assertEquals(julien.getPvMax(),3);
        Magique magique = new Magique(10, 10);
        magique.handleSpecialEffect(julien);
        assertEquals(julien.getPv(),4);
        assertEquals(julien.getPvMax(),4);
    }

}
