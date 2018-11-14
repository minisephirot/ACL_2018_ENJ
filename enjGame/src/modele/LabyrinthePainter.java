package modele;

import engine.GamePainter;
import modele.elements.Arrive;
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
    protected static final int BRIQUE = 0;
    protected static final int BRIQUEPROF = 1;
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
        Arrive arrive = lg.getArrive();
        // Dessiner le labyrinthe
        crayon.setColor(Color.RED);
        for (Brique b : mur){
            // création du nouveau rectangle par rapport à la camera
            Rectangle r = b.getRectangleCamera(camY,camX,WIDTH,HEIGHT);
            if (b.getType() == BRIQUE) {
                crayon.drawImage(b.getImgBrique(), null, r.x, r.y);
            }else{
                crayon.drawImage(b.getImgBriqueProf(), null, r.x, r.y);
            }
        }
        for (Sol s : chemin){
            Rectangle r = s.getRectangleCamera(camY,camX,WIDTH,HEIGHT);
            crayon.drawImage(s.getImgSol(), null, r.x, r.y);
        }
        crayon.setColor(Color.green);
        // Dessiner l'arrive
        crayon.setColor(Color.GRAY);
        Rectangle rectangleArrive = arrive.getRectangleCamera(camY,camX, WIDTH, HEIGHT);
        crayon.fill(rectangleArrive);
        // Dessiner le hero
        //crayon.setColor(Color.blue);
        Rectangle rectangle1 = new Rectangle(lg.getHeroY()-camY +WIDTH/2, lg.getHeroX()-camX +HEIGHT/2, 20, 20);
        crayon.drawImage(lg.getHero().getImgHero(), null, rectangle1.x, rectangle1.y);
        System.out.println(rectangle1.x + " " + rectangle1.y);
       // crayon.fill(rectangle1);
        //Dessiner les monstres;
        crayon.setColor(Color.black);
        // Dessiner la condition de victoire et les étages:
        crayon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        crayon.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        crayon.drawString("Etage n°"+lg.getFloor(), 20, 50);
        if(lg.getGameWin()) {
            crayon.drawString("Bravo ! Vous êtes a l'étage n°"+lg.getFloor(), this.getHeight()/2, this.getWidth()/2);
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
