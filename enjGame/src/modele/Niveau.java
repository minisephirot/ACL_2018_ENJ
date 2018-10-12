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
     * Le labyrinthe
     */
    private Labyrinthe labyrinthe;

    /**
     * Le heros
     */
    private Hero hero;

    /**
     * Constructeur de Niveau
     */
    public Niveau(){

    }

    /**
     * Retourne la coordonnée X du hero
     * @return coordonnée x
     */
    public int getPlayerX(){return this.hero.getX();}

    /**
     * Retourne la coordonnée Y du hero
     * @return coordonnée y
     */
    public int getPlayerY(){return this.hero.getY();}

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
        if (this.labyrinthe.deplacementPossible(this.getPlayerX(),this.getPlayerY(),x,y)){
            this.hero.setX(this.getPlayerX()+x);
            this.hero.setY(this.getPlayerY()+y);
        }
    }

    /**
     * Print le labyrinthe, les joueurs en string
     */
    @Override
    public String toString(){
        int[][] labyrinthe = this.labyrinthe.getLabyrinthe();
        int playerX = this.getPlayerX();
        int playerY = this.getPlayerY();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i<labyrinthe.length;i++){
            sb.append("[");
            for (int j = 0; j<labyrinthe[0].length; j++){
                if (playerX == i && playerY == j){
                    sb.append("H,");
                }else{
                    sb.append(labyrinthe[i][j]+",");
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("]\n");
        }
        return sb.toString();
    }
}
