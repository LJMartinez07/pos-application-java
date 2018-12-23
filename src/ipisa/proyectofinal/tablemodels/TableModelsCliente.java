/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.tablemodels;

import ipisa.proyectofinal.clases.Conexion;
import ipisa.proyectofinal.utilidades.iVerificar;

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
public class TableModelsCliente implements iVerificar{
    
    
    //Establece titulos y los registros
    
    String[] titulos = {"ID","Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Celular", "Cedula", "Creditos"};
    String[] registros = new String[9];
    
    
    public DefaultTableModel mostrarCli(JTable table, String buscar, String ape) {//Este ademas de tener los dos principales tiene otro para buscarlo por cedula y apellido
        DefaultTableModel modelo;

        modelo = new DefaultTableModel(null, titulos);

        try {
            
            if (isNumeric(buscar)) {
                ResultSet rs= Conexion.getRegistros("SELECT * FROM personas, clientes where personas.IdPersona = clientes.PERSONAS_IdPersona and personas.Cedula = "+buscar+"  and activo = 'Activo'");//Aqui hace un select donde buscar sea igual que cedula

                while (rs.next()) {

                    registros[0] = rs.getString("IdCliente");
                    registros[1] = rs.getString("Nombre");
                    registros[2] = rs.getString("Apellido");
                    registros[3] = rs.getString("Genero");
                    registros[4] = rs.getString("Direccion");
                    registros[5] = rs.getString("Telefono");
                    registros[6] = rs.getString("Celular");
                    registros[7] = rs.getString("Cedula");
                    registros[8] = rs.getString("Creditos");


                    modelo.addRow(registros);
                   
                }
               
            }else {
                ResultSet Rn = Conexion.getRegistros("SELECT * FROM personas, clientes where personas.IdPersona = clientes.PERSONAS_IdPersona AND (personas.Nombre = '"+buscar+"' OR "+
                        "personas.Apellido = '"+ape+"' and Activo = 'Activo')");//Hacemos un select pero con el nombre o el apellido de la persona

                while (Rn.next()) {
                    
                    registros[0] = Rn.getString("IdCliente");
                    registros[1] = Rn.getString("Nombre");
                    registros[2] = Rn.getString("Apellido");
                    registros[3] = Rn.getString("Genero");
                    registros[4] = Rn.getString("Direccion");
                    registros[5] = Rn.getString("Telefono");
                    registros[6] = Rn.getString("Celular");
                    registros[7] = Rn.getString("Cedula");
                    registros[8] = Rn.getString("Creditos");

                    modelo.addRow(registros);
                    
                }
                 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            return null;
        } 

        table.setModel(modelo);
        return modelo;

    }
      public DefaultTableModel initTable(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM personas,clientes WHERE personas.IdPersona = clientes.PERSONAS_IdPersona and Activo = 'Activo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("IdCliente");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Apellido");
                registros[3] = rs.getString("Genero");
                registros[4] = rs.getString("Direccion");
                registros[5] = rs.getString("Telefono");
                registros[6] = rs.getString("Celular");
                registros[7] = rs.getString("Cedula");
                registros[8] = rs.getString("Creditos");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
      public DefaultTableModel ClienteDe(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM personas,clientes WHERE personas.IdPersona = clientes.PERSONAS_IdPersona and Activo = 'Desactivo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("IdCliente");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Apellido");
                registros[3] = rs.getString("Genero");
                registros[4] = rs.getString("Direccion");
                registros[5] = rs.getString("Telefono");
                registros[6] = rs.getString("Celular");
                registros[7] = rs.getString("Cedula");
                registros[8] = rs.getString("Creditos");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }

    @Override
    public boolean isNumeric(String cadena) {
         try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
        }
    }

  
}
