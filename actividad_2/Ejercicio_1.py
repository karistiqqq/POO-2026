# EJERCICIO 1

class Individuo:
    def __init__(self, pila_nombre: str, apellidos: str, identificacion: str,
                 fecha_nacimiento: int, nacion: str, sexo: str):
        if sexo not in ("H", "M"):
            raise ValueError("El género debe ser 'H' o 'M'.")
        self.pila_nombre = pila_nombre
        self.apellidos = apellidos
        self.identificacion = identificacion
        self.fecha_nacimiento = fecha_nacimiento
        self.nacion = nacion
        self.sexo = sexo

    def mostrar(self):
        print(f"Nombre = {self.pila_nombre}")
        print(f"Apellidos = {self.apellidos}")
        print(f"Número de documento de identidad = {self.identificacion}")
        print(f"Año de nacimiento = {self.fecha_nacimiento}")
        print(f"País de nacimiento = {self.nacion}")
        print(f"Género = {self.sexo}")


def ejecutar():
    p1 = Individuo("Pedro", "Pérez", "1053121010", 1998, "Colombia", "H")
    p2 = Individuo("Luis", "León", "1053223344", 2001, "Colombia", "H")
    p1.mostrar()
    print()
    p2.mostrar()


if __name__ == "__main__":
    ejecutar()
