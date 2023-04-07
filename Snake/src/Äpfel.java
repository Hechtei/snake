import java.util.Random;

public class Äpfel {

  final static int DURCHMESSER = 20;
  static int xposition;
  static int yposition;

  public Äpfel() {
    spawn();
  }

  public static void spawn() {

    Counter.punktZahlErhöhen();
    Random zufally = new Random();
    int zufallsZahly = zufally.nextInt(Spielfeld.höhe - DURCHMESSER);
    yposition = zufallsZahly;
    Random zufallx = new Random();
    int zufallsZahlx = zufallx.nextInt(Spielfeld.breite - DURCHMESSER + 15);
    xposition = zufallsZahlx;
    Spielfeld.zf.fuelleKreis(zufallsZahlx, zufallsZahly, 10, "rot");
  }

  public static void gegessenWerden() {

    Spielfeld.zf.fuelleKreis(xposition, yposition, DURCHMESSER, "weiss");
    spawn();

  }
}
