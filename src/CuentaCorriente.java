public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(Cliente titular, String numeroCuenta, double saldoInicial) {
        super(titular, numeroCuenta, saldoInicial);
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se retiraron " + cantidad + " unidades. Saldo actual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
