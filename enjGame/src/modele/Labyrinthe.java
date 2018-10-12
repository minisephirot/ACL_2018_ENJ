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
    private int[][] labyrinthe = {{1,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1}};

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
        this.labyrinthe = labyrinthe;
    }

    /**
     * Verifie si le joueur peux se deplacer vers la nouvelle case
     */
    public boolean deplacementPossible(int heroX,int heroY,int x, int y) {
        return this.labyrinthe[heroX+x][heroY+y] == 0;
    }

}
