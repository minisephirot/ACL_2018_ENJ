package modele;

import java.util.Random;

public class LabyGenerator {

    private int[][] grid;
    private int width;
    private int height;
    Random RNG = new Random();

    //Verifie si des cases n'ont pas été visitées
    private boolean nonVisite(int[][] grid, int sr, int sc) {
        if (sc+2 > height-2) {
        } else if (grid[sr][sc+2]==1) {
            return true;
        }
        if (sc-2 < 0) {
        } else if (grid[sr][sc-2]==1) {
            return true;
        }
        if (sr+2 > width-2) {
        } else if (grid[sr+2][sc]==1) {
            return true;
        }
        if (sr-2 < 0) {
        } else if (grid[sr-2][sc]==1) {
            return true;
        }
        return false;
    }

    //Algorithme qui trace un chemin
    private void chemin(int[][] grid, int sr, int sc) {
        //Met l'entrée à 0
        grid[sr][sc] = 0;

        //Empeche de visiter les murs
        if (sr>width-2||sr<1||sc>height-2||sc<1) {
            return;
        }

        //Appelle recursif pour creuser le chemin
        switch (RNG.nextInt(4)) {
            case 0:
                if(nonVisite(grid,sr,sc)) {
                    if(sc+2>height-2) {
                    }else if(grid[sr][sc+2]!=0){
                        grid[sr][sc+1]=0;
                        chemin(grid,sr,sc+2);
                    }
                    chemin(grid,sr,sc);
                }
                break;
            case 1:
                if(nonVisite(grid,sr,sc)) {
                    if(sc-2<0) {
                    } else if(grid[sr][sc-2]!=0){
                        grid[sr][sc-1]=0;
                        chemin(grid,sr,sc-2);
                    }
                    chemin(grid,sr,sc);
                }
                break;
            case 2:
                if(nonVisite(grid,sr,sc)) {
                    if(sr+2>width-2) {
                    }else if(grid[sr+2][sc]!=0){
                        grid[sr+1][sc]=0;
                        chemin(grid,sr+2,sc);
                    }
                    chemin(grid,sr,sc);
                }
                break;

            case 3:
                if(nonVisite(grid,sr,sc)) {
                    if(sr-2<0) {
                    } else if(grid[sr-2][sc]!=0) {
                        grid[sr-1][sc]=0;
                        chemin(grid,sr-2,sc);
                    }
                    chemin(grid,sr,sc);
                }
                break;
        }
    }

    public int[][] generate() {
        grid = new int[width][height];
        //Initialize Grid with all walls
        for (int i=0;i<width;i++)
        {
            for (int j=0;j<height;j++)
            {
                grid[i][j]= 1;
            }
        }

        int sr=1,sc=1;
        //Creuse le chemin
        chemin(grid,sr,sc);

        //pose la case du héros et l'arrivée
        boolean hero = true;
        boolean arriv = true;
        while (hero) {
            int x = (int) (Math.random() * width - 1);
            int y = (int) (Math.random() * height - 1);
            if (grid[x][y] == 0) {
                grid[x][y] = 2;
                hero = false;
            }
        }
        while (arriv) {
            int x = (int) (Math.random() * width - 1);
            int y = (int) (Math.random() * height - 1);
            if (grid[x][y] == 0 && this.isDeadEnd(x,y)) {
                grid[x][y] = 3;
                arriv = false;
            }
        }
        return grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean isDeadEnd(int x,int y){
        int cpt = 0;
        if (this.grid[x-1][y] == 1) cpt++;
        if (this.grid[x+1][y] == 1) cpt++;
        if (this.grid[x][y-1] == 1) cpt++;
        if (this.grid[x][y+1] == 1) cpt++;
        return cpt == 3;
    }

    public LabyGenerator (int largeur, int hauteur) {
        width = largeur;
        height = hauteur;
        grid = this.generate();
    }

}