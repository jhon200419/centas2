import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema bancario");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nombreCliente, cedulaCliente);

        CuentaBancaria cuenta = null;

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear cuenta bancaria");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Mostrar estado de cuenta");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    if (cuenta == null) {
                        System.out.println("--- Tipo de cuenta ---");
                        System.out.println("1. Cuenta corriente");
                        System.out.println("2. Cuenta de ahorros");
                        System.out.print("Seleccione el tipo de cuenta: ");
                        int tipoCuenta = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        System.out.print("Ingrese el número de cuenta: ");
                        String numeroCuenta = scanner.nextLine();

                        System.out.print("Ingrese el saldo inicial: ");
                        double saldoInicial = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer

                        if (tipoCuenta == 1) {
                            cuenta = new CuentaCorriente(cliente, numeroCuenta, saldoInicial);
                        } else if (tipoCuenta == 2) {
                            cuenta = new CuentaAhorros(cliente, numeroCuenta, saldoInicial);
                        } else {
                            System.out.println("Opción inválida. No se pudo crear la cuenta.");
                        }
                    } else {
                        System.out.println("Ya se ha creado una cuenta bancaria para este cliente.");
                    }
                    break;
                case 2:
                    if (cuenta != null) {
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = scanner.nextDouble();
                        cuenta.depositar(cantidadDeposito);
                    } else {
                        System.out.println("No se ha creado una cuenta bancaria.");
                    }
                    break;
                case 3:
                    if (cuenta != null) {
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRetiro = scanner.nextDouble();
                        cuenta.retirar(cantidadRetiro);
                    } else {
                        System.out.println("No se ha creado una cuenta bancaria.");
                    }
                    break;
                case 4:
                    if (cuenta != null) {
                        cuenta.mostrarEstadoCuenta();
                    } else {
                        System.out.println("No se ha creado una cuenta bancaria.");
                    }
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
