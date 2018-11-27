package modele;

import engine.GamePainter;
import engine.TextureFactory;
import modele.elements.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class LabyrinthePainter implements GamePainter {

    /**
     * la taille des cases
     */
    private static final int WIDTH = 736;
    private static final int HEIGHT = 736;
    private static int camX,camY;
    private static int[][] descY;
    private static int[] descX;
    private int anim;
    private Random rand;
    private Font font;
    private Font font2;
    private Font font3;
    private int refresh;

    /**
     * Le modele du jeu Labyrinthe
     */
    private LabyrintheGame lg;

    /**
     * appelle constructeur parent
     *
     * @param game
     *            le jeutest a afficher
     */
    public LabyrinthePainter(LabyrintheGame game) {
        rand = new Random();
        descY = new int[][] { {-1000, -100, -700, -500},{0,0,0,0} };
        descX = new int[] {100, 250, 400, 550};

        anim = 0;
        this.lg = game;
        InputStream font_pixel = getClass().getResourceAsStream("/res/font/pixeled.ttf");
        try {
            Font font_p = Font.createFont(Font.TRUETYPE_FONT, font_pixel);
            this.font = font_p.deriveFont(16f);
            this.font3 = font_p.deriveFont(14f);
            this.font2 = font_p.deriveFont(8f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * methode  redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void draw(BufferedImage img) {

        if (lg.isMenu()){
            this.drawMenu(img);
        }else{
            this.drawGame(img);
        }
    }

    private void drawMenu(BufferedImage img) {
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        crayon.setColor(Color.CYAN);
        crayon.fillRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < 4; i++){
                if (descY[0][i] == 100 || descY[0][i] == 200 || descY[0][i] == 250 || descY[0][i] == 260 || descY[0][i] == 264) {
                    descY[1][i] += 1;
                }
                if (descY[0][i] >= 252) {
                    crayon.drawImage(TextureFactory.getImgDescente(descY[1][i]), null, descX[i], descY[0][i] += 1);
                } else {
                    crayon.drawImage(TextureFactory.getImgDescente(descY[1][i]), null, descX[i], descY[0][i] += 2);
                }
                if (descY[0][i] > HEIGHT){
                    descY[0][i] =  -(400 + rand.nextInt(400));
                    descY[1][i] = 0;
                }
        }

        crayon.drawImage(TextureFactory.getImgArrow(),null,(this.getWidth()/2-TextureFactory.getImgArrow().getWidth()*2-20),(this.getHeight()/2-110)+(this.lg.getNumerolab()*70));
        crayon.fillRect((this.getWidth()/2-90),(this.getHeight()/2-100)+(this.lg.getNumerolab()*70),180,40);
        crayon.setColor(Color.BLACK);
        crayon.setFont(this.font);
        int i;
        for (i = 0 ; i < 5; i++){
            if (i == 0) crayon.drawString("Labyrinthe infinis", (this.getWidth()/2-80),(this.getHeight()/2-75)+i*70);
            else crayon.drawString("Labyrinthe "+i, (this.getWidth()/2-80),(this.getHeight()/2-75)+i*70);
        }
        crayon.drawString("Quitter", (this.getWidth()/2-80),(this.getHeight()/2-75)+i*70);
    }

    private void drawGame(BufferedImage img) {
        camY = lg.getHeroY();
        camX = lg.getHeroX();
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        crayon.setFont(this.font);
        Mur mur = lg.getMur();
        ArrayList<Sol> chemin = lg.getChemin();
        Arrive arrive = lg.getArrive();
        ArrayList<Case> caseSpeciales = lg.getCasesSpeciales();
        refresh = 0;
        for (int i = 0; i < WIDTH*3; i+=32){
            for (int j = 0; j < HEIGHT*3; j+=32){
                int xCamera =i - camY + (32 / 2);
                int yCamera =j - camX + (32 / 2);
                crayon.drawImage(TextureFactory.getImgGrass(), null, xCamera, yCamera);
                if (refresh == 30 || refresh == 50){
                    crayon.drawImage(TextureFactory.getImgPlante3(), null, xCamera, yCamera);
                }else if (refresh == 40 || refresh == 20){
                    crayon.drawImage(TextureFactory.getImgPlante2(), null, xCamera, yCamera);
                }else if (refresh == 60 || refresh == 80){
                    crayon.drawImage(TextureFactory.getImgPlante1(), null, xCamera, yCamera);
                }else if (refresh == 100){
                    refresh = 0;
                }
                refresh++;
            }
        }
        // Dessiner le labyrinthe
        Rectangle rectangleArrive = arrive.getRectangleCamera(camY, camX, WIDTH, HEIGHT);
        crayon.drawImage(TextureFactory.getImgSol(), null, rectangleArrive.x, rectangleArrive.y);
        crayon.drawImage(arrive.getImg(), null, rectangleArrive.x, rectangleArrive.y);
        for (Brique b : mur) {
            // création du nouveau rectangle par rapport à la camera
            Rectangle r = b.getRectangleCamera(camY, camX, WIDTH, HEIGHT);
            crayon.drawImage(b.getImg(), null, r.x, r.y);
        }
        for (Sol s : chemin) {
            Rectangle r = s.getRectangleCamera(camY, camX, WIDTH, HEIGHT);
            crayon.drawImage(s.getImg(), null, r.x, r.y);
        }
        //Dessiner cases spéciales
        for (Case c : caseSpeciales) {
            if (c.isActive()) {
                Rectangle rectanglePiege = c.getRectangleCamera(camY, camX, WIDTH, HEIGHT);
                crayon.drawImage(c.getImg(), null, rectanglePiege.x, rectanglePiege.y);
            }
        }

        //Dessiner les Monstres
        for (Monstre m : this.lg.getMonstres()) {
            Rectangle rectanglemob = new Rectangle(m.y - camY + WIDTH / 2, m.x - camX + HEIGHT / 2, 20, 20);
            crayon.drawImage(m.getImgMonstre(), null, rectanglemob.x, rectanglemob.y);
        }
        // Dessiner le hero
        Rectangle rectangle1 = new Rectangle(lg.getHeroY() - camY + WIDTH / 2, lg.getHeroX() - camX + HEIGHT / 2, 20, 20);
        BufferedImage heroimg = lg.getHero().getImgHero();
        if (lg.getDammageProofHero() % 10 == 0){
            crayon.drawImage(heroimg, null, rectangle1.x + 2, rectangle1.y - 16);
        }

        //RECTANGLE INFO
        crayon.setColor(new Color(173, 216, 230, 127));
        crayon.fillRect(5, 10, 147, 90);
        Stroke oldstroke1 = crayon.getStroke();
        crayon.setStroke(new BasicStroke(3));
        crayon.setColor(new Color(0, 0, 136));
        crayon.drawRect(5, 10, 147, 90);
        crayon.setStroke(oldstroke1);

        // Dessiner la condition de victoire et les étages:
        crayon.setColor(Color.black);
        crayon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        crayon.drawString("ETAGE " + lg.getFloor(), 15, 35);
        if (lg.isFinished() && lg.notInfinite()) {
            crayon.drawImage(TextureFactory.getImgVitory(),null, this.getHeight() / 2 - this.getHeight() / 6,  this.getWidth() / 2 - 65);
        }

        //STAMINA BAR
        int stamina = lg.getStamina();
        int stamina_percentage = (stamina * 100) / 200;
        int width_bar = (125 * stamina_percentage) / 200;
        Rectangle staminabar = new Rectangle(16, 47, width_bar * 2, 15);
        if(stamina <= 10)
            crayon.setColor(Color.BLACK);
        else
            crayon.setColor(new Color(0, 230, 118));
        crayon.fill(staminabar);
        Stroke oldstroke = crayon.getStroke();
        crayon.setStroke(new BasicStroke(3));
        crayon.setColor(new Color(27, 94, 32));
        crayon.drawRect(15, 45, 125, 17);
        crayon.setStroke(oldstroke);
        crayon.setColor(Color.black);
        crayon.setFont(font2);
        crayon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        crayon.drawString("ENDURANCE", 42, 59);

        //Points de Vie BAR
        int pv = lg.getHero().getPv();

        // Dessiner les vies
        for (int p = 0; p<pv; p++) {
            crayon.drawImage(TextureFactory.getImgPv(), null, 12+(p*32), 68);
        }
        for (int p = pv; p<lg.getHero().getPvMax(); p++) {
            crayon.drawImage(TextureFactory.getImgPvLost(), null, 12+(p*32), 68);
        }

        // Dessiner la fin du jeu (GAME OVER)
        if (lg.isOver()) {
            crayon.drawImage(TextureFactory.getImgGameOver(),null, this.getHeight() / 2 - this.getHeight() / 6,  this.getWidth() / 2 - 65);
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
