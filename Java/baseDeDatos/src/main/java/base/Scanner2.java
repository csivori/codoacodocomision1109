package base;

import base.SysOut;
import java.util.Scanner;

public class Scanner2{
    
    private final Scanner sn;
    
    public Scanner2() {
        sn = new Scanner(System.in);
    }
    
    public String cargarCampo(String lbl, String campo){
        if (campo == null) {campo = "";}
//        String etiqueta = (lbl + ((campo == null || campo.equals("0")) ? ("") : (" (" + campo + ")") + ": "));
        String etiqueta = (lbl + ((campo != "" && campo != "0") ? (" (" + campo + ")") : "") + ": ");
        SysOut.dbgprintln("Voy a cargar un campo String con etiqueta " + etiqueta + " y valor x default: " + campo, 20);
//        System.out.print(etiqueta);
        System.out.println(etiqueta);
        System.out.flush();
        return sn.nextLine();
    }
    
    public int cargarCampo(String lbl, int campo){
        String s;
        do{
            s = cargarCampo(lbl, ((campo == 0) ? "0" : Integer.toString(campo)));
            try {
                campo = Integer.parseInt(s);            
            } catch (NumberFormatException e) {
                System.out.println("*** Ingrese un valor correcto !! ***");
            }
        } while (!esNumeroMayorACero(campo));
        return campo;
    }
    
    public void close(){/* sn.close(); System.in no se debe Cerrar */}

    private boolean esNumeroMayorACero(int num){return (num > 0);}
    private boolean esNumeroMayorACero(String num){
        try{return esNumeroMayorACero(Integer.parseInt(num));} 
        catch (NumberFormatException err){return false;}
    }
}
