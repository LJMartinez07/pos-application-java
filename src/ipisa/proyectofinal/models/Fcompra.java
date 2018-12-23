  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import ipisa.proyectofinal.clases.Producto;//Importamos la clase producto
import java.sql.Connection;//Importamos la Connection que trae sql
import java.sql.PreparedStatement;//Importamos el preparedStatement para poder ejecutar un sentencia
import java.sql.SQLException;//Importamos la exception de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para presentar un mensaje

/**
 *
 * @author Luis Martinez
 */
public class Fcompra {
    private Conexion mysql = new Conexion();//Establecemos una variable de la clase Conexion
    private Connection cn = mysql.conectar();//Esteblecemos la variable tipo Connection con un metodo hecho en conexion
    private String sSQL = "";//Creamos una variable tipo string par las sentencia
    
 
  
    public boolean insertarPro(Producto p){//Creamos una variable de instancia de Producto
           sSQL = "insert into productos (IdProducto, NombrePro, DescripcionPro, PrecioVenta, PrecioCompra, CantidadProdu, FechaCompra, FechaVenci, CATEGORIAS_IdCategoria, SUPLIDORES_IdSupli)"
                + "values (?,?,?,?,?,?,?,?,?,?)";//Hacemos una sentencia mysql para insertar en la tabla producto
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);//Preparamos las sentencias
   
            //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst.setInt(1, p.getIdProducto());
            pst.setString(2, p.getNombrePro());
            pst.setString(3, p.getDescripcionPro());
            pst.setDouble(4, p.getPrecioVenta());
            pst.setDouble(5, p.getPrecioCompra());
            pst.setInt(6, p.getCantidadProdu());
            pst.setString(7, p.getFormatearFecha(p.getFechaCompra(), null));
            pst.setString(8, p.getFormatearFecha(p.getFechaVenci(), null));
            pst.setInt(9, p.getNumCatego());
            pst.setInt(10, p.getNumSupli());
            pst.executeUpdate();//Se ejecuta lo que queremos tener para ingresarlo en las sentacia insert

        } catch (SQLException t) {

            JOptionPane.showMessageDialog(null, t);
            return false;
        }
        return true;
    }
    
    public int actualizar(Producto datos){//Creamos una variable 
        
        String sql = "UPDATE Productos set CantidadProdu = CantidadProdu +"+datos.getCantidadProdu()+
                ", FechaCompra = '"+datos.getFormatearFecha(datos.getFechaCompra(), null)+"'"+
                ", FechaVenci = '"+datos.getFormatearFecha(datos.getFechaVenci(), null)+"'"+
                " Where IdProducto = "+datos.getIdProducto();
        //Creamos una sentencia mysql para editar los campos de la tabla seleccionada
        return Conexion.guardarRegistro(sql);//Retornamos el valor de los campos
        
    }
 
    }

    

       
    
    

