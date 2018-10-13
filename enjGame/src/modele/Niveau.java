package modele;

import java.io.*;
import java.util.NoSuchElementException;
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
        this.labyrinthe = new Labyrinthe();
        this.hero = new Hero();
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
    public void chargerNiveau(File file){
        int hauteur = 0;
        String line;
        String strArray[];
        try {
            FileReader fr = new FileReader (file);
            BufferedReader br = new BufferedReader (fr);
            String dimensions[] = br.readLine().split(",");
            int labyrinthe[][] = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
            Scanner scanner = new Scanner(file);
            while (true){
                try{
                    line = scanner.nextLine();
                    strArray = line.split(",");
                    if (hauteur > 0) {
                        for (int i = 0; i < strArray.length; i++) {
                            labyrinthe[hauteur-1][i] = Integer.parseInt(strArray[i]);
                        }
                    }
                    hauteur++;
                }catch(NoSuchElementException exception){
                    break;
                }
            }
        }
        catch (FileNotFoundException exception){
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            e.printStackTrace();
        }


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
        }else{
            System.out.println("Deplacement Impossible!");
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
}
