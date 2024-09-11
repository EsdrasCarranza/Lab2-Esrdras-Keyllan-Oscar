/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class user_actual {
     private static UsuarioInfo usuarioActual;  // Variable global para el usuario actual

    public static UsuarioInfo getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(UsuarioInfo usuario) {
        usuarioActual = usuario;
    }

   
}

