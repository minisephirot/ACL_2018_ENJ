package modele;

import engine.TextureFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Hero du jeu
 */
public class Hero extends Entite {
    private BufferedImage imgHero;
    private int anim;
    private int direction;
    private int stamina;
    private int animation = 0;
    private int sprite = 0;
    private boolean invicible;
    private int pvMax;
    private int vitesse;

    /**
     * Instantiates a new Hero.
     */
    public Hero() {
        imgHero = TextureFactory.getImgHero(1, 0);
        this.pv = 3;
        this.pvMax = 3;
        anim = 0;
        vitesse = 10;
        this.stamina = 200;
        this.invicible = false;
    }

    /**
     * Can sprint boolean.
     *
     * @return the boolean
     */
    public boolean canSprint() {
        return stamina >= 11;
    }

    /**
     * Handle stamina.
     *
     * @param sprinting the sprinting
     */
    public void handleStamina(boolean sprinting){
        if (sprinting){
            this.stamina -= 1;
            if (stamina > 10) vitesse = 4;
            if (this.stamina <= 10) {
                this.stamina = 10;
                vitesse = 10;
            }
        }else{
            vitesse = 10;
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
     * Enlever pv.
     */
    public void enleverPv(){
         if (!invicible && pv > 0) {
            this.pv -= 1;
            this.invicible = true;
        }
    }

    /**
     * No invincible.
     */
    public void noInvincible(){
        this.invicible = false;
    }

    /**
     * Gagner pv.
     */
    public void gagnerPv(){
        this.pv +=1;
        if (this.pv > 4) this.pv = 4;
        if (pv > pvMax && pvMax < 4) {
            pvMax++;}
    }

    public int getPv(){
        return pv;
    }

    /**
     * Changer direction.
     *
     * @param dir the dir
     */
    public void changerDirection(int dir){
        direction = dir;
        if (sprite < 7) {
            if (animation % vitesse == 0) {
                imgHero = TextureFactory.getImgHero(dir, sprite);
                sprite++;
            }
        }else{
            sprite = 0;
        }
        animation++;
    }

    /**
     * Attaque animation.
     *
     * @param anim the anim
     */
    public void attaqueAnimation(int anim){
        imgHero = TextureFactory.getImgAttaque(direction, anim);
    }

    /**
     * Get width int.
     *
     * @return the int
     */
    public int getWidth(){
        return this.imgHero.getWidth();
    }

    /**
     * Get height int.
     *
     * @return the int
     */
    public int getHeight(){
        return this.imgHero.getHeight();
    }

    /**
     * Gets pv max.
     *
     * @return the pv max
     */
    public int getPvMax() {
        return pvMax;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public int getDirection() { return direction; }

    /**
     * Reset.
     */
    public void reset() {
        this.pv = 3;
        this.pvMax = 3;
        this.stamina = 200;
        this.invicible = false;
    }
}