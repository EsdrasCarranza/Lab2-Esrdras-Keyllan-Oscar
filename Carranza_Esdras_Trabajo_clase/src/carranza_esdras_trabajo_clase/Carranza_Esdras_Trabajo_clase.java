/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_trabajo_clase;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Carranza_Esdras_Trabajo_clase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner info = new Scanner(System.in);

        info.useDelimiter("\n");

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("1.Area triangulos. " + "\n" + "2.Minimo y Maximo comun multiplo." + "\n" + "3.Numero perfecto" + "\n" + "4.Salir");
            opcion = info.nextInt();

            if (opcion == 1) {

                double base, altura, area, mayor_area = 0;
                int triangulo_mayor = 0;

                for (int i = 1; i <= 8; i++) {
                    try{
                    System.out.println("Introduce la base del triangulo " + i + ":");
                    base = info.nextDouble();

                    System.out.println("Introduce la altura del triangulo " + i + ":");
                    altura = info.nextDouble();

                    area = (base * altura) / 2;
                    
                    System.out.println("El resultado del  triangulo#" + i + " = " + area);

                    if (area > mayor_area) {
                        mayor_area = area;
                        triangulo_mayor = i;
                    }
                    }catch(InputMismatchException e){
                        System.out.println("Error: num invalido");
                        i--;
                        info.nextLine();
                    }
                }

                System.out.println("La mayor area es: " + mayor_area + " y fue encontrada en el triangulo " + triangulo_mayor);

            } else if (opcion == 2) {
                System.out.println("Introduce el primer número:");
                int num1 = info.nextInt();

                System.out.println("Introduce el segundo número:");
                int num2 = info.nextInt();
                int a = num1;
                int b = num2;
                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                int mcd = a;

                int mcm = (num1 * num2) / mcd;

                System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + mcd);
                System.out.println("El MCM de " + num1 + " y " + num2 + " es: " + mcm);

            } else if (opcion == 3) {
                

            } else if (opcion > 4 || opcion < 1) {
                System.out.println("Error. Opcion no existente.");
            }
        }
    }

}
