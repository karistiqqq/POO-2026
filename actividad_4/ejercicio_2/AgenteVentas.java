package Excepciones;

import java.util.*;

/**
 * Clase que representa a un agente de ventas con nombre, apellidos y edad.
 */
public class AgenteVentas {

    String nombreAgente;
    String apellidosAgente;
    int edadAgente;

    /**
     * Constructor de la clase.
     * @param nombreAgente    nombre del agente
     * @param apellidosAgente apellidos del agente
     */
    AgenteVentas(String nombreAgente, String apellidosAgente) {
        this.nombreAgente = nombreAgente;
        this.apellidosAgente = apellidosAgente;
    }

    /**
     * Muestra en pantalla los datos del agente.
     */
    void mostrarDatos() {
        System.out.println("Nombre del vendedor = " + nombreAgente);
        System.out.println("Apellidos del vendedor = " + apellidosAgente);
        System.out.println("Edad del vendedor = " + edadAgente);
    }

    /**
     * Valida la edad del agente; si no es válida lanza la excepción correspondiente.
     * @throws IllegalArgumentException si la edad es menor de 18, negativa o mayor a 120
     */
    void validarEdad(int edadIngresada) {
        if (edadIngresada < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        if (edadIngresada >= 0 && edadIngresada < 120) {
            this.edadAgente = edadIngresada;
        } else {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
    }

    /**
     * Solicita por teclado los datos del agente, valida la edad y los imprime.
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Nombre del vendedor = ");
        String nombreLeido = lector.next();

        System.out.println("Apellidos del vendedor = ");
        String apellidosLeidos = lector.next();

        AgenteVentas agente = new AgenteVentas(nombreLeido, apellidosLeidos);

        System.out.println("Edad del vendedor = ");
        int edadLeida = lector.nextInt();

        agente.validarEdad(edadLeida);
        agente.mostrarDatos();
    }
}