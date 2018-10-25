package engine;

import modele.LabyrintheController;
import modele.LabyrintheGame;

import java.util.Scanner;

public class GameEngineGraph {
    /**
     * Jeu a executer
     */
    private Game game;


    /**
     * controlleur pour recuperer les commandes
     */
    private GameController gameController;


    /**
     * Construit le moteur du jeu
     * @param game
     *              Jeu a Lancer
     * @param gameController
     *              controlleur a utiliser
     */
    public GameEngineGraph(Game game, GameController gameController) {
        this.game = game;
        this.gameController = gameController;
    }

    /**
     * Lance le Jeu
     * @throws InterruptedException
     */
    public void run() throws InterruptedException{

        Scanner in = new Scanner(System.in);
        Commande c = Commande.IDLE;
        while (true){
            System.out.println(this.game.toString());
            //System.out.println(this.gameController.getCommande());
            String line = in.nextLine();
            char ch = '0';
            if (line.length() > 0)
                ch = line.charAt(0);
            if (ch == 'z' || ch == 'Z'){
                c = Commande.UP;
            } else if (ch == 'q' | ch == 'Q'){
                c = Commande.LEFT;
            } else if (ch == 's' | ch == 'S'){
                c = Commande.DOWN;
            } else if (ch == 'd' | ch == 'D'){
                c = Commande.RIGHT;
            }
            this.game.evolve(c);
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) {
        LabyrintheGame lg = new LabyrintheGame();
        GameController gc = new LabyrintheController();
        GameEngineGraph g = new GameEngineGraph(lg, gc);
        try {
            g.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
