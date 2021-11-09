/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosbasicos;

//import RutinasBasicas.RutinasBasicas; //No es necesario importarla xq esta en el mismo Package

import java.util.Scanner;

public class EjerciciosBasicos1 {
    
    private int ancho;
    private final RutinasBasicas rb = new RutinasBasicas("->");
    private final Scanner sn = new Scanner(System.in);        

    public EjerciciosBasicos1(int ancho) {
        this.ancho = ancho;
    }
    
    public void EjecutarSalidasXPantalla(int ancho) {
        this.ancho = ancho;
        EjecutarSalidasXPantalla();
    }

    public void EjecutarSalidasXPantalla() {
        int ejercicio = 1;
        System.out.println("\n" + rb.cAlg("EJEMPLOS de Salidas por Pantalla (print y println)\n", ancho));
        System.out.print(rb.salidaEj(ejercicio, "println(\"123... Hola Mundo 1!\");", ancho));
        System.out.println("123... Hola Mundo 1!" + "   FUNCIONA!");
        ejercicio++;
        
        System.out.print(rb.salidaEj(ejercicio, "println(\"123... Hola Mundo \" + ejercicio + \"!\");", ancho));
        System.out.println("123... Hola Mundo " + ejercicio + "!" + "   FUNCIONA!");
        ejercicio++;
        
        System.out.print(rb.salidaEj(ejercicio, "print(\"123... \"); print(\"Hola \"); print(\"Mundo \"); + println(ejercicio + \"!\");", ancho));
        System.out.print("123... "); 
        System.out.print("Hola ");
        System.out.print("Mundo ");
        System.out.println(ejercicio + "!" + "   FUNCIONA!");
        ejercicio++;
        
        System.out.print(rb.salidaEj(ejercicio, "println(100 + 20 + 3 + \"... Hola \" + \"Mundo \" + ejercicio/2 + ejercicio/2 + \"!\");", ancho));
        System.out.println(100 + 20 + 3 + "... Hola " + "Mundo " + ejercicio/2 + ejercicio/2 + "!" + "  CUAC !!!");
        System.out.print(rb.salidaEj(ejercicio, "println(100 + 20 + 3 + \"... Hola \" + \"Mundo \" + (int) ejercicio/2 + (int) ejercicio/2 + \"!\");", ancho));
        System.out.println(100 + 20 + 3 + "... Hola " + "Mundo " + (int) ejercicio/2 + (int) ejercicio/2 + "!" + "  CUAC !!!");
        System.out.print(rb.salidaEj(ejercicio, "println(100 + 20 + 3 + \"... Hola \" + \"Mundo \" + (ejercicio/2 + ejercicio/2) + \"!\");", ancho));
        System.out.println(100 + 20 + 3 + "... Hola " + "Mundo " + (ejercicio/2 + ejercicio/2) + "!" + "   FUNCIONA!");
        ejercicio++;    
    
        System.out.print(rb.salidaEj(ejercicio, "println(\"Imprimo \" + (int) 5);", ancho));
        System.out.println("Imprimo " + (int) 5);
        System.out.print(rb.salidaEj(ejercicio, "println(\"Imprimo \" + (double) 5.03);", ancho));
        System.out.println("Imprimo " + (double) 5.03);
        System.out.print(rb.salidaEj(ejercicio, "println(\"Imprimo \" + (double) 235345345345.234534);", ancho));
        System.out.println("Imprimo " + (double) 235345345345.234534);
        System.out.print(rb.salidaEj(ejercicio, "println(\"Imprimo \" + (double) 123123232);", ancho));
        System.out.println("Imprimo " + (double) 123123232);
        ejercicio++;        
    }

    public void EjecutarIngresosXPantalla(int ancho) {
        this.ancho = ancho;
        EjecutarIngresosXPantalla();
    }
    
