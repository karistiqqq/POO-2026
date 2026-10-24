package Figuras;

public class VentanaCubo extends VentanaFigura {

    public VentanaCubo() {
        super("Cubo", new String[]{"Arista"}, v -> new Cubo(v[0]));
    }
}
