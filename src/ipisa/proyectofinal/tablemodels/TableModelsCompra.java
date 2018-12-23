/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.tablemodels;

import ipisa.proyectofinal.clases.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Martinez
 */
public class TableModelsCompra {
    
    String[] Titulos = {"ID", "Nombre del producto", "Descripcion", "Precio de venta ", "Precio de Compra", "Cantidad"};
    String[] Registro = new String[6];
    
    public DefaultTableModel Excaso(JTable table){
        DefaultTableModel model;
        
         model = new DefaultTableModel(null, Titulos);
         
         try {
            
             ResultSet fp = Conexion.getRegistros("Select * from productos where CantidadProdu = 0");
             
             while (fp.next()) {

                 Registro[0] = fp.getString("IdProducto");
                 Registro[1] = fp.getString("NombrePro");
                 Registro[2] = fp.getString("DescripcionPro");
                 Registro[3] = fp.getString("PrecioVenta");
                 Registro[4] = fp.getString("PrecioCompra");
                 Registro[5] = fp.getString("CantidadProdu");
                 
                 model.addRow(Registro);
                 
             }
        } catch (SQLException e) {
        }
        table.setModel(model);
        return model;
        
        
    }
    public DefaultTableModel Busqueda(JTable table, String bus){
        DefaultTableModel model;
        
         model = new DefaultTableModel(null, Titulos);
         
         try {
            
             ResultSet fp = Conexion.getRegistros("Select * from productos where SUPLIDORES_IdSupli ="+bus);
             
             while (fp.next()) {

                 Registro[0] = fp.getString("IdProducto");
                 Registro[1] = fp.getString("NombrePro");
                 Registro[2] = fp.getString("DescripcionPro");
                 Registro[3] = fp.getString("PrecioVenta");
                 Registro[4] = fp.getString("PrecioCompra");
                 Registro[5] = fp.getString("CantidadProdu");
                 
                 model.addRow(Registro);
                 
             }
        } catch (SQLException e) {
        }
        table.setModel(model);
        return model;
        
        
    }
}
