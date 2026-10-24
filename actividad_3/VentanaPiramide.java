package Figuras;

public class VentanaPiramide extends VentanaFigura {

    public VentanaPiramide() {
        super("Pirámide", new String[]{"Base", "Altura", "Apotema"}, v -> new Piramide(v[0], v[1], v[2]));
    }
}
