# EJERCICIO 5

from enum import Enum


class ClaseProducto(Enum):
    AHORROS = "AHORROS"
    CORRIENTE = "CORRIENTE"


class ProductoFinanciero:
    def __init__(self, nombres_propietario: str, apellidos_propietario: str,
                 numero_producto: int, clase_producto: ClaseProducto,
                 tasa_mensual: float = 0.0):
        self.nombres_propietario = nombres_propietario
        self.apellidos_propietario = apellidos_propietario
        self.numero_producto = numero_producto
        self.clase_producto = clase_producto
        self.disponible = 0.0
        self.tasa_mensual = tasa_mensual

    def mostrar(self):
        print(f"Nombres del titular = {self.nombres_propietario}")
        print(f"Apellidos del titular = {self.apellidos_propietario}")
        print(f"Número de cuenta = {self.numero_producto}")
        print(f"Tipo de cuenta = {self.clase_producto.name}")
        print(f"Saldo = {self.disponible}")
        print(f"Interés mensual = {self.tasa_mensual} %")

    def ver_disponible(self):
        print(f"El saldo actual de la cuenta {self.numero_producto} es ${self.disponible}")

    def depositar(self, monto: int):
        if monto <= 0:
            print("El valor a consignar debe ser mayor que cero.")
            return False
        self.disponible += monto
        print(f"Se ha consignado ${monto} en la cuenta. El nuevo saldo es ${self.disponible}")
        return True

    def extraer(self, monto: int):
        if monto <= 0:
            print("El valor a retirar debe ser mayor que cero.")
            return False
        if monto > self.disponible:
            print("Saldo insuficiente para realizar el retiro.")
            return False
        self.disponible -= monto
        print(f"Se ha retirado ${monto} en la cuenta. El nuevo saldo es ${self.disponible}")
        return True

    def comparar_con(self, producto: "ProductoFinanciero"):
        if self.disponible > producto.disponible:
            print(f"La cuenta {self.numero_producto} tiene mayor saldo que la cuenta {producto.numero_producto}.")
        elif self.disponible < producto.disponible:
            print(f"La cuenta {producto.numero_producto} tiene mayor saldo que la cuenta {self.numero_producto}.")
        else:
            print("Ambas cuentas tienen el mismo saldo.")

    def transferir_a(self, producto: "ProductoFinanciero", monto: int):
        if monto <= 0 or monto > self.disponible:
            print("No se pudo realizar la transferencia.")
            return False
        self.disponible -= monto
        producto.disponible += monto
        print(f"Se han transferido ${monto} de la cuenta {self.numero_producto} "
              f"a la cuenta {producto.numero_producto}.")
        return True

    def aplicar_interes(self):
        self.disponible += self.disponible * self.tasa_mensual / 100
        print(f"Se aplicó un interés del {self.tasa_mensual} %. El nuevo saldo es ${self.disponible}")
        return self.disponible


def ejecutar():
    producto = ProductoFinanciero("Pedro", "Pérez", 123456789, ClaseProducto.AHORROS, 1.5)
    producto.mostrar()
    producto.depositar(200000)
    producto.depositar(300000)
    producto.extraer(400000)
    producto.aplicar_interes()

    print()
    otro = ProductoFinanciero("Luis", "León", 987654321, ClaseProducto.CORRIENTE)
    otro.depositar(50000)
    producto.comparar_con(otro)
    producto.transferir_a(otro, 60000)
    producto.ver_disponible()
    otro.ver_disponible()


if __name__ == "__main__":
    ejecutar()
