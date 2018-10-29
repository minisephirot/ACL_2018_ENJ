package modele;

import modele.elements.Brique;
import modele.elements.Case;
import modele.elements.Mur;
import modele.elements.Sol;

import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    public final static int MUR = 1;
    public final static int VIDE = 0;
    public Mur mur;
    public ArrayList<Sol> chemin;
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
     */
    public int[][] getLabyrinthe() {
        return labyrinthe;
    }

    /**
     * Setter de la matrice du labyrinthe
     */
    public void setLabyrinthe(int[][] labyrinthe) {
        mur = new Mur();
        this.labyrinthe = labyrinthe;
        int casex = 0;
        int casey = 0;
        for (int i = 0; i < labyrinthe.length; i++){
            casex = 0;
            for (int j = 0; j < labyrinthe[i].length; j++){
                if (labyrinthe[i][j] == 1) {
                    mur.ajouterBrique(new Brique(casex, casey));
                } else if (labyrinthe[i][j] == 0){
                    chemin.add(new Sol(casex, casey));
                }
                casex += 64;
            }
            casey += 64;
        }
    }

    public Mur getMurs() {
        return mur;
    }

    public ArrayList<Sol> getChemin(){
        return chemin;
    }

    /**
     * Verifie si le joueur peux se deplacer vers la nouvelle case
     */
    public boolean deplacementPossible(int x, int y) {
        return true;
    }

}
