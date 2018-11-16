package modele;

import modele.elements.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {
    public final static int MUR = 1;
    public final static int VIDE = 0;
    private Mur mur;
    private Arrive arrive;
    private ArrayList<Piege> pieges;
    private Piege piegeTrigger;
    private Teleporteur tp1;
    private Teleporteur tp2;
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
        pieges = new ArrayList<Piege>();
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
        mur.toutCasser();
        chemin.clear();
        int rand = (int)(Math.random() * 2);
        this.labyrinthe = labyrinthe;
        int casex = 0;
        int casey = 0;
        int posTpx = 0;
        int posTpy = 0;
        int nbTp = 0;
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
                }else if (labyrinthe[i][j] == 4){
                    if (nbTp == 0){
                        posTpx = casex;
                        posTpy = casey;
                        nbTp += 1;
                    }else {
                        tp1 = new Teleporteur(posTpx, posTpy, casex, casey);
                        tp2 = new Teleporteur(casex, casey, posTpx, posTpy);
                        chemin.add(new Sol(casex, casey, rand));
                        chemin.add(new Sol(posTpx, posTpy, rand));
                    }
                }else if (labyrinthe[i][j] == 5){
                    pieges.add(new Piege(casex, casey));
                    chemin.add(new Sol(casex, casey, rand));
                }
                casex += 32;
            }
            casey += 32;
        }
    }

    public Piege getPiegeTrigger(){
        return piegeTrigger;
    }

    public void setPiegeTrigger(Piege piegeTrigger){
       this.piegeTrigger = piegeTrigger;
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

    public Teleporteur getTp1(){
        return this.tp1;
    }

    public Teleporteur getTp2(){
        return this.tp2;
    }

    public ArrayList<Piege> getPieges() {
        return pieges;
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
