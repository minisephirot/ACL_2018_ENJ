package engine;

import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;

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
     * @param game
     *              Jeu a Lancer
     * @param gamePainter
     *              afficheur a utiliser
     * @param gameController
     *              controlleur a utiliser
     */
    public GameEngineGraph(Game game, GamePainter gamePainter, GameController gameController) {
        this.game = game;
        this.gamePainter = gamePainter;
        this.gameController = gameController;
    }

    /**
     * Lance le Jeu
     * @throws InterruptedException
     */
    public void run() throws InterruptedException{
        this.graphicalInterface = new GraphicalInterface(this.gamePainter, this.gameController);
        while (true){
            // demande controle utilisateur
            Commande c = this.gameController.getCommande();
            // fait evoluer le game
            this.game.evolve(c);
            // affiche le game
            this.graphicalInterface.paint();
            // met en attente
            Thread.sleep(100);
        }
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
