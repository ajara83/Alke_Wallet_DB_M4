package com.walletm4.entidades;

/*
 * Clase que hereda de la Clase Cuenta para el proyecto Alke Wallet.
 * Cuenta que maneja el saldo en CLP pesos chilenos.
 * Con un conversor de moneda, de pesos a dolares.
 * 
 * Alkewallet Mod 04 
 * 
 * @author Alberto Jara
 * @version 1.0
 */

public class CuentaPesos extends Cuenta {
	
	/*
	 * 
	 * Constructor de la clase
	 */
    public CuentaPesos(double saldo) {
        super(saldo);
    }
    
    /**
     * Convierte una cantidad de pesos a dólares.
     * @param valorDolar El valor del dólar en pesos.
     * @param montoPesos La cantidad de pesos a convertir.
     * @return La cantidad equivalente en dólares.
     */
    public double convertirPesosADolares(double valorDolar, double montoPesos) {
    	
    	
        return montoPesos / valorDolar;
    }
}
