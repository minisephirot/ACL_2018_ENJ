package modele.elements;

import modele.TextureFactory;

import java.awt.image.BufferedImage;

public class Sol extends Case {
    private BufferedImage imgSol;

    public Sol(int x, int y, int rand) {
        super(x, y);
        imgSol = TextureFactory.getImgSol();
    }

    public BufferedImage getImgSol(){
        return imgSol;
    }
}
