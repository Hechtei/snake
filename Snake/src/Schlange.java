import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class Schlange {

    final int SCHRITTDURCHMESSER = 1;
    final int SCHRITTGESCHWINDIGKEIT = 6;
    final int APFELHITBOX = 10;
    int xposition = Spielfeld.breite / 2;
    int yposition = (Spielfeld.höhe + 15) / 2;
    int DURCHMESSER = 14;

    public Schlange() {
        Spielfeld.zf.fuelleKreis(xposition, yposition, DURCHMESSER, "gruen");
        bewegen();
    }

  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

    public void bewegen() {
        while (yposition > 15 && xposition - 15 > 0 && yposition + DURCHMESSER * 2 + 24 < Spielfeld.höhe
                && xposition + DURCHMESSER * 2 < Spielfeld.breite) {

            Spielfeld.zf.fuelleKreis(xposition, yposition, DURCHMESSER, "weiss");

            switch (Spielfeld.zf.richtung) {
                case "rechts":
                    xposition += SCHRITTDURCHMESSER;
                    break;
                case "links":
                    xposition -= SCHRITTDURCHMESSER;
                    break;
                case "hoch":
                    yposition -= SCHRITTDURCHMESSER;
                    break;
                case "runter":
                    yposition += SCHRITTDURCHMESSER;
                    break;
                default:
                    ;
                    break;
            }
            Spielfeld.zf.fuelleKreis(xposition, yposition, DURCHMESSER, "gruen");
            fressenSuchen();
            for (int i = 0; i <= Counter.punktzahl; i++) {
                schlangeErweitern(i);
            }
            sleep(SCHRITTGESCHWINDIGKEIT);

        }
        System.out.println("Du Trottel bist TOT");
        sleep(1000);
        System.exit(0);
    }

    public void fressenSuchen() {
        if (Spielfeld.zf.richtung == Spielfeld.zf.links) {
            if (Äpfel.xposition + Äpfel.DURCHMESSER == xposition && Math.abs(Äpfel.yposition - yposition)
                    < (DURCHMESSER * 2 - Äpfel.DURCHMESSER) + APFELHITBOX) {
                schlangeErweitern(Counter.punktzahl);
                Äpfel.gegessenWerden();
            }

        } else if (Spielfeld.zf.richtung == Spielfeld.zf.rechts) {
            if (Math.abs(Äpfel.xposition - xposition) < (DURCHMESSER * 2)
                    && Math.abs(Äpfel.yposition - yposition)
                    < (DURCHMESSER * 2 - Äpfel.DURCHMESSER) + APFELHITBOX) {
                schlangeErweitern(Counter.punktzahl);
                Äpfel.gegessenWerden();
            }
        } else if (Spielfeld.zf.richtung == Spielfeld.zf.runter) {
            if (Math.abs(Äpfel.xposition - xposition) < (DURCHMESSER * 2)
                    && Math.abs(Äpfel.yposition - yposition) < (DURCHMESSER * 2)) {

                schlangeErweitern(Counter.punktzahl);
                Äpfel.gegessenWerden();
            }
        } else if (Spielfeld.zf.richtung == Spielfeld.zf.hoch) {
            if (Math.abs(Äpfel.yposition - yposition) < Äpfel.DURCHMESSER
                    && Math.abs(Äpfel.xposition - xposition) < (DURCHMESSER * 2)) {
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
                    Spielfeld.zf.fuelleKreis(xposition-DURCHMESSER + xToleranz, yposition+ yToleranz, DURCHMESSER, "weiss");
            case "links" ->
                    Spielfeld.zf.fuelleKreis(xposition+DURCHMESSER + xToleranz, yposition+ yToleranz, DURCHMESSER, "weiss");

            case "hoch" ->
                    Spielfeld.zf.fuelleKreis(xposition + xToleranz, yposition+DURCHMESSER+ yToleranz, DURCHMESSER, "weiss");

            case "runter" ->
                    Spielfeld.zf.fuelleKreis(xposition + xToleranz, yposition-DURCHMESSER+ yToleranz, DURCHMESSER, "weiss");
        }

        Spielfeld.zf.fuelleKreis(xposition + xToleranz, yposition + yToleranz, DURCHMESSER, "gruen");
    }
}











