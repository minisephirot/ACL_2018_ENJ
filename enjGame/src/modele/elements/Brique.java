package modele.elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Brique extends Case {
    private BufferedImage imgBrique;
    private BufferedImage imgBriqueProf;
    private int type;

    public Brique(int x, int y, int type) {
        super(x, y);
        this.type = type;
        File path = new File("enjGame/src/res/mur.jpg");
        File path2 = new File("enjGame/src/res/murProf.jpg");
        try {
            imgBrique = ImageIO.read(path);
            imgBriqueProf = ImageIO.read(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getType(){
        return type;
    }

    public BufferedImage getImgBrique(){
        return imgBrique;
    }

    public BufferedImage getImgBriqueProf(){
        return imgBriqueProf;
    }


}
