package prob;

public class Main {

	public static void main(String[] args) {
		Solucion sol = new Solucion();
		sol.mostrarTicket("1 libro a 12,49 €\n" + 
						  "1 CD de música a 14,99 €\n" + 
						  "1 barrita de chocolate a 0,85 €");
		sol.mostrarTicket("1 caja de bombones importados a 10,00 €\n" +
						  "1 frasco de perfume importado a 47,50 €\n");
		sol.mostrarTicket("1 frasco de perfume importado a 27,99 €\n" +
						  "1 frasco de perfume a 18,99 €\n" +
						  "1 caja de pastillas para el dolor de cabeza a 9,75 €\n" +
						  "1 caja de bombones importados a 11,25 €");
	}

}
