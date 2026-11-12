package Excepciones;

/**
 * Clase de apoyo: representa a un integrante del equipo de la maratón.
 */
public class Participante {

    String nombrePersona;
    String apellidosPersona;

    /**
     * Constructor de la clase.
     * @param nombrePersona    nombre del participante
     * @param apellidosPersona apellidos del participante
     */
    Participante(String nombrePersona, String apellidosPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
    }
}
