package Figuras;

public class Esfera extends FiguraGeometrica {

    public float radio;

    public Esfera(float radio) {
        this.radio = radio;
    }

    @Override
    public float calcular_volumen() {
        return (float) (4.0 / 3.0 * Math.PI * radio * radio * radio);
    }

    @Override
    public float calcular_superficie() {
        return (float) (4 * Math.PI * radio * radio);
    }
}
