package modele;

import modele.elements.*;

import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    public final static int MUR = 1;
    public final static int VIDE = 0;
    private Mur mur;
    private Arrive arrive;
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
                    if (i+1 < labyrinthe.length) {
                        if (labyrinthe[i+1][j] == 0) {
                            mur.ajouterBrique(new Brique(casex, casey, 1));
                        } else {
                            mur.ajouterBrique(new Brique(casex, casey, 0));
                        }
                    }else{
                        mur.ajouterBrique(new Brique(casex, casey, 0));
                    }
                } else if (labyrinthe[i][j] == 0){
                    chemin.add(new Sol(casex, casey));
                }else if (labyrinthe[i][j] == 2){
                    heroposX = casey;
                    heroposY = casex;
                    chemin.add(new Sol(casex, casey));
                }else if (labyrinthe[i][j] == 3){
                    arrive = new Arrive(casex,casey);
                }
                casex += 32;
            }
            casey += 32;
        }
    }

    public Mur getMurs() {
        return mur;
    }

    public ArrayList<Sol> getChemin(){
        return chemin;
    }

    public Arrive getArrive(){
        return this.arrive;
    }

    public int getHeroposX(){
        return heroposX;
    }

    public int getHeroposY(){
        return heroposY;
    }

    /**
     * Verifie si le joueur peux se deplacer vers la nouvelle case
     */
    public boolean deplacementPossible(int x, int y) {
        return true;
    }


}
