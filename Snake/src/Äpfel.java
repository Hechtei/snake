import java.util.Random;

public class Äpfel {

  final static int DURCHMESSER = 20;
  static int xpositionApfel;
  static int ypositionApfel;

  public Äpfel() {
    spawn();
  }

  public void spawn() {
    Random zufally = new Random();
    int zufallsZahly = zufally.nextInt(Spielfeld.höhe - DURCHMESSER);
    ypositionApfel = zufallsZahly;
    Random zufallx = new Random();
    int zufallsZahlx = zufallx.nextInt(Spielfeld.breite - DURCHMESSER + 15);
    xpositionApfel = zufallsZahlx;
    Spielfeld.zf.fuelleKreis(zufallsZahlx, zufallsZahly, 10, "rot");
  }

  public  static void gegessenWerden() {

    Counter.punktZahlErhöhen();
    Spielfeld.zf.fuelleKreis(xpositionApfel, ypositionApfel, DURCHMESSER, "weiss");
    Äpfel äpfel = new Äpfel();





  }
}

