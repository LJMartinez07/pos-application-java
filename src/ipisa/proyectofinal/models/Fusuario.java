package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;
import ipisa.proyectofinal.clases.Usuario;//Importamos la clase usuario para usar sus variables

public class Fusuario {
    
    public int insertUsu(Usuario u){//Creamos la variable de instancia
                String sql = "INSERT INTO usuarios(Usuario, Password, Acceso, Activo, EMPLEADOS_IdEmpleado)"+
                " VALUES ('"+u.getUsuario()+"','"+u.getPassword()+"','"+u.getAcceso()+"', default,"+u.getIdEmpleado()+")";
        return Conexion.guardarRegistro(sql);//Hacemos un insertar usando la variable de instancia para obtener los valores que queremos para que realice el proceso
            
       
    }
    
    
    
}
