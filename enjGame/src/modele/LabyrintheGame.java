package modele;

import engine.Commande;
import engine.Game;
import engine.TextureFactory;
import modele.elements.Arrive;
import modele.elements.Case;
import modele.elements.Mur;
import modele.elements.Sol;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LabyrintheGame implements Game {

    private int numerolab;
    private Niveau level;
    private boolean gameWin;
    private int floor;
    private final static int HAUT = 0;
    private final static int BAS = 1;
    private final static int GAUCHE = 2;
    private final static int DROITE = 3;
    private int gestionAttaqueAnimation;
    private int animationImg;
    private int dammageProofHero;
    private boolean menu;
    private int ignoreInput;

    public LabyrintheGame(){
        this.gameWin = false;
        this.level = new Niveau();
        this.numerolab = 0;
        this.gestionAttaqueAnimation = 0;
        this.animationImg = 0;
        this.dammageProofHero = 0;
        this.menu = true;
    }

    public void genLabyrinth(int numerolab){
        TextureFactory.genererCombinaison();
        if (numerolab == 0){
            this.level.genererNiveau();
        }else{
            TextureFactory.setTresor();
            this.level.chargerNiveau("Labyrinthe"+numerolab);
        }
        this.level.poserMonstres();
    }

    @Override
    public String toString(){
        return this.level.toString();
    }

    @Override
    public void evolve(Commande cmd, boolean[] tab) {
            if (ignoreInput != 0){
                cmd = Commande.IDLE;
                for (int i = 0; i < tab.length; i++) tab[i] = false;
                ignoreInput--;
            }
            if (isMenu()){
                if (cmd == Commande.DOWN){
                    this.numerolab++;
                    this.ignorerInput(15);
                }
                if (cmd == Commande.UP){
                    this.numerolab--;
                    this.ignorerInput(15);
                }
                if (this.numerolab < 0 ) this.numerolab = 5;
                if (this.numerolab > 5 ) this.numerolab = 0;
                if (cmd == Commande.ATTAQUE){
                    if (this.numerolab == 5) System.exit(3771);
                    else {
                        this.genLabyrinth(this.numerolab);
                        this.menu = false;
                        this.ignorerInput(25);
                    }
                }
            }else {
                if (isFinished()) {
                    this.gameWin = true;
                    if (this.numerolab == 0) {
                        this.genLabyrinth(this.numerolab);
                        this.incrementFloor();
                    }else{
                        if (cmd == Commande.ATTAQUE){
                            this.menu = true;
                            this.ignorerInput(50);
                        }
                    }
                } else if (isOver()) {
                    if (cmd == Commande.ATTAQUE){
                        this.menu = true;
                        this.ignorerInput(50);
                    }
                } else {
                    this.gestionCases();
                    int sprint = (tab[4]) ? 2 : 1;
                    this.level.sprintHandler(tab[4]);
                    if (!this.level.heroSprint()) sprint = 1;
                    if (gestionCollision(getMur(), cmd, tab)) {
                        if (cmd == Commande.UP || tab[0]) this.level.deplacerHero(-1 * sprint, 0);
                        else if (cmd == Commande.DOWN || tab[1]) this.level.deplacerHero(1 * sprint, 0);
                        else if (cmd == Commande.LEFT || tab[2]) this.level.deplacerHero(0, -1 * sprint);
                        else if (cmd == Commande.RIGHT || tab[3]) this.level.deplacerHero(0, 1 * sprint);
                    }
                    if (cmd == Commande.ATTAQUE && tab[5]) {
                        if (this.animationImg < 6) {
                            this.level.heroAttaque(this.animationImg);
                            if (gestionAttaqueAnimation % 5 == 0)
                                this.animationImg++;
                            this.gestionAttaqueAnimation++;
                            gestionAttaque();
                        }
                    } else {
                        this.gestionAttaqueAnimation = 0;
                        this.animationImg = 0;
                    }
                    for (Monstre m : this.level.getMonstres()) {
                        m.seRapprocher();
                        if (!m.isFamtome()) {
                            this.gestionCollision(getMur(), m);
                        }
                    }
                    if (dammageProofHero > 0) {
                        dammageProofHero--;
                        if (dammageProofHero == 0)
                            this.level.unsetInvincibleHero();
                    } else {
                        gestionMonstresAttaque();
                    }
                }
            }
    }



    private void ignorerInput(int i) {
        this.ignoreInput = i;
    }

    private void gestionMonstresAttaque(){
        int heightH = this.level.getHero().getHeight();
        int widthH = this.level.getHero().getWidth();
        int heroX = this.level.getPlayerX();
        int heroY = this.level.getPlayerY();

        Rectangle hero = new Rectangle(heroY, heroX, widthH, heightH);
        for (Monstre m : this.level.getMonstres()){
            Rectangle mob = new Rectangle(m.getY(), m.getX(), 32, 32);
            if (hero.intersects(mob) && dammageProofHero == 0){
                this.level.dammageHero();
                this.dammageProofHero += 250;
            }
        }
    }

    private void gestionAttaque(){
        int heightH = this.level.getHero().getHeight();
        int widthH = this.level.getHero().getWidth();
        int heroX = this.level.getPlayerX();
        int heroY = this.level.getPlayerY();
        int heroDirection = this.level.getHero().getDirection();

        if (heroDirection == 0){
            heroX -= 5;
        } else if (heroDirection == 1){
            heightH += 5;
        } else if (heroDirection == 2){
            heroY -= 0;
        } else if (heroDirection == 3){
            widthH += 0;
        }
        Rectangle hero = new Rectangle(heroY, heroX, widthH, heightH);
        ArrayList<Monstre> deadMonsters = new ArrayList<Monstre>();
        for (Monstre m : this.level.getMonstres()){
            Rectangle mob = new Rectangle(m.getY(), m.getX(), 32, 32);
            if (hero.intersects(mob)){
                m.takeDammage();
                if (m.isDead())
                    deadMonsters.add(m);
            }
        }
        this.level.killMonstres(deadMonsters);
    }

    private void gestionCases() {
        int herox = getHeroX();
        int heroy = getHeroY();
        Rectangle hero = new Rectangle(heroy, herox, 20, 20);
        for (Case c : this.getCasesSpeciales()){
            if (c.isActive() && c.getRectangle().intersects(hero)){
                if (c.handleSpecialEffect(this.getHero()) == 1)
                    this.dammageProofHero += 250;
            }
        }
    }

    @Override
    public boolean isFinished() {
        int herox = getHeroX();
        int heroy = getHeroY();
        Arrive arrive = this.getArrive();
        Rectangle hero = new Rectangle(heroy, herox, 20, 20);
        return arrive.getRectangle().intersects(hero);
    }

    @Override
    public boolean isOver() {
        return getHero().isDead();
    }

    public void gestionCollision(Mur mur, Monstre m){
        int x = m.x;
        int y = m.y;
        int dir = m.getDirection();
        boolean avancer = true;
        if (dir == 0) {
            x -= 1;
        } else if (dir == 1) {
            x += 1;
        }else if (dir == 2) {
            y -= 1;
        }else if (dir == 3) {
            y += 1;
        }
        Rectangle mob = new Rectangle(y, x, 32, 32);
        for (Case c : mur){
            if (c.getRectangle().intersects(mob))
                avancer = false;
        }
        if (avancer){
            if (dir == 0) {
                m.x -= 1;
            } else if (dir == 1) {
                m.x += 1;
            }else if (dir == 2) {
                m.y -= 1;
            }else if (dir == 3) {
                m.y += 1;
            }
        }
    }

    public boolean gestionCollision(Mur mur, Commande cmd, boolean[] tab){
        int herox = getHeroX();
        int heroy = getHeroY();
        int sprint = (tab[4]) ? 2 : 1;
        boolean avancer = true;
        if (cmd == Commande.UP || tab[0]) {
            herox -= sprint;
            changerDirection(HAUT);
        } else if (cmd == Commande.DOWN || tab[1]) {
            herox += sprint;
            changerDirection(BAS);
        }else if (cmd == Commande.LEFT || tab[2]) {
            heroy -= sprint;
            changerDirection(GAUCHE);
        }else if (cmd == Commande.RIGHT || tab[3]) {
            heroy += sprint;
            changerDirection(DROITE);
        }
        Rectangle hero = new Rectangle(heroy+2, herox, 16, 20);
        for (Case c : mur){
            if (c.getRectangle().intersects(hero))
                avancer = false;
        }
        return avancer;
    }

    public int[][] getLabyrinthe(){
        return level.getLabyrinthe();
    }

    public Hero getHero(){ return level.getHero();}

    public Mur getMur(){
        return level.getMur();
    }

    public void changerDirection(int dir){
        level.changerDirection(dir);
    }

    public ArrayList<Sol> getChemin(){return level.getChemin();}

    public Arrive getArrive(){
        return this.level.getArrive();
    }

    public ArrayList<Case> getCasesSpeciales(){
        return this.level.getCasesSpeciales();
    }

    public int getHeroX(){
        return level.getPlayerX();
    }

    public int getHeroY(){
        return level.getPlayerY();
    }

    public ArrayList<Monstre> getMonstres(){
        return level.getMonstres();
    }

    public boolean getGameWin() {
        return this.gameWin;
    }

    public void resetGame(){
        this.gameWin = false;
    }

    public int getNumerolab() {
        return numerolab;
    }

    public String getFloor() {
        return this.floor+"";
    }

    public void incrementFloor(){
        this.floor++;
    }

    public int getStamina(){
        return this.level.getStamina();
    }

    public int getDammageProofHero(){
        return this.dammageProofHero;
    }

    public boolean notInfinite() {
        return this.numerolab != 0;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }
}
