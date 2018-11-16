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

    public Hero() {
        imgHero = TextureFactory.getImgHero(1, 0);
        this.pv = 3;
        anim = 0;
        this.stamina = 200;
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

    public void attaquer(){
    }

    public void enleverPv(){
        this.pv -= 1;
    }

    public void gagnerPv(){
        this.pv +=1;
    }

    public int getPv(){
        return pv;
    }

    public void changerDirection(int dir){
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

}