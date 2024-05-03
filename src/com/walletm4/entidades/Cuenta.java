package com.walletm4.entidades;

/*
 * Clase Cuenta para el proyecto Alke Wallet
 * Genera una cuenta que maneja saldos para el Cliente del mismo proyecto
 * 
 * Alkewallet Mod 04 
 * 
 * @author Alberto Jara
 * @version 1.0
 */

public class Cuenta {
	
	/**
     * El saldo de la cuenta.
     */
    protected double saldo;

    /**
     * Constructor de la clase Cuenta.
     * @param saldo El saldo inicial de la cuenta.
     */
    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Permite abonar dinero a la cuenta.
     * @param monto El monto a abonar.
     */
    public void abonar(double monto) {
        saldo += monto;
    }

    /**
     * Permite cargar dinero desde la cuenta.
     * @param monto El monto a cargar.
     */
    public void cargar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return El saldo de la cuenta.
     */
    public double verSaldo() {
        return saldo;
    }
}
