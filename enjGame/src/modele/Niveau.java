package modele;

import exception.ExceptionTailleLaby;
import modele.elements.Arrive;
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
     * Constructeur de Niveau
     */
    public Niveau(){
        this.labyrinthe = new Labyrinthe();
        this.hero = new Hero();
        this.lg = new LabyGenerator(51,51);
    }

    /**
     * Hero sprint boolean.
     *
     * @return the boolean
     */
    public boolean heroSprint(){
        return hero.canSprint();
    }

    /**
     * Sprint handler.
     *
     * @param isSprinting the is sprinting
     */
    public void sprintHandler(boolean isSprinting){
        hero.handleStamina(isSprinting);
    }

    /**
     * Get stamina int.
     *
     * @return the int
     */
    public int getStamina(){
        return this.hero.getStamina();
    }

    /**
     * Get labyrinthe int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getLabyrinthe(){
        return labyrinthe.getLabyrinthe();
    }

    /**
     * Generer niveau.
     */
    public void genererNiveau() {
        this.labyrinthe.setLabyrinthe(this.lg.generate());
        setPlayerX(labyrinthe.getHeroposX());
        setPlayerY(labyrinthe.getHeroposY());
    }

    /**
     * Retourne la coordonnée X du hero
     *
     * @return coordonnée x
     */
    public int getPlayerX(){return this.hero.getX();}

    /**
     * Retourne la coordonnée Y du hero
     *
     * @return coordonnée y
     */
    public int getPlayerY(){return this.hero.getY();}

    /**
     * Set player x.
     *
     * @param x the x
     */
    public void setPlayerX(int x){
        hero.setX(x);
    }

    /**
     * Set player y.
     *
     * @param y the y
     */
    public void setPlayerY(int y){
        hero.setY(y);
    }

    /**
     * Permet de charger le niveau souhaité
     *
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
     *
     * @param x deplacement en X du héro
     * @param y deplacement en Y du héro
     */
    public void deplacerHero(int x, int y){
        this.hero.setX(this.getPlayerX() + x);
        this.hero.setY(this.getPlayerY() + y);
    }

    /**
     * Get hero hero.
     *
     * @return the hero
     */
    public Hero getHero(){ return hero; }

    /**
     * Changer direction.
     *
     * @param dir the dir
     */
    public void changerDirection(int dir){ hero.changerDirection(dir);}

    /**
     * Get mur mur.
     *
     * @return the mur
     */
    public Mur getMur(){
        return labyrinthe.getMurs();
    }

    /**
     * Get arrive arrive.
     *
     * @return the arrive
     */
    public Arrive getArrive(){return labyrinthe.getArrive();}

    /**
     * Get chemin array list.
     *
     * @return the array list
     */
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
}
