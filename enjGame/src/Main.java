import engine.GameController;
import engine.GameEngineGraph;
import engine.GamePainter;
import engine.TextureFactory;
import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;

public class Main {

    public static void main(String[] args){
        TextureFactory textureFactory = new TextureFactory();
        LabyrintheGame lg = new LabyrintheGame();
        GameController gc = new LabyrintheController();
        GamePainter gp = new LabyrinthePainter(lg);
        GameEngineGraph g = new GameEngineGraph(lg, gp, gc);
        try {
            g.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
