#EJERCICIO 5

class Operar:
    def __init__(self):
        self.Sumar = 0
        self.x = 20
        self.y = 0
        self._ejecutar_pasos()

    def _ejecutar_pasos(self):
        
        self.Sumar += self.x
        
        self.y = 40
        self.x = self.x + (self.y ** 2)
    
        self.Sumar += self.x / self.y

    def mostrar_resultado(self):
        print(f"El valor de la suma es: {self.Sumar}")


proceso = Operar()
proceso.mostrar_resultado()
