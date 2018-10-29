package modele;

import java.awt.*;

public class Mur {
    protected Rectangle rectangle;
    public Mur(int x, int y) {
        rectangle = new Rectangle(x, y, 64, 64);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
