package modele;

import java.awt.*;

public class Mur {
    protected String collision;
    protected Rectangle rectangle;

    public Rectangle getRectangle() {

        return rectangle;
    }

    public Mur(int x, int y){
        rectangle = new Rectangle(x, y, 64, 64);
    }

    public void setCollision(String collision) {
        this.collision = collision;
    }

    public String getCollision() {

        return collision;
    }
}
