package modele.elements;

import modele.TextureFactory;

import java.awt.image.BufferedImage;

public class Teleporteur extends Case {
    private BufferedImage imgTp;
    private int voisinX;
    private int voisinY;
    private boolean active;

    public Teleporteur(int x, int y, int voisinX, int voisinY) {
        super(x, y);
        imgTp = TextureFactory.getImgTp();
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
    }

    public int getVoisinX(){
        return voisinX;
    }

    public int getVoisinY(){
        return voisinY;
    }
}
