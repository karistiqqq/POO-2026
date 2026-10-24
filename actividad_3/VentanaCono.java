package Figuras;

public class VentanaCono extends VentanaFigura {

    public VentanaCono() {
        super("Cono", new String[]{"Radio", "Altura", "Generatriz"}, v -> new Cono(v[0], v[1], v[2]));
    }
}
