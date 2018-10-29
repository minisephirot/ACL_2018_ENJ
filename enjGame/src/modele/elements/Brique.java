package modele.elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Brique extends Case {
    private BufferedImage imgBrique;

    public Brique(int x, int y) {
        super(x, y);
        File path = new File("enjGame/src/res/brick.jpg");
        try {
            imgBrique = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImgBrique(){
        return imgBrique;
    }
}
