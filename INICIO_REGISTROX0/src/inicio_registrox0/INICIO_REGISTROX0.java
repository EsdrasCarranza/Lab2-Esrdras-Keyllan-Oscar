/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio_registrox0;

/**
 *
 * @author 50488
 */
public class INICIO_REGISTROX0 {

    private String nombre_jugador;
    private int puntos;
    private String username;
    private String contra;
    
    private static INICIO_REGISTROX0 infoJugadores [] = new INICIO_REGISTROX0[100];
    
    private static int contador = 0;
    
    public INICIO_REGISTROX0(String nombre_jugador,String username,String contra){
        this.nombre_jugador = nombre_jugador;
        this.puntos = puntos;
        this.username = username;
        this.contra = contra;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getUsername() {
        return username;
    }

    public String getContra() {
        return contra;
    }

    public static int getContador() {
        return contador;
    }
    
    public static INICIO_REGISTROX0 getCuenta(int index) {
        return infoJugadores[index];
    }
    
     public static void agregarCuenta(INICIO_REGISTROX0 cuenta){
        if(contador<infoJugadores.length){
            infoJugadores[contador]=cuenta;
            contador++;
        }
    
    }
     public static boolean verificar_cuenta(String user){
        for (int i = 0; i < contador; i++) {
            if(infoJugadores[i].getUsername().equals(user)){
                return true;
            }
        }
        return false;
    }
    
    
}
