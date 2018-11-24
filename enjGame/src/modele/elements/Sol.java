package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

/**
 * The type Sol.
 */
public class Sol extends Case {
    private BufferedImage imgSol;

    /**
     * Instantiates a new Sol.
     *
     * @param x    the x
     * @param y    the y
     * @param rand the rand
     */
    public Sol(int x, int y, int rand) {
        super(x, y);
        imgSol = TextureFactory.getImgSol();
    }

    /**
     * Get img sol buffered image.
     *
     * @return the buffered image
     */
    public BufferedImage getImgSol(){
        return imgSol;
    }
}
