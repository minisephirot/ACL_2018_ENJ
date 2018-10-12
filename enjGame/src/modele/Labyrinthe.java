package modele;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    public final static int MUR = 1;
    public final static int VIDE = 0;

    /**
     * Représentation du labyrinthe
     */
    private int[][] labyrinthe;

    /**
     * Constructeur de Labyrinthe
     */
    public Labyrinthe(){
    }

    public boolean deplacementPossible(int x, int y){
        return true;
    }
}
