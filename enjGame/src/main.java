import com.sun.prism.Texture;
import engine.GameController;
import engine.GameEngineGraph;
import engine.GamePainter;
import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;
import modele.TextureFactory;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
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
