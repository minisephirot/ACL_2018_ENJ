package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

public class PointVie extends Case {
    private BufferedImage imgPv;
    private BufferedImage imgPvLost;

    public PointVie(int x, int y)  {
        super(x, y);
        imgPv = TextureFactory.getImgPv();
        imgPvLost = TextureFactory.getImgPvLost();

    }

    public BufferedImage getImgPv(){
        return imgPv;
    }
    public BufferedImage getImgPvLost(){
        return imgPvLost;
    }


}