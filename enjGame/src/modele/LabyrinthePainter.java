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
    protected static final int WIDTH = 736;
    protected static final int HEIGHT = 736;
    static int camX,camY;

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
        camY = lg.getHeroY();
        camX = lg.getHeroX();
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        Mur mur = lg.getMur();
        ArrayList<Sol> chemin = lg.getChemin();
        // Dessiner le labyrinthe
        crayon.setColor(Color.RED);
        for (Brique b : mur){

            // création du nouveau rectangle par rapport à la camera
            Rectangle r = b.getRectangleCamera(camY,camX,WIDTH,HEIGHT);

            crayon.fill(r);

//            crayon.drawImage(b.getImgBrique(), null, b.getX(), b.getY()); => dessiner les brique avec les coordonnées originaux
//            crayon.drawImage(b.getImgBrique(), null, b.getxCamera(), b.getyCamera()); => dessiner les briques avec les coordonnées de la cam
        }
        crayon.setColor(Color.green);
        for (Sol s : chemin){
            Rectangle r = s.getRectangleCamera(camY,camX,WIDTH,HEIGHT);

            crayon.fill(r);

//            crayon.drawImage(s.getImgBrique(), null, s.getX(), s.getY());
//            crayon.drawImage(s.getImgBrique(), null, s.getxCamera(), s.getyCamera());
        }
        // Dessiner le hero
        crayon.setColor(Color.blue);
        Rectangle rectangle1 = new Rectangle(lg.getHeroY()-camY +WIDTH/2, lg.getHeroX()-camX +HEIGHT/2, 20, 20);
//        Rectangle rectangle1 = new Rectangle(lg.getHeroY(), lg.getHeroX(), 20, 20);
        crayon.fill(rectangle1);
        //Dessiner les monstres;
        crayon.setColor(Color.black);
        for (Monstre m: this.lg.getMonstres()) {
            Rectangle rectangle2 = new Rectangle(m.y-camY +WIDTH/2,m.x-camX +HEIGHT/2,20,20);
//            Rectangle rectangle2 = new Rectangle(m.y-camY ,m.x-camX ,20,20);
            crayon.fill(rectangle2);
        }
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
