import engine.GameController;
import engine.GameEngineGraph;
import engine.GamePainter;
import engine.TextureFactory;
import modele.LabyrintheController;
import modele.LabyrintheGame;
import modele.LabyrinthePainter;

import javax.swing.*;
import java.awt.*;

public class main {

    public static void main(String[] args){

        //init
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Le labyrinthe");
        TextureFactory textureFactory = new TextureFactory();

        //Menu
        JLabel label = new JLabel(new ImageIcon(TextureFactory.getImgMenu()));
        label.setLayout(new FlowLayout());
        Object[] elem = new Object[]{"Labyrinthe Infinis (le vrai jeu)","Labyrinthe 1", "Labyrinthe 2", "Labyrinthe 3", "Labyrinthe 4"};
        JComboBox liste = new JComboBox(elem);
        JButton starter = new JButton("Démarrer");

        starter.addActionListener(e -> {
            frame.dispose();
        });

        label.add(liste);
        label.add(starter);
        panel.add(label);
        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(800,583));
        frame.pack();
        frame.validate();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        newGame(0);

    }

    public static void newGame(int selectedIndex) {
        LabyrintheGame lg = new LabyrintheGame(selectedIndex);
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
