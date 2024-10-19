/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_problema2;

import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Actividad_problema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        info.useDelimiter("\n");
        
          double nota_parcialI = 0, nota_parcialII = 0, nota_parcialIII = 0, promedio_nota = 0, notas_parciales = 0, nota_examenfinal = 0, trabajofinal = 0, nota_total = 0;

        System.out.println("Programa para calcular el total de las notas (INGRESAR NOTAS ENTRE 0 Y 100)");
        
        System.out.println("Nota parcial I:");
        nota_parcialI = info.nextDouble();
        System.out.println("Nota parcial II:");
        nota_parcialII = info.nextDouble();
        System.out.println("Nota parcial III:");
        nota_parcialIII = info.nextDouble();
        
        if(nota_parcialI < 0 || nota_parcialI > 100 || nota_parcialII < 0 || nota_parcialII > 100 || nota_parcialIII < 0 || nota_parcialIII > 100) {
            System.out.println("INGRESAR NOTAS MAYORES O IGUALES A 0 Y MENORES O IGUALES A 100");
            return;
        }

        promedio_nota = (nota_parcialI + nota_parcialII + nota_parcialIII) / 3;
        notas_parciales = promedio_nota * 0.55;

        System.out.println("Ingresar la nota del examen final (entre 0 y 100):");
        nota_examenfinal = info.nextDouble();
        if(nota_examenfinal < 0 || nota_examenfinal > 100) {
            System.out.println("Ingresar una nota válida para el examen final (entre 0 y 100).");
            return;
        }
        nota_examenfinal = nota_examenfinal * 0.30;

        System.out.println("Ingresar la nota del trabajo final (entre 0 y 100):");
        trabajofinal = info.nextDouble();
        if(trabajofinal < 0 || trabajofinal > 100) {
            System.out.println("Ingresar una nota válida para el trabajo final (entre 0 y 100).");
            return;
        }
        trabajofinal = trabajofinal * 0.15;

        nota_total = notas_parciales + nota_examenfinal + trabajofinal;

        System.out.println("La nota final sera: " + nota_total);
    }
}
