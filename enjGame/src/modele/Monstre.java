package modele;

import engine.TextureFactory;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Monstre du jeu
 */
public class Monstre extends Entite {

    /**
     * Niveau pour interagir
     */
    private Niveau level;

    private Random rng = new Random();

    private boolean famtome;
    private int direction;

    public Monstre(Niveau niveau, int x , int y, boolean nocoll) {
        this.pv = 1;
        this.level = niveau;
        this.famtome = nocoll;
        this.x = x;
        this.y = y;
    }

    /**
     * Methodes pour se rapprocher du héro
     */
    public void seRapprocher(){
        if (famtome){
            int heroX = this.level.getPlayerX();
            int heroY = this.level.getPlayerY();
            int deplacement = rng.nextInt(101);
            if (heroX < this.x && deplacement < 25){
                this.x -= 1;
            }
            if (heroY < this.y && deplacement < 25){
                this.y -= 1;
            }
            if (heroX > this.x && deplacement < 25){
                this.x += 1;
            }
            if (heroY > this.y && deplacement < 25){
                this.y += 1;
            }
        }else{
            int deplacement = rng.nextInt(101);
            if (deplacement < 5){
                this.direction = rng.nextInt(4);
            }
        }
    }

    public int getDirection(){
        return  this.direction;
    }

    public boolean isFamtome() {
        return famtome;
    }

    public BufferedImage getImgMonstre(){
        return TextureFactory.getImgMonstre(this.famtome);
    }

    public void takeDammage(){
        this.pv -= 1;
    }
}