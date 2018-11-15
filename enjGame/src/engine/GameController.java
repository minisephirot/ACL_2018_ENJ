package engine;

import java.awt.event.KeyListener;

/**
 * Envoie les commandes au jeu
 */
public interface GameController extends KeyListener {
    /**
     * Retourne la commande en cours
     * @return commande faite par le joueur
     */
    public Commande getCommande();

    /**
     * Retourne le tableau de touches appuyées en continue
     * @return tableau de boolean
     */
    public boolean[] getToucheAppuyee();
}
