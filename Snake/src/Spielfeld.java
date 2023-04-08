import java.awt.Color;
import java.awt.Graphics;

public class Spielfeld {

  static ZEICHENFENSTER zf;
  static int breite = 700;
  static int höhe = 500;
  private State state = State.START;
  private int sizeX, sizeY;
  private int[][] tileMap;
  public Spielfeld() {
    zf = new ZEICHENFENSTER("Snake !           Deine Punktzahl: ", breite, höhe, State.START);
    zf.frame.setBounds(400, 100, breite, höhe);

    new Counter();
    new Äpfel();
    Schlange kopf = new Schlange(Spielfeld.breite / 2, (Spielfeld.höhe + 15) / 2, 14, "gruen");
    kopf.bewegen();

  }

}
