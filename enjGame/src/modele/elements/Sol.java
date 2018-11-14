package modele.elements;

import modele.TextureFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sol extends Case {
    private BufferedImage imgSol;

    public Sol(int x, int y, int rand) {
        super(x, y);
        imgSol = TextureFactory.getImgSol(rand);
    }

    public BufferedImage getImgSol(){
        return imgSol;
    }
}
