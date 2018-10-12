package modele;

public class LabyrintheGame {

    private Niveau level;

    public LabyrintheGame(){
        this.level = new Niveau();
    }

    public void deplacerHeros(String s){
        if (s.equalsIgnoreCase("Z")) this.level.deplacerHero(-1,0);
        if (s.equalsIgnoreCase("S")) this.level.deplacerHero(1,0);
        if (s.equalsIgnoreCase("Q")) this.level.deplacerHero(0,-1);
        if (s.equalsIgnoreCase("D")) this.level.deplacerHero(0,1);
    }

    @Override
    public String toString(){
        return this.level.toString();
    }
}
