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
 * @author Luis Martinez
 */
//Realiza el mismo proceso que la clase TableModelsCategoria ver para referencia
public class TableModelsProducto {
    

    
     public DefaultTableModel mostrarPro(JTable table, String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"Codigo de Barra", "Nombre", "Precio de venta", "Cantidad", "Fecha de vencimiento","Suplidor", "Precio de compra"};

        String[] registros = new String[7];
      
        modelo = new DefaultTableModel(null, titulos);
            //Hacemos un select de busqueda de productos con su codigo de barra y con los suplidores que lo suplen
            String Query="SELECT * FROM suplidores, productos, personas where suplidores.Personas_idPersona = Personas.idPersona and suplidores.IdSupli = productos.Suplidores_IdSupli and IdProducto= "+buscar;
         System.out.println(Query);
        try {

            ResultSet pdts = Conexion.getRegistros(Query);
            

            while (pdts.next()) {

                registros[0] = pdts.getString("IdProducto");
                registros[1] = pdts.getString("NombrePro");
                registros[2] = pdts.getString("PrecioVenta");
                registros[3] = pdts.getString("CantidadProdu");
                registros[4] = pdts.getString("FechaVenci");
                registros[5] = pdts.getString("Personas.Nombre");
                registros[6] = pdts.getString("PrecioCompra");
                
                modelo.addRow(registros);
            }
            table.setModel(modelo);
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
      public DefaultTableModel initTable(JTable table){
         DefaultTableModel modelo;
        
        String[] titulos = {"Codigo de Barra", "Nombre", "Precio de venta", "Cantidad", "Fecha de vencimiento","Suplidor", "Precio de compra"};

        String[] registros = new String[7];
      
        modelo = new DefaultTableModel(null, titulos);
        try {
            //Hacemos un select de todos los productos con sus respectivos suplidores
            String q = "SELECT * FROM suplidores, productos, personas where suplidores.Personas_idPersona = Personas.idPersona and suplidores.IdSupli = productos.Suplidores_IdSupli";
            ResultSet pdts = Conexion.getRegistros(q);
            while (pdts.next()) {

                registros[0] = pdts.getString("IdProducto");
                registros[1] = pdts.getString("NombrePro");
                registros[2] = pdts.getString("PrecioVenta");
                registros[3] = pdts.getString("CantidadProdu");
                registros[4] = pdts.getString("FechaVenci");
                registros[5] = pdts.getString("Personas.Nombre");
                registros[6] = pdts.getString("PrecioCompra");
                
                modelo.addRow(registros);
            }
            
           
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
      }

