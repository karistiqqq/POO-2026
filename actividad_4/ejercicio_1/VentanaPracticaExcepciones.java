package Excepciones;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Ventana del ejercicio 1: muestra en pantalla la secuencia de try/catch/finally.
 */
public class VentanaPracticaExcepciones extends JFrame {

    private JTextArea areaSalida;

    public VentanaPracticaExcepciones() {
        setTitle("Práctica de Excepciones con Interfaz Gráfica");
        setSize(480, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel etiquetaTitulo = new JLabel("Ejecución de la secuencia de excepciones");
        etiquetaTitulo.setBounds(30, 20, 400, 25);
        add(etiquetaTitulo);

        JButton botonEjecutar = new JButton("Ejecutar secuencia");
        botonEjecutar.setBounds(140, 60, 180, 35);
        add(botonEjecutar);

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane panelDesplazable = new JScrollPane(areaSalida);
        panelDesplazable.setBounds(30, 115, 410, 240);
        add(panelDesplazable);

        botonEjecutar.addActionListener((ActionEvent evento) -> {
            areaSalida.setText("");

            // Primer bloque try: división entera por cero
            try {
                areaSalida.append("Ingresando al primer try\n");
                double resultadoDivision = 10000 / 0; // Lanza ArithmeticException
                areaSalida.append("Después de la división\n"); // Nunca se ejecuta
            } catch (ArithmeticException ex) {
                areaSalida.append("División por cero\n");
            } finally {
                areaSalida.append("Ingresando al primer finally\n");
            }

            // Segundo bloque try: referencia nula
            try {
                areaSalida.append("Ingresando al segundo try\n");
                Object elemento = null;
                elemento.toString(); // Lanza NullPointerException
                areaSalida.append("Imprimiendo objeto\n"); // Nunca se ejecuta
            } catch (ArithmeticException ex) {
                areaSalida.append("División por cero\n");
            } catch (Exception ex) {
                areaSalida.append("Ocurrió una excepción\n");
            } finally {
                areaSalida.append("Ingresando al segundo finally\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPracticaExcepciones().setVisible(true);
        });
    }
}
