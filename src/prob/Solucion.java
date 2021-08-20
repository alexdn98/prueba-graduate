package prob;

import java.text.DecimalFormat;
import java.util.*;

public class Solucion {
	
	private static final double IMPUESTO_BASICO = 10;
	private static final double IMPUESTO_IMPORTACION = 5;
	
	private double totalImpuestos;
	private double totalPrecio;
	
	HashSet<String> setExentos = new HashSet<String>();
	
	public Solucion() {
		setExentos.add("chocolate");
		setExentos.add("bombones");
		setExentos.add("libro");
		setExentos.add("pastillas");
	}
	
	private double precioPostImpuestos(String nombre, double precio) {
		// Se calculan las cantidades antes para no aplicar un impuesto sobre el otro
		double precioOriginal = precio;
		// Calculo de los impuestos redondeando al 0.05
		double cantidadImpuestoBasico = IMPUESTO_BASICO*precio/100;
		cantidadImpuestoBasico = Math.round(cantidadImpuestoBasico * 20) / 20.0;
		double cantidadImpuestoImportacion = IMPUESTO_IMPORTACION*precio/100;
		cantidadImpuestoImportacion = Math.round(cantidadImpuestoImportacion * 20) / 20.0;
		// Comprobar si el impuesto de ventas es aplicable
		boolean impuestoBasico = true;
		for(String productoExento: setExentos) {
			if(nombre.contains(productoExento)) {
				impuestoBasico = false;
			}
		}
		precio += impuestoBasico ? cantidadImpuestoBasico : 0;
		// Comprobar si el impuesto de importación es aplicable
		precio += nombre.contains("import") ? cantidadImpuestoImportacion : 0;
	    totalImpuestos += precio - precioOriginal;
	    totalPrecio += precio;
	    return precio;
	}
	
	public void mostrarTicket(String productos) {
		String[] lineas = productos.split("\n");
		totalImpuestos = 0;
		totalPrecio = 0;
		// Formato: con dos decimales siempre 
		DecimalFormat df = new DecimalFormat("0.00");
		for(String linea: lineas) {
			// Quitar el € final y dividir entre nombre y precio
			String[] producto = linea.substring(0, linea.length() - 2).split(" a ");
			String nombre = producto[0];
			// Cambiar las comas por puntos para obtener el valor
			double precio = Double.parseDouble(producto[1].replace(",", "."));
			String precioImpuestos = "" + df.format(precioPostImpuestos(nombre, precio));
			// Deshacer la conversión al mostrar por pantalla
			System.out.println(nombre + ": " + precioImpuestos.replace(".", ",") + " €");
		}
		String impuestos = "" + df.format(totalImpuestos);
		System.out.println("Impuestos sobre las ventas: " + impuestos.replace(".", ",") + " €");
		String total = "" + df.format(totalPrecio);
		System.out.println("Total: " + total.replace(".",",") + " €");
	}
	
}