    public void EjecutarIngresosXPantalla() {
        int ejercicio = 1;
        System.out.println("\n" + rb.cAlg("EJEMPLOS de Ingresos por Pantalla (clase Scanner)\n", ancho));

        System.out.println(rb.salidaEj(ejercicio, "Scanner sn = new Scanner(System.in);", ancho));
//        Scanner sn = new Scanner(System.in); Lo creo como atributo de la clase
        ejercicio++;
        
        System.out.print("\n" + rb.salidaEj(ejercicio, "println(\"Introduzca el 1º Operador: \"); int int1 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 1º Operador: ");
        int int1 = sn.nextInt();
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 2º Operador: \"); int int2 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 2º Operador: ");
        int int2 = sn.nextInt();
        System.out.println("El 1º Operador ingresado es " + int1 + " y el 2º Operador ingresado es " + int2);
        ejercicio++;        

        System.out.print("\n" + rb.salidaEj(ejercicio, "println(\"Introduzca el 1º Operador: \"); double d1 = sn.nextDouble();", ancho));
        System.out.print("Introduzca el 1º Operador: ");
        double d1 = sn.nextDouble();
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 2º Operador: \"); double d2 = sn.nextDouble();", ancho));
        System.out.print("Introduzca el 2º Operador: ");
        double d2 = sn.nextDouble();
        System.out.println("El 1º Operador ingresado es " + d1 + " y el 2º Operador ingresado es " + d2);
        ejercicio++; 
        
        System.out.print("\n" + rb.salidaEj(ejercicio, "println(\"Introduzca el 1º Operador: \"); String s1 = sn.nextLine();", ancho));
        System.out.print("Introduzca el 1º Operador: ");
        String s1 = sn.nextLine();
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 2º Operador: \"); String s2 = sn.nextLine();", ancho));
        System.out.print("Introduzca el 2º Operador: ");
        String s2 = sn.nextLine();
        System.out.println("El 1º String ingresado es " + s1);
        System.out.println("El 2º String ingresado es " + s2);
        ejercicio++;        
    }
    
    public void EjecutarOperacionesDeComparacion(int ancho) {
        this.ancho = ancho;
        EjecutarOperacionesDeComparacion();
    }
    
    public void EjecutarOperacionesDeComparacion() {
        int ejercicio = 1;
        System.out.println("\n" + rb.cAlg("EJEMPLOS de Operaciones de Comparación\n", ancho));
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 1º Operador: \"); int int1 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 1º Operador: ");
        int int1 = sn.nextInt();
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 2º Operador: \"); int int2 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 2º Operador: ");
        int int2 = sn.nextInt();
        
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + ((int1 > int2) ? \" es > que \" : ((int1 < int2) ? \" es < que \" : \" es = a \")) + int2);", ancho));
        System.out.println(int1 + ((int1 > int2) ? " es > que " : ((int1 < int2) ? " es < que " : " es = a ")) + int2);
        ejercicio++;
    }
    
    public void EjecutarOperacionesMatematicas(int ancho) {
        this.ancho = ancho;
        EjecutarOperacionesMatematicas();
    }
    
    public void EjecutarOperacionesMatematicas() {
        int ejercicio = 1;
        System.out.println("\n" + rb.cAlg("EJEMPLOS de Operaciones Matemáticas\n", ancho));
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 1º Operador: \"); int int1 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 1º Operador: ");
        int int1 = sn.nextInt();
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca el 2º Operador: \"); int int2 = sn.nextInt();", ancho));
        System.out.print("Introduzca el 2º Operador: ");
        int int2 = sn.nextInt();
                
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + \" + \" + int2 + \" = \" + (int1 + int2));", ancho));
        System.out.println(int1 + " + " + int2 + " = " + (int1 + int2));
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + \" - \" + int2 + \" = \" + (int1 - int2));", ancho));
        System.out.println(int1 + " - " + int2 + " = " + (int1 - int2));
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + \" * \" + int2 + \" = \" + (int1 * int2));", ancho));
        System.out.println(int1 + " * " + int2 + " = " + (int1 * int2));
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + \" / \" + int2 + \" = \" + (int1 / int2));", ancho));
        System.out.println(int1 + " / " + int2 + " = " + (int1 / int2));
        System.out.print(rb.salidaEj(ejercicio, "println(int1 + \" % \" + int2 + \" = \" + (int1 % int2));", ancho));
        System.out.println(int1 + " % " + int2 + " = " + (int1 % int2));
        ejercicio++;
        
        System.out.println(rb.salidaEj(ejercicio, "Verificar si int1 es par y si int2 es impar", ancho));
        System.out.print(rb.salidaEj(ejercicio, "println((int1%2 == 0) ? \"Es Par\" : \"No es Par\");", ancho));
        System.out.println((int1%2 == 0) ? "Es Par" : "No es Par");
        System.out.print(rb.salidaEj(ejercicio, "println((int2%2 != 0) ? \"Es Impar\" : \"No es Impar\");", ancho));
        System.out.println((int2%2 != 0) ? "Es Impar" : "No es Impar");
        ejercicio++;
    }

    public void EjecutarOperacionesConCaracteres(int ancho) {
        this.ancho = ancho;
        EjecutarOperacionesConCaracteres();
    }
    
    public void EjecutarOperacionesConCaracteres() {
        int ejercicio = 1;
        System.out.println("\n" + rb.cAlg("EJEMPLOS de Operaciones con Caracteres\n", ancho));

        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca un código ASCII: \"); byte codAscii1 = sn.nextByte();", ancho));
        System.out.print("Introduzca un código ASCII: ");
        byte codAscii1 = sn.nextByte();
        System.out.print(rb.salidaEj(ejercicio, "println((char) codAscii1);", ancho));
        System.out.println((char) codAscii1);
        ejercicio++;
        
        System.out.print(rb.salidaEj(ejercicio, "println(\"Introduzca otro código ASCII: \"); char chrAscii2 = (char) sn.nextByte();", ancho));
        System.out.print("Introduzca otro código ASCII: ");
        char chrAscii2 = (char) sn.nextByte();
        System.out.print(rb.salidaEj(ejercicio, "println(chrAscii2);", ancho));
        System.out.println(chrAscii2);
        ejercicio++;
    }
}
