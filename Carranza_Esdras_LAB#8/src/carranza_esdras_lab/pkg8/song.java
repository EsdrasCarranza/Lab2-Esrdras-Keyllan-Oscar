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
    private int numero_estrella;
    private int cant_views;
    
    
    public song(int codigo,String nombre,double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.numero_estrella = 0;
        this.cant_views = 0;
       
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

    public int getNumero_estrella() {
        return numero_estrella;
    }

    public int getCant_views() {
        return cant_views;
    }
    
    
    public void addstars(int estrellas){
        if(estrellas >= 1 && estrellas <= 5){
            cant_views++;
            numero_estrella += estrellas;
        }else{
            JOptionPane.showMessageDialog(null, "ingrese unicamente estrellas en el rango de 0 a 5");
        }
    }
    
    public double rating(){
        if(cant_views == 0){
            return 0;
        }
        return (double) numero_estrella /cant_views;
    }
    
    public void print(){
        System.out.println(codigo + " – " + nombre + " – " + precio + " – " + rating());
    }
    
}
