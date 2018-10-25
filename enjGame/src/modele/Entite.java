package modele;

/**
 * Hero du jeu
 */
public abstract class Entite {
    /**
     * Cordoonnée X de l'entité
     */
    private int x;

    /**
     * Coordonnée Y de l'entité
     */
    private int y;

    /**
     * Point de vie de l'entité
     */
    private int pv;

    /**
     * Constructeur de l'entité
     */
    public Entite(){
        this.x = 1;
        this.y = 1;
        this.pv = 1;
    }

    /**
     * getter Cordoonnée X de l'entité
     */
    public int getX() {
        return x;
    }

    /**
     * setter Cordoonnée X de l'entité
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter Cordoonnée Y de l'entité
     */
    public int getY() {
        return y;
    }

    /**
     * setter Cordoonnée Y de l'entité
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter pv de l'entité
     */
    public int getPv() {
        return pv;
    }

    /**
     * setter pv de l'entité
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * est-ce que l'entitée est morte
     */
    public boolean isDead() { return this.pv <= 0; }

}
