package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

public class Teleporteur extends Case {
    private BufferedImage imgTp;
    private int voisinX;
    private int voisinY;
    private boolean active;

    public Teleporteur(int x, int y, int voisinX, int voisinY) {
        super(x, y);
        imgTp = TextureFactory.getImgTp(true);
        this.voisinX = voisinX;
        this.voisinY = voisinY;
        active = true;
    }

    public BufferedImage getImgTp(){
        return imgTp;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
        imgTp = TextureFactory.getImgTp(active);
    }

    public int getVoisinX(){
        return voisinX;
    }

    public int getVoisinY(){
        return voisinY;
    }
}
