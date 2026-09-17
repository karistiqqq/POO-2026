#EJERCICIO 12

class CalculadoraSalario:
    def __init__(self, hrs, tarifa, retencion_pct):
        self.hrs = hrs
        self.tarifa = tarifa
        self.retencion_pct = retencion_pct
        self._calcular_totales()

    def _calcular_totales(self):
        self.bruto = self.hrs * self.tarifa
        self.descuento = self.bruto * (self.retencion_pct / 100)
        self.neto = self.bruto - self.descuento

    def mostrar_resultados(self):
        print(f"Salario Bruto: {self.bruto}")
        print(f"Retención en la fuente: {self.descuento}")
        print(f"Salario Neto: {self.neto}")


#llamo la función
trabajador = CalculadoraSalario(hrs=48, tarifa=5000, retencion_pct=12.5)
trabajador.mostrar_resultados()
