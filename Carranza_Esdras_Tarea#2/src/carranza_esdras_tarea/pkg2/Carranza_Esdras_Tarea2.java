/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_tarea.pkg2;

import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Carranza_Esdras_Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner info = new Scanner(System.in);

        info.useDelimiter("\n");
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("1. Palabra diagonal.");
            System.out.println("2. Piramide de numeros.");
            System.out.println("3. Listado palindromo.");
            System.out.println("4. Salir.");
            System.out.println("Ingrese la opcion que quiere: ");
            opcion = info.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese una palabra: ");
                String palabra = info.next().toUpperCase();
                int longitud = palabra.length();

                for (int i = 0; i < longitud; i++) {

                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }

                    System.out.println(palabra.charAt(i));
                }

                for (int i = longitud - 2; i >= 0; i--) {

                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }

                    System.out.println(palabra.charAt(i));
                }

            } else if (opcion == 2) {
                System.out.print("Ingrese el numero de filas: ");
                int numero = info.nextInt();

                for (int i = 1; i <= numero; i++) {

                    for (int j = numero; j > i; j--) {
                        System.out.print("  ");
                    }

                    for (int k = 1; k <= i; k++) {
                        System.out.print(k + " ");
                    }

                    for (int k = i - 1; k >= 1; k--) {
                        System.out.print(k + " ");
                    }
                    System.out.println();
                }
            } else if (opcion == 3) {
                // Solicitar al usuario la cantidad de palabras
                System.out.print("Ingrese la cantidad de palabras a evaluar: ");
                int cantidad = info.nextInt();
                info.nextLine(); // Consumir el salto de línea restante

                // Evaluar cada palabra
                for (int i = 0; i < cantidad; i++) {
                    System.out.print("Ingrese la palabra #" + (i + 1) + ": ");
                    String palabra = info.nextLine();

                    // Determinar si es un palíndromo
                    int longitud = palabra.length();
                    boolean esPalindromo = true;
                    for (int j = 0; j < longitud / 2; j++) {
                        if (Character.toLowerCase(palabra.charAt(j)) != Character.toLowerCase(palabra.charAt(longitud - j - 1))) {
                            esPalindromo = false;
                            break;
                        }
                    }

                    // Mostrar el resultado
                    if (esPalindromo) {
                        System.out.println("La palabra '" + palabra + "' es un palindromo.");
                    } else {
                        System.out.println("La palabra '" + palabra + "' no es un palindromo.");
                    }
                }
            } else if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opcion no valida, intente de nuevo.");
            }
        }
    }
}
