package banco;

public class Cliente {
    private int nroCuenta = 0;
    private String nombre = "";
    private float saldo=0;

// CONTRUCTORES
    
    public Cliente() {}
    public Cliente(String nombre) {this.nombre = nombre;}
    public Cliente(int nroCuenta, String nombre) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
    }

// GETTERs & SETTERs
    
    public int getNroCuenta() {return nroCuenta;}
    public String getNombre() {return nombre;}
    public float getSaldo() {return saldo;}

// ACCIONES
    
    public void depositar(float monto) {saldo += monto;}
    public void extraer(float monto) {saldo -= monto;}
    
}
