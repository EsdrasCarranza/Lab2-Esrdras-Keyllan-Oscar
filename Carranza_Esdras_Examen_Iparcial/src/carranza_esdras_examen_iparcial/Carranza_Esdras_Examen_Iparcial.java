/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_examen_iparcial;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author 50488
 */
public class Carranza_Esdras_Examen_Iparcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);

        info.useDelimiter("\n");

        double monto = 0, subtotal = 0, impuesto = 0, total = 0;
        int opcion = 0, cont_opcion = 0, filas = 0, numero = 0, suma = 0, contador = 0, mayor = 0, correct_caja = 0, precio_caja = 0, cant_normales = 0, cant_hd = 0;
        String continuar = "si", nombre = " ", cont_compra = "si", tipo_canal = " ", caja_digital = " ";

        while (opcion != 5) {
            try {
                System.out.println("1.Piramide " + "\n" + "2.El mayor " + "\n" + "3.Compra canales" + "\n" + "4.Carcteres Vocales" + "\n" + "5.salir" + "\n" + "Ingrese una opcion: ");
                opcion = info.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese valores enteros");
                info.nextLine();
            }
            if (opcion < 0 || opcion > 5) {
                System.out.println("Error.Ingreso una opcion no valida.");
            } else if (opcion == 1) {
                cont_opcion = 0;
                System.out.println("Bienvenido a la  piramide");
                while (cont_opcion == 0) {
                    try {
                        System.out.println("Ingrese una cantidad de filas: ");
                        filas = info.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error. Ingrese valores enteros");
                        info.nextLine();
                    }
                    System.out.println(" ");
                    if (filas <= 0) {
                        System.out.println("Error.ingresar unicamente filas positivas.");
                    } else {
                        cont_opcion = 1;
                    }
                }
                for (int fila = 1; fila <= filas; fila++) {
                    int contadorPrimos = 0;
                    for (int i = 0; i < fila;) {
                        boolean esPrimo = true;
                        if (numero <= 1) {
                            esPrimo = false;
                        } else {
                            for (int j = 2; j <= Math.sqrt(numero); j++) {
                                if (numero % j == 0) {
                                    esPrimo = false;
                                    break;
                                }
                            }
                        }
                        if (esPrimo) {
                            System.out.print(numero + " ");
                            contadorPrimos++;
                            i++;
                        }

                        numero++;
                    }
                    int resultado = contadorPrimos * contadorPrimos * contadorPrimos;
                    System.out.println("= " + resultado);
                }

            } 
        }

    }

}
