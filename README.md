# Projet-Labyrinthe
Projet M1 - Conception

Compiler et exécuter le programme :

Pour compiler et lancer le programme, il faut run la méthode main présente dans la class GameEngineGraph
Le labyrinthe va s'afficher dans la console :
        - Les 1 représentent les murs
        - Les 0 représentent les cases vides dans lesquelles le héro peut se déplacer
        - H concerne la position du héro dans le labyrinthe

Pour déplacer le héro, il faut rentrer "z", "q", "s" ou "d" dans la console.


Diagramme UML du projet :

https://www.plantuml.com/plantuml/img/XLHHQzim47xNhpZov45IblTI2btQ3jeHjeTjZ3qezjKMbILFajE4iV--a-JObj9k48ppwUwxxpxVwTewRbpVIiPAoQs51xux6g5SSyTRXClBHrsXlBe2qNOIMrJEWZ_vpG3sMbHGenfJYdU4Vd7qNeFJyOMmFoVkJsAFl9z8FGdbWGhuyAT6jvNyYEPRe4kWxm4ATSk6cnfDf2nkXKHueiTuNc4dUOdc7eqk3ilZwz8cRMCJcClxeNxI3-GO0CLxqCzBM4FR6y-xqreYLwUQtgMjjbRi91PU_s4PsZZEhF2o9dFnu51L5ZRA2HUy7RhWpl5VFPhe8jzPPtZf87ASeaVIHwqe0D_cdOWjVkPTPtJPdCWp6swqSaPBYURj8PXYWkHdF3u8InK39G4aLMWrmyxBR3az_rLZ28YUqB0wKGOpNqJbcXniKDIDysLOo7gYhp5deJ8RLGk5yUEEq_NLaqND9-W-K0rOd2Z3Ns8FAVSPgHy74FPMA64RhEOSkDToZyLcJ_q1laAMs9xIagWRtRPSLNCdVLACkpEyQxAiKBIbvgV52GjFPIpDR8O61a7pbXJmuCTHPAugP7VUtddI1_AADcpB5Sh_fKoR1ulrOhKQhWast1QBzSM5yd1wCp6_GKa2i67-Gmge6LN8yB5zjpfpZ6M-HyuiYisdA4JqtLbCgZ3ov9FECZzNAufB_6A9UV5yLftb-gb824bu6RkcpQTx_Iy0

@startuml

note as N1
  <b>Iter 1: </b>Modele+Console
  <b>Iter 2: </b>Création IG
  <b>Iter 3: </b>Lien IG-Modele
end note

class Launcher{
  void main()
  void startConsole()
  void startGraphique()
}

package Model{

class GameManager extends Observable {
  int[n][n] labyrinth (0 ok, 1 mur, -1 joueur)
  int getPlayerX()
  int getPlayerY()
  void setLabyrinthSize(int n)
  void genLabyrinth()
  String toString()
  void sendUpdate()
}

}

package View{

class GameView extends Observer {
   JLabel[n][n] labyCases
   JMenuBar toolbar
   void update()
}

}

package Controllers{
class Controller {
   keyListener()
   actionListener()
}
}

GameView *-- GameManager
GameView *-- Controller
GameManager *--down Controller

@enduml

EDIT :

UML Caché secret : 

