# EJERCICIO 2


from enum import Enum

class CategoriaCuerpo(Enum):
    GASEOSO = "GASEOSO"
    ROCOSO = "ROCOSO"
    ENANO = "ENANO"


class CuerpoCeleste:
    # 1 UA = 149 597 870 km. Se considera lejano un cuerpo más allá de 3,4 UA.
    DISTANCIA_UA_KM = 149_597_870
    UMBRAL_LEJANO_UA = 3.4

    def __init__(self, denominacion: str, num_lunas: int, masa: float,
                 volumen: float, diametro: int, distancia_estrella: int,
                 categoria: CategoriaCuerpo, es_visible: bool,
                 periodo_traslacion: float, periodo_giro: float):
        self.denominacion = denominacion
        self.num_lunas = num_lunas
        self.masa = masa                              # kg
        self.volumen = volumen                        # km^3
        self.diametro = diametro                      # km
        self.distancia_estrella = distancia_estrella  # km
        self.categoria = categoria
        self.es_visible = es_visible
        self.periodo_traslacion = periodo_traslacion  # años
        self.periodo_giro = periodo_giro              # días

    def mostrar(self):
        print(f"Denominación del cuerpo = {self.denominacion}")
        print(f"Cantidad de lunas = {self.num_lunas}")
        print(f"Masa del cuerpo = {self.masa}")
        print(f"Volumen del cuerpo = {self.volumen}")
        print(f"Diámetro del cuerpo = {self.diametro}")
        print(f"Distancia a la estrella = {self.distancia_estrella}")
        print(f"Categoría del cuerpo = {self.categoria.name}")
        print(f"Es visible = {str(self.es_visible).lower()}")
        print(f"Periodo de traslación (años) = {self.periodo_traslacion}")
        print(f"Periodo de giro (días) = {self.periodo_giro}")
        print(f"Densidad del cuerpo = {self.obtener_densidad()}")
        print(f"Es cuerpo lejano = {str(self.es_cuerpo_lejano()).lower()}")

    def obtener_densidad(self):
        return self.masa / self.volumen

    def es_cuerpo_lejano(self):
        umbral = self.UMBRAL_LEJANO_UA * self.DISTANCIA_UA_KM
        return self.distancia_estrella > umbral


def ejecutar():
    tierra = CuerpoCeleste("Tierra", 1, 5.9736e24, 1.08321e12, 12742, 150000000,
                           CategoriaCuerpo.ROCOSO, True, 1.0, 1.0)
    jupiter = CuerpoCeleste("Júpiter", 79, 1.899e27, 1.4313e15, 139820, 750000000,
                            CategoriaCuerpo.GASEOSO, True, 11.86, 0.41)
    tierra.mostrar()
    print()
    jupiter.mostrar()


if __name__ == "__main__":
    ejecutar()
