/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class seguidores {
    
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
    
    // Nuevo método para obtener el arreglo de usuarios seguidos
    public UsuarioInfo[] obtenerSeguidos() {
        UsuarioInfo[] seguidosActivos = new UsuarioInfo[cantidadSeguidos];
        System.arraycopy(seguidos, 0, seguidosActivos, 0, cantidadSeguidos);
        return seguidosActivos;
    }
}

