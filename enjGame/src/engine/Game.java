package engine;

/**
 * Jeu
 */
public interface Game {

    /**
     * Action du jeu en fonction des commandes utilisateur
     * @param cmd Commande effectuer par l'utilisateur
     * @param tab Liste des touches appuyées en continue
     */
    public void evolve(Commande cmd, boolean[] tab);

    /**
     * Permet de savoir si le jeu est terminer
     * @return true si le jeu est terminer
     */
    public boolean isFinished();
    public boolean isOver();
}
