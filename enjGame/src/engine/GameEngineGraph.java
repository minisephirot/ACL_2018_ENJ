package engine;

import com.sun.org.apache.regexp.internal.RE;
import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;
import modele.Mur;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEngineGraph {
    /**
     * Jeu a executer
     */
    private Game game;

    /**
     * Afficheur rendu
     */
    private GamePainter gamePainter;

    /**
     * controlleur pour recuperer les commandes
     */
    private GameController gameController;

    /**
     * Inteface Graphique
     */
    private GraphicalInterface graphicalInterface;

    /**
     * Construit le moteur du jeu
     *
     * @param game           Jeu a Lancer
     * @param gamePainter    afficheur a utiliser
     * @param gameController controlleur a utiliser
     */
    public GameEngineGraph(Game game, GamePainter gamePainter, GameController gameController) {
        this.game = game;
        this.gamePainter = gamePainter;
        this.gameController = gameController;
    }

    /**
     * Lance le Jeu
     *
     * @throws InterruptedException
     */
    public void run() throws InterruptedException {
        graphicalInterface = new GraphicalInterface(gamePainter, gameController);
        ArrayList<Mur> murs = ((LabyrintheGame)game).getMur();
        while (true) {
            try {
                // demande controle utilisateur
                Commande c = gameController.getCommande();
                //GESTION COLLISION
                if (gestionCollision(murs, c)) {
                    // fait evoluer le game
                    game.evolve(c);
                }
                // affiche le game
                graphicalInterface.paint();
                // met en attentde
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean gestionCollision(ArrayList<Mur> murs, Commande cmd){
        int herox = ((LabyrintheGame)game).getHeroX();
        int heroy = ((LabyrintheGame)game).getHeroY();
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
        for (Mur m : murs){
            if (m.getRectangle().intersects(hero))
                avancer = false;
        }
        return avancer;
    }

    public static void main(String[] args) {
        LabyrintheGame lg = new LabyrintheGame();
        GameController gc = new LabyrintheController();
        GamePainter gp = new LabyrinthePainter(lg);
        GameEngineGraph g = new GameEngineGraph(lg, gp, gc);
        try {
            g.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
