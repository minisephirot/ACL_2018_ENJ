package modele;

import engine.Commande;
import engine.Game;

import javax.swing.plaf.multi.MultiRootPaneUI;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class LabyrintheGame implements Game {

    private Niveau level;

    public LabyrintheGame(){
        this.level = new Niveau();
        genLabyrinth();
    }

    public void genLabyrinth(){
        this.level.chargerNiveau("Labyrinthe1");
    }

    @Override
    public String toString(){
        return this.level.toString();
    }

    @Override
    public void evolve(Commande cmd) {
        if (cmd == Commande.UP) this.level.deplacerHero(-1,0);
        if (cmd == Commande.DOWN) this.level.deplacerHero(1,0);
        if (cmd == Commande.LEFT) this.level.deplacerHero(0,-1);
        if (cmd == Commande.RIGHT) this.level.deplacerHero(0,1);
    }

    public int[][] getLabyrinthe(){
        return level.getLabyrinthe();
    }

    public ArrayList<Mur> getMur(){
        return level.getMur();
    }

    public int getHeroX(){
        return level.getPlayerX();
    }

    public int getHeroY(){
        return level.getPlayerY();
    }

    public void collision(String direction){
        level.setCollision(direction);}

    @Override
    public boolean isFinished() {
        return false;
    }
}
