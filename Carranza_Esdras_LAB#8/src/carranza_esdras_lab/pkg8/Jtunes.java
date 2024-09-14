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
    
    
    public Jtunes (){
        this.canciones = new song [40];
    }
    
    public song buscarrola(int codigo) {
        for (song cancion : canciones) {
            if (cancion != null && cancion.getCodigo() == codigo) {
                return cancion; 
            }
        }
        return null; 
    }
    public boolean addSong(int codigo, String nombre, double precio) {
        
        if (buscarrola(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Error cancion ya existe");
            return false;
        }
         for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] == null) {
                canciones[i] = new song(codigo, nombre, precio); 
                JOptionPane.showMessageDialog(null, "cancion agregada: " + nombre);
                return true;
            }
        }
         
         JOptionPane.showMessageDialog(null, "NO HAY ESPACIO");
        return false; 
    }
    
    public void ratesong(int codigo ,int estrellas ){
        song cancion = buscarrola(codigo);
        if(cancion != null){
            cancion.addstars(estrellas);
            JOptionPane.showMessageDialog(null, "ESTRELLAS ACTUALIZADAS");
            cancion.print();
        }else{
            JOptionPane.showMessageDialog(null,"Error. Cancion no existe");
        }
    }
    
    public void printSong(){
        
    }
    
        
}
