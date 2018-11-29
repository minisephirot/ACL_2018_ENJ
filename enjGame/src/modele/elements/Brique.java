package modele.elements;

import engine.TextureFactory;
import modele.Hero;

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

    public BufferedImage getImg(){
        return imgBrique;
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
