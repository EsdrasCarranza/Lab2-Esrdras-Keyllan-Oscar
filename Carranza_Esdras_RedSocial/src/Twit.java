/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50488
 */

  import java.text.SimpleDateFormat;
import java.util.Date;

public class Twit {
    private String usuario; // Nombre del usuario que publicó el tweet
    private String contenido; // Contenido del tweet
    private String fecha; // Fecha en que se publicó

    public Twit(String usuario, String contenido) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return usuario + " escribió: \"" + contenido + "\" el [" + fecha + "]";
    }
}


