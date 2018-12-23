/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import ipisa.proyectofinal.clases.Suplidores;//Importamos la clase suplidores
import java.sql.Connection;//Importamos la Connection que trae sql
import java.sql.PreparedStatement;//Importamos el preparedStatement para poder ejecutar un sentencia
import java.sql.SQLException;//Importamos la exception de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para presentar un mensaje

/**
 *
 * @author junio
 */
public class Fsuplidores {
    private Conexion mysql = new Conexion();//Establecemos una variable de la clase Conexion
    private Connection cn = mysql.conectar();//Esteblecemos la variable tipo Connection con un metodo hecho en conexion
    private String sSQL = "";
    private String sSQL2 = "";//Creamos una variable tipo string par las sentencia
    
 
  
    public boolean insertar(Suplidores s){//Creamos una variable de instancia de suplidores
           sSQL = "insert into personas (Nombre, Apellido, Genero, Direccion, Telefono, Celular, Cedula, FechaReg)"
                + "values (?,?,?,?,?,?,?,?)";//Hacemos un insertar en personas

           sSQL2 = "insert into suplidores (Empresa, Prestablecimiento, Activo, PERSONAS_IdPersona)"
                + " values(?, ?, default, (select IdPersona from personas order by IdPersona desc limit 1))";//Hacemos un insertar en suplidores donde cogera de forma automatica el id de persona al crearla
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);//Preparamos las sentencias
            
            //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst.setString(1, s.getNombre());
            pst.setString(2, s.getApellido());
            pst.setObject(3, s.getGenero());
            pst.setString(4, s.getDireccion());
            pst.setString(5, s.getTelefono());
            pst.setString(6, s.getCelular());
            pst.setString(7, s.getCedula());
            pst.setString(8,s.getFormatearFecha(s.getFechaReg(), null));

            pst2.setString(1, s.getEmpresa());
            pst2.setString(2, s.getPrestablecimiento());
            
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
  
  public int Borrar(int s) {//Creamos una variable 
            String p = "UPDATE Suplidores"+ 
                  " SET Activo = 'Desactivo' Where IdCliente = "+ s;
    //Hacemos un update para cambiar el activo de la persona para poner si lo esta o cambio a no estarlo
          return Conexion.guardarRegistro(p);//Retornamos el valor de la sentencia
      }
    
    
}