https://www.plantuml.com/plantuml/img/hLPBRjim4Dth58HN2XgdTRjh3ID8uYG6ai1e5crHT45BOuc8HAeKxTWeSg2UenVhaDI7rAT0W1g6OCsycJUS7trUAYhLBiy2meK2GaloC0i8cMyMAmMIp3wI-TlDubx4aC6RIy5BaO6ZVs_rb_BFRwgOu6HrusW_MEqT0wsOMYy1yDYG8H0_KKRBajpHpL4ohj8RcWEPpmrqiI0iBpB8WQkIQCqlQqFsWiKa0TwOXIULvb7XUqAKi3yg-OlBzS3sG7SjIUqK_H1kT8uW0RNEw17aruR24tzhn2QcAAKo0MafmckM0TdYmyF4K6Gq0daBKeI7q-E_GtVY3mRo1KF7-Cv_u9Ta3OY4xuXuEYKpakzapRSHM4lAwtXqbjUYBDacWr2VyN1gZdey6Gv1XzyM2WuAwrgI9LTCDNMooJfyybwF_cknRz_ha5Xv1JGEHvZliGsLXFzDRefJmcTQ5594ASW-FzqWCOrK5OZBDruYd1ebHPRXG8msTejfed-2unqhyM1D83g0I4zPH-vrTqExflZy5sS5QDE5kq2noEJbcSKg7LAam99KkRJ6oHORo7MAh4kUC0vjNpQ3yqNxRezKYs-DPqTkXqNIP_-OFjyWaMuZxA5hnbcPGjpr2NkHxI5SxZ4L17f5zWcywlMfCF1BaUUKnqF5q0wipOsaHJhWmGIKOzByFMBMShLk1pJ66_kvWx4HCO1LSv2Xo8stGfThpCaLvXuNqPfoo5xjeg3H4qs0BEkMQysQ7zrnij0MM7V7eISvzZ4HvbhIFd90Vh7RRa52lCfrX4m_6_rBFyngw-oSKHb5FMBdDUkeUvvHgmkfY_agmyfamYVJgOxDHxm4GNj5aEbqCfiGW-f8pyuuAZ1eLu5Wz5dTaq5rNLeiohshEj2tGCUWMi_6Wd1NOmRMW7T5RpQ2phHPfnrKuEwOsbCFvF-Ri8wwUp7eZ8ZDaTloWTV_Lk_G1zq388c1U7u3SeubnJzOVm40
@startuml
 note as N1
  <b>Iter 1: </b>Modele+Console
  <b>Iter 2: </b>Création IG
  <b>Iter 3: </b>Lien IG-Modele
end note
     class LabyrinthGame <<Model>> implements Game{
      void genLabyrinth()
      String toString()
    }
     class Niveau <<Model>>{
      int niveau
      int getPlayerX()
      int getPlayerY()
      void chargerNiveau(File file)
      void deplacerHero(x,y)
      String toString()
    
    }
    
    class Labyrinthe<<Model>>{
      int[n][n] labyrinthe (0 ok, 1 mur)
      boolean deplacementPossible(int x, int y)
    }
    
    class Hero<<Model>> extends Entite{
        int x;
        int y;
        int pv;
        boolean isDead()
    }
    
    class Monstre<<Model>> extends Entite{
        int x;
        int y;
        int pv;
        void seRapprocher()
    }
    
    abstract class Entite{
    }
    
    class LabyrinthController <<Model>> implements GameController{
       keyListener()
       actionListener()
    }
     class LabyrinthPainter <<Model>> implements GamePainter{
        static int width
        static int height
    }
     interface GamePainter <<Engine>>{
        int getWidth()
        int getHeight()
        void draw()
    }
     interface Game <<Engine>>{
        bool isFinished()
        void evolve(Event e)
    }
    
    interface GameController <<Engine>>{
        getCommand()
    }
     class GameEngineGraph <<Engine>>{
      void main()
      void startConsole()
      void startGraphique()
    }
    
    class GraphInterface <<Engine>>{
        void paint()
    }
    
    class DrawingPanel <<Engine>>{
        void paint()
    }
    
    package Elements {
        
        abstract class Element{
            int x
            int y
            int xcamera
            int ycamera
            BufferedImage image
        }
        
        class Mur{
        }
        
        class Sol extends Element{
        }
        
        class Brique extends Element{
        }
        
        Brique "n"-- Mur
        
    }

Labyrinthe --"1"  Mur
Labyrinthe --"1..n"  Sol
Labyrinthe "1"--  Niveau
Niveau "1..n"-- LabyrinthGame
Hero "1"--  Niveau
Monstre "1.. n"--  Niveau
Game "1"--up GameEngineGraph 
GameController "1"-- GameEngineGraph
GamePainter "1"--up  GameEngineGraph
LabyrinthGame "1"-- LabyrinthPainter
GraphInterface --"1" DrawingPanel
DrawingPanel --"1" GamePainter
GameEngineGraph -- "1" GraphInterface
 @enduml
