package com.walletm4.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.walletm4.entidades.Cliente;
import com.walletm4.entidades.CuentaDolar;
import com.walletm4.entidades.CuentaPesos;

/*
 * Clase de presentación del proyecto * 
 * Alkewallet Mod 04 
 * 
 * @author Alberto Jara
 * @version 1.0
 */
public class Main {
    private HashMap<String, Cliente> clientes;
    private double dolarReferencia = 900;

    /**
     * Constructor de la clase Main.
     */
    public Main() {
        clientes = new HashMap<>();
    }

    /**
     * Método principal que inicia la aplicación y muestra el menú de opciones.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Crear nuevo cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Ver saldo");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Traspasar pesos a dólares");
            System.out.println("7. Traspasar dólares a pesos");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    verSaldo();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    retirar();
                    break;
                case 6:
                    traspasarPesosADolares();
                    break;
                case 7:
                    traspasarDolaresAPesos();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);
        scanner.close();
    }

    /**
     * Método para ver el saldo de un cliente.
     */
    public void verSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente: ");
        String RUT = scanner.nextLine();
        Cliente cliente = clientes.get(RUT);
        if (cliente != null) {
            System.out.println("Saldo en pesos: " + cliente.getCuentaPesos().verSaldo());
            System.out.println("Saldo en dólares: " + cliente.getCuentaDolares().verSaldo());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Método para realizar un depósito en la cuenta de un cliente.
     */
    public void depositar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente: ");
        String RUT = scanner.nextLine();
        Cliente cliente = clientes.get(RUT);
        if (cliente != null) {
            System.out.print("Ingrese el monto a depositar: ");
            double monto = scanner.nextDouble();
            cliente.getCuentaPesos().abonar(monto); // Se asume que se deposita en la cuenta en pesos
            System.out.println("Depósito realizado con éxito");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Método para realizar un retiro de la cuenta de un cliente.
     */
    public void retirar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente: ");
        String RUT = scanner.nextLine();
        Cliente cliente = clientes.get(RUT);
        if (cliente != null) {
            System.out.print("Ingrese el monto a retirar: ");
            double monto = scanner.nextDouble();
            cliente.getCuentaPesos().cargar(monto); // Se asume que se retira de la cuenta en pesos
            System.out.println("Retiro realizado con éxito");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Método para realizar un traspaso de una cantidad de pesos a dólares.
     */
    public void traspasarPesosADolares() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente: ");
        String RUT = scanner.nextLine();
        Cliente cliente = clientes.get(RUT);
        if (cliente != null) {
            System.out.print("Ingrese el monto en pesos a traspasar a dólares: ");
            double montoPesos = scanner.nextDouble();
            double montoDolares = cliente.getCuentaPesos().convertirPesosADolares(dolarReferencia, montoPesos);
            if (cliente.getCuentaPesos().verSaldo() >= montoPesos && cliente.getCuentaDolares().verSaldo() >= montoDolares) {
                cliente.getCuentaPesos().cargar(montoPesos);
                cliente.getCuentaDolares().abonar(montoDolares);
                System.out.println("Traspaso de pesos a dólares realizado con éxito");
            } else {
                System.out.println("Saldo insuficiente en la cuenta en pesos o en dólares");
            }
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Método para realizar un traspaso de una cantidad de dólares a pesos.
     */
    public void traspasarDolaresAPesos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente: ");
        String RUT = scanner.nextLine();
        Cliente cliente = clientes.get(RUT);
        if (cliente != null) {
            System.out.print("Ingrese el monto en dólares a traspasar a pesos: ");
            double montoDolares = scanner.nextDouble();
            double montoPesos = cliente.getCuentaDolares().convertirDolaresAPesos(dolarReferencia, montoDolares);
            if (cliente.getCuentaDolares().verSaldo() >= montoDolares && cliente.getCuentaPesos().verSaldo() >= montoPesos) {
                cliente.getCuentaDolares().cargar(montoDolares);
                cliente.getCuentaPesos().abonar(montoPesos);
                System.out.println("Traspaso de dólares a pesos realizado con éxito");
            } else {
                System.out.println("Saldo insuficiente en la cuenta en dólares o en pesos");
            }
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Método para crear un nuevo cliente.
     */
    public void crearCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del nuevo cliente: ");
        String RUT = scanner.nextLine();
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del nuevo cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el saldo inicial en pesos: ");
        double saldoPesos = scanner.nextDouble();
        System.out.print("Ingrese el saldo inicial en dólares: ");
        double saldoDolares = scanner.nextDouble();
        CuentaPesos cuentaPesos = new CuentaPesos(saldoPesos);
        CuentaDolar cuentaDolares = new CuentaDolar(saldoDolares);
        Cliente cliente = new Cliente(RUT, nombre, apellido, cuentaPesos, cuentaDolares);
        clientes.put(RUT, cliente);
        System.out.println("Cliente creado con éxito");
    }

    /**
     * Método para listar todos los clientes.
     */
    public void listarClientes() {
        System.out.println("Clientes registrados:");
        for (Map.Entry<String, Cliente> entry : clientes.entrySet()) {
            Cliente cliente = entry.getValue();
            System.out.println("RUT: " + cliente.getRUT() + ", Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }

    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
