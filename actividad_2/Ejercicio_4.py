# EJERCICIO 4

import math


class Circunferencia:
    def __init__(self, radio: int):
        self.radio = radio

    def obtener_area(self):
        return math.pi * self.radio ** 2

    def obtener_perimetro(self):
        return 2 * math.pi * self.radio


class Cuadrilatero:
    def __init__(self, lado: int):
        self.lado = lado

    def obtener_area(self):
        return float(self.lado ** 2)

    def obtener_perimetro(self):
        return float(4 * self.lado)


class Rectangulo:
    def __init__(self, ancho: int, alto: int):
        self.ancho = ancho
        self.alto = alto

    def obtener_area(self):
        return float(self.ancho * self.alto)

    def obtener_perimetro(self):
        return float(2 * (self.ancho + self.alto))


class TrianguloRecto:
    def __init__(self, cateto_a: int, cateto_b: int):
        self.cateto_a = cateto_a
        self.cateto_b = cateto_b

    def obtener_area(self):
        return self.cateto_a * self.cateto_b / 2

    def obtener_hipotenusa(self):
        return math.hypot(self.cateto_a, self.cateto_b)

    def obtener_perimetro(self):
        return self.cateto_a + self.cateto_b + self.obtener_hipotenusa()

    def clasificar_triangulo(self):
        h = self.obtener_hipotenusa()
        lados = [self.cateto_a, self.cateto_b, h]
        iguales = len({round(l, 9) for l in lados})
        if iguales == 1:
            print("Es un triángulo equilátero")
        elif iguales == 2:
            print("Es un triángulo isósceles")
        else:
            print("Es un triángulo escaleno")


class Rombo:
    def __init__(self, diagonal_mayor: int, diagonal_menor: int):
        self.diagonal_mayor = diagonal_mayor
        self.diagonal_menor = diagonal_menor

    def obtener_lado(self):
        return math.hypot(self.diagonal_mayor / 2, self.diagonal_menor / 2)

    def obtener_area(self):
        return self.diagonal_mayor * self.diagonal_menor / 2

    def obtener_perimetro(self):
        return 4 * self.obtener_lado()


class Trapecio:
    def __init__(self, base_mayor: int, base_menor: int, altura: int,
                 lado_izquierdo: int, lado_derecho: int):
        self.base_mayor = base_mayor
        self.base_menor = base_menor
        self.altura = altura
        self.lado_izquierdo = lado_izquierdo
        self.lado_derecho = lado_derecho

    def obtener_area(self):
        return (self.base_mayor + self.base_menor) * self.altura / 2

    def obtener_perimetro(self):
        return float(self.base_mayor + self.base_menor
                     + self.lado_izquierdo + self.lado_derecho)


class DemostracionFiguras:
    @staticmethod
    def ejecutar():
        figura1 = Circunferencia(2)
        figura2 = Rectangulo(1, 2)
        figura3 = Cuadrilatero(3)
        figura4 = TrianguloRecto(3, 5)
        figura5 = Rombo(8, 6)
        figura6 = Trapecio(10, 6, 4, 5, 5)

        print(f"El área del círculo es = {figura1.obtener_area()}")
        print(f"El perímetro del círculo es = {figura1.obtener_perimetro()}")
        print()
        print(f"El área del rectángulo es = {figura2.obtener_area()}")
        print(f"El perímetro del rectángulo es = {figura2.obtener_perimetro()}")
        print()
        print(f"El área del cuadrado es = {figura3.obtener_area()}")
        print(f"El perímetro del cuadrado es = {figura3.obtener_perimetro()}")
        print()
        print(f"El área del triángulo es = {figura4.obtener_area()}")
        print(f"El perímetro del triángulo es = {figura4.obtener_perimetro()}")
        figura4.clasificar_triangulo()
        print()
        print(f"El área del rombo es = {figura5.obtener_area()}")
        print(f"El perímetro del rombo es = {figura5.obtener_perimetro()}")
        print()
        print(f"El área del trapecio es = {figura6.obtener_area()}")
        print(f"El perímetro del trapecio es = {figura6.obtener_perimetro()}")


if __name__ == "__main__":
    DemostracionFiguras.ejecutar()
