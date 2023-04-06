public class Spielfeld {

  static ZEICHENFENSTER zf;
  static int breite = 700;
  static int höhe = 500;

  public Spielfeld() {
    zf = new ZEICHENFENSTER("Snake!", breite, höhe);
    zf.frame.setBounds(400, 100, breite, höhe);

    new Counter();
    new Äpfel();
    new Schlange();

  }
}
