package engine;

import modele.LabyrintheGame;

import java.util.Scanner;

public class GameEngineGraph {

    public static void main(String[] args) {

        LabyrintheGame lg = new LabyrintheGame();

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println(lg.toString());
            String s = in.nextLine().charAt(0)+"";
            lg.deplacerHeros(s);
        }

    }
}
