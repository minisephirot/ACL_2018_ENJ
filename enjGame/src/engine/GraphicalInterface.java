package engine;

public class GraphicalInterface {
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
    public GraphicalInterface(Game game, GamePainter gamePainter, GameController gameController) {
        this.game = game;
        this.gamePainter = gamePainter;
        this.gameController = gameController;
    }

    /**
     * Lance le Jeu
     * @throws InterruptedException
     */
    public void run() throws InterruptedException{

    }
}
