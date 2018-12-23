/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import ipisa.proyectofinal.clases.DetalleFac;//Importamos la clase DetalleFac
import java.sql.Connection;//Importamos la Connection que trae sql
import java.sql.PreparedStatement;//Importamos el preparedStatement para poder ejecutar un sentencia
import java.sql.SQLException;//Importamos la exception de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para presentar un mensaje

/**
 *
 * @author Luis Martinez
 */
public class Ffactura {
    private Conexion mysql = new Conexion();//Establecemos una variable de la clase Conexion
    private Connection cn = mysql.conectar();//Esteblecemos la variable tipo Connection con un metodo hecho en conexion
    private String sSQL = "";
    private String sSQL2 = "";//Creamos dos variables tipo string par las sentencias
    
 
  
    public boolean insertarFac(DetalleFac f){//Creamos una variable de instancia de DetalleFac
           sSQL = "insert into facturas (FechaFac,subtotal, Total, Itebis,  PagoRecivido, Estado, CLIENTES_IdCliente, Usuarios_IdUsuario, MontoDeuda, Activo)"
                + "values (?,?,?,?,?,?,?,?,?,default)";//Creamos una sentencia para insertar los valores en facturas
          
           try {
            PreparedStatement pst = cn.prepareStatement(sSQL);//Preparamos las sentencia
            //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst.setString(1, f.getFormatearFecha(f.getFechaFac(), null));
            pst.setDouble(2, f.getSubTotal());
            pst.setDouble(3, f.getTotal());
            pst.setDouble(4, f.getItbis());
            pst.setDouble(5, f.getPagoRecivido());
            pst.setString(6, f.getEstado());
            pst.setInt(7, f.getNomCliente());
            pst.setInt(8, f.getNomUsuario());
            pst.setDouble(9, f.getMontoDeuda());
            pst.executeUpdate();//Se ejecuta lo que queremos tener para ingresarlo en las sentacia insert
            
            } catch (SQLException t) {

            
            return false;
        }
        return true;
    }
    public boolean InsertarDe (DetalleFac f){//Creamos otra variable de instancia de DetalleFac
        sSQL2 = "insert into detallefac (CantidadProdu, importe, Descuento,Productos_IdProducto, Activo, Facturas_IdFactura)"
                + "values (?,?,?,?,default,(select IdFactura from facturas order by IdFactura desc limit 1))";//Hacemos un insertar en detalle de factura donde cogera de forma automatica el id de factura al crearla
        try{
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);//Preparamos las sentencia
             //Seleccionamos los registros que vamos a darle insert representadas en los insert como signos de interogacion
            pst2.setInt(1, f.getCantidadProdu());
            pst2.setDouble(2, f.getImporte());
            pst2.setDouble(3, f.getDescuento());
            pst2.setInt(4, f.getIdProducto());
            pst2.executeUpdate();
            
            } catch (SQLException t) {

            JOptionPane.showMessageDialog(null, t);
            return false;
        }
        return true;
    }
    }

    
    