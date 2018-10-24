# Projet-Labyrinthe
Projet M1 - Conception

Ici on fait la conception d'un jeu et son dévelopement en scrub, voilà.
https://www.plantuml.com/plantuml/img/XLHHQzim47xNhpZov45IblTI2btQ3jeHjeTjZ3qezjKMbILFajE4iV--a-JObj9k48ppwUwxxpxVwTewRbpVIiPAoQs51xux6g5SSyTRXClBHrsXlBe2qNOIMrJEWZ_vpG3sMbHGenfJYdU4Vd7qNeFJyOMmFoVkJsAFl9z8FGdbWGhuyAT6jvNyYEPRe4kWxm4ATSk6cnfDf2nkXKHueiTuNc4dUOdc7eqk3ilZwz8cRMCJcClxeNxI3-GO0CLxqCzBM4FR6y-xqreYLwUQtgMjjbRi91PU_s4PsZZEhF2o9dFnu51L5ZRA2HUy7RhWpl5VFPhe8jzPPtZf87ASeaVIHwqe0D_cdOWjVkPTPtJPdCWp6swqSaPBYURj8PXYWkHdF3u8InK39G4aLMWrmyxBR3az_rLZ28YUqB0wKGOpNqJbcXniKDIDysLOo7gYhp5deJ8RLGk5yUEEq_NLaqND9-W-K0rOd2Z3Ns8FAVSPgHy74FPMA64RhEOSkDToZyLcJ_q1laAMs9xIagWRtRPSLNCdVLACkpEyQxAiKBIbvgV52GjFPIpDR8O61a7pbXJmuCTHPAugP7VUtddI1_AADcpB5Sh_fKoR1ulrOhKQhWast1QBzSM5yd1wCp6_GKa2i67-Gmge6LN8yB5zjpfpZ6M-HyuiYisdA4JqtLbCgZ3ov9FECZzNAufB_6A9UV5yLftb-gb824bu6RkcpQTx_Iy0

@startuml

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
    void attaquer()
}

abstract class Entite{
}

class Monstre<<Model>> extends Entite{

    void seRapprocher()
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
Labyrinthe "1"-- Niveau
Niveau "1..n"-- LabyrinthGame 
Hero "1"-- Niveau 
Monstre "1.. n"-- Niveau
Game "1"-up- GameEngineGraph 
GameController "1"-- GameEngineGraph
GamePainter "1"--up GameEngineGraph
LabyrinthGame "1"-- LabyrinthPainter
GraphInterface --"1" DrawingPanel
DrawingPanel --"1" GamePainter
GameEngineGraph -- "1" GraphInterface

@enduml
