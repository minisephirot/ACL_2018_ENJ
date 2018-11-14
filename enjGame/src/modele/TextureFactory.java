package modele;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class TextureFactory {
    private static BufferedImage imgBrique;
    private static BufferedImage imgBriqueProf;
    private static BufferedImage imgSol;
    private static BufferedImage imgSol2;

    public TextureFactory() throws IOException {
         imgBrique = ImageIO.read(getClass().getResource("/res/mur.jpg"));
         imgBriqueProf = ImageIO.read(getClass().getResource("/res/murProf.jpg"));
         imgSol = ImageIO.read(getClass().getResource("/res/sol.png"));
         imgSol2 = ImageIO.read(getClass().getResource("/res/sol.jpg"));
    }

    public static BufferedImage getImgBrique(int rand) {
        return imgBrique;
    }

    public static BufferedImage getImgBriqueProf(int rand) {
        return imgBriqueProf;
    }

    public static BufferedImage getImgSol(int rand) {
        if (rand == 1){
            return imgSol;
        }else{
            return imgSol2;
        }
    }
}
