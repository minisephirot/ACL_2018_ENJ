package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class Teleporteur extends Case {
    private BufferedImage imgTp;
    private boolean active;
    private Teleporteur tpjumele;

    public Teleporteur(int x, int y, Teleporteur tpjumele) {
        super(x, y);
        imgTp = TextureFactory.getImgTp(true);
        this.tpjumele = tpjumele;
        active = true;
    }

    public BufferedImage getImg(){
        return imgTp;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
        if(this.getTpjumele().isActive()){
            this.getTpjumele().setActive(false);
        }
        imgTp = TextureFactory.getImgTp(active);
    }

    public Teleporteur getTpjumele() {
        return tpjumele;
    }

    public void setTpjumele(Teleporteur tpjumele) {
        this.tpjumele = tpjumele;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        h.setX(this.tpjumele.getY());
        h.setY(this.tpjumele.getX());
        this.setActive(false);
        return 2;
    }
}
