package modele;

import Exception.ExceptionTailleLaby;
import modele.elements.Mur;
import modele.elements.Sol;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Un Niveau du jeu
 */
public class Niveau {


    /**
     * Numéro du niveau
     */
    private int niveau;

    /**
     * Generateur de labyrinthe
     */
    private LabyGenerator lg;

    /**
     * Le labyrinthe
     */
    private Labyrinthe labyrinthe;

    /**
     * Le heros
     */
    private Hero hero;

    /**
     * Liste des monstres
     */
    private final ArrayList<Monstre> monstres;

    /**
     * Constructeur de Niveau
     */
    public Niveau(){
        this.labyrinthe = new Labyrinthe();
        this.hero = new Hero();
        Monstre mobtest = new Monstre(this);
        this.monstres = new ArrayList();
        this.monstres.add(mobtest);
        this.lg = new LabyGenerator(11,11);
    }

    public int[][] getLabyrinthe(){
        return labyrinthe.getLabyrinthe();
    }

    public void genererNiveau() {
        this.labyrinthe.setLabyrinthe(this.lg.getGrid());
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
     * Permet de charger le niveau souhaité
     * @param file informations nécessaire au niveau
     */
    public void chargerNiveau(String file){
        int hauteur = 0;
        String line;
        String strArray[];
        try {
            BufferedReader br = new BufferedReader (new InputStreamReader(getClass().getResourceAsStream("/res/" + file)));
            String dimensions[] = br.readLine().split(",");
            int labyrinthe[][] = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
            Scanner scanner = new Scanner(new InputStreamReader(getClass().getResourceAsStream("/res/" + file)));
            while (hauteur < labyrinthe.length+1) {
                line = scanner.nextLine();
                strArray = line.split(",");
                if (hauteur > 0) {
                    if (strArray.length != labyrinthe[0].length){
                       ExceptionTailleLaby exceptionTailleLaby = new ExceptionTailleLaby();
                       throw exceptionTailleLaby;
                    }
                    for (int i = 0; i < strArray.length; i++) {
                        labyrinthe[hauteur - 1][i] = Integer.parseInt(strArray[i]);
                    }
                }
                hauteur++;
            }
            this.labyrinthe.setLabyrinthe(labyrinthe);
        }
        catch (FileNotFoundException exception){
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionTailleLaby exceptionTailleLaby) {
            System.out.println(exceptionTailleLaby.getMessage());
        } catch (NumberFormatException numberException){
            System.out.println("Fichier corrompu");
        }
    }

    /**
     * Deplace le héro dans le labyrinthe
     * @param x deplacement en X du héro
     * @param y deplacement en Y du héro
     */
    public void deplacerHero(int x, int y){
        if (this.labyrinthe.deplacementPossible(x,y)) {
            this.hero.setX(this.getPlayerX() + x);
            this.hero.setY(this.getPlayerY() + y);
        }
    }

    public Mur getMur(){
        return labyrinthe.getMurs();
    }

    public ArrayList<Sol> getChemin(){return labyrinthe.getChemin();}
    /**
     * Print le labyrinthe, les joueurs en string
     */
    @Override
    public String toString(){
        int[][] labyrinthe = this.labyrinthe.getLabyrinthe();
        int playerX = this.getPlayerX();
        int playerY = this.getPlayerY();
        System.out.println("Hero("+playerX+","+playerY+")");
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

    public ArrayList<Monstre> getMonstres() {
        return monstres;
    }
}
