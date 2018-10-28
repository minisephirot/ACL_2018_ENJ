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
     */
    boolean Z = false;
    boolean Q = false;
    boolean S = false;
    boolean D = false;


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
        //Cardinaux
        if (keyPress == 'z' || keyPress == 'Z'){
            this.Z = true;
            cmd = Commande.UP;
        }
        if (keyPress == 'q' || keyPress == 'Q'){
            this.Q = true;
            cmd = Commande.LEFT;
        }
        if (keyPress == 's' || keyPress == 'S'){
            this.S = true;
            cmd = Commande.DOWN;
        }
        if (keyPress == 'd' || keyPress == 'D'){
            this.D = true;
            cmd = Commande.RIGHT;
        }
        //Diagonales
        if (this.D && this.S){
            cmd = Commande.DOWNRIGHT;
        }
        if (this.Q && this.S){
            cmd = Commande.DOWNLEFT;
        }
        if (this.Q && this.Z){
            cmd = Commande.UPLEFT;
        }
        if (this.D && this.Z){
            cmd = Commande.UPRIGHT;
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
            this.Z = false;
        }
        if (keyPress == 'q' || keyPress == 'Q'){
            this.Q = false;
        }
        if (keyPress == 's' || keyPress == 'S'){
            this.S = false;
        }
        if (keyPress == 'd' || keyPress == 'D'){
            this.D = false;
        }
        if (!this.Q && !this.Z && !this.D && !this.S) cmd = Commande.IDLE;
    }
}
