package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class Piege extends Case {
    private BufferedImage imgPiege;
    private boolean active;

    public Piege(int x, int y) {
        super(x, y);
        imgPiege = TextureFactory.getImgPiege();
        active = true;
    }

    @Override
    public void handleSpecialEffect(Hero h) {
        h.enleverPv();
        this.setActive(false);
    }

    public BufferedImage getImg(){
        return imgPiege;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
