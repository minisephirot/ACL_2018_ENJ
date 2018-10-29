package modele;

import engine.GamePainter;
import modele.elements.Brique;
import modele.elements.Mur;
import modele.elements.Sol;

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
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        Mur mur = lg.getMur();
        ArrayList<Sol> chemin = lg.getChemin();
        // Dessiner le labyrinthe
        crayon.setColor(Color.RED);
        for (Brique b : mur){
           // crayon.fill(b.getRectangle());
            crayon.drawImage(b.getImgBrique(), null, b.getX(), b.getY());
        }
        crayon.setColor(Color.green);
        for (Sol s : chemin){
            crayon.fill(s.getRectangle());
            // crayon.drawImage(s.getImgBrique(), null, s.getX(), s.getY());
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
