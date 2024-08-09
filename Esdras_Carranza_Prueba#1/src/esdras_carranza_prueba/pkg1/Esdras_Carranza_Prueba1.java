/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esdras_carranza_prueba.pkg1;


import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author 50488
 */
public class Esdras_Carranza_Prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        Random random = new Random();

        //variables 
        int opcion = 0, numero = 0, suma = 0, divisores = 0, votos_azul = 0, votos_rojo = 0, votos_negro = 0, votos_amarillo = 0, votos_nulos = 0
                ,cant_palabraalrevez = 0,cant_numeroperfecto = 0,cant_primos = 0, cant_votaciones = 0;

        String palabra = " ", visual_palabra = " ", lista_divisores = " ";

        while (opcion != 5) {
            //menu 
            System.out.println("1.Palabra al revez" + "\n" + "2.Numero Perfecto" + "\n" + "3.primos" + "\n" + "4.Votaciones" + "\n" + "5.Salir");
            System.out.println("Ingrese cual opcion desea: ");
            opcion = info.nextInt();

            if (opcion < 1 || opcion > 5) {
                //error por si se ingresa una opcion no deseada 
                System.out.println("Error.unicamente ingresar valores del menu");
            } else if (opcion == 1) {
                cant_palabraalrevez ++;
                //ingresar la palabra
                System.out.println("Bienvenido a la aplicacion de imprimir palabra al revez" + "\n" + "Ingrese una palabra: ");
                palabra = info.next();
                // cuenta la longitud de la palabra para el ciclo
                int longitud_palabra = palabra.length();

                //inicio del ciclo el cual ira de forma descentende imprimiendo la palabra al revez
                for (int i = longitud_palabra - 1; i >= 0; i--) {
                    char letra = palabra.charAt(i);

                    visual_palabra += letra;

                }
                //imprime la palabra
                System.out.println("Su palabra es: " + visual_palabra);
                System.out.println(" ");

            } else if (opcion == 2) {
                cant_numeroperfecto++;
                //Ingresa el numero que de desea evaluar 
                System.out.println("Ingrese un numero entero: ");
                numero = info.nextInt();

                if (numero <= 0) {
                    System.out.println("ERROR.VALOR NO VALIDO DEBE SER UN ENTERO POSITIVO");
                }
                /*
                //INICIO DEL PROCESO ANALITICO DONDE EL CICLO DIVIDE EL NUMERO POR LOS VALORES ENTRE 1 Y EL NUMERO.
                SI EL RESIDUO ES IGUAL A CERO SIGNIFICA QUE ESE NUMERO ES DIVISOR DEL NUMERO Y SE SUMA EN LA VARIABLE SUMA.
                 */
                for (int l = 1; l < numero; l++) {
                    if (numero % l == 0) {
                        suma += l;
                    }

                }
                /*
                Aqui se revisa si la suma de estos valores son iguales al numero,
                si es asi es un numero perfecto si no, obviamente no lo es.
                 */
                if (suma == numero) {
                    System.out.println(numero + " es un numero perfecto.");
                } else {
                    System.out.println(numero + " no es un numero perfecto.");
                }

            } else if (opcion == 3) {
                cant_primos++;
                //se hace inicio de programa
                System.out.println("este programa va generar un numero aleatorio y vera si es primo: ");
                //genera un numero aleatorio entre 0 y 100
                int numero_aleatorio = random.nextInt(101);
                // se muestra el numero aleatorio 
                System.out.println("el numero aleatorio es : " + numero_aleatorio);
                /*
                en este for se lleva a cabo la busqueda de los divisiones del numero aleatorio
                y se ve guardando la lista de divisores y  la cantidad de divisores
                 */
                for (int o = 1; o <= numero_aleatorio; o++) {
                    if (numero % o == 0) {
                        divisores++;
                        lista_divisores += o + " y ";
                    }
                }
                // en esta linea hago uso de substring para que no se imprima la Y al final de la lista, ademas que aseguro que muestre la lista
                    String nueva_lista = lista_divisores.length() > 0 
                             ? lista_divisores.substring(0, lista_divisores.length() - 3) 
                             : lista_divisores;
                // aqui se valida que si el numero tiene mas de 2 divisores no es primo,pero si tiene solo 2 si lo es
                if (divisores == 2) {
                    System.out.println("el numero " + numero_aleatorio + " es primo porque solo tiene dos divisores.");
                } else {
                    System.out.println("el numero " + numero_aleatorio + " no es primo.");
                }
                // se imprimen los  resultados
                System.out.println("numero de divisores: " + divisores);
                System.out.println("divisores de " + numero + " son: " + nueva_lista);
            } else if (opcion == 4) {
                cant_votaciones++;
                //Inicio de programa y solicituda de cuantos votantes seran
                System.out.println("Cuantos votantes hay en el pais?");
                int total_votantes = info.nextInt();
                info.nextLine();
                // si se ingresan negativos o 0 saltara este error
                if (total_votantes <= 0) {
                    System.out.println("Error.INGRESAR VALORES MAYORES A 0 ");

                }
                //ciclo donde se pediran las votaciones
                for (int contador = 1; contador <= total_votantes; contador++) {
                    System.out.println("Votante " + contador + ":");
                    System.out.println("Ingrese su voto que pueden se azul, amarillo, rojo, negro :");
                    String voto = info.nextLine().toUpperCase();

                    // aqui verificamos el voto que se ingreso y se actualizan los contadores 
                    switch (voto) {
                        case "AZUL":
                            votos_azul++;
                            break;
                        case "ROJO":
                            votos_rojo++;
                            break;
                        case "NEGRO":
                            votos_negro++;
                            break;
                        case "AMARILLO":
                            votos_amarillo++;
                            break;
                        default:
                            votos_nulos++;
                    }
                }

                // aqui se calculan los votos validos y su porcentaje 
                double votos_validos = votos_azul + votos_rojo + votos_negro + votos_amarillo;
                double porcentaje_valido =  votos_validos / total_votantes;

                // verificamos si la votación es válida 
                if (porcentaje_valido >= 0.6) {
                    // Determinamos la planilla ganadora
                    String ganador;
                    if (votos_azul > votos_rojo && votos_azul > votos_negro && votos_azul > votos_amarillo) {
                        ganador = "Azul";
                    } else if (votos_rojo > votos_negro && votos_rojo > votos_amarillo) {
                        ganador = "Rojo";
                    } else if (votos_negro > votos_amarillo) {
                        ganador = "Negro";
                    } else {
                        ganador = "Amarillo";
                    }
                    // aqui se imprime el ganador
                    System.out.println("El ganador es: " + ganador);
                } else {
                    // se imprime "VOTACIÓN FALLIDA" si la votación no es válida
                    System.out.println("VOTACIÓN FALLIDA");
                }

            } else if (opcion == 5) {
                System.out.println("Cantidad de veces que se entro a palabra al revez: " + cant_palabraalrevez+ "\n" +
                        "Cantidad de veces que se entro a numero perfecto: " + cant_numeroperfecto + "\n" +
                        "Cantidad de veces que se entro a numeros primos: " + cant_primos + "\n" + 
                        "Cantidad de veces que se entro a votaciones: " + cant_votaciones);
                
                
            }
        }
    }
}
