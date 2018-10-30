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

    //Returns a complete maze, gets the carved out paths from the chemin function,
    //then 'cleans it up' to return a useable maze format for the game.
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
        //Starting from row and column 1 and 1, respectively.
        int sr=1,sc=1;
        //Carve Out the Grid
        chemin(grid,sr,sc);

        //JUST FOR DEBUGGING:
        for (int i=0;i<height;i++)
        {
            for (int j=0;j<width;j++)
            {
                System.out.print(grid[j][i]);
            }
            System.out.println("");
        }
        //JUST FOR DEBUGGING ERASE IMMEDIATELY AFTER DONE WITH
        return grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public LabyGenerator (int largeur, int hauteur) {
        width = largeur;
        height = hauteur;
        grid = this.generate();
    }

}