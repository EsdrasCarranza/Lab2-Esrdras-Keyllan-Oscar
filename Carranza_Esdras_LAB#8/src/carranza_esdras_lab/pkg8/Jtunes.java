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
public class Jtunes {
private song[] canciones;

    public Jtunes() {
        this.canciones = new song[40];
    }

    public song buscarRola(int codigo) {
    for (song cancion : canciones) {
        if (cancion != null && cancion.getCodigo() == codigo) {
            return cancion;
        }
    }
    return null;
}

    public boolean addSong(int codigo, String nombre, double precio) {
        if (buscarRola(codigo) != null) {
            
            return false;
        }
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] == null) {
                canciones[i] = new song(codigo, nombre, precio);
                
                return true;
            }
        }
        System.out.println("No hay espacio");
        return false;
    }

    public void rateSong(int codigo, int estrellas) {
        song cancion = buscarRola(codigo);
        if (cancion != null) {
            cancion.addStars(estrellas);
           
            cancion.print();
        } else {
            System.out.println("Error: Canción no existe");
        }
    }

    public void printSongs() {
        System.out.println("Lista de canciones:");
        for (song cancion : canciones) {
            if (cancion != null) {
                cancion.print();
            }
        }
    }
    
    }

