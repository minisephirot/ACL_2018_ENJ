package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class Arrive extends Case {
    private BufferedImage imgArrive;
    private boolean leftside;

    public Arrive(int x, int y,boolean leftside) {
        super(x, y);
        this.leftside = leftside;
        imgArrive = TextureFactory.getImgArrive(leftside);
    }

    public BufferedImage getImg(){
        return imgArrive;
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
