package Excepciones;

import java.util.*;

/**
 * Clase que permite calcular el logaritmo natural y la raíz cuadrada de un valor.
 */
public class OperacionesNumericas {

    /**
     * Devuelve el logaritmo natural de un número.
     * @throws ArithmeticException si el número es negativo
     */
    static double obtenerLogaritmo(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("El valor debe ser un número positivo");
        }
        return Math.log(numero);
    }

    /**
     * Devuelve la raíz cuadrada de un número.
     * @throws ArithmeticException si el número es negativo
     */
    static double obtenerRaiz(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("El valor debe ser un número positivo");
        }
        return Math.sqrt(numero);
    }

    /**
     * Calcula e imprime el logaritmo natural de un número (versión consola).
     */
    static void logaritmoNatural(double numero) {
        try {
            double salida = obtenerLogaritmo(numero);
            System.out.println("Resultado = " + salida);
        } catch (ArithmeticException ex) {
            System.out.println("El valor debe ser un número positivo para calcular el logaritmo");
        } catch (InputMismatchException ex) {
            System.out.println("El valor debe ser numérico para calcular el logaritmo");
        }
    }

    /**
     * Calcula e imprime la raíz cuadrada de un número (versión consola).
     */
    static void raizCuadrada(double numero) {
        try {
            double salida = obtenerRaiz(numero);
            System.out.println("Resultado = " + salida);
        } catch (ArithmeticException ex) {
            System.out.println("El valor debe ser un número positivo para calcular la raíz cuadrada");
        } catch (InputMismatchException ex) {
            System.out.println("El valor debe ser numérico para calcular la raíz cuadrada");
        }
    }

    /**
     * Pide un valor numérico por teclado y calcula su logaritmo natural y su raíz cuadrada.
     */
    public static void main(String[] args) {
        System.out.print("Valor numérico = ");
        Scanner lector = new Scanner(System.in);
        double datoIngresado = lector.nextDouble();
        logaritmoNatural(datoIngresado);
        raizCuadrada(datoIngresado);
    }
}