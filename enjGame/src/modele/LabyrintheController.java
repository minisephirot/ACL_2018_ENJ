package modele;

import engine.Commande;
import engine.GameController;

import java.awt.event.KeyEvent;

/**
 * Controlleur de type KeyListener
 */
public class LabyrintheController implements GameController {

    /**
     * Commade en cours
     */
    private Commande cmd;

    /**
     * Constructeur du controlleur, aucune commande en cours par défaut
     */
    public LabyrintheController(){
        this.cmd = Commande.IDLE;
    }

    /**
     * Retourne la commande en cours
     * @return commande faite par le joueur
     */
    @Override
    public Commande getCommande() {
        return null;
    }

    /**
     * ne fais rien
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
