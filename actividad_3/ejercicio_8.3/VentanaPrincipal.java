package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private final JButton btnCilindro = new JButton("Cilindro");
    private final JButton btnCono = new JButton("Cono");
    private final JButton btnEsfera = new JButton("Esfera");
    private final JButton btnPiramide = new JButton("Pirámide");
    private final JButton btnCubo = new JButton("Cubo");
    private final JButton btnPrisma = new JButton("Prisma rectangular");

    public VentanaPrincipal() {
        super("Figuras geométricas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 360);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton[] botones = {btnCilindro, btnCono, btnEsfera, btnPiramide, btnCubo, btnPrisma};
        for (JButton b : botones) {
            b.addActionListener(this);
            panel.add(b);
        }
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == btnCilindro) {
            new VentanaCilindro().setVisible(true);
        } else if (o == btnCono) {
            new VentanaCono().setVisible(true);
        } else if (o == btnEsfera) {
            new VentanaEsfera().setVisible(true);
        } else if (o == btnPiramide) {
            new VentanaPiramide().setVisible(true);
        } else if (o == btnCubo) {
            new VentanaCubo().setVisible(true);
        } else if (o == btnPrisma) {
            new VentanaPrismaRectangular().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
