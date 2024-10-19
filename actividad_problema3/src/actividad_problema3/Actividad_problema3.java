/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_problema3;

import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Actividad_problema3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        info.useDelimiter("\n");
        
        double altura = 0,base = 0,area = 0,perimetro=0;
        
        System.out.println("Ingresar la base del rectangulo: ");
        base = info.nextDouble();
        System.out.println("Ingresar la base del rectangulo: ");
        altura = info.nextDouble();
        if(base<=0 || altura<= 0){
            System.out.println("Ingresar valores mayores a 0");
        }
        
        area= base*altura;
        perimetro = (2*base) + (2*altura);
        
        System.out.println("El area es de " + area + " y el perimetro es: " + perimetro);
        
    }
    
}
