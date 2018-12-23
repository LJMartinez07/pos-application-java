/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.tablemodels;

import ipisa.proyectofinal.clases.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junio
 */
//Realiza el mismo proceso que la clase TableModelsCategoria ver para referencia
public class TableModelsDetalleFac {
    
    public boolean isNumeric(String cadena) {//Si la cadena tiene numero que lo convierta a integer
        try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    String[] titulos = {"Producto", "Cantidad del Producto","Importe","Descuento", "Total"};
    String[] registros = new String[5];
    
    
    public DefaultTableModel mostrarFac(JTable table, String buscar) {
        DefaultTableModel modelo;

        modelo = new DefaultTableModel(null, titulos);

        try {
            //Selecciona los campos donde se relacionen con factura y productos y donde la ultima condicion sea igual que buscar
                ResultSet Rc= Conexion.getRegistros("SELECT * FROM  Detallefac ,facturas, Productos where DetalleFac.Activo = 'Activo' and DetalleFac.Activo = Facturas.Activo and facturas.IdFactura = Detallefac.FACTURAS_IdFactura and DetalleFac.Productos_IdProducto = Productos.IdProducto and DetalleFac.Facturas_IdFactura = "+buscar+"");

                while (Rc.next()) {

                    registros[0] = Rc.getString("NombrePro");
                    registros[1] = Rc.getString("DetalleFac.CantidadProdu");
                    registros[2] = Rc.getString("importe");
                    registros[3] = Rc.getString("Descuento");
                    registros[4] = Rc.getString("Total");


                    modelo.addRow(registros);
                   
                }
               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e+"Error de registro producto");
            return null;
        } 

        table.setModel(modelo);
        return modelo;

    }
      public DefaultTableModel initTable(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            //Hacemos un select de todo lo que se relacione con factura y producto
             String q = "SELECT * FROM DetalleFac,facturas,Productos where DetalleFac.Activo = 'Activo' and DetalleFac.Facturas_Idfactura = Facturas.IdFactura and Detallefac.Productos_IdProducto = Productos.IdProducto";
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                    registros[0] = rs.getString("NombrePro");
                    registros[1] = rs.getString("DetalleFac.CantidadProdu");
                    registros[2] = rs.getString("importe");
                    registros[3] = rs.getString("Descuento");
                    registros[4] = rs.getString("Total");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table.setModel(modelo);
        return modelo;
    }
}
