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
                //   murs.add(new Mur(casex, casey));//new Rectangle(casex, casey, 64, 64));
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

           // System.out.println(murs.size());

        boolean collision = false;
            for (Mur mur : murs){
                if (mur.getRectangle().intersects(rectangle1)) {
                    lg.collision(checkIntersect(rectangle1, mur.getRectangle()));
                    collision = true;
                }
                crayon.fillRect(lg.getHeroY(), lg.getHeroX(), 20, 20);
            }
            if (collision == false){
                lg.collision(null);
            }
    }

    private String checkIntersect(Rectangle r1, Rectangle r2) {
        Point2D upperLeft = new Point2D.Double(r1.getX(), r1.getY());
        Point2D upperRight = new Point2D.Double(r1.getX() + r1.getWidth(),
                r1.getY());
        Point2D lowerLeft = new Point2D.Double(r1.getX(), r1.getY()
                + r1.getHeight());
        Point2D lowerRight = new Point2D.Double(r1.getX() + r1.getWidth(),
                r1.getY() + r1.getHeight());

    /*    if (r2.contains(upperRight) && r2.contains(lowerRight)){return "DROITE";}
        else if (r2.contains(lowerRight) && r2.contains(lowerLeft)) {return "BAS";}
        else if (r2.contains(lowerLeft) && r2.contains(upperLeft)) { return "GAUCHE";}
        else if (r2.contains(upperLeft) && r2.contains(upperRight)) {return "HAUT";}*/
        if (r2.contains(lowerRight)){return "LOWERRIGHT";}
        else if (r2.contains((upperRight))){ return "UPPERRIGHT";}
        else if (r2.contains(lowerLeft)){return "LOWERLEFT";}
        else if (r2.contains(upperLeft)){return "UPPERLEFT";}
        else {return null;}
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
