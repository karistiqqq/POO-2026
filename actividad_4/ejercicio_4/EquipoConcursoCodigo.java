package Excepciones;

import java.util.*;

/**
 * Clase que modela un equipo de programadores que participa en una maratón de
 * programación. Un equipo tiene nombre, universidad, lenguaje de programación,
 * cantidad de integrantes y un arreglo con sus participantes.
 */
public class EquipoConcursoCodigo {

    String nombreGrupo;          // Nombre del equipo
    String institucion;          // Universidad a la que pertenece
    String lenguajeUsado;        // Lenguaje de programación del equipo
    Participante[] integrantes;  // Participantes del equipo
    int cantidadIntegrantes;     // Cantidad de integrantes registrados

    /**
     * Constructor de la clase.
     * @param nombreGrupo   nombre del equipo
     * @param institucion   universidad a la que pertenece
     * @param lenguajeUsado lenguaje de programación que usará el equipo
     */
    EquipoConcursoCodigo(String nombreGrupo, String institucion, String lenguajeUsado) {
        this.nombreGrupo = nombreGrupo;
        this.institucion = institucion;
        this.lenguajeUsado = lenguajeUsado;
        cantidadIntegrantes = 0;               // Al inicio no hay integrantes
        integrantes = new Participante[3];     // Arreglo con espacio para tres
    }

    /**
     * Indica si el arreglo de integrantes ya está lleno.
     * @return true si el equipo está completo, false en caso contrario
     */
    boolean estaCompleto() {
        return cantidadIntegrantes == integrantes.length;
    }

    /**
     * Agrega un participante al equipo.
     * @param nuevo participante a agregar
     * @throws Exception si el equipo ya está completo
     */
    void agregarIntegrante(Participante nuevo) throws Exception {
        if (estaCompleto()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        integrantes[cantidadIntegrantes] = nuevo;
        cantidadIntegrantes++;
    }

    /**
     * Valida que un texto no tenga dígitos y que no supere los 20 caracteres.
     * @param texto texto a validar
     * @throws Exception si contiene dígitos o su longitud es mayor a 20
     */
    static void verificarTexto(String texto) throws Exception {
        for (int pos = 0; pos < texto.length(); pos++) {
            char caracter = texto.charAt(pos);
            if (Character.isDigit(caracter)) {
                throw new Exception("El nombre no puede tener dígitos.");
            }
        }
        if (texto.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    /**
     * Solicita por teclado los datos del equipo, lo crea y luego pide los datos
     * de tres integrantes, validando cada campo.
     */
    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(System.in);

        System.out.println("Nombre del equipo = ");
        String datoEquipo = lector.next();
        System.out.println("Universidad = ");
        String datoUniversidad = lector.next();
        System.out.println("Lenguaje de programación = ");
        String datoLenguaje = lector.next();

        EquipoConcursoCodigo equipo =
                new EquipoConcursoCodigo(datoEquipo, datoUniversidad, datoLenguaje);

        System.out.println("Datos de los integrantes del equipo");
        String nombreLeido;
        String apellidosLeidos;

        for (int i = 0; i < 3; i++) {
            System.out.println("Nombre del integrante = ");
            nombreLeido = lector.next();
            verificarTexto(nombreLeido);   // Valida el nombre

            System.out.println("Apellidos del integrante = ");
            apellidosLeidos = lector.next();
            verificarTexto(apellidosLeidos); // Valida los apellidos

            Participante persona = new Participante(nombreLeido, apellidosLeidos);
            equipo.agregarIntegrante(persona);
        }
    }
}
