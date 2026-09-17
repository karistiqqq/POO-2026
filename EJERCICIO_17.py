#EJERCICIO 17

import math


class CalculadoraCirculo:
    def __init__(self, r):
        self.r = r
        self._calcular_medidas()

    def _calcular_medidas(self):
        self.superficie = math.pi * (self.r ** 2)
        self.perimetro = 2 * math.pi * self.r

    def imprimir_resultados(self):
        print(f"El radio ingresado es: {self.r}")
        print(f"El área del círculo es: {self.superficie}")
        print(f"La longitud de la circunferencia es: {self.perimetro}")



dato = float(input("Ingrese el radio del círculo: "))
circ = CalculadoraCirculo(r=dato)
circ.imprimir_resultados()
