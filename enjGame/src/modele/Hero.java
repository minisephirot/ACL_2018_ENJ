package modele;

/**
 * Hero du jeu
 */
public class Hero {
    /**
     * Cordoonnée X du hero
     */
    private int x;

    /**
     * Coordonnée Y du hero
     */
    private int y;

    /**
     * Point de vie du héro
     */
    private int pv;

    /**
     * Constructeur du hero
     */
    public Hero(){
        this.x = 2;
        this.y = 2;
    }

    /**
     * getter Cordoonnée X du hero
     */
    public int getX() {
        return x;
    }

    /**
     * setter Cordoonnée X du hero
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter Cordoonnée Y du hero
     */
    public int getY() {
        return y;
    }

    /**
     * setter Cordoonnée Y du hero
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter pv du hero
     */
    public int getPv() {
        return pv;
    }

    /**
     * setter pv du hero
     */
    public void setPv(int pv) {
        this.pv = pv;
    }
}
