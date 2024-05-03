package com.walletm4.entidades;

/*
 * Clase Cliente para el proyecto Alke Wallet
 * Genera un Cliente, con dos cuentas, una en pesos y otra en dolares
 * Cada cliente maneja sus saldos, y tiene sus metodos para abonos, cargos, y manejo de sus cuentas.
 * Alkewallet Mod 04 
 * 
 * @author Alberto Jara
 * @version 1.0
 */

public class Cliente {
	
	private String RUT;
    private String nombre;
    private String apellido;
    private CuentaPesos cuentaPesos;
    private CuentaDolar cuentaDolares;

    /**
     * Constructor de la clase Cliente.
     * @param RUT El número de identificación del cliente.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param cuentaPesos La cuenta en pesos del cliente.
     * @param cuentaDolares La cuenta en dólares del cliente.
     */
    public Cliente(String RUT, String nombre, String apellido, CuentaPesos cuentaPesos, CuentaDolar cuentaDolares) {
        this.RUT = RUT;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentaPesos = cuentaPesos;
        this.cuentaDolares = cuentaDolares;
    }

    /**
     * Obtiene el RUT del cliente.
     * @return El RUT del cliente.
     */
    public String getRUT() {
        return RUT;
    }

    /**
     * Establece el RUT del cliente.
     * @param RUT El nuevo RUT del cliente.
     */
    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return El apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     * @param apellido El nuevo apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene  el saldo de la cuenta en pesos del cliente.
     * @return La cuenta en pesos del cliente.
     */
    public CuentaPesos getCuentaPesos() {
        return cuentaPesos;
    }

    /**
     * Establece el saldo de la cuenta en pesos del cliente.
     * @param cuentaPesos La nueva cuenta en pesos del cliente.
     */
    public void setCuentaPesos(CuentaPesos cuentaPesos) {
        this.cuentaPesos = cuentaPesos;
    }

    /**
     * Obtiene el saldo de la cuenta en dólares del cliente.
     * @return La cuenta en dólares del cliente.
     */
    public CuentaDolar getCuentaDolares() {
        return cuentaDolares;
    }

    /**
     * Establece el saldo de la cuenta en dólares del cliente.
     * @param cuentaDolares La nueva cuenta en dólares del cliente.
     */
    public void setCuentaDolares(CuentaDolar cuentaDolares) {
        this.cuentaDolares = cuentaDolares;
    }
    
    /**
     * Realiza un traspaso de una cantidad de pesos desde la cuenta en pesos a la cuenta en dólares.
     * @param valorDolar El valor del dólar en pesos.
     * @param montoPesos La cantidad de pesos a traspasar.
     */
    public void traspasarPesosADolares(double valorDolar, double montoPesos) {
        double montoDolares = cuentaPesos.convertirPesosADolares(valorDolar, montoPesos);        
        
        if (cuentaPesos.verSaldo() >= montoPesos) { 
            cuentaPesos.cargar(montoPesos);
            cuentaDolares.abonar(montoDolares);
            System.out.println("Se ha realizado el traspaso de " + montoPesos + " pesos a " + montoDolares + " dólares");
        } else {
            System.out.println("Saldo insuficiente en la cuenta en pesos o en dólares");
        }
    }

    /**
     * Realiza un traspaso de una cantidad de dólares desde la cuenta en dólares a la cuenta en pesos.
     * @param valorDolar El valor del dólar en pesos.
     * @param montoDolares La cantidad de dólares a traspasar.
     */
    public void traspasarDolaresAPesos(double valorDolar, double montoDolares) {
        double montoPesos = cuentaDolares.convertirDolaresAPesos(valorDolar, montoDolares);
        if (cuentaDolares.verSaldo() >= montoDolares) {
            cuentaDolares.cargar(montoDolares);
            cuentaPesos.abonar(montoPesos);
            System.out.println("Se ha realizado el traspaso de " + montoDolares + " dólares a " + montoPesos + " pesos");
        } else {
            System.out.println("Saldo insuficiente en la cuenta en dólares o en pesos");
        }
    }

}
