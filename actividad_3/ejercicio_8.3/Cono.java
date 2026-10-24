package Figuras;

public class Cono extends FiguraGeometrica {

    public float radio;
    public float altura;
    public float generatriz;

    public Cono(float radio, float altura, float generatriz) {
        this.radio = radio;
        this.altura = altura;
        this.generatriz = generatriz;
    }

    @Override
    public float calcular_volumen() {
        return (float) (Math.PI * radio * radio * altura / 3.0);
    }

    @Override
    public float calcular_superficie() {
        return (float) (Math.PI * radio * (radio + generatriz));
    }
}
