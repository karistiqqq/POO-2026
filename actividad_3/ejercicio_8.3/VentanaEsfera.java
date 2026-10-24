package Figuras;

public class VentanaEsfera extends VentanaFigura {

    public VentanaEsfera() {
        super("Esfera", new String[]{"Radio"}, v -> new Esfera(v[0]));
    }
}
