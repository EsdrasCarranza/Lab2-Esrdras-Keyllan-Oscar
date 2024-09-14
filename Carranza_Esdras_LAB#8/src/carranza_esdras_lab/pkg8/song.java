/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carranza_esdras_lab.pkg8;
import javax.swing.JOptionPane;
/**
 *
 * @author 50488
 */
public class song {
   private int codigo;
    private String nombre;
    private double precio;
    private int sumaEstrellas;
    private int cantidadReviews;

    public song(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.sumaEstrellas = 0;
        this.cantidadReviews = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void addStars(int stars) {
        if (stars >= 0 && stars <= 5) {
            sumaEstrellas += stars;
            cantidadReviews++;
        } else {
            System.out.println("Error: La cantidad de estrellas debe estar entre 0 y 5");
        }
    }

    public double songRating() {
        if (cantidadReviews == 0) {
            return 0;
        }
        return (double) sumaEstrellas / cantidadReviews;
    }

    public void print() {
        System.out.printf("CÓDIGO: %d - NOMBRE: %s - PRECIO: %.2f - RATING: %.2f%n", codigo, nombre, precio, songRating());
    }
    
}
