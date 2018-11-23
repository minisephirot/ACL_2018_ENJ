package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class Sol extends Case {
    private BufferedImage imgSol;

    public Sol(int x, int y) {
        super(x, y);
        imgSol = TextureFactory.getImgSol();
    }

    @Override
    public BufferedImage getImg() {
        return imgSol;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        return -1;
    }
}
