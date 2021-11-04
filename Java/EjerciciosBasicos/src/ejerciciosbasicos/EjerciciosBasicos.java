/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosbasicos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EjerciciosBasicos {
    
    static boolean verConSwing = false;
    static MenuItem[] opciones;

    public static void main(String[] args) {
        inicializarMenu();
        char opcion = mostrarMenu();
        while (opcion != 'S'){
            switch (opcion){
                case 'A', 'B', 'C', 'D', 'E' -> {
                    EjerciciosBasicos1 ej = new EjerciciosBasicos1(110);
                    switch (opcion){
                        case 'A' -> {
                            ej.EjecutarSalidasXPantalla();
                        }
                        case 'B' -> {
                            ej.EjecutarIngresosXPantalla();
                        }
                        case 'C' -> {
                            ej.EjecutarOperacionesDeComparacion();
                        }
                        case 'D' -> {
                            ej.EjecutarOperacionesMatematicas();
                        }
                        case 'E' -> {
                            ej.EjecutarOperacionesConCaracteres();
                        }
                    }
                }
                case 'Z' -> {
                    verConSwing = !verConSwing;
                }
            }
            opcion = mostrarMenu();
        }
    }

    private static void inicializarMenu(){
        opciones = new MenuItem[10];
        opciones[0] = new MenuItem('A', "Ejercicios Básicos - Salidas x Pantalla: print & println");
        opciones[1] = new MenuItem('B', "Ejercicios Basicos - Ingresos x Pantalla: Scanner / next()");
        opciones[2] = new MenuItem('C', "Ejercicios Basicos - Operaciones de Comparación (<, >, ==)");
        opciones[3] = new MenuItem('D', "Ejercicios Basicos - Operaciones Matemáticas (+, -, *, /, %)");
        opciones[4] = new MenuItem('E', "Ejercicios Basicos - Operaciones con Caracteres (char <-> ASCII code)");
        opciones[5] = new MenuItem('Z', "Cambiar Presentación a modo ");
    }
        
    private static char mostrarMenu() {
        return verConSwing ? mostrarMenuConSwing() : mostrarMenuConScanner();
    }
    
    private static char mostrarMenuConScanner() {
        System.out.println("\n\nSeleccione que Ejercicios desea ver (SCANNER)\n");
        for (MenuItem item : opciones) {
            if (item != null) {
                String msg = item.getItemMenu();
                if (item.getOpcion() == 'Z') { 
                    msg += (verConSwing ? "Scanner" : "Swing");
                }
                System.out.println(msg);
            }
        }
        char op = ObtenerOpcionrMenuConScanner();
        op = (new RutinasBasicas("->")).toUpperCase(op);
        System.out.println("op después: " + op);
        return op;
    }
    
    public static char mostrarMenuConSwing() {
        System.out.println("\n\nSeleccione que Ejercicios desea ver (SWING)\n");
        System.out.println("A -> Ejercicios Básicos - Salidas x Pantalla: print & println");
        System.out.println("B -> Ejercicios Basicos - Ingresos x Pantalla: Scanner / next()");
        System.out.println("C -> Ejercicios Basicos - Operaciones de Comparación (<, >, ==)");
        System.out.println("D -> Ejercicios Basicos - Operaciones Matemáticas (+, -, *, /, %)");
        System.out.println("E -> Ejercicios Basicos - Operaciones con Caracteres (char <-> ASCII code)");
        char op = ObtenerOpcionrMenuConSwing();
        op = (new RutinasBasicas("->")).toUpperCase(op);
        System.out.println("op después: " + op);
        return op;
    }
/*
    public static char ObtenerOpcionrMenu() {
        return (verConSwing) ? ObtenerOpcionrMenuConSwing() : ObtenerOpcionrMenuConScanner();
    }    
*/
    public static char ObtenerOpcionrMenuConScanner() {
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIntroduzca la Opción (S: Salir): ");
        return (char) sn.next().charAt(0);
    }    

    public static char ObtenerOpcionrMenuConSwing() {
//        Scanner sn = new Scanner(System.in);
        System.out.print("\nEntró a ObtenerOpcionrMenuConSwing2()");
//      
//        String apellido = JOptionPane.showInputDialog("ingrese Apellido:");
//        int opcion = JOptionPane.showOptionDialog(null, "Titulo", "SubTitulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        int opcion = JOptionPane.showOptionDialog(null, "Titulo", "SubTitulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        System.out.print("\nEntró a ObtenerOpcionrMenuConSwing3()");
        
        System.out.println("\nOpción: " + opcion);
        System.out.print("\nIntroduzca la Opción (S: Salir): ");
//        return (char) sn.next().charAt(0);
        return 'Z';
    }    
}