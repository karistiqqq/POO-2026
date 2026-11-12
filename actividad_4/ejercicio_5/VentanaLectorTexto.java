package Excepciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Ventana del ejercicio 5: lee un archivo de texto y muestra su contenido.
 */
public class VentanaLectorTexto extends JFrame {

    private JTextField campoRuta;
    private JTextArea areaContenido;

    public VentanaLectorTexto() {
        setTitle("Lector de Archivos de Texto");
        setSize(520, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel etiquetaRuta = new JLabel("Archivo (.txt):");
        etiquetaRuta.setBounds(30, 25, 100, 25);
        add(etiquetaRuta);

        campoRuta = new JTextField("C:/prueba.txt");
        campoRuta.setBounds(130, 25, 250, 25);
        add(campoRuta);

        JButton botonExaminar = new JButton("Examinar");
        botonExaminar.setBounds(390, 25, 95, 25);
        add(botonExaminar);

        JButton botonLeer = new JButton("Leer archivo");
        botonLeer.setBounds(170, 65, 170, 32);
        add(botonLeer);

        areaContenido = new JTextArea();
        areaContenido.setEditable(false);
        JScrollPane panelDesplazable = new JScrollPane(areaContenido);
        panelDesplazable.setBounds(30, 115, 455, 270);
        add(panelDesplazable);

        botonExaminar.addActionListener((ActionEvent evento) -> {
            JFileChooser selector = new JFileChooser();
            if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File elegido = selector.getSelectedFile();
                campoRuta.setText(elegido.getAbsolutePath());
            }
        });

        botonLeer.addActionListener((ActionEvent evento) -> {
            areaContenido.setText("");
            try {
                String contenido = LectorTexto.leerContenido(campoRuta.getText().trim());
                areaContenido.setText(contenido);
            } catch (IOException ex) {
                areaContenido.setText("No se pudo leer el archivo.");
                JOptionPane.showMessageDialog(null, "No se pudo leer el archivo.",
                        "Error de lectura", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaLectorTexto().setVisible(true);
        });
    }
}
