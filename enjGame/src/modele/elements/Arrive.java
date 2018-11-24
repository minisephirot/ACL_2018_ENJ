package modele.elements;

import engine.TextureFactory;

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

    /**
     * Get img arrive buffered image.
     *
     * @return the buffered image
     */
    public BufferedImage getImgArrive(){
        return imgArrive;
    }

}
