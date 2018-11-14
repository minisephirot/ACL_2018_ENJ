package modele.elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sol extends Case {
    private BufferedImage imgSol;

    public Sol(int x, int y) {
        super(x, y);
        File path = new File("enjGame/src/res/sol.png");
        try {
            imgSol = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImgSol(){
        return imgSol;
    }
}
