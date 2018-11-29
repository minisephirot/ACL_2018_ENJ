package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

/**
 * The type Piege.
 */
public class Piege extends Case {
    private BufferedImage imgPiege;
    private boolean active;

    /**
     * Instantiates a new Piege.
     *
     * @param x the x
     * @param y the y
     */
    public Piege(int x, int y) {
        super(x, y);
        imgPiege = TextureFactory.getImgPiege();
        active = true;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        h.enleverPv();
        this.setActive(false);
        return 1;
    }

    public BufferedImage getImg(){
        return imgPiege;
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
