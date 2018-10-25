package engine;

/**
 * Jeu
 */
public interface Game {

    /**
     * Action du jeu en fonction des commandes utilisateur
     * @param cmd Commande effectuer par l'utilisateur
     */
    public void evolve(Commande cmd);

    /**
     * Permet de savoir si le jeu est terminer
     * @return true si le jeu est terminer
     */
    public boolean isFinished();
}
