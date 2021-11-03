/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosbasicos;

/***********************************
 *** Librería de Rutinas Básicas ***
 *** @author Fer                 ***
 ***********************************/
public class RutinasBasicas {

    private final String salida;

    RutinasBasicas(String salida){
        this.salida = salida;
    }
    public String lAlg(String str, int cant){
        String strout = str;
        for (int a=strout.length(); a<=cant; a++){ strout += " "; }
        return strout;
    }
    public String rAlg(String str, int cant){
        return rFill(str, cant, ' ');
    }
    public String cAlg(String str, int cant){
        return cFill(str, cant, ' ');
    }
    public String lFill(String str, int cant, char c){
        String strout = str;
        for (int a=strout.length(); a<=cant-1; a++){
            strout += c;
        }
        return strout;
    }
    public String rFill(String str, int cant, char c){
        String strout = "";
        for (int a=str.length(); a<=cant-1; a++){
            strout += c;
        }
        return strout + str;
    }
    public String cFill(String str, int cant, char c){
        String strout = "";
        for (int a=1; a<=((cant-str.length())/2); a++){
            strout += c;
        }
        return strout + str + strout;
    }
    public String salida(String str, int cant){
        return lAlg(str, cant-2) + this.salida + " ";
    }    
    public String salidaEj(int ejercicio, String str, int cant){
        return "Ej:"+ rFill(Integer.toString(ejercicio), 2, '0') + " " + salida(str, cant-6);
    }
    public char toUpperCase(char c){
        if (c >= 'a' && c <= 'z') {
            return (char) ((byte)c - 32);
        } else if ((c >= 'A' && c <= 'Z') || c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú') {
            return c;
        } else if (c == 'ñ') {
            return 'Ñ';
        } else if (c == 'á') {
            return 'Á';
        } else if (c == 'é') {
            return 'É';
        } else if (c == 'í') {
            return 'Í';
        } else if (c == 'ó') {
            return 'Ó';
        } else if (c == 'ú') {
            return 'Ú';
        } else {return ' ';}
    }
}
