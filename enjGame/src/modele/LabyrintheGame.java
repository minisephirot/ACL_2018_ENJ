package modele;

import engine.Commande;
import engine.Game;
import modele.elements.Case;
import modele.elements.Mur;
import modele.elements.Sol;

import java.awt.*;
import java.util.ArrayList;

public class LabyrintheGame implements Game {

    private Niveau level;

    public LabyrintheGame(){
        this.level = new Niveau();
        genLabyrinth(true);
    }

    public void genLabyrinth(boolean useGenerator){
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
    public void evolve(Commande cmd) {
        if (gestionCollision(getMur(), cmd)) {
            if (cmd == Commande.UP) this.level.deplacerHero(-1, 0);
            if (cmd == Commande.DOWN) this.level.deplacerHero(1, 0);
            if (cmd == Commande.LEFT) this.level.deplacerHero(0, -1);
            if (cmd == Commande.RIGHT) this.level.deplacerHero(0, 1);
        }
        for (Monstre m :this.level.getMonstres()) {
            m.seRapprocher();
        }
    }

    public boolean gestionCollision(Mur mur, Commande cmd){
        int herox = getHeroX();
        int heroy = getHeroY();
        boolean avancer = true;
        if (cmd == Commande.UP)
            herox -=1;
        else if (cmd == Commande.DOWN)
            herox+=1;
        else if (cmd == Commande.LEFT)
            heroy-=1;
        else if (cmd == Commande.RIGHT)
            heroy+=1;
        Rectangle hero = new Rectangle(heroy, herox, 20, 20);
        for (Case c : mur){
            if (c.getRectangle().intersects(hero))
                avancer = false;
        }
        return avancer;
    }

    public int[][] getLabyrinthe(){
        return level.getLabyrinthe();
    }

    public Mur getMur(){
        return level.getMur();
    }

    public ArrayList<Sol> getChemin(){return level.getChemin();}

    public int getHeroX(){
        return level.getPlayerX();
    }

    public int getHeroY(){
        return level.getPlayerY();
    }

    public ArrayList<Monstre> getMonstres(){
        return level.getMonstres();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
