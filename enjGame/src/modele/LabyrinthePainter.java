package modele;

import engine.GamePainter;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LabyrinthePainter implements GamePainter {
    private final static Rectangle intersection = new Rectangle();
    /**
     * la taille des cases
     */
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 640;

    /**
     * Le modele du jeu Labyrinthe
     */
    protected LabyrintheGame lg;

    /**
     * appelle constructeur parent
     *
     * @param game
     *            le jeutest a afficher
     */
    public LabyrinthePainter(LabyrintheGame game) {
        this.lg = game;
    }

    /**
     * methode  redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void draw(BufferedImage img) {
       int[][] lab = lg.getLabyrinthe();
        ArrayList<Mur> murs = lg.getMur();
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        int casex = 0;
        int casey = 0;
        // Dessiner le labyrinthe
        for (int i = 0; i < lab.length; i++){
            casex = 0;
            for (int j = 0; j < lab[i].length; j++){
                if (lab[i][j] == 1){
                    crayon.setColor(Color.RED);
                } else {
                    crayon.setColor(Color.green);
                }
                crayon.fillRect(casex, casey, 64, 64);
                casex += 64;
            }
            casey+=64;
        }
        // Dessiner le hero
        crayon.setColor(Color.blue);
        Rectangle rectangle1 = new Rectangle(lg.getHeroY(), lg.getHeroX(), 20, 20);
        crayon.fill(rectangle1);
    }
    

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
