package modele;

import java.util.Random;

/**
 * Monstre du jeu
 */
public class Monstre extends Entite {

    /**
     * Niveau pour interagir
     */
    Niveau level;

    Random rng = new Random();

    public Monstre(Niveau niveau) {
        this.level = niveau;
        this.x = 100;
        this.y = 100;
    }

    /**
     * Methodes pour se rapprocher du héro
     */
    public void seRapprocher(){
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
    }
}
