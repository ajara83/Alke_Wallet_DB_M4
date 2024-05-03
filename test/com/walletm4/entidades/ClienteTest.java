package com.walletm4.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        CuentaPesos cuentaPesos = new CuentaPesos(1000);
        CuentaDolar cuentaDolares = new CuentaDolar(500);
        Cliente cliente = new Cliente("123456789", "Juan", "Perez", cuentaPesos, cuentaDolares);

        // Act
        String nuevoRUT = "98765432-1";
        cliente.setRUT(nuevoRUT);
        String nuevoNombre = "Pedro";
        cliente.setNombre(nuevoNombre);
        String nuevoApellido = "Gonzalez";
        cliente.setApellido(nuevoApellido);
        CuentaPesos nuevaCuentaPesos = new CuentaPesos(2000);
        cliente.setCuentaPesos(nuevaCuentaPesos);
        CuentaDolar nuevaCuentaDolares = new CuentaDolar(1000);
        cliente.setCuentaDolares(nuevaCuentaDolares);

        // Assert
        assertEquals(nuevoRUT, cliente.getRUT());
        assertEquals(nuevoNombre, cliente.getNombre());
        assertEquals(nuevoApellido, cliente.getApellido());
        assertEquals(nuevaCuentaPesos, cliente.getCuentaPesos());
        assertEquals(nuevaCuentaDolares, cliente.getCuentaDolares());
        
        cliente = null;
    }
    
    @Test
    public void testTraspasarPesosADolares() {
        // Arrange
        double valorDolar = 900; // Suponiendo que 1 dólar equivale a 900 pesos
        CuentaPesos cuentaPesos = new CuentaPesos(1800);
        CuentaDolar cuentaDolares = new CuentaDolar(2);
        Cliente cliente = new Cliente("12345678-9", "Juan", "Perez", cuentaPesos, cuentaDolares);

        // Act
        cliente.traspasarPesosADolares(valorDolar, 900);
        
        System.out.println("Saldo pesos:"+cuentaPesos.verSaldo());
        System.out.println("Saldo dolares:"+cuentaDolares.verSaldo());

        // Assert
        assertEquals(900, cuentaPesos.verSaldo(), 0);
        assertEquals(3, cuentaDolares.verSaldo(), 0); // 500 / 900 ≈ 0.5555
    }

    @Test
    public void testTraspasarDolaresAPesos() {
        // Arrange
        double valorDolar = 900; // Suponiendo que 1 dólar equivale a 900 pesos
        CuentaPesos cuentaPesos = new CuentaPesos(0);
        CuentaDolar cuentaDolares = new CuentaDolar(100);
        Cliente cliente = new Cliente("12345678-9", "Juan", "Perez", cuentaPesos, cuentaDolares);

        // Act
        cliente.traspasarDolaresAPesos(valorDolar, 50);
        System.out.println("Saldo pesos:"+cuentaPesos.verSaldo());
        System.out.println("Saldo dolares:"+cuentaDolares.verSaldo());
        

        // Assert
        assertEquals(45000, cuentaPesos.verSaldo(), 0); // 50 * 900 = 45000 / 1000 (valor anterior en pesos)
        assertEquals(50, cuentaDolares.verSaldo(), 0);
    }
}
