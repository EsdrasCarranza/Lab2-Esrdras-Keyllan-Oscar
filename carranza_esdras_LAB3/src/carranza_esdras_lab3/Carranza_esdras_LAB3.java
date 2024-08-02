/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_lab3;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author 50488
 */
public class Carranza_esdras_LAB3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        Random random = new Random();

        info.useDelimiter("\n");

        int opcion = 0, contador = 0, correct_opcion = 0;
        String siguiente_ronda = "si", opcion_juego = " ";

        while (opcion != 4) {
            System.out.println("1.piedra, papel, tijera." + "\n" + "2.Ejercicio suma" + "\n" + "3.Piramide" + "\n" + "4.salir" + "\n" + "Ingrese la opcion que necesite: ");
            opcion = info.nextInt();

            if (opcion > 3 || opcion < 1) {
                System.out.println("Error. opcion no existente");
            } else if (opcion == 1) {
                while (siguiente_ronda.equals("si")) {
                    contador++;
                    System.out.println("Bienvenido al juego de piedra, papel o tijera");
                    System.out.println("Ronda " + contador);

                    while (correct_opcion == 0) {

                        System.out.println("Ingrese que opcion quiere jugar: ");
                        opcion_juego = info.next().toLowerCase();

                        if (opcion_juego.equals("tijera") || opcion_juego.equals("piedra") || opcion_juego.equals("papel")) {
                            System.out.println("Opcion ingresada = " + opcion_juego);
                            correct_opcion++;
                        } else {
                            System.out.println("Error. Opcion no permitida");
                        }

                    }
                    int opcion_computadora = random.nextInt(3);
                    String computadora = "";
                    if (opcion_computadora == 0) {
                        computadora = "piedra";
                    } else if (opcion_computadora == 1) {
                        computadora = "papel";
                    } else if (opcion_computadora == 2) {
                        computadora = "tijera";
                    }
                    System.out.println("La computadora juega: " + computadora);

                    if (opcion_juego.equals(computadora)) {
                        System.out.println("Empate!");
                    } else if ((opcion_juego.equals("piedra") && computadora.equals("tijera"))
                            || (opcion_juego.equals("papel") && computadora.equals("piedra"))
                            || (opcion_juego.equals("tijera") && computadora.equals("papel"))) {
                        System.out.println("Ganaste!");
                    } else {
                        System.out.println("Perdiste. Intentalo de nuevo!");
                    }
                    correct_opcion -= 1;

                    System.out.println("Quiere jugar otra ronda? (si/no): ");
                    siguiente_ronda = info.next().toLowerCase();

                }
            } else if (opcion == 2) {
                System.out.println("bienvenido a la opcion de suma de digitos" + "\n");
                System.out.println("Ingrese un numero: ");
                int numero = info.nextInt();
                if (numero < 0) {
                    System.out.println("Por favor, ingrese un numero entero no negativo.");
                    return;
                }

                int suma = 0, divisor = 1, temp = numero;

                while (temp >= 10) {
                    temp /= 10;
                    divisor *= 10;
                }

                temp = numero;
                boolean primerDigito = true;

                System.out.print("La suma de los digitos de " + numero + " es: ");

                while (divisor > 0) {
                    int digito = temp / divisor;
                    temp = temp % divisor;
                    divisor = divisor / 10;
                    suma += digito;

                    if (primerDigito) {
                        System.out.print(digito);
                        primerDigito = false;
                    } else {
                        System.out.print(" + " + digito);
                    }
                }

                System.out.println(" = " + suma);

            } else if (opcion == 3) {
                System.out.println("Que numero de filas desea en la piramide");
                int numero = info.nextInt();
                for (int i = 1; i <= numero; i++) {
                    for (int j = 1; j < i; j++) {
                        System.out.print("  ");
                    }
                    for (int k = numero; k >= i; k--) {
                        System.out.print(k + " ");
                    }
                    System.out.println();
                }

            }

        }

    }

}
    


