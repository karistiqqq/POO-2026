package Excepciones;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Ventana del ejercicio 4: registro de un equipo de maratón de programación
 * y de sus tres integrantes.
 */
public class VentanaEquipoConcursoCodigo extends JFrame {

    private JTextField campoGrupo, campoInstitucion, campoLenguaje;
    private JTextField campoNombrePersona, campoApellidosPersona;
    private JButton botonCrear, botonAgregar;
    private JTextArea areaSalida;

    private EquipoConcursoCodigo equipo;

    public VentanaEquipoConcursoCodigo() {
        setTitle("Registro de Maratón de Programación");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titulo1 = new JLabel("Datos del Equipo");
        titulo1.setBounds(30, 15, 200, 25);
        add(titulo1);

        JLabel etiqueta1 = new JLabel("Nombre del equipo:");
        etiqueta1.setBounds(30, 45, 130, 25);
        add(etiqueta1);
        campoGrupo = new JTextField();
        campoGrupo.setBounds(170, 45, 270, 25);
        add(campoGrupo);

        JLabel etiqueta2 = new JLabel("Universidad:");
        etiqueta2.setBounds(30, 75, 130, 25);
        add(etiqueta2);
        campoInstitucion = new JTextField();
        campoInstitucion.setBounds(170, 75, 270, 25);
        add(campoInstitucion);

        JLabel etiqueta3 = new JLabel("Lenguaje:");
        etiqueta3.setBounds(30, 105, 130, 25);
        add(etiqueta3);
        campoLenguaje = new JTextField();
        campoLenguaje.setBounds(170, 105, 270, 25);
        add(campoLenguaje);

        botonCrear = new JButton("Crear equipo");
        botonCrear.setBounds(170, 140, 270, 28);
        add(botonCrear);

        JLabel titulo2 = new JLabel("Registrar integrantes");
        titulo2.setBounds(30, 180, 200, 25);
        add(titulo2);

        JLabel etiqueta4 = new JLabel("Nombre del integrante:");
        etiqueta4.setBounds(30, 210, 140, 25);
        add(etiqueta4);
        campoNombrePersona = new JTextField();
        campoNombrePersona.setBounds(170, 210, 270, 25);
        campoNombrePersona.setEnabled(false); // Se activa al crear el equipo
        add(campoNombrePersona);

        JLabel etiqueta5 = new JLabel("Apellidos del integrante:");
        etiqueta5.setBounds(30, 240, 140, 25);
        add(etiqueta5);
        campoApellidosPersona = new JTextField();
        campoApellidosPersona.setBounds(170, 240, 270, 25);
        campoApellidosPersona.setEnabled(false);
        add(campoApellidosPersona);

        botonAgregar = new JButton("Agregar integrante");
        botonAgregar.setBounds(170, 275, 270, 30);
        botonAgregar.setEnabled(false);
        add(botonAgregar);

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane panelDesplazable = new JScrollPane(areaSalida);
        panelDesplazable.setBounds(30, 320, 410, 130);
        add(panelDesplazable);

        // Crear el equipo
        botonCrear.addActionListener((ActionEvent evento) -> {
            try {
                String datoGrupo = campoGrupo.getText().trim();
                String datoInstitucion = campoInstitucion.getText().trim();
                String datoLenguaje = campoLenguaje.getText().trim();

                if (datoGrupo.isEmpty() || datoInstitucion.isEmpty() || datoLenguaje.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos del equipo son obligatorios.");
                }

                equipo = new EquipoConcursoCodigo(datoGrupo, datoInstitucion, datoLenguaje);

                areaSalida.append("¡Equipo '" + datoGrupo + "' creado con éxito!\n");
                areaSalida.append("Capacidad: " + equipo.integrantes.length
                        + " integrantes. Ingrese los programadores.\n\n");

                campoGrupo.setEnabled(false);
                campoInstitucion.setEnabled(false);
                campoLenguaje.setEnabled(false);
                botonCrear.setEnabled(false);

                campoNombrePersona.setEnabled(true);
                campoApellidosPersona.setEnabled(true);
                botonAgregar.setEnabled(true);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error de validación", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Agregar integrantes
        botonAgregar.addActionListener((ActionEvent evento) -> {
            try {
                String nombreLeido = campoNombrePersona.getText().trim();
                String apellidosLeidos = campoApellidosPersona.getText().trim();

                if (nombreLeido.isEmpty() || apellidosLeidos.isEmpty()) {
                    throw new IllegalArgumentException("El nombre y los apellidos son obligatorios.");
                }

                EquipoConcursoCodigo.verificarTexto(nombreLeido);
                EquipoConcursoCodigo.verificarTexto(apellidosLeidos);

                Participante persona = new Participante(nombreLeido, apellidosLeidos);
                equipo.agregarIntegrante(persona);

                areaSalida.append("-> Integrante agregado: " + persona.nombrePersona + " "
                        + persona.apellidosPersona + " (" + equipo.cantidadIntegrantes
                        + "/" + equipo.integrantes.length + ")\n");

                campoNombrePersona.setText("");
                campoApellidosPersona.setText("");

                if (equipo.estaCompleto()) {
                    areaSalida.append("\n¡EQUIPO COMPLETO, LISTO PARA LA MARATÓN!\n");
                    campoNombrePersona.setEnabled(false);
                    campoApellidosPersona.setEnabled(false);
                    botonAgregar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Equipo completo y registrado",
                            "Registro completo", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error de validación", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaEquipoConcursoCodigo().setVisible(true);
        });
    }
}
