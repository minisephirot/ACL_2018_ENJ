package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

/**
 * The type Magique.
 */
public class Magique extends Case {
    private BufferedImage imgMagique;
    private boolean active;

    /**
     * Instantiates a new Magique.
     *
     * @param x the x
     * @param y the y
     */
    public Magique(int x, int y) {
        super(x, y);
        imgMagique = TextureFactory.getImgMagique();
        active = true;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        h.gagnerPv();
        this.setActive(false);
        return 0;
    }

    public BufferedImage getImg(){
        return imgMagique;
    }

    public boolean isActive(){
        return active;
    }

    /**
     * Set active.
     *
     * @param active the active
     */
    public void setActive(boolean active){
        this.active = active;
    }
}
