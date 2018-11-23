import engine.GameController;
import engine.GameEngineGraph;
import engine.GamePainter;
import engine.TextureFactory;
import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un entier : \n1 : Labyrinthe 1\n2 : Labyrinthe 2\n3 : Labyrinthe 3\n4 : Labyrinthe 4\n0 : Labyrinthe aléatoire\n");
        int res = -1;
        do {
            try{
                res = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Un entier svp.");
                sc.next();
            }
        }while (res < 0 ||  res > 4);
        newGame(res);
    }

    private static void newGame(int selectedIndex) {
        TextureFactory textureFactory = new TextureFactory();
        LabyrintheGame lg = new LabyrintheGame(selectedIndex);
        GameController gc = new LabyrintheController();
        GamePainter gp = new LabyrinthePainter(lg);
        GameEngineGraph g = new GameEngineGraph(lg, gp, gc);
        try {
            g.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
