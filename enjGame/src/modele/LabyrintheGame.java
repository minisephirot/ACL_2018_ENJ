package modele;

import engine.Commande;
import engine.Game;
import engine.TextureFactory;
import modele.elements.Arrive;
import modele.elements.Case;
import modele.elements.Mur;
import modele.elements.Sol;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The type Labyrinthe game.
 */
public class LabyrintheGame implements Game {

    private Niveau level;
    private boolean gameWin;
    private int floor;
    private final static int HAUT = 0;
    private final static int BAS = 1;
    private final static int GAUCHE = 2;
    private final static int DROITE = 3;

    /**
     * Instantiates a new Labyrinthe game.
     */
    public LabyrintheGame(){
        this.gameWin = false;
        this.level = new Niveau();
        genLabyrinth(true);
    }

    /**
     * Gen labyrinth.
     *
     * @param useGenerator the use generator
     */
    public void genLabyrinth(boolean useGenerator){
        TextureFactory.genererCombinaison();
       if (useGenerator){
            this.level.genererNiveau();
        }else{
            this.level.chargerNiveau("Labyrinthe1");
        }
    }

    @Override
    public String toString(){
        return this.level.toString();
    }

    @Override
    public void evolve(Commande cmd, boolean[] tab) {
        if (gameWon()){
            this.gameWin = true;
            this.incrementFloor();
            new Timer(5000, e -> resetGame()).start();
            this.genLabyrinth(true);
        }
        int sprint = (tab[4] == true)?2:1;
        this.level.sprintHandler(tab[4]);
        if (!this.level.heroSprint())
            sprint = 1;
        if (gestionCollision(getMur(), cmd, tab)) {
            if (cmd == Commande.UP || tab[0]) this.level.deplacerHero(-1*sprint, 0);
            else if (cmd == Commande.DOWN || tab[1]) this.level.deplacerHero(1*sprint, 0);
            else if (cmd == Commande.LEFT || tab[2]) this.level.deplacerHero(0, -1*sprint);
            else if (cmd == Commande.RIGHT || tab[3]) this.level.deplacerHero(0, 1*sprint);
        }
    }

    private boolean gameWon() {
        int herox = getHeroX();
        int heroy = getHeroY();
        Arrive arrive = this.getArrive();
        Rectangle hero = new Rectangle(heroy, herox, 20, 20);
        return arrive.getRectangle().intersects(hero);
    }

    /**
     * Gestion collision boolean.
     *
     * @param mur the mur
     * @param cmd the cmd
     * @param tab the tab
     * @return the boolean
     */
    public boolean gestionCollision(Mur mur, Commande cmd, boolean[] tab){
        int herox = getHeroX();
        int heroy = getHeroY();
        int sprint = (tab[4] == true)?2:1;
        boolean avancer = true;
        if (cmd == Commande.UP || tab[0]) {
            herox -= 1*sprint;
            changerDirection(HAUT);
        } else if (cmd == Commande.DOWN || tab[1]) {
            herox += 1*sprint;
            changerDirection(BAS);
        }else if (cmd == Commande.LEFT || tab[2]) {
            heroy -= 1*sprint;
            changerDirection(GAUCHE);
        }else if (cmd == Commande.RIGHT || tab[3]) {
            heroy += 1*sprint;
            changerDirection(DROITE);
        }
        Rectangle hero = new Rectangle(heroy+2, herox, 16, 20);
        for (Case c : mur){
            if (c.getRectangle().intersects(hero))
                avancer = false;
        }
        return avancer;
    }

    /**
     * Get labyrinthe int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getLabyrinthe(){
        return level.getLabyrinthe();
    }

    /**
     * Get hero hero.
     *
     * @return the hero
     */
    public Hero getHero(){ return level.getHero();}

    /**
     * Get mur mur.
     *
     * @return the mur
     */
    public Mur getMur(){
        return level.getMur();
    }

    /**
     * Changer direction.
     *
     * @param dir the dir
     */
    public void changerDirection(int dir){
        level.changerDirection(dir);
    }

    /**
     * Get chemin array list.
     *
     * @return the array list
     */
    public ArrayList<Sol> getChemin(){return level.getChemin();}

    /**
     * Get arrive arrive.
     *
     * @return the arrive
     */
    public Arrive getArrive(){
        return this.level.getArrive();
    }

    /**
     * Get hero x int.
     *
     * @return the int
     */
    public int getHeroX(){
        return level.getPlayerX();
    }

    /**
     * Get hero y int.
     *
     * @return the int
     */
    public int getHeroY(){
        return level.getPlayerY();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * Gets game win.
     *
     * @return the game win
     */
    public boolean getGameWin() {
        return this.gameWin;
    }

    /**
     * Reset game.
     */
    public void resetGame(){
        this.gameWin = false;
    }

    /**
     * Gets floor.
     *
     * @return the floor
     */
    public String getFloor() {
        return this.floor+"";
    }

    /**
     * Increment floor.
     */
    public void incrementFloor(){
        this.floor++;
    }

    /**
     * Get stamina int.
     *
     * @return the int
     */
    public int getStamina(){
        return this.level.getStamina();
    }
}
