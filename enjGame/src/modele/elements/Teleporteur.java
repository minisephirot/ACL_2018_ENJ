package modele.elements;

import engine.TextureFactory;
import modele.Hero;

import java.awt.image.BufferedImage;

/**
 * The type Teleporteur.
 */
public class Teleporteur extends Case {
    private BufferedImage imgTp;
    private boolean active;
    private Teleporteur tpjumele;
    private boolean cooldown;

    /**
     * Instantiates a new Teleporteur.
     *
     * @param x        the x
     * @param y        the y
     * @param tpjumele the tpjumele
     */
    public Teleporteur(int x, int y, Teleporteur tpjumele) {
        super(x, y);
        imgTp = TextureFactory.getImgTp(true);
        this.tpjumele = tpjumele;
        active = true;
        cooldown = true;
    }

    public BufferedImage getImg(){
        return imgTp;
    }

    public boolean isActive(){
        return active;
    }

    /**
     * Is cooldown boolean.
     *
     * @return the boolean
     */
    public boolean isCooldown(){
        return cooldown;
    }

    /**
     * Set active.
     *
     * @param active the active
     */
    public void setActive(boolean active){
        this.cooldown = active;
        if(this.getTpjumele().isCooldown()){
            this.getTpjumele().setActive(active);
        }
        imgTp = TextureFactory.getImgTp(active);
    }

    /**
     * Gets tpjumele.
     *
     * @return the tpjumele
     */
    public Teleporteur getTpjumele() {
        return tpjumele;
    }

    /**
     * Sets tpjumele.
     *
     * @param tpjumele the tpjumele
     */
    public void setTpjumele(Teleporteur tpjumele) {
        this.tpjumele = tpjumele;
    }

    @Override
    public int handleSpecialEffect(Hero h) {
        if (this.isCooldown()) {
            h.playTPSound();
            h.setX(this.tpjumele.getY());
            h.setY(this.tpjumele.getX());
            this.setActive(false);
        }
        return 2;
    }
}
