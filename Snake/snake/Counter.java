
public class Counter {

	static int punktzahl = -1;
	static ZEICHENFENSTER zf2;
	
	 public Counter() {
	
		zf2 = new ZEICHENFENSTER ("Punktzahl",200,50);
		zf2.zeichneText("Deine Punktzahl du hund: " + punktzahl, 20, 20);
	}
	
	
	static public void punktZahlErhöhen() {
		punktzahl ++; 	
		zf2.fuelleRechteck(0, 0, 200, 50, "weiss");
		zf2.zeichneText("Deine Punktzahl du hund: " + punktzahl, 20, 20);
		
	}
}
