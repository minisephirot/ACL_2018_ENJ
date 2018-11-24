package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

/**
 * The type Brique.
 */
public class Brique extends Case {
    private BufferedImage imgBrique;
    private BufferedImage imgBriqueProf;
    private boolean profondeur;

    /**
     * Instantiates a new Brique.
     *
     * @param x          the x
     * @param y          the y
     * @param profondeur the profondeur
     */
    public Brique(int x, int y, boolean profondeur)  {
        super(x, y);
        this.profondeur = profondeur;
        imgBrique = TextureFactory.getImgBrique(this.profondeur);
    }

    /**
     * Is profondeur boolean.
     *
     * @return the boolean
     */
    public boolean isProfondeur(){
        return this.profondeur;
    }

    /**
     * Get img brique buffered image.
     *
     * @return the buffered image
     */
    public BufferedImage getImgBrique(){
        return imgBrique;
    }

    /**
     * Get img brique prof buffered image.
     *
     * @return the buffered image
     */
    public BufferedImage getImgBriqueProf(){
        return imgBriqueProf;
    }


}
