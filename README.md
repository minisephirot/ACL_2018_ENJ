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
https://www.plantuml.com/plantuml/img/fLRTRjem5BxtKnnnHRM2ndRNLLNNbbAajaBhf6r2lJ39WLXDxCnnA17YWVOSUx4Tso5_j5kb8HJCyJdVT_xXF3DScpo9WJ6f30BFu7u4R6fGm-W4xbI8CRwxL39JCPRo3oTmgN__uaOe2TD9AVru0hS2hM3WhO2X3C6XCXR4FClWbYyABQI99Zp1qrEdTtO68abZJ52Q3Ep55jXQYH1MA2k3_X4meDU3eQyhCCeVh7XNmT-BDVAymjrw4p87wMxSSOLc5lC2zVV-KNLV2N-KGkT0476zGkrX-zU2ObhIetJ5gOIOnZn0VODQzJV7nT7BNhBTGGhg-BVCEJ6NZ_I6k5A0_djGJySmWYJN5dYXg0XSxabjncOgoyGYnhwDOdFiWYaQTDQlEj6uCLIJ3CRI28FRAlpDf-fOrCTqxSzxMf5T8G-RmTnHNnYD_qlWCfdX5vwcMWKHQi_15mJE0mEUR8zvc4fgJwDL75CNljfKjOxpwWcBMv6HiuwC1CH3xToGxHXqQ6QSdd_ZA1Lys3HPHWGkpcSHcgWhZ52i8cDfdD6I2je48PQnN0c9lZ-gDlrciTgTU-EGceqRQlxiGsXZ7u3Qqb9ThuKKMOHX4mFNAbvZVxocy01TGTfWhQotOScfIvKaN8RDH5eZhpVHF8qwLeuqeU2T4xubx78gTqz7wX34pnoRxUY4qyh9hbVEEhNfRHfTKQveHcTSOln6atg69xPPk56DfgYgDN-SFzeTXXfrRU5nKXuyyHN2UDy-tiezFCTN6gLSupNrfT95UMzV5_boIP3XDB40ngjbm-6mqjWlJqjCPLW8oKMcP5dSNStK7J3lJ4tb9hVrhMZV1LHHpTiQ7LdRNM6VNJVANPANWtDmyq0zMYsMfey7cf-rfbtzHkKBRVlddygbMa_s1WFhfB_PiRgaC1ZqHhsI_51kRJh2uL3sR5XDEQaIWV-jOIzrc5NGTj8hBVy17e-CMp-lpAx-Dcgvhfq1oCQ5smrEDK-xOyewi-uHNrBQRwxNW5hkbJZTvSewC-nJs9nHrXfOVzzWPzqjGoHEfOtBs3bLdVxu_040

@startuml 

note as N1 
Iter 1: Modele+Console 
Iter 2: Création IG 
Iter 3: Lien IG-Modele 
end note 

class LabyrinthGame<<Model>> implements Game{ 
void genLabyrinth() 
    String toString() 
} 

class Niveau<<Model>>{ 
    int niveau int getPlayerX()
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

class LabyrintheGenerator <<Model>>{
    int[][] genererLabyrinthe()
}

package Elements {
    
    class TextureFactory {
        BufferedImage textures...
        void genererCombinaison()
    }
    
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
    
    class Arrive extends Element{
    }
    
    class Brique extends Element{
    }
    
    Brique "n"-- Mur
    
}
Labyrinthe --"1" Arrive
Labyrinthe --"1" Mur
Labyrinthe --"1..n" Sol
Labyrinthe "1"-- Niveau
LabyrintheGenerator "1"-right- Niveau
Niveau "1..n"-- LabyrinthGame
Hero "1"-- Niveau
Monstre "1.. n"-- Niveau
Game "1"--up GameEngineGraph
GameController "1"-- GameEngineGraph
GamePainter "1"--up GameEngineGraph
LabyrinthGame "1"-- LabyrinthPainter
GraphInterface --"1" DrawingPanel
DrawingPanel --"1" GamePainter
GameEngineGraph -- "1" GraphInterface 

@enduml
