package ipisa.proyectofinal.models;


import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import ipisa.proyectofinal.clases.Empleado;//Importamos la clase empleado
import java.sql.Connection;//Importamos la Connection que trae sql
import java.sql.PreparedStatement;//Importamos el preparedStatement para poder ejecutar un sentencia
import java.sql.SQLException;//Importamos la exception de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para presentar un mensaje


public class Fempleado {
 private Conexion mysql = new Conexion();//Establecemos una variable de la clase Conexion
    private Connection cn = mysql.conectar();//Esteblecemos la variable tipo Connection con un metodo hecho en conexion
    private String sSQL = "";
    private String sSQL2 = "";//Creamos dos variables tipo string par las sentencias
    
 
  
    public boolean insertar(Empleado e){//Creamos una variable de instancia de empleado
           sSQL = "insert into personas (Nombre, Apellido, Genero, Direccion, Telefono, Celular, Cedula, FechaReg)"
                + "values (?,?,?,?,?,?,?,?)";//Hacemos un insertar en personas

           sSQL2 = "insert into empleados (Puesto, Sueldo, Activo, PERSONAS_IdPersona)"
                + " values(?, ?, default, (select IdPersona from personas order by IdPersona desc limit 1))";//Hacemos un insertar en empleado donde cojera de forma automatica el id de persona al crearla 
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);//Preparamos las sentencias
            //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst.setString(1, e.getNombre());
            pst.setString(2, e.getApellido());
            pst.setObject(3, e.getGenero());
            pst.setString(4, e.getDireccion());
            pst.setString(5, e.getTelefono());
            pst.setString(6, e.getCelular());
            pst.setString(7, e.getCedula());
            pst.setString(8, e.getFormatearFecha(e.getFechaReg(),null));
           

            pst2.setString(1, e.getPuesto());
            pst2.setDouble(2, e.getSueldo());
            
            
            //Realizamos una condicion para la realizacion de los dos inserts
            int N = pst.executeUpdate();
            if (N != 0) {

                int N2 = pst2.executeUpdate();

                if (N2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (SQLException t) {

            JOptionPane.showMessageDialog(null, t);
            return false;
        }
    }
  
  
      public int actualizarC(Empleado e) {//Creamos una variable de instancia
     String SQL = "UPDATE empleados "+ 
            " SET Puesto = '"+e.getPuesto()+"'"+
            ", Sueldo = "+e.getSueldo()+
            " Where IdEmpleado = "+e.getIdEmpleado();
     //Creamos una sentencia mysql para editar los campos de la tabla seleccionada
     return Conexion.guardarRegistro(SQL);//Retornamos el valor de los campos
      
  }
      
      public int BorrarEmpl(int e){//Creamos una variable 
          
          String sql = "UPDATE Empleados Set Activo = 'Desactivo' Where IdEmpleado ="+e;
          //Hacemos un update para cambiar el activo de la persona para poner si lo esta o cambio a no estarlo
     return Conexion.guardarRegistro(sql);//Retornamos el valor de la sentencia
          
      }
}
