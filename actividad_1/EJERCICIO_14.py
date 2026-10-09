#EJERCICIO 14

class CalculadoraPotencias:
    def __init__(self, valor):
        self.valor = valor
        self._obtener_potencias()

    def _obtener_potencias(self):
        self.al_cuadrado = self.valor ** 2
        self.al_cubo = self.valor ** 3

    def mostrar_resultados(self):
        print(f"El número ingresado es: {self.valor}")
        print(f"Su cuadrado es: {self.al_cuadrado}")
        print(f"Su cubo es: {self.al_cubo}")

#llamar función
dato_ingreso = float(input("Ingrese un número: "))
calc = CalculadoraPotencias(valor=dato_ingreso)
calc.mostrar_resultados()
