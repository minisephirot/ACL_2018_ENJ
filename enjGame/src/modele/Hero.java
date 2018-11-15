package modele;

import java.awt.image.BufferedImage;
import java.sql.Time;

/**
 * Hero du jeu
 */
public class Hero extends Entite {
    private BufferedImage imgHero;
    private int anim;
    private int direction;

    public Hero() {
        imgHero = TextureFactory.getImgHero(1);
        this.pv = 3;
        anim = 0;

    }

    public BufferedImage getImgHero(){
        return imgHero;
    }

    public void attaquer(){
    }
    public void changerDirection(int dir){
        imgHero = TextureFactory.getImgHero(dir);
    }

}