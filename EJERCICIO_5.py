#EJERCICIO 5

class Operar:
    def __init__(self):
        self.Sumar = 0
        self.x = 20
        self.y = 0
        self._ejecutar_pasos()

    def _ejecutar_pasos(self):
        # Paso 1: acumular el valor inicial de X
        self.Suman += self.x
        # Paso 2: asignar Y y recalcular X
        self.y = 40
        self.x = self.x + (self.y ** 2)
        # Paso 3: acumular la división de X entre Y
        self.Sumar += self.x / self.y

    def mostrar_resultado(self):
        print(f"El valor de la suma es: {self.acumulador}")


# Bloque principal
proceso = Operar()
proceso.mostrar_resultado()
