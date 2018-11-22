package modele;

import modele.elements.*;

import java.util.ArrayList;

/**
 * Labyrinthe d'un niveau du jeu
 */
public class Labyrinthe {

    private Mur murs;
    private Arrive arrive;
    private ArrayList<Case> casesSpeciales;
    private ArrayList<Sol> chemin;

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
        chemin = new ArrayList<>();
        casesSpeciales = new ArrayList<>();
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
        murs = new Mur();
        murs.toutCasser();
        chemin.clear();
        casesSpeciales.clear();
        int rand = (int)(Math.random() * 2);
        this.labyrinthe = labyrinthe;
        Teleporteur tp1,tp2;
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
                            murs.ajouterBrique(new Brique(casex, casey, false));
                        } else {
                            murs.ajouterBrique(new Brique(casex, casey, true));
                        }
                    }else{
                        murs.ajouterBrique(new Brique(casex, casey, false));
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
                        tp1 = new Teleporteur(posTpx, posTpy, null);
                        tp2 = new Teleporteur(casex, casey, tp1);
                        tp1.setTpjumele(tp2);
                        this.casesSpeciales.add(tp1);
                        this.casesSpeciales.add(tp2);
                        chemin.add(new Sol(casex, casey, rand));
                        chemin.add(new Sol(posTpx, posTpy, rand));
                    }
                }else if (labyrinthe[i][j] == 5){
                    this.casesSpeciales.add(new Piege(casex, casey));
                    chemin.add(new Sol(casex, casey, rand));
                }else if (labyrinthe[i][j] == 6){
                    this.casesSpeciales.add(new Magique(casex, casey));
                    chemin.add(new Sol(casex, casey, rand));
                }
                casex += 32;
            }
            casey += 32;
        }
    }

    public ArrayList<Case> getCasesSpeciales() {
        return casesSpeciales;
    }

    public Mur getMurs() {
        return murs;
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

}
