/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_problema1;

import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Actividad_problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner (System.in);
        info.useDelimiter("\n");
        
        double fahrenheit=0,celsius = 0;
        System.out.println("Ingreese los grados fahrenheit:");
        fahrenheit = info.nextDouble();
        celsius = (fahrenheit - 32) *5/9;
        System.out.println("los grados ingresados fueron: " + fahrenheit);
        System.out.println("los grados en celsius son: " + celsius);
    }
    
}
