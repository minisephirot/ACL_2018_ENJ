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

    public Hero() {
        imgHero = TextureFactory.getImgHero(1);
        this.pv = 3;
        anim = 0;
        this.stamina = 200;
    }

    public boolean canSprint() {
        return stamina >= 50;
    }

    public void handleStamina(boolean sprinting){
        if (sprinting){
            this.stamina -= 1;
            if (this.stamina <= 49) this.stamina = 49;
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
        imgHero = TextureFactory.getImgHero(dir);
    }

}