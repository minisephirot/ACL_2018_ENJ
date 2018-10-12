package modele;

import java.io.File;

/**
 * Un Niveau du jeu
 */
public class Niveau {
    /**
     * Numéro du niveau
     */
    private int niveau;

    /**
     * Constructeur de Niveau
     */
    public Niveau(){

    }

    /**
     * Retourne la coordonnée X du hero
     * @return coordonnée x
     */
    public int getPlayerX(){return 0;}

    /**
     * Retourne la coordonnée Y du hero
     * @return coordonnée y
     */
    public int getPlayerY(){return 0;}

    /**
     * Permet de charger le niveau souhaiter
     * @param file informations nécessaire au niveau
     */
    public void chargerNiveau(File file){
    }

    /**
     * Deplace le héro dans le labyrinthe
     * @param x deplacement en X du héro
     * @param y deplacement en Y du héro
     */
    public void deplacerHero(int x, int y){
    }
}
