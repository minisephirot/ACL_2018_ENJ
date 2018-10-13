package modele;

import engine.Commande;
import engine.Game;

import java.io.File;

public class LabyrintheGame implements Game {

    private Niveau level;

    public LabyrintheGame(){
        this.level = new Niveau();
        genLabyrinth();
    }

    public void genLabyrinth(){
        File file = new File("enjGame\\src\\modele\\Labyrinthe1");
        this.level.chargerNiveau(file);
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

    @Override
    public boolean isFinished() {
        return false;
    }
}
