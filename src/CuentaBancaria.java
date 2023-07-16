public abstract class CuentaBancaria {
    protected Cliente titular;
    protected String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(Cliente titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public Cliente getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Se depositaron " + cantidad + " unidades. Saldo actual: " + saldo);
    }

    public abstract void retirar(double cantidad);

    public void mostrarEstadoCuenta() {
        System.out.println("=== Estado de cuenta ===");
        System.out.println("Titular de la cuenta: " + titular.getNombre());
        System.out.println("Cédula del titular: " + titular.getCedula());
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: " + saldo);
    }
}
