package modele;

import javax.swing.plaf.multi.MultiRootPaneUI;
import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    public final static int MUR = 1;
    public final static int VIDE = 0;
    public ArrayList<Mur> murs;

    /**
     * Représentation du labyrinthe
     */
    private int[][] labyrinthe;

    /**
     * Constructeur de Labyrinthe
     */
    public Labyrinthe(){
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
        murs = new ArrayList<>();
        this.labyrinthe = labyrinthe;
        int casex = 0;
        int casey = 0;
        for (int i = 0; i < labyrinthe.length; i++){
            casex = 0;
            for (int j = 0; j < labyrinthe[i].length; j++){
                if (labyrinthe[i][j] == 1) {
                    murs.add(new Mur(casex, casey));//new Rectangle(casex, casey, 64, 64));
                }
                casex += 64;
            }
            casey += 64;
        }
    }

    public ArrayList<Mur> getMurs() {
        return murs;
    }

    /**
     * Verifie si le joueur peux se deplacer vers la nouvelle case
     */
    public boolean deplacementPossible(int x, int y, String direction) {
         if (direction == "HAUT" && x < 0){
            return false;
        }  else if (direction == "BAS" && x > 0){
            return false;
        }  else if (direction == "GAUCHE" && y < 0){
            return false;
        } else if (direction == "DROITE" && y > 0){
            return false;
        }else{
            return true;
        }
    }

}
