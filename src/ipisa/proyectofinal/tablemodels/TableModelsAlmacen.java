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
public class TableModelsAlmacen {
    
    public DefaultTableModel mostrarAl(JTable table){
        DefaultTableModel modelo;
        
        String[] titulos = {"Nombre", "Cantidad"};
        
        String[] registro = new String[2];
        
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            ResultSet al = Conexion.getRegistros("Select * from Alamacen");
            
            while (al.next()) {
                
                registro[0] = al.getString("PRODUCTO_IdProducto");
                registro[1] = al.getString("CatidadTotal");
                modelo.addRow(registro);
            }
            
            table.setModel(modelo);
        } catch (SQLException e) {
        }
        
        
        
        return null;

    }    
}
