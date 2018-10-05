# Projet-Labyrinthe
Projet M1 - Conception

Ici on fait la conception d'un jeu et son dévelopement en scrub, voilà.

http://www.plantuml.com/plantuml/img/RPBFJW8n4CRlVOevWhBHrPinXCY1O1Or8HgDyJ2xEragtHRRBeY41_8vV37RNVuKDEcX_NxjVFDbsZCMjQrAmPXKbW0DtCKCu3hj3YrfYA_W-YpjZbHEWaxxIXebAE0N3U_hds-qN4aO3W9wsT24amTHKuMHpC6RCPO9D0OIh6Gs8RroB-UAvr0YbwtszbHtk74-KWSQPnF-KNbzpTWCioaM1BNFQbj-W2MDK3gWWJwjSpTmdnhISqm5WNVbqhxADxT0OBhKxZY1rZceQGTYA2lTWIY6TrLHfTlDTIZ8FWXSadvk_P5UWZR99jkIO_v5BNzHxd11SeVhHsFhzWLOrMp2GZ9_dELeDrc3k4-S5WTflN0KrMNtGU7MsP48mlRHaAd9Y6HrWzfvAv6YzbhjNFtlwYPYjHA2j5bjlFTIOpQbPSADQuDq7GGmytyaqDQ-ugxbaoWAftK8ziLPE567ShMG8MOz5znzwLy0
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


