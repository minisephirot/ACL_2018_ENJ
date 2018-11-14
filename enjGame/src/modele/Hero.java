package modele;

import java.awt.image.BufferedImage;

/**
 * Hero du jeu
 */
public class Hero extends Entite {
    private BufferedImage imgHero;

    public Hero() {
        imgHero = TextureFactory.getImgHero();
        this.pv = 3;

    }

    public BufferedImage getImgHero(){
        return imgHero;
    }

    public void attaquer(){
    }

}