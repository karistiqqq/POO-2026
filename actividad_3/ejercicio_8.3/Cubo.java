package Figuras;

public class Cubo extends FiguraGeometrica {

    public float arista;

    public Cubo(float arista) {
        this.arista = arista;
    }

    @Override
    public float calcular_volumen() {
        return arista * arista * arista;
    }

    @Override
    public float calcular_superficie() {
        return 6 * arista * arista;
    }
}
