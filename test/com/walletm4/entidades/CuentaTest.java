package com.walletm4.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuentaTest {

	@Test
    public void testAbonar() {
        // Arrange
        double saldoInicial = 1000;
        double montoAbono = 500;
        Cuenta cuenta = new Cuenta(saldoInicial);

        // Act
        cuenta.abonar(montoAbono);

        // Assert
        assertEquals(saldoInicial + montoAbono, cuenta.verSaldo(), 0);
    }

    @Test
    public void testCargar_SaldoSuficiente() {
        // Arrange
        double saldoInicial = 1000;
        double montoCargo = 500;
        Cuenta cuenta = new Cuenta(saldoInicial);

        // Act
        cuenta.cargar(montoCargo);

        // Assert
        assertEquals(saldoInicial - montoCargo, cuenta.verSaldo(), 0);
    }

    @Test
    public void testCargar_SaldoInsuficiente() {
        // Arrange
        double saldoInicial = 1000;
        double montoCargo = 1500;
        Cuenta cuenta = new Cuenta(saldoInicial);

        // Act
        cuenta.cargar(montoCargo);

        // Assert
        assertEquals(saldoInicial, cuenta.verSaldo(), 0);
    }

}
