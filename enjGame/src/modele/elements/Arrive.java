package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

/**
 * The type Arrive.
 */
public class Arrive extends Case {
    private BufferedImage imgArrive;
    private boolean leftside;

    /**
     * Instantiates a new Arrive.
     *
     * @param x        the x
     * @param y        the y
     * @param leftside the leftside
     */
    public Arrive(int x, int y,boolean leftside) {
        super(x, y);
        this.leftside = leftside;
        imgArrive = TextureFactory.getImgArrive(leftside);
    }

    public BufferedImage getImg(){
        return imgArrive;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        return -1;
    }
}
