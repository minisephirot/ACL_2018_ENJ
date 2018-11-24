package modele;

import engine.TextureFactory;

import java.awt.image.BufferedImage;

/**
 * Hero du jeu
 */
public class Hero extends Entite {
    private BufferedImage imgHero;
    private int anim;
    private int direction;
    private int stamina;

    /**
     * Instantiates a new Hero.
     */
    public Hero() {
        imgHero = TextureFactory.getImgHero(1);
        this.pv = 3;
        anim = 0;
        this.stamina = 200;
    }

    /**
     * Can sprint boolean.
     *
     * @return the boolean
     */
    public boolean canSprint() {
        return stamina >= 50;
    }

    /**
     * Handle stamina.
     *
     * @param sprinting the sprinting
     */
    public void handleStamina(boolean sprinting){
        if (sprinting){
            this.stamina -= 1;
            if (this.stamina <= 49) this.stamina = 49;
        }else{
            this.stamina += 1;
            if (this.stamina >= 200) this.stamina = 200;
        }
    }

    /**
     * Gets stamina.
     *
     * @return the stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    /**
     * Get img hero buffered image.
     *
     * @return the buffered image
     */
    public BufferedImage getImgHero(){
        return imgHero;
    }

    /**
     * Attaquer.
     */
    public void attaquer(){
    }

    /**
     * Changer direction.
     *
     * @param dir the dir
     */
    public void changerDirection(int dir){
        imgHero = TextureFactory.getImgHero(dir);
    }

}