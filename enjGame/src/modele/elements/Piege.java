package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

public class Piege extends Case {
    private BufferedImage imgPiege;
    private int voisinX;
    private int voisinY;
    private boolean active;

    public Piege(int x, int y) {
        super(x, y);
        imgPiege = TextureFactory.getImgPiege();
        this.voisinX = voisinX;
        this.voisinY = voisinY;
        active = true;
    }

    public BufferedImage getImgPiege(){
        return imgPiege;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
