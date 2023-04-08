public class Schlange {

  final int SCHRITTDURCHMESSER = 1;
  final int SCHRITTGESCHWINDIGKEIT = 6;
  final int APFELHITBOX = 10;
  int xPosition = Spielfeld.breite / 2;
  int yPosition = (Spielfeld.höhe + 15) / 2;
  int durchmesser = 14;
  String farbe = "gruen";

  public Schlange(int xPosition, int yPosition, int durchmesser, String farbe ) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.durchmesser = durchmesser;
    this.farbe = farbe;
    Spielfeld.zf.fuelleKreis(xPosition, yPosition, durchmesser, farbe);

  }

  public int getxPosition() {
    return xPosition;
  }

  public void setxPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  public int getyPosition() {
    return yPosition;
  }

  public void setyPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  public int getDurchmesser() {
    return durchmesser;
  }

  public void setDurchmesser(int durchmesser) {
    this.durchmesser = durchmesser;
  }

  public String getFarbe() {
    return farbe;
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

  public void bewegen() {
    while (yPosition > 15 && xPosition - 15 > 0 && yPosition + durchmesser * 2 + 24 < Spielfeld.höhe
        && xPosition + durchmesser * 2 < Spielfeld.breite) {

      Spielfeld.zf.fuelleKreis(xPosition, yPosition, durchmesser, "weiss");

      switch (Spielfeld.zf.richtung) {
        case "rechts":
          xPosition += SCHRITTDURCHMESSER;
          break;
        case "links":
          xPosition -= SCHRITTDURCHMESSER;
          break;
        case "hoch":
          yPosition -= SCHRITTDURCHMESSER;
          break;
        case "runter":
          yPosition += SCHRITTDURCHMESSER;
          break;
        default:
          ;
          break;
      }
      Spielfeld.zf.fuelleKreis(xPosition, yPosition, durchmesser, "gruen");
      for (int i = 0; i <= Counter.punktzahl; i++) {
        schlangeErweitern(i);
      }
      fressenSuchen();

      sleep(SCHRITTGESCHWINDIGKEIT);

    }
    System.out.println("Du Trottel bist TOT");
    sleep(1000);
    System.exit(0);
  }

  public void fressenSuchen() {
    if (Spielfeld.zf.richtung == Spielfeld.zf.links) {
      if (Äpfel.xpositionApfel + Äpfel.DURCHMESSER == xPosition && Math.abs(Äpfel.ypositionApfel - yPosition)
          < (durchmesser * 2 - Äpfel.DURCHMESSER) + APFELHITBOX) {
        schlangeErweitern(Counter.punktzahl);
        Äpfel.gegessenWerden();
      }

    } else if (Spielfeld.zf.richtung == Spielfeld.zf.rechts) {
      if (Math.abs(Äpfel.xpositionApfel - xPosition) < (durchmesser * 2)
          && Math.abs(Äpfel.ypositionApfel - yPosition)
          < (durchmesser * 2 - Äpfel.DURCHMESSER) + APFELHITBOX) {
        schlangeErweitern(Counter.punktzahl);
        Äpfel.gegessenWerden();
      }
    } else if (Spielfeld.zf.richtung == Spielfeld.zf.runter) {
      if (Math.abs(Äpfel.xpositionApfel - xPosition) < (durchmesser * 2)
          && Math.abs(Äpfel.ypositionApfel - yPosition) < (durchmesser * 2)) {

        schlangeErweitern(Counter.punktzahl);
        Äpfel.gegessenWerden();
      }
    } else if (Spielfeld.zf.richtung == Spielfeld.zf.hoch) {
      if (Math.abs(Äpfel.ypositionApfel - yPosition) < Äpfel.DURCHMESSER
          && Math.abs(Äpfel.xpositionApfel - xPosition) < (durchmesser * 2)) {
        schlangeErweitern(Counter.punktzahl);

        Äpfel.gegessenWerden();

      }
    }
  }

  public void schlangeErweitern(int counter) {

    int xToleranz = 0;
    int yToleranz = 0;
    int spawnReichweite = 20 * counter;

    switch (Spielfeld.zf.richtung) {
      case "rechts" -> xToleranz -= spawnReichweite;
      case "links" -> xToleranz += spawnReichweite;
      case "hoch" -> yToleranz += spawnReichweite;
      case "runter" -> yToleranz -= spawnReichweite;
    }

    switch (Spielfeld.zf.richtung) {
      case "rechts" ->
          Spielfeld.zf.fuelleKreis(xPosition - durchmesser + xToleranz, yPosition + yToleranz,
              durchmesser, "weiss");
      case "links" ->
          Spielfeld.zf.fuelleKreis(xPosition + durchmesser + xToleranz, yPosition + yToleranz,
              durchmesser, "weiss");

      case "hoch" ->
          Spielfeld.zf.fuelleKreis(xPosition + xToleranz, yPosition + durchmesser + yToleranz,
              durchmesser, "weiss");

      case "runter" ->
          Spielfeld.zf.fuelleKreis(xPosition + xToleranz, yPosition - durchmesser + yToleranz,
              durchmesser, "weiss");
    }

    new Schlange(xPosition + xToleranz, yPosition + yToleranz, durchmesser, "gruen");


  }
}











