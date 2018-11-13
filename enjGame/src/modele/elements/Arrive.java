package modele.elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Arrive extends Case {
    private BufferedImage imgArrive;

    public Arrive(int x, int y) {
        super(x, y);
        File path = new File("enjGame/src/res/brick.jpg");
        try {
            imgArrive = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImgArrive(){
        return imgArrive;
    }
}
