public class Spielfeld {

  static ZEICHENFENSTER zf;
  static int breite = 700;
  static int höhe = 500;

  public Spielfeld() {
    zf = new ZEICHENFENSTER("Snake !           Deine Punktzahl: ", breite, höhe);
    zf.frame.setBounds(400, 100, breite, höhe);

    new Counter();
    new Äpfel();
    Schlange kopf = new Schlange(Spielfeld.breite / 2, (Spielfeld.höhe + 15) / 2, 14, "gruen");
    kopf.bewegen();

  }
}
