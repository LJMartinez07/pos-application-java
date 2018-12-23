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
public class TableModelsFactura {
    
    public boolean isNumeric(String cadena) {//Si la cadena tiene numero que lo convierta a integer
        try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    String[] titulos = {"Id Factura","Fecha de la factura", "Estado","Subtotal","Itbis", "Total", "Pago Recibido","Id del Cliente"};
    String[] registros = new String[8];
    
    
    public DefaultTableModel mostrarFac(JTable table, String buscar) {
        DefaultTableModel modelo;

        modelo = new DefaultTableModel(null, titulos);

        try {   //Hacemos un select con las facturas que se relacionan con los clientes y las cuales esten activas
                ResultSet Rc= Conexion.getRegistros("SELECT * FROM facturas, clientes where Facturas.Activo = 'Activo' and facturas.CLIENTES_IdCliente = clientes.IdCliente and facturas.CLIENTES_IdCliente = "+buscar+"");

                while (Rc.next()) {
                    registros[0] = Rc.getString("IdFactura");
                    registros[1] = Rc.getString("Fechafac");
                    registros[2] = Rc.getString("Estado");
                    registros[3] = Rc.getString("Subtotal");
                    registros[4] = Rc.getString("Itebis");
                    registros[5] = Rc.getString("Total");
                    registros[6] = Rc.getString("PagoRecivido");
                    registros[7] = Rc.getString("Clientes_IdCliente");


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
            String q = "SELECT * FROM facturas where Facturas.Activo = 'Activo' ";//Seleccionamos todas las facturas activas
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                    registros[0] = rs.getString("IdFactura");
                    registros[1] = rs.getString("Fechafac");
                    registros[2] = rs.getString("Estado");
                    registros[3] = rs.getString("Subtotal");
                    registros[4] = rs.getString("Itebis");
                    registros[5] = rs.getString("Total");
                    registros[6] = rs.getString("PagoRecivido");
                    registros[7] = rs.getString("Clientes_IdCliente");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table.setModel(modelo);
        return modelo;
    }
      
      public DefaultTableModel Pendiente(JTable table, int bus){
          
        DefaultTableModel modelo;
        
         String[] titu = {"Codigo factura", "Monto Deudor", "Total", "Fechafac" };
           String[] registro = new String[4];
        modelo = new DefaultTableModel(null, titu);
        try {
            //Seleccionamos las facturas de un cliente con su id
            String q = "SELECT * FROM facturas where Facturas.Activo = 'Activo' and facturas.Estado = 'Pendiente' and CLIENTES_IdCliente = "+bus;
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                    
                    registro[0] = rs.getString("IdFactura");
                    registro[1] = rs.getString("MontoDeuda");
                    registro[2] = rs.getString("Total");
                    registro[3] = rs.getString("Fechafac");
                    
     
                
                modelo.addRow(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table.setModel(modelo);
        return modelo;
    }
      
       public DefaultTableModel pago(JTable table){
          
        DefaultTableModel modelo;
        
         String[] titu = {"Codigo factura", "Monto", "Fechafac" };
           String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titu);
        try {
            String q = "SELECT * FROM facturas where Facturas.Activo = 'Activo' and facturas.Estado = 'Pendiente' and CLIENTES_IdCliente = ";
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                    
                    registro[0] = rs.getString("IdFactura");
                    registro[1] = rs.getString("MontoDeuda");
                    registro[2] = rs.getString("Fechafac");
                    
     
                
                modelo.addRow(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table.setModel(modelo);
        return modelo;
    }
      
}
