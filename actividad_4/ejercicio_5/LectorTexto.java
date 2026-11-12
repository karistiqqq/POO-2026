package Excepciones;

import java.io.*;

/**
 * Clase que lee los datos de un archivo de texto (.txt) y los muestra en pantalla.
 */
public class LectorTexto {

    /**
     * Lee todo el archivo y devuelve su contenido como texto.
     * @throws IOException si no se puede leer el archivo
     */
    static String leerContenido(String rutaArchivo) throws IOException {
        StringBuilder acumulado = new StringBuilder();
        FileInputStream flujoEntrada = new FileInputStream(rutaArchivo);
        InputStreamReader lectorFlujo = new InputStreamReader(flujoEntrada);
        BufferedReader bufferLectura = new BufferedReader(lectorFlujo);

        String renglon = bufferLectura.readLine();
        while (renglon != null) {
            acumulado.append(renglon).append("\n");
            renglon = bufferLectura.readLine();
        }
        bufferLectura.close(); // Cierra el archivo
        return acumulado.toString();
    }

    /**
     * Lee un archivo de texto línea por línea y lo imprime en pantalla (versión consola).
     */
    public static void main(String[] args) throws Exception {
        String rutaArchivo = "C:/Users/Usser/Desktop/ProyectoPOO4/Excepciones/texto.txt"; // Archivo de texto a leer

        FileInputStream flujoEntrada;
        InputStreamReader lectorFlujo;
        BufferedReader bufferLectura;
        String renglon;

        try {
            flujoEntrada = new FileInputStream(rutaArchivo);
            lectorFlujo = new InputStreamReader(flujoEntrada);
            bufferLectura = new BufferedReader(lectorFlujo);

            renglon = bufferLectura.readLine();
            while (renglon != null) {
                System.out.println(renglon);
                renglon = bufferLectura.readLine();
            }
            bufferLectura.close();
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
