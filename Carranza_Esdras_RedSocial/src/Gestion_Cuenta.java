/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class Gestion_Cuenta {
   public boolean verificar(String user) {
        int contador = UsuarioInfo.getContador();
        for (int i = 0; i < contador; i++) {
            UsuarioInfo cuenta = UsuarioInfo.getCuenta(i);
            if (cuenta.getusuario().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public UsuarioInfo obtenerInformacion(String user) {
        int contador = UsuarioInfo.getContador();
        for (int i = 0; i < contador; i++) {
            UsuarioInfo cuenta = UsuarioInfo.getCuenta(i);
            if (cuenta.getusuario().equals(user)) {
                return cuenta;
            }
        }
        return null;
    }
}




