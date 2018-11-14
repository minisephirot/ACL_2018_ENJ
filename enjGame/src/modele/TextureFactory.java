package modele;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class TextureFactory {

    //Logic
    private final static int NBSPRITEMUR = 1;
    private final static int NBSPRITESOL = 2;
    private static final Random rng = new Random();
    private static int numeroSol;
    private static int numeroMur;
    //Texture
    private static BufferedImage imgBrique;
    private static BufferedImage imgBriqueP;
    private static BufferedImage imgSol;
    private static BufferedImage imgSol2;

    public TextureFactory() throws IOException {
         imgBrique = ImageIO.read(getClass().getResource("/res/mur.jpg"));
         imgBriqueP = ImageIO.read(getClass().getResource("/res/murProf.jpg"));
         imgSol = ImageIO.read(getClass().getResource("/res/sol.png"));
         imgSol2 = ImageIO.read(getClass().getResource("/res/sol.jpg"));
    }

    public static BufferedImage getImgBrique(boolean isProfondeur) {
        switch (numeroMur){
            case 0:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
            default:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
        }
    }

    public static BufferedImage getImgSol() {
        switch (numeroSol){
            case 0:
                return imgSol;
            case 1:
                return imgSol2;
            default:
                return imgSol;
        }
    }

    public static void genererCombinaison(){
        numeroSol = rng.nextInt(NBSPRITESOL);
        numeroMur = rng.nextInt(NBSPRITEMUR);
    }
}
