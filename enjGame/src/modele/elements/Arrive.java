package modele.elements;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

public class Arrive extends Case {
    private BufferedImage imgArrive;
    private boolean leftside;

    public Arrive(int x, int y,boolean leftside) {
        super(x, y);
        this.leftside = leftside;
        imgArrive = TextureFactory.getImgArrive(leftside);
    }

    public BufferedImage getImgArrive(){
        return imgArrive;
    }

}
