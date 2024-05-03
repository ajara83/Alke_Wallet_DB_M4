Proyecto de Alberto Jara para el entregable del Modulos 04 "Fundamentos de programación en Java"
La documentación de las clases está en el subdirectorio "doc" del mismo proyecto

Para el proyecto se considero entregar 2 clases al cliente, y utilizar el RUT como llave para las operaciones.

La pruebas se encuentran en el subdirectorio "test" utilizando la herramienta JUnit.

El diagrama de clases propuesto es el siguiente:

-----------------------------------
|             Cliente             |
-----------------------------------
| - RUT: String                   |
| - nombre: String                |
| - apellido: String              |
| - cuentaPesos: CuentaPesos     |
| - cuentaDolares: CuentaDolar   |
-----------------------------------
| + Cliente(RUT: String,         |
|            nombre: String,      |
|            apellido: String,    |
|            cuentaPesos: CuentaPesos, |
|            cuentaDolares: CuentaDolar) |
| + getRUT(): String              |
| + setRUT(RUT: String): void     |
| + getNombre(): String           |
| + setNombre(nombre: String): void |
| + getApellido(): String         |
| + setApellido(apellido: String): void |
| + getCuentaPesos(): CuentaPesos |
| + setCuentaPesos(cuentaPesos: CuentaPesos): void |
| + getCuentaDolares(): CuentaDolar |
| + setCuentaDolares(cuentaDolares: CuentaDolar): void |
-----------------------------------

-----------------------------------
|             Cuenta              |
-----------------------------------
| - saldo: double                 |
-----------------------------------
| + Cuenta(saldo: double)         |
| + abonar(monto: double): void   |
| + cargar(monto: double): void   |
| + verSaldo(): double            |
-----------------------------------

-----------------------------------
|          CuentaPesos            |
-----------------------------------
| <<extends>>                      |
|          - saldo: double        |
-----------------------------------
| + CuentaPesos(saldo: double)    |
-----------------------------------

-----------------------------------
|          CuentaDolar            |
-----------------------------------
| <<extends>>                      |
|          - saldo: double        |
-----------------------------------
| + CuentaDolar(saldo: double)    |
-----------------------------------
