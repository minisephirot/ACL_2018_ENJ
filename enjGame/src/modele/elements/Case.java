package modele.elements;

import modele.Hero;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Case {
    public static int CASE_SIZE = 32;

    private int x;
    private int y;
    private int xCamera;
    private int yCamera;
    private Rectangle rectangle;

    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x, y, CASE_SIZE, CASE_SIZE);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxCamera() {
        return xCamera;
    }

    public int getyCamera() {
        return yCamera;
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

    /* methode de creation de rectangle avec les nouvelles coordonnées du camera
    *  camY, camX : positions des la camera
    *  width, height : longeur et largeur de la fenetre
    * */
    public Rectangle getRectangleCamera(int camY, int camX, int width, int height) {
        xCamera =x - camY + (width / 2);
        yCamera =y - camX + (height / 2);

        return new Rectangle(xCamera,yCamera,(int)rectangle.getWidth(),(int)rectangle.getHeight());
    }

    abstract public BufferedImage getImg();

    abstract public boolean isActive();

    abstract public int handleSpecialEffect(Hero h);
}
