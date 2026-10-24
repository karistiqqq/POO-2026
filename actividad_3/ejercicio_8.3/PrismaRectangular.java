package Figuras;

public class PrismaRectangular extends FiguraGeometrica {

    public float largo;
    public float ancho;
    public float altura;

    public PrismaRectangular(float largo, float ancho, float altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public float calcular_volumen() {
        return largo * ancho * altura;
    }

    @Override
    public float calcular_superficie() {
        return 2 * (largo * ancho + largo * altura + ancho * altura);
    }
}
