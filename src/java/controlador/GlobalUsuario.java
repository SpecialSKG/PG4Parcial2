
package controlador;
public class GlobalUsuario {
    public static String USUARIO = "";
    
    public static String getUSUARIO(){
        return GlobalUsuario.USUARIO;
    }
    
    public static void setUSUARIO(String USUARIO){
        GlobalUsuario.USUARIO = USUARIO;
    }
}
