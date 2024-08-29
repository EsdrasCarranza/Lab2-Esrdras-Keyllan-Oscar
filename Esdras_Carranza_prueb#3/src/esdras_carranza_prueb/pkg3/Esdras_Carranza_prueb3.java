/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esdras_carranza_prueb.pkg3;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author 50488
 */
public class Esdras_Carranza_prueb3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         String palabras[] = { "radar", "level", "world", "civic", "java", "deified", "python", "rotor", "language", "madam", "refer", "stats", "noon", "hello", "moon", "wow", "racecar", "kayak", "apple", "deed" };
         
         Scanner info = new Scanner(System.in);
         Random random = new Random();
         
         int valor_arreglos = 0;
         
         
         System.out.println("Lista de palabras: ");
         
         for (int i = 0; i < palabras.length; i++) {
             System.out.println("[ " + i + " ]: " + palabras[i]);
            
        }
             System.out.println("Ingrese ahora el tamano de los arreglos");
             valor_arreglos = info.nextInt();
             
            
         
         
         
         String arreglo_b []= new String[valor_arreglos];
         String arreglo_a [] = new String[valor_arreglos];
        
         System.out.println("Lista palabras a");
         for (int j = 0; j < valor_arreglos; j++) {
             int indice_palabrasa = random.nextInt(palabras.length);
             
             arreglo_a [j] = palabras[indice_palabrasa];
             
            
             System.out.println("[ " + j + " ]:" +arreglo_a [j]);   
        }
         System.out.println(" ");
         System.out.println("Lista de palabras B");
         for (int k = 0; k < 10; k++) {
            int indice_palabrasb = random.nextInt(palabras.length);
            arreglo_b[k] =palabras[indice_palabrasb];
            
             System.out.println("[ " + k + " ]:" + arreglo_b[k]);
        }
        
    }
    
}
