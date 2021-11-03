/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosbasicos;

import java.util.Scanner;
import javax.swing.*;

public class EjerciciosBasicos {
    
    public static void main(String[] args) {
        char opcion = mostrarMenu();
        while (opcion != 'S'){
            switch (opcion){
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                    EjerciciosBasicos1 ej = new EjerciciosBasicos1(110);
                    switch (opcion){
                        case 'A':{
                            ej.EjecutarSalidasXPantalla();
                            break;
                        }
                        case 'B':{
                            ej.EjecutarIngresosXPantalla();
                            break;
                        }
                        case 'C':{
                            ej.EjecutarOperacionesDeComparacion();
                            break;
                        }
                        case 'D':{
                            ej.EjecutarOperacionesMatematicas();
                            break;
                        }
                        case 'E':{
                            ej.EjecutarOperacionesConCaracteres();
                            break;
                        }
                    }
/*                case 'A' -> {
                    EjerciciosBasicos1 ej = new EjerciciosBasicos1(110);
                    ej.Ejecutar();
                }
                case 'B' -> {
                    EjerciciosBasicos1 ej = new EjerciciosBasicos3(110);
                    ej.Ejecutar();
                }
                case 'C' -> {
                    EjerciciosBasicos3 ej = new EjerciciosBasicos3(110);
                    ej.Ejecutar();
                }
*/            
            }
            opcion = mostrarMenu();
        }
    }

    public static char mostrarMenu() {
        System.out.println("\n\nSeleccione que Ejercicios desea ver\n");
        System.out.println("A -> Ejercicios Básicos - Salidas x Pantalla: print & println");
        System.out.println("B -> Ejercicios Basicos - Ingresos x Pantalla: Scanner / next()");
        System.out.println("C -> Ejercicios Basicos - Operaciones de Comparación (<, >, ==)");
        System.out.println("D -> Ejercicios Basicos - Operaciones Matemáticas (+, -, *, /, %)");
        System.out.println("E -> Ejercicios Basicos - Operaciones con Caracteres (char <-> ASCII code)");
        char op = ObtenerOpcionrMenu1();
        op = (new RutinasBasicas("->")).toUpperCase(op);
        System.out.println("op después: " + op);
        return op;
    }
    
    public static char ObtenerOpcionrMenu1() {
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIntroduzca la Opción (S: Salir): ");
        return (char) sn.next().charAt(0);
    }    

    public char ObtenerOpcionrMenu2() {
        System.out.print("\nIntroduzca la Opción (S: Salir): ");
        return (char) (new Scanner(System.in)).next().charAt(0);
    }    
}
