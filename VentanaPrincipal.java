package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica
 * que permitirá crear un array de notas. Luego, se puede calcular el
 * promedio de notas, la desviación, la nota mayor y la nota menor del
 * array.
 * @version 1.3/2026
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Etiquetas estáticas de cada nota
    private JLabel[] etiquetasNota;
    // Etiquetas de resultados
    private JLabel promedio, desviacion, mayor, menor;
    // Campos de ingreso de cada nota
    private JTextField[] camposNota;
    // Botones para realizar cálculos y para borrar las notas
    private JButton calcular, limpiar;

    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");                 // Establece el título de la ventana
        setSize(280, 380);                 // Establece el tamaño de la ventana
        setLocationRelativeTo(null);       /* La ventana se posiciona en el centro
                                              de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);               /* El tamaño de la ventana no se puede
                                              cambiar */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes
     * gráficos
     */
    private void inicio() {
        contenedor = getContentPane();     /* Obtiene el panel de contenidos */
        contenedor.setLayout(null);        /* El contenedor no tiene un layout */

        etiquetasNota = new JLabel[5];
        camposNota = new JTextField[5];

        // Etiqueta y campo de texto de cada nota
        for (int i = 0; i < 5; i++) {
            etiquetasNota[i] = new JLabel();
            etiquetasNota[i].setText("Nota " + (i + 1) + ":");
            etiquetasNota[i].setBounds(20, 20 + 30 * i, 80, 23);

            camposNota[i] = new JTextField();
            camposNota[i].setBounds(105, 20 + 30 * i, 135, 23);

            contenedor.add(etiquetasNota[i]);
            contenedor.add(camposNota[i]);
        }

        // Establece el botón Calcular
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);  /* Gestiona los eventos del botón */

        // Establece el botón Limpiar
        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);

        // Establece las etiquetas de resultados
        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 200, 23);

        desviacion = new JLabel();
        desviacion.setText("Desviación = ");
        desviacion.setBounds(20, 240, 200, 23);

        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 200, 23);

        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 200, 23);

        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    /**
     * Método que verifica si todos los campos de notas están vacíos
     * @return true si no se ingresó ninguna nota
     */
    private boolean todosVacios() {
        for (int i = 0; i < 5; i++) {
            if (!camposNota[i].getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que muestra un diálogo de error y deja el cursor en el
     * campo con el problema
     * @param mensaje Mensaje que se muestra al usuario
     * @param campo Campo de texto donde se posiciona el cursor
     */
    private void mostrarError(String mensaje, JTextField campo) {
        JOptionPane.showMessageDialog(this, mensaje, "Error",
                JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
        campo.selectAll();
    }

    /**
     * Método que gestiona los eventos generados en la ventana principal
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { /* Si se pulsa el botón Calcular */
            // 1. Si no se ingresó ninguna nota, se muestra un error general
            if (todosVacios()) {
                mostrarError("No se ingresó ninguna nota", camposNota[0]);
                return;
            }

            Notas notas = new Notas();        // Se crea un objeto Notas

            // 2. Se revisa cada nota: vacía o no numérica
            for (int i = 0; i < 5; i++) {
                String texto = camposNota[i].getText().trim();

                if (texto.isEmpty()) {
                    mostrarError("La Nota " + (i + 1) + " está vacía", camposNota[i]);
                    return;
                }

                // Se acepta coma o punto decimal; solo dígitos, signo y un separador
                String normalizado = texto.replace(',', '.');
                if (!normalizado.matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)")) {
                    mostrarError("La Nota " + (i + 1)
                            + " no es un valor numérico: \"" + texto + "\"",
                            camposNota[i]);
                    return;
                }

                notas.listaNotas[i] = Double.parseDouble(normalizado);
            }

            // Se muestran los resultados formateados
            promedio.setText("Promedio = "
                    + String.format("%.2f", notas.calcularPromedio()));
            desviacion.setText("Desviación estándar = "
                    + String.format("%.2f", notas.calcularDesviacion()));
            mayor.setText("Valor mayor = " + notas.calcularMayor());
            menor.setText("Valor menor = " + notas.calcularMenor());
        }

        /* Si se pulsa el botón Limpiar se dejan en blanco los campos de notas */
        if (evento.getSource() == limpiar) {
            for (int i = 0; i < 5; i++) {
                camposNota[i].setText("");
            }
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}
