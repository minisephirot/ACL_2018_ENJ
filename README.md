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


