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
    private static BufferedImage attaqueDroite[];
    private static BufferedImage attaqueGauche[];
    private static BufferedImage attaqueHaut[];
    private static BufferedImage attaqueBas[];
    private static BufferedImage animGauche[];
    private static BufferedImage animHaut[];
    private static BufferedImage imgMenu;
    private static BufferedImage imgFamtome;
    private static BufferedImage imgGoomba;
    private static BufferedImage imgPv;
    private static BufferedImage imgPvLost;
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
            imgTp = ImageIO.read(getClass().getResource("/res/teleporteur.png"));
            imgTpDisabled = ImageIO.read(getClass().getResource("/res/teleporteurdis.png"));
            imgArrive = ImageIO.read(getClass().getResource("/res/stairLeft.png"));
            imgArrive2 = ImageIO.read(getClass().getResource("/res/stairRight.png"));
            imgTresor = ImageIO.read(getClass().getResource("/res/tresor.png"));
            imgPiege = ImageIO.read(getClass().getResource("/res/piege.png"));
            imgMagique = ImageIO.read(getClass().getResource("/res/bonus.png"));
            imgFamtome = ImageIO.read(getClass().getResource("/res/boo.png"));
            imgGoomba = ImageIO.read(getClass().getResource("/res/goomba.png"));
            imgPv = ImageIO.read(getClass().getResource("/res/life.png"));
            imgPvLost = ImageIO.read(getClass().getResource("/res/nolife.png"));
            animBas = new BufferedImage[9];
            animDroite = new BufferedImage[9];
            animHaut = new BufferedImage[9];
            animGauche = new BufferedImage[9];
            animGauche[0] = ImageIO.read(getClass().getResource("/res/gauche/luigG1.png"));
            animGauche[1] = ImageIO.read(getClass().getResource("/res/gauche/luigG2.png"));
            animGauche[2] = ImageIO.read(getClass().getResource("/res/gauche/luigG3.png"));
            animGauche[3] = ImageIO.read(getClass().getResource("/res/gauche/luigG4.png"));
            animGauche[4] = ImageIO.read(getClass().getResource("/res/gauche/luigG5.png"));
            animGauche[5] = ImageIO.read(getClass().getResource("/res/gauche/luigG6.png"));
            animGauche[6] = ImageIO.read(getClass().getResource("/res/gauche/luigG7.png"));
            animGauche[7] = ImageIO.read(getClass().getResource("/res/gauche/luigG8.png"));
            animHaut[0] = ImageIO.read(getClass().getResource("/res/haut/luigH1.png"));
            animHaut[1] = ImageIO.read(getClass().getResource("/res/haut/luigH2.png"));
            animHaut[2] = ImageIO.read(getClass().getResource("/res/haut/luigH3.png"));
            animHaut[3] = ImageIO.read(getClass().getResource("/res/haut/luigH4.png"));
            animHaut[4] = ImageIO.read(getClass().getResource("/res/haut/luigH5.png"));
            animHaut[5] = ImageIO.read(getClass().getResource("/res/haut/luigH6.png"));
            animHaut[6] = ImageIO.read(getClass().getResource("/res/haut/luigH7.png"));
            animHaut[7] = ImageIO.read(getClass().getResource("/res/haut/luigH8.png"));
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
            attaqueHaut = new BufferedImage[6];
            attaqueBas = new BufferedImage[6];
            attaqueGauche = new BufferedImage[6];
            attaqueDroite = new BufferedImage[6];
            attaqueHaut[0] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU1.png"));
            attaqueHaut[1] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU2.png"));
            attaqueHaut[2] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU3.png"));
            attaqueHaut[3] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU4.png"));
            attaqueHaut[4] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU5.png"));
            attaqueHaut[5] = ImageIO.read(getClass().getResource("/res/attaque/attaqueU6.png"));
            attaqueBas[0] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD1.png"));
            attaqueBas[1] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD2.png"));
            attaqueBas[2] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD3.png"));
            attaqueBas[3] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD4.png"));
            attaqueBas[4] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD5.png"));
            attaqueBas[5] = ImageIO.read(getClass().getResource("/res/attaque/attaqueD6.png"));
            attaqueGauche[0] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL1.png"));
            attaqueGauche[1] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL2.png"));
            attaqueGauche[2] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL3.png"));
            attaqueGauche[3] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL4.png"));
            attaqueGauche[4] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL5.png"));
            attaqueGauche[5] = ImageIO.read(getClass().getResource("/res/attaque/attaqueL6.png"));
            attaqueDroite[0] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR1.png"));
            attaqueDroite[1] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR2.png"));
            attaqueDroite[2] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR3.png"));
            attaqueDroite[3] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR4.png"));
            attaqueDroite[4] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR5.png"));
            attaqueDroite[5] = ImageIO.read(getClass().getResource("/res/attaque/attaqueR6.png"));

        } catch (IOException e) {
            System.out.println("Impossible de charger les fichiers");
        }
    }

    public static BufferedImage getImgMenu(){return imgMenu;}

    public static BufferedImage getImgPv(){return imgPv;}
    public static BufferedImage getImgPvLost(){return imgPvLost;}

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
            return animHaut[anim];
        }else{
            return animGauche[anim];
        }
    }

    public static BufferedImage getImgAttaque(int dir, int anim){
        if (dir == 1){
            return attaqueBas[anim];
        }else if (dir == 3){
            return attaqueDroite[anim];
        }else if (dir == 0){
            return attaqueHaut[anim];
        }else{
            return attaqueGauche[anim];
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

    public static BufferedImage getImgGrass() {
        return imgSol3;
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

    public static BufferedImage getImgMonstre(boolean famtome) {
        if (famtome) return imgFamtome;
        return imgGoomba;
    }
}
