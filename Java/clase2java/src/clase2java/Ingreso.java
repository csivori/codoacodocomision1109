package clase2java;

import java.util.Scanner;

public class Ingreso {
    private String usuario,pass;
    private final String miUsuario = "csivori";
    private final String miPass = "pp";
    private final Scanner sn = new Scanner(System.in);

    public Ingreso() {
        this.usuario = "";
        this.pass = "";
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean Ingresar(){
        System.out.print("\nIngrese su nombre de usuario: ");
        String nombre = sn.nextLine();
        System.out.print("\nIngrese su contraseña: ");
        String passw = sn.nextLine();
        return Validar(nombre, passw);
    }

    public boolean IngresarLoop(){
        while (!Ingresar()){
            if (!deseaReintentar()){return false;}
        }
        return true;
    }

    private boolean Validar(String usuario, String pass) {
        if ((usuario.equals(this.miUsuario)) && (pass.equals(this.miPass))){
            this.usuario = usuario;
            this.pass = pass;
            return true;
        } else {
            return false;            
        }
    }    

    private boolean deseaReintentar() {
        String opcion = " ";
        while (!opcion.equals("n") && !opcion.equals("N") && !opcion.equals("s") && !opcion.equals("S")){
            System.out.print("\nDesea Reintentar (S/N) ?: ");
            opcion = sn.nextLine();
        }   
        return (opcion.equals("s") || opcion.equals("S"));
                
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
