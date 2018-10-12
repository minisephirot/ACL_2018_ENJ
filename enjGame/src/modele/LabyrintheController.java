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
        return cmd;
    }

    /**
     * ne fais rien
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Met à jour la commande en fonction de la touche appuyee
     * @param e touche appuyee
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char keyPress = e.getKeyChar();
        if (keyPress == 'z' || keyPress == 'Z'){
            cmd = Commande.UP;
        } else if (keyPress == 'q' || keyPress == 'Q'){
            cmd = Commande.LEFT;
        } else if (keyPress == 's' || keyPress == 'S'){
            cmd = Commande.DOWN;
        } else if (keyPress == 'd' || keyPress == 'D'){
            cmd = Commande.RIGHT;
        }
    }


    /**
     * Met à jour quand le joueur relache la touche
     * @param e touche relachee
     */
    @Override
    public void keyReleased(KeyEvent e) {
        cmd = Commande.IDLE;
    }
}
