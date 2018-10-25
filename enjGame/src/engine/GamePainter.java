package engine;

public interface GamePainter {

    /**
     * @return largeur de l'image
     */
    public int getWidth();

    /**
     * @return hauteur de l'image
     */
    public int getHeight();

    /**
     * dessine l'image
     */
    public void draw();

}
