package Excepciones;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Ventana del ejercicio 2: registro de un agente de ventas con validación de edad.
 */
public class VentanaAgenteVentas extends JFrame {

    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEdad;

    public VentanaAgenteVentas() {
        setTitle("Registro de Vendedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(30, 30, 100, 25);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(140, 30, 200, 25);
        add(campoNombre);

        JLabel etiquetaApellidos = new JLabel("Apellidos:");
        etiquetaApellidos.setBounds(30, 70, 100, 25);
        add(etiquetaApellidos);

        campoApellidos = new JTextField();
        campoApellidos.setBounds(140, 70, 200, 25);
        add(campoApellidos);

        JLabel etiquetaEdad = new JLabel("Edad:");
        etiquetaEdad.setBounds(30, 110, 100, 25);
        add(etiquetaEdad);

        campoEdad = new JTextField();
        campoEdad.setBounds(140, 110, 200, 25);
        add(campoEdad);

        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(140, 160, 120, 30);
        add(botonRegistrar);

        botonRegistrar.addActionListener((ActionEvent evento) -> {
            try {
                String nombreLeido = campoNombre.getText().trim();
                String apellidosLeidos = campoApellidos.getText().trim();

                if (nombreLeido.isEmpty() || apellidosLeidos.isEmpty()) {
                    throw new IllegalArgumentException("El nombre y los apellidos son obligatorios.");
                }

                int edadLeida = Integer.parseInt(campoEdad.getText().trim());

                AgenteVentas agente = new AgenteVentas(nombreLeido, apellidosLeidos);
                agente.validarEdad(edadLeida);

                JOptionPane.showMessageDialog(null,
                        "Vendedor registrado con éxito\nNombre: " + agente.nombreAgente
                                + " " + agente.apellidosAgente
                                + "\nEdad: " + agente.edadAgente,
                        "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Por favor, ingrese un número válido para la edad.",
                        "Error de formato", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error de validación", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaAgenteVentas().setVisible(true);
        });
    }
}
