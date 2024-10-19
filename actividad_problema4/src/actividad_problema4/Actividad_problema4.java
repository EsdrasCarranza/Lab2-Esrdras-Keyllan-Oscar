/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_problema4;

import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Actividad_problema4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner (System.in);
        info.useDelimiter("\n");
        
        int ganados = 0,perdidos=0,empatados=0,puntos = 0;
        
        System.out.println("Ingresar los partidos ganados");
        ganados = info.nextInt();
        System.out.println("Ingresar los partidos empatados");
        empatados = info.nextInt();
        System.out.println("Ingresar los partidos perdidos");
        perdidos = info.nextInt();
        
        if(ganados< 0|| perdidos<0|| empatados <0){
            System.out.println("no se pueden ingresar valores negativos");
        }
        
        ganados = ganados*3;
        perdidos = 0;
        
        puntos = ganados+empatados;
        System.out.println("Los puntos totales: " + puntos);
    }
    
}
