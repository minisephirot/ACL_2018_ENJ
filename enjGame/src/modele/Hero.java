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
    private int animation = 0;
    private int sprite = 0;
    private boolean invicible;
    private int pvMax=3;

    public Hero() {
        imgHero = TextureFactory.getImgHero(1, 0);
        this.pv = 3;
        anim = 0;
        this.stamina = 200;
        this.invicible = false;
    }

    public boolean canSprint() {
        return stamina >= 11;
    }

    public void handleStamina(boolean sprinting){
        if (sprinting){
            this.stamina -= 1;
            if (this.stamina <= 10) this.stamina = 10;
        }else{
            this.stamina += 1;
            if (this.stamina >= 200) this.stamina = 200;
        }
    }

    public int getStamina() {
        return this.stamina;
    }

    public BufferedImage getImgHero(){
        return imgHero;
    }

    public void enleverPv(){
        if (!invicible && pv > 0) {
            this.pv -= 1;
            this.invicible = true;
        }
    }

    public void noInvincible(){
        this.invicible = false;
    }

    public void gagnerPv(){
        this.pv +=1;
        this.pvMax++;
    }

    public int getPv(){
        return pv;
    }

    public void changerDirection(int dir){
        direction = dir;
        if (sprite < 7) {
            if (animation % 10 == 0) {
                imgHero = TextureFactory.getImgHero(dir, sprite);
                sprite++;
            }
        }else{
            sprite = 0;
        }
        animation++;
    }

    public void attaqueAnimation(int anim){
        imgHero = TextureFactory.getImgAttaque(direction, anim);
    }

    public int getWidth(){
        return this.imgHero.getWidth();
    }

    public int getHeight(){
        return this.imgHero.getHeight();
    }

    public int getPvMax() {
        return pvMax;
    }

}