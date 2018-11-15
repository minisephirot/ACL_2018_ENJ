package modele;

import engine.Commande;
import engine.GameController;

import java.awt.event.KeyEvent;

/**
 * Controlleur de type KeyListener
 */
public class LabyrintheController implements GameController {


    /**
     * Booleans de directions
        0 = Z
        1 = S
        2 = Q
        3 = D
        4 = SPRINT
     */
    private boolean[] keyPressed;

    /**
     * Commade en cours
     */
    private Commande cmd;

    /**
     * Constructeur du controlleur, aucune commande en cours par défaut
     */
    public LabyrintheController(){
        this.cmd = Commande.IDLE;
        this.keyPressed = new boolean[5];
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
     * Retourne le tableau de touches appuyées en continue
     * @return tableau de boolean
     */
    public boolean[] getToucheAppuyee(){
        return this.keyPressed;
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
        //Cardinaux
        if (keyPress == 'z' || keyPress == 'Z'){
            this.keyPressed[0] = true;
            cmd = Commande.UP;
        }
        if (keyPress == 'q' || keyPress == 'Q'){
            this.keyPressed[2] = true;
            cmd = Commande.LEFT;
        }
        if (keyPress == 's' || keyPress == 'S'){
            this.keyPressed[1] = true;
            cmd = Commande.DOWN;
        }
        if (keyPress == 'd' || keyPress == 'D'){
            this.keyPressed[3] = true;
            cmd = Commande.RIGHT;
        }
        if (keyPress == ' '){
            this.keyPressed[4] = true;
            cmd = Commande.SPRINT;
        }
    }


    /**
     * Met à jour quand le joueur relache la touche
     * @param e touche relachee
     */
    @Override
    public void keyReleased(KeyEvent e) {
        char keyPress = e.getKeyChar();
        //Cardinaux
        if (keyPress == 'z' || keyPress == 'Z'){
            this.keyPressed[0] = false;
        }
        if (keyPress == 'q' || keyPress == 'Q'){
            this.keyPressed[2] = false;
        }
        if (keyPress == 's' || keyPress == 'S'){
            this.keyPressed[1] = false;
        }
        if (keyPress == 'd' || keyPress == 'D'){
            this.keyPressed[3] = false;
        }
        if (keyPress == ' ') {
            this.keyPressed[4] = false;
        }
        cmd = Commande.IDLE;
    }
}
