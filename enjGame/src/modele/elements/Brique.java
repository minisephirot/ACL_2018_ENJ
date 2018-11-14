package modele.elements;

import modele.TextureFactory;

import java.awt.image.BufferedImage;

public class Brique extends Case {
    private BufferedImage imgBrique;
    private BufferedImage imgBriqueProf;
    private boolean profondeur;

    public Brique(int x, int y, boolean profondeur)  {
        super(x, y);
        this.profondeur = profondeur;
        imgBrique = TextureFactory.getImgBrique(this.profondeur);
    }

    public boolean isProfondeur(){
        return this.profondeur;
    }

    public BufferedImage getImgBrique(){
        return imgBrique;
    }

    public BufferedImage getImgBriqueProf(){
        return imgBriqueProf;
    }


}
