package engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class TextureFactory {

    //Logic
    private final static int NBSPRITEMUR = 2;
    private final static int NBSPRITESOL = 4;
    private static final Random rng = new Random();
    private static int numeroSol;
    private static int numeroMur;
    //Texture
    private static BufferedImage imgBrique;
    private static BufferedImage imgBriqueP;
    private static BufferedImage imgBrique2;
    private static BufferedImage imgBriqueP2;
    private static BufferedImage imgSol;
    private static BufferedImage imgSol2;
    private static BufferedImage imgSol3;
    private static BufferedImage imgSol4;
    private static BufferedImage imgHero[];
    private static BufferedImage imgArrive;
    private static BufferedImage imgArrive2;
    private static BufferedImage imgTp;
    private static BufferedImage imgTpDisabled;
    private static BufferedImage imgPiege;
    private static BufferedImage imgMagique;
    private static BufferedImage imgTresor;
     private static BufferedImage animBas[];
     private static BufferedImage animDroite[];
    private static BufferedImage imgMenu;
    private static boolean tresor = false;

    public TextureFactory() {
        try {
            imgMenu = ImageIO.read(getClass().getResource("/res/LB.jpg"));
            imgBrique = ImageIO.read(getClass().getResource("/res/mur.jpg"));
            imgBriqueP = ImageIO.read(getClass().getResource("/res/murProf.jpg"));
            imgBrique2 = ImageIO.read(getClass().getResource("/res/murgele.png"));
            imgBriqueP2 = ImageIO.read(getClass().getResource("/res/murgeleProf.png"));
            imgSol = ImageIO.read(getClass().getResource("/res/sol.png"));
            imgSol2 = ImageIO.read(getClass().getResource("/res/sol.jpg"));
            imgSol3 = ImageIO.read(getClass().getResource("/res/grass.jpeg"));
            imgSol4 = ImageIO.read(getClass().getResource("/res/solgele.png"));
            imgHero = new BufferedImage[4];
            imgHero[0] = ImageIO.read(getClass().getResource("/res/luigdown.png"));
            imgHero[1] = ImageIO.read(getClass().getResource("/res/luigup.png"));
            imgHero[2] = ImageIO.read(getClass().getResource("/res/luigleft.png"));
            imgHero[3] = ImageIO.read(getClass().getResource("/res/luigright.png"));
            imgTp = ImageIO.read(getClass().getResource("/res/teleporteur.png"));
            imgTpDisabled = ImageIO.read(getClass().getResource("/res/teleporteurdis.png"));
            imgArrive = ImageIO.read(getClass().getResource("/res/stairLeft.png"));
            imgArrive2 = ImageIO.read(getClass().getResource("/res/stairRight.png"));
            imgTresor = ImageIO.read(getClass().getResource("/res/luigup.png"));
            imgPiege = ImageIO.read(getClass().getResource("/res/piege.png"));
            imgMagique = ImageIO.read(getClass().getResource("/res/bonus.png"));
            animBas = new BufferedImage[9];
            animDroite = new BufferedImage[9];
            animBas[0] = ImageIO.read(getClass().getResource("/res/bas/luigB1.png"));
            animBas[1] = ImageIO.read(getClass().getResource("/res/bas/luigB2.png"));
            animBas[2] = ImageIO.read(getClass().getResource("/res/bas/luigB3.png"));
            animBas[3] = ImageIO.read(getClass().getResource("/res/bas/luigB4.png"));
            animBas[4] = ImageIO.read(getClass().getResource("/res/bas/luigB5.png"));
            animBas[5] = ImageIO.read(getClass().getResource("/res/bas/luigB6.png"));
            animBas[6] = ImageIO.read(getClass().getResource("/res/bas/luigB7.png"));
            animBas[7] = ImageIO.read(getClass().getResource("/res/bas/luigB8.png"));
            animDroite[0] = ImageIO.read(getClass().getResource("/res/droite/luigD1.png"));
            animDroite[1] = ImageIO.read(getClass().getResource("/res/droite/luigD2.png"));
            animDroite[2] = ImageIO.read(getClass().getResource("/res/droite/luigD3.png"));
            animDroite[3] = ImageIO.read(getClass().getResource("/res/droite/luigD4.png"));
            animDroite[4] = ImageIO.read(getClass().getResource("/res/droite/luigD5.png"));
            animDroite[5] = ImageIO.read(getClass().getResource("/res/droite/luigD6.png"));
            animDroite[6] = ImageIO.read(getClass().getResource("/res/droite/luigD7.png"));
            animDroite[7] = ImageIO.read(getClass().getResource("/res/droite/luigD8.png"));
        } catch (IOException e) {
            System.out.println("Impossible de charger les fichiers");
        }
    }

    public static BufferedImage getImgMenu(){return imgMenu;}

    public static BufferedImage getImgBrique(boolean isProfondeur) {
        switch (numeroMur){
            case 0:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
            case 1:
                if (isProfondeur) return imgBriqueP2;
                return imgBrique2;
            default:
                if (isProfondeur) return imgBriqueP;
                return imgBrique;
        }
    }

    public static BufferedImage getImgHero(int dir, int anim) {
        if (dir == 1){
            return animBas[anim];
        }else if (dir == 3){
            return animDroite[anim];
        }else if (dir == 0){
            return imgHero[0];
        }else{
            return imgHero[2];
        }
    }

    public static BufferedImage getImgTp(boolean activated) {
        if (activated) return imgTp;
        return imgTpDisabled;
    }

    public static BufferedImage getImgPiege(){return imgPiege;}

    public static BufferedImage getImgMagique(){return imgMagique;}

    public static BufferedImage getImgArrive(boolean leftside) {
        if (tresor) return imgTresor;
        if (leftside)return imgArrive;
        return imgArrive2;
    }

    public static BufferedImage getImgSol() {
        switch (numeroSol){
            case 0:
                return imgSol;
            case 1:
                return imgSol2;
            case 2:
                return imgSol3;
            case 3:
                return imgSol4;
            default:
                return imgSol;
        }
    }

    public static void genererCombinaison(){
        numeroSol = rng.nextInt(NBSPRITESOL);
        numeroMur = rng.nextInt(NBSPRITEMUR);
    }

    public static void setTresor() {
        tresor = true;
    }
}
