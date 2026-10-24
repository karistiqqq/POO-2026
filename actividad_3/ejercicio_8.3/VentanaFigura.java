package Figuras;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

// Ventana base: todas las ventanas de figuras heredan de aquí
public class VentanaFigura extends JFrame {

    public VentanaFigura(String titulo, String[] etiquetas,
                         Function<float[], FiguraGeometrica> fabrica) {
        super(titulo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(360, 120 + etiquetas.length * 40);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formulario = new JPanel(new GridLayout(etiquetas.length, 2, 8, 8));
        JTextField[] campos = new JTextField[etiquetas.length];
        for (int i = 0; i < etiquetas.length; i++) {
            formulario.add(new JLabel(etiquetas[i] + ":"));
            campos[i] = new JTextField();
            formulario.add(campos[i]);
        }

        JButton boton = new JButton("Calcular");
        JLabel lblVolumen = new JLabel("Volumen: -");
        JLabel lblSuperficie = new JLabel("Superficie: -");

        JPanel resultados = new JPanel(new GridLayout(3, 1, 5, 5));
        resultados.add(boton);
        resultados.add(lblVolumen);
        resultados.add(lblSuperficie);

        boton.addActionListener(e -> {
            try {
                float[] v = new float[campos.length];
                for (int i = 0; i < campos.length; i++) {
                    v[i] = Float.parseFloat(campos[i].getText().trim().replace(',', '.'));
                }
                FiguraGeometrica f = fabrica.apply(v);
                lblVolumen.setText(String.format("Volumen: %.2f", f.volumen()));
                lblSuperficie.setText(String.format("Superficie: %.2f", f.superficie()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa solo números válidos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(formulario, BorderLayout.NORTH);
        panel.add(resultados, BorderLayout.CENTER);
        add(panel);
    }
}
