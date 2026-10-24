package Figuras;

public class VentanaCilindro extends VentanaFigura {

    public VentanaCilindro() {
        super("Cilindro", new String[]{"Radio", "Altura"}, v -> new Cilindro(v[0], v[1]));
    }
}
