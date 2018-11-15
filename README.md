# Projet-Labyrinthe
Projet M1 - Conception

Compiler et exécuter le programme :

Pour compiler et lancer le programme, il faut run la méthode main présente dans la class GameEngineGraph
Le labyrinthe va s'afficher dans la console :
        - Les 1 représentent les murs
        - Les 0 représentent les cases vides dans lesquelles le héro peut se déplacer
        - H concerne la position du héro dans le labyrinthe

Pour déplacer le héro : il faut utiliser les touches "z", "q", "s" ou "d".
Pour sprinter : la touche "espace".

Diagramme UML du projet :

https://www.plantuml.com/plantuml/img/ZLRRJXin47ttLupo55GIDUMD8aI142915ObAROLuS7OdYSMklRMz8Qie7zJlw8zrR6_s5cY9qCOxdZbdxk72MAvjdYR0c5GMWHluEW8sjQXXT0htAiO4FrmfQLI2fVpJALpfFx-v5Kh2T59AJqxXJg0J388LC9GnU5J6hB0akLPHdgAq42D4IaQOUOproN34M9HmO-2Epmijf5rDU8fdPnxg_1n4cYNeJ0suYosmjH8nB55M1lqZO42V1qklIx0g79nu1tluhsADFAzmjy64p47w6tzSefqbl43zetzKtLV2dwNGEn2jk5wY3h3z6q51BkXHkk9LOimI7g6-HQtwc-FYw7KlsUuW1NNyM-QTU9HFz0T9fG3zZw2UZs44QQuTy5nHdRZSaxgCpPGnOfvWtqMnEVR150qwvrUTQDnOAfk1iQIIuROAV_EvEXRrCLk7yvvMc6laSGY6putLFB8GQFQ0Xs5ITrcjaeIQwCs2rphUfMSixeGXJr67QX0FTL93jcFGePbnUlwBerG8CTDWM17v85z4R5TTuGh5ScKTZJTQKBAR8CGobaiXCTIkQg7l3glTLRSUgTbKiUOl8OGszW6eIplb_4P8OLOODp5mhP8rziThDsxe2z86QsMz3KjENQaqvJ9k9j8P1Rs9vjcgO-L9KmhUE-7V_6ufLqT7wX74hnoRVU-5qyh9hbVUEdFfRHfTKwveVcPSOl9Eatg-9gvPk5MDfgYgzVZq-EJs2shKjKN0oNZqp9S8uttx12l_21pVQ8voZJVKbqeNvRtxNEQB1K76qzG1sA1cXiDXfR5VR8wOoZ0NaWkZP5dSNStK7R3WJ4tbnxRrLhJl8ggevcsDZgpjhd3FhXk1_Jul1-VWve5wjDegJHyFDBzeJNlqdSgNslNFVvLBjPxi3GREoN2pOtL9OJ3eZNeb-Q7SsNI4mw7ikR2QSb8bWl0xm5xhCAUWtQHNMk4B0XuPjtxwc5lBRLI_0hmapxhJo3eZ7GnVKzelgBU0MbwKEDqToZgZ6ZBL74NMcijmts1dtML295wbZSlO1HMN_Ztv2m00

@startuml 

note as N1 
Iter 1: Modele+Console 
Iter 2: Création IG 
Iter 3: Lien IG-Modele 
end note 

title Document de conception v3.1

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
Game "1"--up GameEngineGraph
GameController "1"-- GameEngineGraph
GamePainter "1"--up GameEngineGraph
LabyrinthGame "1"-- LabyrinthPainter
GraphInterface --"1" DrawingPanel
DrawingPanel --"1" GamePainter
GameEngineGraph -- "1" GraphInterface 

@enduml
