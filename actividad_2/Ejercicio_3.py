# EJERCICIO 3

from enum import Enum


class ClaseCarburante(Enum):
    GASOLINA = "GASOLINA"
    BIOETANOL = "BIOETANOL"
    DIESEL = "DIESEL"
    BIODIESEL = "BIODIESEL"
    GAS_NATURAL = "GAS_NATURAL"


class CategoriaVehiculo(Enum):
    URBANO = "URBANO"
    SUBCOMPACTO = "SUBCOMPACTO"
    COMPACTO = "COMPACTO"
    FAMILIAR = "FAMILIAR"
    EJECUTIVO = "EJECUTIVO"
    TODO_TERRENO = "TODO_TERRENO"


class TonoPintura(Enum):
    BLANCO = "BLANCO"
    NEGRO = "NEGRO"
    ROJO = "ROJO"
    NARANJA = "NARANJA"
    AMARILLO = "AMARILLO"
    VERDE = "VERDE"
    AZUL = "AZUL"
    VIOLETA = "VIOLETA"


class Vehiculo:
    def __init__(self, fabricante: str, anio: int, cilindraje: int,
                 carburante: ClaseCarburante, categoria: CategoriaVehiculo,
                 puertas: int, plazas: int,
                 velocidad_tope: int, tono: TonoPintura):
        self._fabricante = fabricante
        self._anio = anio
        self._cilindraje = cilindraje
        self._carburante = carburante
        self._categoria = categoria
        self._puertas = puertas
        self._plazas = plazas
        self._velocidad_tope = velocidad_tope
        self._tono = tono
        self._velocidad_actual = 0

    @property
    def fabricante(self):
        return self._fabricante

    @fabricante.setter
    def fabricante(self, fabricante: str):
        self._fabricante = fabricante

    @property
    def anio(self):
        return self._anio

    @anio.setter
    def anio(self, anio: int):
        self._anio = anio

    @property
    def cilindraje(self):
        return self._cilindraje

    @cilindraje.setter
    def cilindraje(self, cilindraje: int):
        self._cilindraje = cilindraje

    @property
    def carburante(self):
        return self._carburante

    @carburante.setter
    def carburante(self, carburante: ClaseCarburante):
        self._carburante = carburante

    @property
    def categoria(self):
        return self._categoria

    @categoria.setter
    def categoria(self, categoria: CategoriaVehiculo):
        self._categoria = categoria

    @property
    def puertas(self):
        return self._puertas

    @puertas.setter
    def puertas(self, puertas: int):
        self._puertas = puertas

    @property
    def plazas(self):
        return self._plazas

    @plazas.setter
    def plazas(self, plazas: int):
        self._plazas = plazas

    @property
    def velocidad_tope(self):
        return self._velocidad_tope

    @velocidad_tope.setter
    def velocidad_tope(self, velocidad_tope: int):
        self._velocidad_tope = velocidad_tope

    @property
    def tono(self):
        return self._tono

    @tono.setter
    def tono(self, tono: TonoPintura):
        self._tono = tono

    @property
    def velocidad_actual(self):
        return self._velocidad_actual

    @velocidad_actual.setter
    def velocidad_actual(self, velocidad_actual: int):
        self._velocidad_actual = velocidad_actual

    def incrementar_velocidad(self, delta_velocidad: int):
        candidata = self._velocidad_actual + delta_velocidad
        if candidata > self._velocidad_tope:
            print("No se puede superar la velocidad máxima.")
            self._velocidad_actual = self._velocidad_tope
        else:
            self._velocidad_actual = candidata

    def reducir_velocidad(self, delta_velocidad: int):
        candidata = self._velocidad_actual - delta_velocidad
        if candidata < 0:
            print("No se puede decrementar a una velocidad negativa.")
        else:
            self._velocidad_actual = candidata

    def detener(self):
        self._velocidad_actual = 0

    def estimar_tiempo_recorrido(self, distancia: float):
        """Tiempo en horas para recorrer 'distancia' (km) a la velocidad actual."""
        if self._velocidad_actual <= 0:
            raise ValueError("El vehículo está detenido; no se puede calcular el tiempo.")
        return distancia / self._velocidad_actual

    def mostrar(self):
        print(f"Marca = {self._fabricante}")
        print(f"Modelo = {self._anio}")
        print(f"Motor = {self._cilindraje}")
        print(f"Tipo de combustible = {self._carburante.name}")
        print(f"Tipo de automóvil = {self._categoria.name}")
        print(f"Número de puertas = {self._puertas}")
        print(f"Cantidad de asientos = {self._plazas}")
        print(f"Velocidad máxima = {self._velocidad_tope}")
        print(f"Color = {self._tono.name}")
        print(f"Velocidad actual = {self._velocidad_actual}")


def ejecutar():
    auto1 = Vehiculo("Ford", 2018, 3, ClaseCarburante.DIESEL,
                     CategoriaVehiculo.EJECUTIVO, 5, 6, 250, TonoPintura.NEGRO)
    auto1.mostrar()
    auto1.incrementar_velocidad(100)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.incrementar_velocidad(20)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.reducir_velocidad(50)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    print(f"Tiempo de llegada para 140 km = {auto1.estimar_tiempo_recorrido(140)} horas")
    auto1.detener()
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.reducir_velocidad(10)


if __name__ == "__main__":
    ejecutar()
