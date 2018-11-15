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
    protected Font font;
    protected Font font2;

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
        this.font = new Font("Comic Sans MS", Font.BOLD, 20);
        this.font2 = new Font("Impact", Font.BOLD, 50);
    }

    /**
     * methode  redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void draw(BufferedImage img) {
        camY = lg.getHeroY();
        camX = lg.getHeroX();
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        crayon.setFont(this.font);
        Mur mur = lg.getMur();
        ArrayList<Sol> chemin = lg.getChemin();
        Arrive arrive = lg.getArrive();

        // Dessiner le labyrinthe
        crayon.setColor(Color.RED);
        for (Brique b : mur){
            // création du nouveau rectangle par rapport à la camera
            Rectangle r = b.getRectangleCamera(camY,camX,WIDTH,HEIGHT);
            crayon.drawImage(b.getImgBrique(), null, r.x, r.y);
        }
        for (Sol s : chemin){
            Rectangle r = s.getRectangleCamera(camY,camX,WIDTH,HEIGHT);
            crayon.drawImage(s.getImgSol(), null, r.x, r.y);
        }
        crayon.setColor(Color.green);

        // Dessiner l'arrive
        Rectangle rectangleArrive = arrive.getRectangleCamera(camY,camX, WIDTH, HEIGHT);
        crayon.drawImage(arrive.getImgArrive(),null,rectangleArrive.x,rectangleArrive.y);

        // Dessiner le hero
        Rectangle rectangle1 = new Rectangle(lg.getHeroY()-camY +WIDTH/2, lg.getHeroX()-camX +HEIGHT/2, 20, 20);
        crayon.drawImage(lg.getHero().getImgHero(), null, rectangle1.x + 2, rectangle1.y - 16);

        //Dessiner les monstres;

        //RECTANGLE INFO
        crayon.setColor(Color.WHITE);
        crayon.fillRect(10, 10, 145,75);

        // Dessiner la condition de victoire et les étages:
        crayon.setColor(Color.black);
        crayon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        crayon.drawString("Etage n°"+lg.getFloor(), 20, 30);
        if(lg.getGameWin()) {
            crayon.setFont(this.font2);
            crayon.drawString("Bravo !", this.getHeight()/2-200, this.getWidth()/2);
        }

        //STAMINA BAR
        int stamina = lg.getStamina();
        int stamina_percentage = (stamina * 100) / 200;
        int width_bar = (125 *stamina_percentage) / 200;
        Rectangle staminabar = new Rectangle(20, 50, width_bar*2, 15);
        crayon.setColor(Color.green);
        crayon.fill(staminabar);
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
