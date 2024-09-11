/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class seguidores {
   
 private UsuarioInfo[] seguidos = new UsuarioInfo[100];
    private int contadorSeguidos = 0;

    

    public void seguirUsuario(UsuarioInfo usuario) {
        if (contadorSeguidos < seguidos.length) {
            seguidos[contadorSeguidos] = usuario;
            contadorSeguidos++;
        }
    }

    public boolean loSigo(UsuarioInfo usuario) {
        for (int i = 0; i < contadorSeguidos; i++) {
            if (seguidos[i].equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public UsuarioInfo[] obtenerSeguidos() {
        return seguidos;
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