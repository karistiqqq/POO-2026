package Figuras;

public class Cilindro extends FiguraGeometrica {

    public float radio;
    public float altura;

    public Cilindro(float radio, float altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public float calcular_volumen() {
        return (float) (Math.PI * radio * radio * altura);
    }

    @Override
    public float calcular_superficie() {
        return (float) (2 * Math.PI * radio * (radio + altura));
    }
}
