package Figuras;

public class VentanaPrismaRectangular extends VentanaFigura {

    public VentanaPrismaRectangular() {
        super("Prisma rectangular", new String[]{"Largo", "Ancho", "Altura"}, v -> new PrismaRectangular(v[0], v[1], v[2]));
    }
}
