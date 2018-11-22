package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class Magique extends Case {
    private BufferedImage imgMagique;
    private boolean active;

    public Magique(int x, int y) {
        super(x, y);
        imgMagique = TextureFactory.getImgMagique();
        active = true;
    }

    @Override
    public void handleSpecialEffect(Hero h) {
        h.gagnerPv();
        this.setActive(false);
    }

    public BufferedImage getImg(){
        return imgMagique;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
