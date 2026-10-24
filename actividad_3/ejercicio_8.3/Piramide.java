package Figuras;

public class Piramide extends FiguraGeometrica {

    public float base;      // lado de la base cuadrada
    public float altura;
    public float apotema;

    public Piramide(float base, float altura, float apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    @Override
    public float calcular_volumen() {
        return base * base * altura / 3;
    }

    @Override
    public float calcular_superficie() {
        return base * base + 2 * base * apotema;
    }
}
