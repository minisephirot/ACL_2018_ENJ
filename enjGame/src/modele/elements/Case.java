package modele.elements;

import modele.Hero;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The type Case.
 */
public abstract class Case {
    /**
     * The constant CASE_SIZE.
     */
    public static int CASE_SIZE = 32;

    private int x;
    private int y;
    private int xCamera;
    private int yCamera;
    private Rectangle rectangle;

    /**
     * Instantiates a new Case.
     *
     * @param x the x
     * @param y the y
     */
    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x, y, CASE_SIZE, CASE_SIZE);
    }

    /**
     * Get x int.
     *
     * @return the int
     */
    public int getX(){
        return x;
    }

    /**
     * Get y int.
     *
     * @return the int
     */
    public int getY(){
        return y;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets camera.
     *
     * @return the camera
     */
    public int getxCamera() {
        return xCamera;
    }

    /**
     * Gets camera.
     *
     * @return the camera
     */
    public int getyCamera() {
        return yCamera;
    }

    /**
     * Get rectangle rectangle.
     *
     * @return the rectangle
     */
    public Rectangle getRectangle(){
        return rectangle;
    }

    /**
     * Gets rectangle camera.
     *
     * @param camY   the cam y
     * @param camX   the cam x
     * @param width  the width
     * @param height the height
     * @return the rectangle camera
     */
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
