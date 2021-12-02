package tpun2;

import java.util.Scanner;

public class Scanner2{
    
    private final Scanner sn;
    
    public Scanner2() {
        sn = new Scanner(System.in);
    }
    
    public String cargarCampo(String lbl, String campo){
        System.out.print(lbl+": " + ((campo == null || campo.equals("0")) ? "" : campo));
        return sn.nextLine();
    }
    
    public int cargarCampo(String lbl, int campo){
        String s;
        do{
            s = cargarCampo(lbl, Integer.toString(campo));
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
