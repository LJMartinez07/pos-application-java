
package ipisa.proyectofinal.clases;

public class Usuario extends Empleado{
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql
    private int IdUsuario;
    private String Usuario;
    private String Password;
    private String Acceso;
    private String Estado;

    //Creamos un constructor de esas variables
    public Usuario(int IdUsuario, String Usuario, String Password, String Acceso, String Estado) {
        this.IdUsuario = IdUsuario;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Acceso = Acceso;
        this.Estado = Estado;
    }

    //Creamos un Constructor vacio
    public Usuario() {
    }
    
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String Acceso) {
        this.Acceso = Acceso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

   
    
}
