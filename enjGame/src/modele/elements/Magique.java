package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

public class Magique extends Case {
    private BufferedImage imgMagique;
    private boolean active;

    public Magique(int x, int y) {
        super(x, y);
        imgMagique = TextureFactory.getImgMagique();
        active = true;
    }

    public BufferedImage getImgMagique(){
        return imgMagique;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
