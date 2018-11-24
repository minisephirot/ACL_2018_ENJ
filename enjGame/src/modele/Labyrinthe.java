package modele;

import modele.elements.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    /**
     * The constant MUR.
     */
    public final static int MUR = 1;
    /**
     * The constant VIDE.
     */
    public final static int VIDE = 0;
    private Mur mur;
    private Arrive arrive;
    /**
     * The Chemin.
     */
    public ArrayList<Sol> chemin;
    private int heroposX;
    private int heroposY;
    /**
     * Représentation du labyrinthe
     */
    private int[][] labyrinthe;

    /**
     * Constructeur de Labyrinthe
     */
    public Labyrinthe(){
        chemin = new ArrayList<Sol>();
    }

    /**
     * Getter de la matrice du labyrinthe
     *
     * @return the int [ ] [ ]
     */
    public int[][] getLabyrinthe() {
        return labyrinthe;
    }

    /**
     * Setter de la matrice du labyrinthe
     *
     * @param labyrinthe the labyrinthe
     */
    public void setLabyrinthe(int[][] labyrinthe) {
        mur = new Mur();
        mur.toutCasser();
        chemin.clear();
        int rand = (int)(Math.random() * 2);
        this.labyrinthe = labyrinthe;
        int casex = 0;
        int casey = 0;
        for (int i = 0; i < labyrinthe.length; i++){
            casex = 0;
            for (int j = 0; j < labyrinthe[i].length; j++){
                if (labyrinthe[i][j] == 1) {
                    if (i+1 < labyrinthe.length) {
                        if (labyrinthe[i+1][j] == 1) {
                            mur.ajouterBrique(new Brique(casex, casey, false));
                        } else {
                            mur.ajouterBrique(new Brique(casex, casey, true));
                        }
                    }else{
                        mur.ajouterBrique(new Brique(casex, casey, false));
                    }
                } else if (labyrinthe[i][j] == 0){
                    chemin.add(new Sol(casex, casey, rand));
                }else if (labyrinthe[i][j] == 2){
                    heroposX = casey;
                    heroposY = casex;
                    chemin.add(new Sol(casex, casey, rand));
                }else if (labyrinthe[i][j] == 3){
                    if (labyrinthe[i][j-1] == 0){
                        arrive = new Arrive(casex,casey,true);
                    }else if(labyrinthe[i][j+1] == 0){
                        arrive = new Arrive(casex,casey,false);
                    }else{
                     arrive = new Arrive(casex,casey,Math.random() < 0.5);
                    }
                }
                casex += 32;
            }
            casey += 32;
        }
    }

    /**
     * Gets murs.
     *
     * @return the murs
     */
    public Mur getMurs() {
        return mur;
    }

    /**
     * Get chemin array list.
     *
     * @return the array list
     */
    public ArrayList<Sol> getChemin(){
        return chemin;
    }

    /**
     * Get arrive arrive.
     *
     * @return the arrive
     */
    public Arrive getArrive(){
        return this.arrive;
    }

    /**
     * Get heropos x int.
     *
     * @return the int
     */
    public int getHeroposX(){
        return heroposX;
    }

    /**
     * Get heropos y int.
     *
     * @return the int
     */
    public int getHeroposY(){
        return heroposY;
    }

    /**
     * Verifie si le joueur peux se deplacer vers la nouvelle case
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean deplacementPossible(int x, int y) {
        return true;
    }


}
