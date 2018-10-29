package modele.elements;

import java.awt.*;

public abstract class Case {
    public static int CASE_SIZE = 64;

    private int x;
    private int y;
    private Rectangle rectangle;

    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x, y, CASE_SIZE, CASE_SIZE);
    }

    public Rectangle getRectangle(){
        return rectangle;
    }
}
