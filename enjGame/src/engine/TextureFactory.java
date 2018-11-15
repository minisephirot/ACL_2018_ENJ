package engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class TextureFactory {

    //Logic
    private final static int NBSPRITEMUR = 2;
    private final static int NBSPRITESOL = 4;
    private static final Random rng = new Random();
    private static int numeroSol;
    private static int numeroMur;
    //Texture
    private static BufferedImage imgBrique;
    private static BufferedImage imgBriqueP;
    private static BufferedImage imgBrique2;
    private static BufferedImage imgBriqueP2;
    private static BufferedImage imgSol;
    private static BufferedImage imgSol2;
    private static BufferedImage imgSol3;
    private static BufferedImage imgSol4;
    private static BufferedImage imgHero[];
    private static BufferedImage imgArrive;
    private static BufferedImage imgArrive2;
    private static BufferedImage imgTp;
   // private static BufferedImage animHaut[];

    public TextureFactory() throws IOException {
        imgBrique = ImageIO.read(getClass().getResource("/res/mur.jpg"));
        imgBriqueP = ImageIO.read(getClass().getResource("/res/murProf.jpg"));
        imgBrique2 = ImageIO.read(getClass().getResource("/res/murgele.png"));
        imgBriqueP2 = ImageIO.read(getClass().getResource("/res/murgeleProf.png"));
        imgSol = ImageIO.read(getClass().getResource("/res/sol.png"));
        imgSol2 = ImageIO.read(getClass().getResource("/res/sol.jpg"));
        imgSol3 = ImageIO.read(getClass().getResource("/res/grass.jpeg"));
        imgSol4 = ImageIO.read(getClass().getResource("/res/solgele.png"));
      /*  animHaut = new BufferedImage[9];
        animHaut[0] = ImageIO.read(getClass().getResource("/res/luig1.png"));
        animHaut[1] = ImageIO.read(getClass().getResource("/res/luig2.png"));
        animHaut[2] = ImageIO.read(getClass().getResource("/res/luig3.png"));
        animHaut[3] = ImageIO.read(getClass().getResource("/res/luig4.png"));
        animHaut[4] = ImageIO.read(getClass().getResource("/res/luig5.png"));
        animHaut[5] = ImageIO.read(getClass().getResource("/res/luig6.png"));
        animHaut[6] = ImageIO.read(getClass().getResource("/res/luig7.png"));
        animHaut[7] = ImageIO.read(getClass().getResource("/res/luig8.png"));*/

        imgHero = new BufferedImage[4];
        imgHero[0] = ImageIO.read(getClass().getResource("/res/luigdown.png"));
        imgHero[1] = ImageIO.read(getClass().getResource("/res/luigup.png"));
        imgHero[2] = ImageIO.read(getClass().getResource("/res/luigleft.png"));
        imgHero[3] = ImageIO.read(getClass().getResource("/res/luigright.png"));


        imgTp = ImageIO.read(getClass().getResource("/res/teleporteur.png"));
        imgArrive = ImageIO.read(getClass().getResource("/res/stairLeft.png"));
        imgArrive2 = ImageIO.read(getClass().getResource("/res/stairRight.png"));
    }

    public static BufferedImage getImgBrique(boolean isProfondeur) {
        switch (numeroMur){
            case 0:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
            case 1:
                if (isProfondeur) return imgBriqueP2;
                return imgBrique2;
            default:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
        }
    }

    public static BufferedImage getImgHero(int dir) {
        return imgHero[dir];
    }

    public static BufferedImage getImgTp() {
        return imgTp;
    }

    public static BufferedImage getImgArrive(boolean leftside) {
        if (leftside)return imgArrive;
        return imgArrive2;
    }

    public static BufferedImage getImgSol() {
        switch (numeroSol){
            case 0:
                return imgSol;
            case 1:
                return imgSol2;
            case 2:
                return imgSol3;
            case 3:
                return imgSol4;
            default:
                return imgSol;
        }
    }

    public static void genererCombinaison(){
        numeroSol = rng.nextInt(NBSPRITESOL);
        numeroMur = rng.nextInt(NBSPRITEMUR);
        System.out.println("numéro sol : "+numeroSol + "\n numero mur :" + numeroMur);
    }
}
