/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_trabajoclase.pkg4;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author 50488
 */
public class Carranza_Esdras_TRABAJOCLASE4 {

    /*
    Hacer un arreglo bidimensional cuadrado de dimensiones N x N, donde N es el 
    número de filas y columnas ingresada desde el teclado,
    luego de crear el arreglo se necesita cargar en las posiciones
    valores numéricos de manera aleatoria con la restricción de solo permitir todos los números 
    que contiene solo dos dígitos, además, realizar las siguientes operaciones y mostrar en pantalla 
    el arreglo(Formato de estilo matriz) y la suma:

1. Suma de la Diagonal Principal: La diagonal principal se extiende desde
    la esquina superior izquierda hasta la esquina inferior derecha.

2. Suma de la Diagonal Secundaria: La diagonal secundaria se extiende desde 
    la esquina superior derecha hasta la esquina inferior izquierda.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        Random aleatorio = new Random();
        int[][] arreglo_principal;
        int valor_arreglo = 0, cont_ejercicio = 0, suma_principal = 0, filas = 0, columnas = 0, suma_secundaria = 0;

        while (cont_ejercicio == 0) {
            System.out.println("Ingresar un valor para el arreglo: ");
            valor_arreglo = info.nextInt();

            if (valor_arreglo < 0) {
                System.out.println("Error no se puede ingresar valores negativos");

            } else {
                cont_ejercicio = 1;
            }
        }

        arreglo_principal = new int[valor_arreglo][valor_arreglo];

        for (filas = 0; filas < valor_arreglo; filas++) {
            for (columnas = 0; columnas < valor_arreglo; columnas++) {
                arreglo_principal[filas][columnas] = aleatorio.nextInt(90) + 10;

            }

        }

        for (filas = 0; filas < valor_arreglo; filas++) {

            for (columnas = 0; columnas < valor_arreglo; columnas++) {
                System.out.print(arreglo_principal[filas][columnas] + "  ");
                if (filas == columnas) {
                    suma_principal += arreglo_principal[filas][columnas];
                }
                if (filas + columnas == valor_arreglo - 1) {
                    suma_secundaria += arreglo_principal[filas][columnas];
                }
            }
            System.out.println("");

        }

        System.out.println("Suma principal: " + suma_principal);
        System.out.println("Suma secundaria: " + suma_secundaria);

    }

}
