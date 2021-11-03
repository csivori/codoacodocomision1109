/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2java;

import java.util.Scanner;

/**
 *
 * @author Fer
 */
public class Clase2java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ingreso ing = new Ingreso();
        if (ing.IngresarLoop()) {
            System.out.println("Ingreso Exitoso");
        } else {
            System.out.println("Reintente mas Tarde!");
        }

    }
}
