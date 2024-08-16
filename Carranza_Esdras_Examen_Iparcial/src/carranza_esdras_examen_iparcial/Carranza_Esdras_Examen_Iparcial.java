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

            } else if (opcion == 2) {
                while (continuar.equalsIgnoreCase("si")) {
                    try {
                        System.out.print("Ingrese un numero entero: ");
                        int entero = info.nextInt();
                        suma += entero;
                        contador++;

                        if (entero > mayor) {
                            mayor = entero;
                        }

                        System.out.print("Desea ingresar otro numero? (SI/NO): ");
                        continuar = info.next().toLowerCase();
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor ingrese un numero valido.");
                        info.nextLine();
                    }
                }

                if (contador > 0) {
                    double promedio = (double) suma / contador;
                    System.out.println("El numero mayor ingresado es: " + mayor);
                    System.out.println("El promedio de los numeros ingresados es: " + promedio);
                } else {
                    System.out.println("No se ingresaron numeros.");
                }
            }else if (opcion == 3) {
                try{
                System.out.println("Servicio de venta de canales");
                System.out.println("Ingrese su nombre: ");
                nombre = info.next();
                }catch(InputMismatchException e ){
                    System.out.println("Ingresar nombre");
                    info.nextLine();
                }
                while (cont_compra.equalsIgnoreCase("SI")) {
                    try{
                    System.out.println("Ingrese el tipo de canal que puede ser HD o NORMAL: ");
                    tipo_canal = info.next().toUpperCase();
                    }catch(InputMismatchException e){
                        System.out.println("Ingresar el tipo de canal");
                        info.nextLine();
                    }
                    if (tipo_canal.equals("HD") || tipo_canal.equals("NORMAL")) {
                        System.out.println("Usted selecciono: " + tipo_canal);
                    } else {
                        System.out.println("Ingrese un tipo de canal valido.");
                    }

                    if (tipo_canal.equals("HD")) {
                        monto += 30;
                        cant_hd++;
                    } else if (tipo_canal.equals("NORMAL")) {
                        monto += 20;
                        cant_normales++;
                    }

                    System.out.println("Desea comprar otra caja? (SI o NO): ");
                    cont_compra = info.next().toUpperCase();
                }

                while (correct_caja == 0) {
                    try{
                    System.out.println("Ingrese el tipo de caja digital que necesite, estas pueden ser: "
                            + "\n1.LIGHTBOX"
                            + "\n2.HDBOX"
                            + "\n3.DVRBOX"
                            + "\nIngrese el tipo de caja: ");
                    caja_digital = info.next();
                    }catch(InputMismatchException e){
                        System.out.println("Ingresar el tipo de caja digital");
                    }
                    if (caja_digital.equalsIgnoreCase("LIGHTBOX")) {
                        precio_caja = 50;
                        correct_caja = 1;
                    } else if (caja_digital.equalsIgnoreCase("HDBOX")) {
                        precio_caja = 100;
                        correct_caja = 1;
                    } else if (caja_digital.equalsIgnoreCase("DVRBOX")) {
                        precio_caja = 150;
                        correct_caja = 1;
                    } else {
                        System.out.println("Ingrese una caja de las 3.");
                    }
                }

                subtotal = monto + precio_caja;
                impuesto = subtotal * 0.15;
                total = subtotal + impuesto;
                System.out.println(" ");
                System.out.println(nombre + " usted agrego " + cant_normales + " canales normales y " + cant_hd + " canales HD.");
                System.out.println("El subtotal a pagar es " + subtotal + " Lps."
                        + "\nEl impuesto es del 15%, por ende, se cobrara " + impuesto + " Lps."
                        + "\nTotal a pagar es de: " + total + " Lps.");
                System.out.println(" ");

            }

        }

    }
}
