package Excepciones;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Ventana del ejercicio 3: logaritmo natural y raíz cuadrada de un valor.
 */
public class VentanaOperacionesNumericas extends JFrame {

    private JTextField campoNumero;
    private JLabel etiquetaSalida;

    public VentanaOperacionesNumericas() {
        setTitle("Cálculo de Logaritmo Natural y de Raíz Cuadrada");
        setSize(380, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel etiquetaIndicacion = new JLabel("Ingrese un valor numérico:");
        etiquetaIndicacion.setBounds(30, 30, 180, 25);
        add(etiquetaIndicacion);

        campoNumero = new JTextField();
        campoNumero.setBounds(210, 30, 120, 25);
        add(campoNumero);

        JButton botonLogaritmo = new JButton("Calcular Ln(x)");
        botonLogaritmo.setBounds(30, 80, 155, 35);
        add(botonLogaritmo);

        JButton botonRaiz = new JButton("Calcular Raíz");
        botonRaiz.setBounds(205, 80, 155, 35);
        add(botonRaiz);

        etiquetaSalida = new JLabel("Resultado: ");
        etiquetaSalida.setBounds(30, 150, 320, 25);
        add(etiquetaSalida);

        botonLogaritmo.addActionListener((ActionEvent evento) -> realizarCalculo("logaritmo"));
        botonRaiz.addActionListener((ActionEvent evento) -> realizarCalculo("raiz"));
    }

    private void realizarCalculo(String operacion) {
        try {
            String textoIngresado = campoNumero.getText().trim().replace(',', '.');
            if (textoIngresado.isEmpty()) {
                throw new IllegalArgumentException("El campo no puede estar vacío");
            }
            double numero = Double.parseDouble(textoIngresado);

            if (operacion.equals("logaritmo")) {
                double salida = OperacionesNumericas.obtenerLogaritmo(numero);
                etiquetaSalida.setText(String.format("Ln(%.2f) = %.4f", numero, salida));
            } else {
                double salida = OperacionesNumericas.obtenerRaiz(numero);
                etiquetaSalida.setText(String.format("Raíz(%.2f) = %.4f", numero, salida));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException | IllegalArgumentException ex) {
            String mensaje = ex.getMessage();
            JOptionPane.showMessageDialog(null, mensaje,
                    "Error de validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaOperacionesNumericas().setVisible(true);
        });
    }
}