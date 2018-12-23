/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Cliente;//Importamos la clase cliente
import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import java.sql.Connection;//Importamos la Connection que trae sql
import java.sql.PreparedStatement;//Importamos el preparedStatement para poder ejecutar un sentencia
import java.sql.SQLException;//Importamos la exception de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para presentar un mensaje

/**
 *
 * @author junio
 */
public class Fcliente{
    
    
    private Conexion mysql = new Conexion();//Establecemos una variable de la clase Conexion
    private Connection cn = mysql.conectar();//Esteblecemos la variable tipo Connection con un metodo hecho en conexion
    private String sSQL = "";
    private String sSQL2 = "";//Creamos dos variables tipo string par las sentencias
    
 
  
    public boolean insertar(Cliente c){//Creamos una variable de instancia de cliente
           sSQL = "insert into personas (Nombre, Apellido, Genero, Direccion, Telefono, Celular, Cedula, FechaReg)"
                + "values (?,?,?,?,?,?,?,?)";//Hacemos un insertar en personas

           sSQL2 = "insert into clientes (Creditos, Activo, PERSONAS_IdPersona)"
                + " values(?, default, (select IdPersona from personas order by IdPersona desc limit 1))";//Hacemos un insertar en cliente donde cogera de forma automatica el id de persona al crearla
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);//Preparamos las sentencias
            //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.setObject(3, c.getGenero());
            pst.setString(4, c.getDireccion());
            pst.setString(5, c.getTelefono());
            pst.setString(6, c.getCelular());
            pst.setString(7, c.getCedula());
            pst.setString(8, c.getFormatearFecha(c.getFechaReg(), null));
            

            pst2.setDouble(1, c.getCreditos());
            
            
            
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

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
  
  
  public int actualizarC(Cliente c) {//Creamos una variable de instancia
      sSQL = "UPDATE clientes"+ 
            " SET Creditos = "+c.getCreditos()+
            " WHERE IdCliente = "+c.getIdCliente();
      //Creamos una sentencia mysql para editar los campos de la tabla seleccionada
        return Conexion.guardarRegistro(sSQL);//Retornamos el valor de los campos
     
}
   
        public int Borrar(int c) {//Creamos una variable 
            String p = "UPDATE clientes"+ 
                  " SET Activo = 'Desactivo' Where IdCliente = "+ c;
            //Hacemos un update para cambiar el activo de la persona para poner si lo esta o cambio a no estarlo
          return Conexion.guardarRegistro(p);//Retornamos el valor de la sentencia
      }
}