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
    private String  genero;
    
    private static UsuarioInfo[] cuentas = new UsuarioInfo[100];

    private static int contador = 0;
    
    public UsuarioInfo(String usuario,String nombre,String edad,String fecha,String contraseña,String genero){
        this.usuario=usuario;
        this.edad = edad;
        this.contraseña = contraseña;
        this.genero= genero;
        this.nombre=nombre;
    }
    public String getusuario(){
        return usuario;
    }
    public String getedad(){
        return edad;
    }
    public String getcontraseña(){
        return contraseña;
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getgenero(){
        return genero;
    }
    public String getfecha(){
        return fecha;
    }
     public static UsuarioInfo getCuenta(int index) {
        return cuentas[index];
    }

    public static int getContador() {
        return contador;
    }
    public static void agregarCuenta(UsuarioInfo cuenta){
        if(contador<cuentas.length){
            cuentas[contador]=cuenta;
            contador++;
        }
    
    }
    
    public static boolean verificar_cuenta(String user){
        for (int i = 0; i < contador; i++) {
            if(cuentas[i].getusuario().equals(user)){
                return true;
            }
        }
        return false;
    }
    
   
    
    
   
    
    
    
}
