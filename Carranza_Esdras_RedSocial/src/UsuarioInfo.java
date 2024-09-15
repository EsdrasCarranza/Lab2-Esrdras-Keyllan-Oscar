
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 50488
 */
public class UsuarioInfo {
    private String usuario;
    private String nombre;
    private String edad;
    private String fecha;
    private String contraseña;
    private String genero;
    private boolean cuenta_activada;
    private int seguidores = 0;

    private static UsuarioInfo[] cuentas = new UsuarioInfo[100];
    private static int contador = 0;

    private Seguidores seguidos; // Clase que maneja los usuarios seguidos

    public UsuarioInfo(String usuario, String nombre, String edad, String fecha, String contraseña, String genero) {
        this.usuario = usuario;
        this.edad = edad;
        this.contraseña = contraseña;
        this.genero = genero;
        this.nombre = nombre;
        this.seguidos = new Seguidores(); // Inicialización de la lista de seguidos
        this.cuenta_activada = true; 
    }
     // Método para desactivar cuenta
    public void desactivarCuenta() {
        cuenta_activada = false;
    }

    // Método para activar cuenta
    public void activarCuenta() {
        cuenta_activada = true;
    }

    // Método para verificar si la cuenta está activa
    public boolean isCuentaActiva() {
        return cuenta_activada;
    }

    // Métodos de acceso a los atributos
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

    public Seguidores getSeguidos() {
        return seguidos;
    }
   

    public int getSeguidores() {
        return seguidores;
    }
 public void incrementarSeguidores() {
        seguidores++;
    }

    public void decrementarSeguidores() {
        if (seguidores > 0) {
            seguidores--;
        }
    }

    public void seguirUsuario(UsuarioInfo usuarioASeguir) {
    if (!this.equals(usuarioASeguir) && !seguidos.loSigo(usuarioASeguir)) {
        seguidos.agregar(usuarioASeguir); // Agregar a la lista de seguidos del usuario actual
        usuarioASeguir.incrementarSeguidores(); // Incrementar seguidores solo del usuario seguido
    }
    // Llamar al método que actualiza la interfaz
    
}

    public void dejarDeSeguir(UsuarioInfo usuarioADejarDeSeguir) {
    if (seguidos.loSigo(usuarioADejarDeSeguir)) {
        seguidos.eliminar(usuarioADejarDeSeguir); // Eliminar de la lista de seguidos del usuario actual
        usuarioADejarDeSeguir.decrementarSeguidores(); // Decrementar seguidores solo del usuario seguido
    }
    // Llamar al método que actualiza la interfaz
    
}

    // Métodos estáticos para el manejo de cuentas
    public static UsuarioInfo obtenerUsuarioPerfil(String nombreUsuario) {
        for (int i = 0; i < contador; i++) {
            UsuarioInfo usuario = cuentas[i];
            if (usuario.getusuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }

    public static UsuarioInfo getCuenta(int index) {
        if (index >= 0 && index < contador) {
            return cuentas[index];
        } else {
            return null; // Índice fuera de rango
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
        return false; // Usuario no encontrado
    }

    public static void buscarUsuarios(String texto) {
    boolean encontrado = false;
    for (int i = 0; i < contador; i++) {
        UsuarioInfo usuario = cuentas[i];
        if (usuario.getusuario().contains(texto) && usuario.isCuentaActiva()) {
            System.out.println(usuario.getusuario());
            encontrado = true;
        }
    }
    if (!encontrado) {
        System.out.println("No se encontraron usuarios activos.");
    }
}

    public static String[] buscarUsuariosConSeguimiento(String texto, UsuarioInfo usuarioActual) {
    // Contador para el número de resultados encontrados
    int contadorResultados = 0;
    
    // Arreglo fijo para almacenar los resultados (puedes ajustar el tamaño si es necesario)
    String[] resultadosTemp = new String[getContador()];
    
    for (int i = 0; i < getContador(); i++) {
        UsuarioInfo cuenta = getCuenta(i);
        
        // Verifica si el nombre del usuario contiene el texto buscado y si la cuenta está activa
        if (cuenta.getusuario().contains(texto) && cuenta.isCuentaActiva()) {
            // Verifica si el usuario actual sigue a esta cuenta
            String estado = usuarioActual.getSeguidos().loSigo(cuenta) ? "Sigues" : "No sigues";
            
            // Añadir el resultado al arreglo temporal
            resultadosTemp[contadorResultados] = cuenta.getusuario() + " - " + estado;
            contadorResultados++;
        }
    }
    
    // Crear un arreglo final con el tamaño adecuado
    String[] resultados = new String[contadorResultados];
    System.arraycopy(resultadosTemp, 0, resultados, 0, contadorResultados);
    
    return resultados;
}
}

   

