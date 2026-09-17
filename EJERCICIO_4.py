#EJERCICIO 4
class GrupoFamiliar:
    def __init__(self, edad_juan):
        self.juan = edad_juan
        self._calcular_edades()

    def _calcular_edades(self):
        self.alberto = (2 * self.juan) / 3
        self.ana = (4 * self.juan) / 3
        self.mama = self.juan + self.alberto + self.ana

    def edades(self):
        print(f"La edad de Juan es: {self.juan}")
        print(f"La edad de Alberto es: {self.alberto}")
        print(f"La edad de Ana es: {self.ana}")
        print(f"La edad de la mamá es: {self.mama}")


edad= int(input("Ingrese la edad de Juan: "))
familia = GrupoFamiliar(edad)
familia.edades()
