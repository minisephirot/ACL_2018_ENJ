package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

public class PointVie extends Case {
    private BufferedImage imgPv;
    private BufferedImage imgPvLost;

    public PointVie(int x, int y)  {
        super(x, y);
        imgPv = TextureFactory.getImgPv();
        imgPvLost = TextureFactory.getImgPvLost();

    }

    @Override
    public BufferedImage getImg() {
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void handleSpecialEffect(Hero h) {

    }

    public BufferedImage getImgPv(){
        return imgPv;
    }
    public BufferedImage getImgPvLost(){
        return imgPvLost;
    }


}