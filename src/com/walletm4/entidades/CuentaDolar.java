package com.walletm4.entidades;

/*
 * Clase que hereda de la Clase Cuenta para el proyecto Alke Wallet
 * Cuenta que maneja el saldo en dolares
 * Con un conversor de moneda, el valor de dicha moneda, por ser variable, debe ser entregado desde fuera
 * 
 * Alkewallet Mod 04 
 * 
 * @author Alberto Jara
 * @version 1.0
 */

public class CuentaDolar extends Cuenta {
	
	/*
	 * 
	 * Constructor de la clase
	 */
    public CuentaDolar(double saldo) {
        super(saldo);
    }
    
    /**
     * Convierte una cantidad de dólares a pesos.
     * @param valorDolar El valor del dólar en pesos.
     * @param montoDolares La cantidad de dólares a convertir.
     * @return La cantidad equivalente en pesos.
     */
    public double convertirDolaresAPesos(double valorDolar, double montoDolares) {
        return montoDolares * valorDolar;
    }
}
