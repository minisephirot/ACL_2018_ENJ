# Projet-Labyrinthe
Projet M1 - Conception

Ici on fait la conception d'un jeu et son dévelopement en scrub, voilà.

https://www.plantuml.com/plantuml/img/bLN1Rjim3BthAuYSN2pfbkss1i60h4q3f4Mm7RPXs46nsLYeB7couYOO-a7xZltOADbnBCSfjY0mB99wZtoaPAQqHU05t8yPm6GzNLWqC7uFazVhwPrEKEAhcLQ5bjZolwtyC_FdDxT2ArZCMzvtbNSfq3b65Gf3bO0ZOnG944jU5B3awxqHogPpdY5C9ZvqEWMHvH8pLBO0v_dbjm2KMYImGTLiYovgpsTBwmrONRtKzkSsrxqeaM-F90TGmW7bVIt31krAyZsQhmr5OFxMc7rESShD1ar54Tq8YV10Zo0cmLpo6Cqj6XtjXlkNKw_pRruxUc5V6T_L3_g3R88WUWFwSGXZoBRcmBVMr4kk3laubLUwACHQOkHgt0rzgVkB_XHS-YVabJgxgs2v3vTvUTMFU4VZPSrfHVy3sgXSu2UUvqR7APheJ0cDYZJOrcWfQMRFpjunfidh4VTBKLXK3GNzUEmEGiV-t3liAqxFbpZhWACGXQLZ5lkAdqHYqpv7YcAJsWCjgnL2yq1DRgCIxRNQ28LTfMculpZmOqq7yws7RjchWJRyAQmpvEibSjC7ehWHIXGf9brCBBKiCRekIGl0a_w5147xJgaeyPdECgwIlcuuW6hFtF0yxK7m2MKaMdZMIN9Zwoknn-FHnCyjdfi-7x1e2kdBtAFbhbtdG3wIzdHPhBX2-QyGZ1sl3nYC1wCHr9SYg-_6mVZoKZbxS2ypT-Gx6-epwtU0QdjyvwlWhiIiqxJUADOULH-npU4aAFnmL43TyyKwIez651Senm8PAt-BddKB818V4k2IhX_esxRDv5y0

@
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
    
    class Hero<<Model>>{
        int x;
        int y;
        int pv;
    }
    
    class Monstre<<Model>>{
        int x;
        int y;
        int pv;
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


Labyrinthe "1"--  Niveau
Niveau "1..n"-- LabyrinthGame
Hero "1"--  Niveau
Monstre "1.. n"--  Niveau
Game "1"-- GameEngineGraph 
GameController "1"-- GameEngineGraph
GamePainter "1"--up  GameEngineGraph
LabyrinthGame "1"-- LabyrinthPainter
GraphInterface --"1" DrawingPanel
DrawingPanel --"1" GamePainter
GameEngineGraph -- "1" GraphInterface


@enduml

