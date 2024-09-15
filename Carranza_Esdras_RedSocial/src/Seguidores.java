
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class Seguidores {
    private UsuarioInfo[] seguidos = new UsuarioInfo[100]; // Lista de usuarios seguidos
    private int cantidadSeguidos = 0;

    public void agregar(UsuarioInfo usuario) {
        if (cantidadSeguidos < seguidos.length) {
            seguidos[cantidadSeguidos] = usuario;
            cantidadSeguidos++;
        }
    }

    public void eliminar(UsuarioInfo usuario) {
        for (int i = 0; i < cantidadSeguidos; i++) {
            if (seguidos[i].equals(usuario)) {
                // Desplazar elementos
                for (int j = i; j < cantidadSeguidos - 1; j++) {
                    seguidos[j] = seguidos[j + 1];
                }
                seguidos[cantidadSeguidos - 1] = null;
                cantidadSeguidos--;
                break;
            }
        }
    }

    public boolean loSigo(UsuarioInfo usuario) {
        for (int i = 0; i < cantidadSeguidos; i++) {
            if (seguidos[i].equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public int cantidadSeguidos() {
        return cantidadSeguidos;
    }
    
}





//private UsuarioInfo usuario;
//    private UsuarioInfo[] seguidos = new UsuarioInfo[100]; // Perfiles que sigo
//    private UsuarioInfo[] seguidores = new UsuarioInfo[100]; // Perfiles que me siguen
//    private int contadorSeguidos = 0;
//    private int contadorSeguidores = 0;
//
//    public seguidores(UsuarioInfo usuario) {
//        this.usuario = usuario;
//    }
//
//    // Métodos para gestionar los perfiles que sigo
//    public void seguir(UsuarioInfo perfil) {
//        if (contadorSeguidos < seguidos.length) {
//            seguidos[contadorSeguidos] = perfil;
//            contadorSeguidos++;
//        }
//    }
//
//    public UsuarioInfo[] getSeguidos() {
//        return seguidos;
//    }
//
//    // Métodos para gestionar los perfiles que me siguen
//    public void agregarSeguidor(UsuarioInfo perfil) {
//        if (contadorSeguidores < seguidores.length) {
//            seguidores[contadorSeguidores] = perfil;
//            contadorSeguidores++;
//        }
//    }
//
//    public UsuarioInfo[] getSeguidores() {
//        return seguidores;
//    }
//
//    // Método para obtener la información del usuario
//    public UsuarioInfo getUsuario() {
//        return usuario;
//    }