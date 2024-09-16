
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private static final int MAX_HASHTAGS = 100;
    private Twit[] hashtags = new Twit[MAX_HASHTAGS];
    private int contadorHashtags = 0;

    private Twit[] twits = new Twit[100]; // Arreglo para almacenar tweets
    private int contadorTwits = 0;
    private Twit[] menciones = new Twit[100];
    private int contadorMenciones = 0;

    private static UsuarioInfo[] cuentas = new UsuarioInfo[100];
    private static int contador = 0;

    private seguidores seguidos; // Clase que maneja los usuarios seguidos

    public UsuarioInfo(String usuario, String nombre, String edad, String fecha, String contraseña, String genero) {
        this.usuario = usuario;
        this.edad = edad;
        this.contraseña = contraseña;
        this.genero = genero;
        this.nombre = nombre;
        this.seguidos = new seguidores(); // Inicialización de la lista de seguidos
        this.cuenta_activada = true;
        this.twits = new Twit[100];
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

    public seguidores getSeguidos() {
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

    public void mandarTweet(String contenido) {
        if (!isCuentaActiva()) {
            System.out.println("No puedes enviar tweets con una cuenta desactivada.");
            return;
        }

        if (contenido.length() > 140) {
            System.out.println("El tweet no puede exceder los 140 caracteres.");
            return;
        }

        if (contadorTwits < twits.length) {
            Twit nuevoTwit = new Twit(this.usuario, contenido);
            twits[contadorTwits] = nuevoTwit;
            contadorTwits++;

            // Procesar mención y hashtags
            procesarMencionYHashtags(nuevoTwit);

            // Notificar a los seguidores
            notificarSeguidores(nuevoTwit);

            System.out.println("Tweet enviado exitosamente.");
        } else {
            System.out.println("Límite de tweets alcanzado.");
        }
    }

    private void notificarSeguidores(Twit twit) {
        UsuarioInfo[] seguidoresArray = seguidos.obtenerSeguidos();
        for (int i = 0; i < seguidoresArray.length; i++) {
            if (seguidoresArray[i] != null && seguidoresArray[i].isCuentaActiva()) {
                seguidoresArray[i].agregarTwit(twit);
            }
        }
    }

    public void agregarTwit(Twit twit) {
        if (contadorTwits < twits.length) {
            twits[contadorTwits] = twit;
            contadorTwits++;
        }
    }

    public Twit[] obtenerTwits() {
        Twit[] twitsActivos = new Twit[contadorTwits];
        System.arraycopy(twits, 0, twitsActivos, 0, contadorTwits);
        return twitsActivos;
    }

    public int getContadorTwits() {
        return contadorTwits;
    }

    public String[] obtenerTimeline() {
        Set<Twit> todosTwitsSet = new LinkedHashSet<>(); // Usar LinkedHashSet para evitar duplicados y mantener el orden
        todosTwitsSet.addAll(Arrays.asList(obtenerTwits())); // Añadir los tweets propios

        UsuarioInfo[] seguidoresArray = seguidos.obtenerSeguidos();
        for (int i = 0; i < seguidoresArray.length; i++) {
            if (seguidoresArray[i] != null && seguidoresArray[i].isCuentaActiva() && !seguidoresArray[i].getusuario().equals(this.getusuario())) {
                todosTwitsSet.addAll(Arrays.asList(seguidoresArray[i].obtenerTwits()));
            }
        }

        // Convertir el set a un array y ordenar del más reciente al más viejo
        Twit[] todosTwits = todosTwitsSet.toArray(new Twit[0]);
        Arrays.sort(todosTwits, (t1, t2) -> t2.getFecha().compareTo(t1.getFecha())); // Ordenar en orden descendente

        // Convertir a arreglo de String para mostrar
        String[] timeline = new String[todosTwits.length];
        for (int i = 0; i < todosTwits.length; i++) {
            timeline[i] = todosTwits[i].toString();
        }

        return timeline;
    }

    public String[] obtenerInteracciones() {
        int totalTwits = UsuarioInfo.getContador() * 100; // Estimación alta

        Twit[] interacciones = new Twit[totalTwits];
        int index = 0;

        // Buscar en todos los tweets de todos los usuarios
        for (int i = 0; i < UsuarioInfo.getContador(); i++) {
            UsuarioInfo usuario = UsuarioInfo.getCuenta(i);
            if (usuario.isCuentaActiva()) { // Solo considerar usuarios activos
                Twit[] twitsUsuario = usuario.obtenerTwits();
                for (Twit twit : twitsUsuario) {
                    if (twit.getContenido().contains("@" + this.usuario)) {
                        interacciones[index++] = twit;
                    }
                }
            }
        }

        // Ordenar por fecha (más reciente primero)
        Arrays.sort(interacciones, 0, index, (t1, t2) -> t2.getFecha().compareTo(t1.getFecha()));

        // Convertir a arreglo de String para mostrar
        String[] interaccionesStr = new String[index];
        for (int i = 0; i < index; i++) {
            interaccionesStr[i] = interacciones[i].toString();
        }

        return interaccionesStr;
    }

    public void agregarMencion(Twit twit) {
        if (contadorMenciones < menciones.length) {
            menciones[contadorMenciones] = twit;
            contadorMenciones++;
        }
    }

   public Twit[] obtenerMenciones() {
    if (!isCuentaActiva()) {
        // Si la cuenta está desactivada, devolver un arreglo vacío
        return new Twit[0];
    }
    
    // Si la cuenta está activa, devolver las menciones
    Twit[] mencionesActivas = new Twit[contadorMenciones];
    System.arraycopy(menciones, 0, mencionesActivas, 0, contadorMenciones);
    return mencionesActivas;
}

    private void procesarMencionYHashtags(Twit twit) {
        String contenido = twit.getContenido();

        if (!isCuentaActiva()) {
            System.out.println("No se procesarán menciones ni hashtags porque la cuenta está desactivada.");
            return;
        }

        // Procesar menciones
        if (contenido.contains("@")) {
            String[] palabras = contenido.split(" ");
            for (String palabra : palabras) {
                if (palabra.startsWith("@")) {
                    String mencionado = palabra.substring(1); // Quitar el "@"
                    
                    // Obtener información del usuario mencionado
                    UsuarioInfo mencionadoUsuario = Gestion_Cuenta.obtenerInformacion(mencionado);
                    
                    if (mencionadoUsuario != null && mencionadoUsuario.isCuentaActiva()) {
                        mencionadoUsuario.agregarMencion(twit);
                        System.out.println("El usuario @" + mencionado + " ha sido mencionado.");
                    } else {
                        System.out.println("El usuario @" + mencionado + " no existe o tiene su cuenta desactivada.");
                    }
                }
            }
        }

        // Procesar hashtags
        if (contenido.contains("#")) {
            String[] palabras = contenido.split(" ");
            for (String palabra : palabras) {
                if (palabra.startsWith("#")) {
                    if (contadorHashtags < hashtags.length) {
                        hashtags[contadorHashtags] = twit;
                        contadorHashtags++;
                        System.out.println("El tweet contiene el hashtag " + palabra);
                    }
                }
            }
        }
    }

    public Twit[] obtenerTweetsPorHashtag(String hashtag) {
        Twit[] resultados = new Twit[MAX_HASHTAGS];
        int contadorResultados = 0;

        for (int i = 0; i < contadorHashtags; i++) {
            if (hashtags[i].getContenido().contains(hashtag)) {
                resultados[contadorResultados] = hashtags[i];
                contadorResultados++;
            }
        }

        // Convertir a un arreglo de tamaño exacto
        Twit[] tweetsFiltrados = new Twit[contadorResultados];
        System.arraycopy(resultados, 0, tweetsFiltrados, 0, contadorResultados);

        return tweetsFiltrados;
    }

    public Twit[] obtenerHashtags() {
        if (!isCuentaActiva()) {
            System.out.println("La cuenta está desactivada. No se mostrarán hashtags.");
            return new Twit[0]; // Devuelve un arreglo vacío si la cuenta está desactivada
        }

        Twit[] hashtagsActivos = new Twit[contadorHashtags];
        System.arraycopy(hashtags, 0, hashtagsActivos, 0, contadorHashtags);
        return hashtagsActivos;
    }

    public Twit[] getHashtagsVisibles() {
        if (!isCuentaActiva()) {
            return new Twit[0];
        }
        return Arrays.copyOf(hashtags, contadorHashtags);
    }

    public Twit[] getMencionesVisibles() {
        if (!isCuentaActiva()) {
            return new Twit[0];
        }
        return Arrays.copyOf(menciones, contadorMenciones);
    }

    // Métodos de activación y desactivación de cuenta
    
}
