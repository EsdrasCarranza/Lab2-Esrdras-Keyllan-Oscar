
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 50488
 */
class UsuarioInfo {

    private String usuario;
    private String nombre;
    private String edad;
    private String fecha;
    private String contraseña;
    private String genero;
    private boolean cuenta_activada;
   

    private static UsuarioInfo[] cuentas = new UsuarioInfo[100];
    private static int contador = 0;

    private seguidores seguidos;

    public UsuarioInfo(String usuario, String nombre, String edad, String fecha, String contraseña, String genero) {
        this.usuario = usuario;
        this.edad = edad;
        this.contraseña = contraseña;
        this.genero = genero;
        this.nombre = nombre;
        this.seguidos = new seguidores();
    }

    public String getusuario() {
        return usuario;
    }

    public String getedad() {
        return edad;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public String getnombre() {
        return nombre;
    }

    public String getgenero() {
        return genero;
    }

    public String getfecha() {
        return fecha;
    }

    public seguidores getSeguidos() {
        return seguidos;
    }

     public static UsuarioInfo getCuenta(int index) {
        if (index >= 0 && index < contador) {
            return cuentas[index];
        } else {
            return null;
        }
    }

    public static int getContador() {
        return contador;
    }

    public static void agregarCuenta(UsuarioInfo cuenta) {
        if (contador < cuentas.length) {
            cuentas[contador] = cuenta;
            contador++;
        }

    }

    public static boolean verificar_cuenta(String user) {

        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getusuario().equals(user)) {
             
                return true;
            }
        }
        return false;
    }
    

    public static void buscarUsuarios(String texto) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getusuario().contains(texto)) {
                System.out.println(cuentas[i].getusuario()); // Imprime los usuarios que coinciden
                encontrado = true;
            }
        }

    }

    public static String[] buscarUsuariosConSeguimiento(String texto, UsuarioInfo usuarioActual) {
        String[] resultados = new String[UsuarioInfo.getContador()];
        int count = 0;

        for (int i = 0; i < UsuarioInfo.getContador(); i++) {
            UsuarioInfo usuario = UsuarioInfo.getCuenta(i);
            if (usuario.getusuario().contains(texto)) {
                String estadoSeguimiento = usuarioActual.getSeguidos().loSigo(usuario) ? "(Siguiendo)" : "(No Siguiendo)";
                resultados[count] = usuario.getusuario() + " " + estadoSeguimiento;
                count++;
            }
        }

        return Arrays.copyOf(resultados, count);  // Ajustar el tamaño del arreglo
    }
}
   

