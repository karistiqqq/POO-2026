package Figuras;

public abstract class FiguraGeometrica {

    protected float _volumen;
    protected float _superficie;

    public float volumen() {
        _volumen = calcular_volumen();
        return _volumen;
    }

    public float superficie() {
        _superficie = calcular_superficie();
        return _superficie;
    }

    public abstract float calcular_volumen();

    public abstract float calcular_superficie();
}
