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
public class TableModelsSuplidores implements iVerificar{
    
     @Override
     public boolean isNumeric(String cadena) {//Si la cadena tiene numero que lo convierta a integer
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    
    String[] titulos = {"Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Celular", "Cedula", "Empresa", "Prestablecimiento"};
    String[] registros = new String[9];
    
    
    public DefaultTableModel mostrarSupli(JTable table, String buscar, String ape) {
        DefaultTableModel modelo;

        modelo = new DefaultTableModel(null, titulos);

        try {
            
            if (isNumeric(buscar)) {
                //Hacemos un select de busqueda con la cedula del suplidor con la tabla persona
                ResultSet Rc= Conexion.getRegistros("SELECT * FROM personas, suplidores where personas.IdPersona = suplidores.PERSONAS_IdPersona and personas.Cedula = '"+buscar+"'");

                while (Rc.next()) {

                    registros[0] = Rc.getString("Nombre");
                    registros[1] = Rc.getString("Apellido");
                    registros[2] = Rc.getString("Genero");
                    registros[3] = Rc.getString("Direccion");
                    registros[4] = Rc.getString("Telefono");
                    registros[5] = Rc.getString("Celular");
                    registros[6] = Rc.getString("Cedula");
                    registros[7] = Rc.getString("Empresa");
                    registros[8] = Rc.getString("Prestablecimiento");


                    modelo.addRow(registros);
                }
            }else {
                ResultSet Rn = Conexion.getRegistros("SELECT * FROM personas, suplidores where personas.IdPersona = suplidores.PERSONAS_IdPersona AND (personas.Nombre = '"+buscar+"' OR "+
                        "personas.Apellido  = '"+ape+"')");//Hacemos un select con el nombre y apellido del suplidor

                while (Rn.next()) {

                    registros[0] = Rn.getString("Nombre");
                    registros[1] = Rn.getString("Apellido");
                    registros[2] = Rn.getString("Genero");
                    registros[3] = Rn.getString("Direccion");
                    registros[4] = Rn.getString("Telefono");
                    registros[5] = Rn.getString("Celular");
                    registros[6] = Rn.getString("Cedula");
                    registros[7] = Rn.getString("Empresa");
                    registros[8] = Rn.getString("Prestablecimiento");

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
            String q = "SELECT * FROM personas,suplidores WHERE personas.IdPersona = suplidores.PERSONAS_IdPersona AND activo = 'Activo'";//Seleccionamos los suplidores que estan activos
            ResultSet Rt = Conexion.getRegistros(q);
            while (Rt.next()) {

                    registros[0] = Rt.getString("Nombre");
                    registros[1] = Rt.getString("Apellido");
                    registros[2] = Rt.getString("Genero");
                    registros[3] = Rt.getString("Direccion");
                    registros[4] = Rt.getString("Telefono");
                    registros[5] = Rt.getString("Celular");
                    registros[6] = Rt.getString("Cedula");
              
                    registros[7] = Rt.getString("Empresa");
                    registros[8] = Rt.getString("Prestablecimiento");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
      public DefaultTableModel initTable2(JTable table){
          
        DefaultTableModel modelo;
        String[] titulos2 = {"Id","Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Celular", "Cedula", "Empresa", "Prestablecimiento"};
        String[] registros2 = new String[10];
         
        modelo = new DefaultTableModel(null, titulos2);
        try {
            String q = "SELECT * FROM personas,suplidores WHERE personas.IdPersona = suplidores.PERSONAS_IdPersona AND activo = 'Activo'";
            ResultSet Rt = Conexion.getRegistros(q);
            while (Rt.next()) {
                    registros2[0] = Rt.getString("IdSupli");//Agregamos id del suplidor
                    registros2[1] = Rt.getString("Nombre");
                    registros2[2] = Rt.getString("Apellido");
                    registros2[3] = Rt.getString("Genero");
                    registros2[4] = Rt.getString("Direccion");
                    registros2[5] = Rt.getString("Telefono");
                    registros2[6] = Rt.getString("Celular");
                    registros2[7] = Rt.getString("Cedula");
              
                    registros2[8] = Rt.getString("Empresa");
                    registros2[9] = Rt.getString("Prestablecimiento");
                
                modelo.addRow(registros2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
      public DefaultTableModel ReaSup(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM personas,suplidores WHERE personas.IdPersona = suplidores.PERSONAS_IdPersona and Activo = 'Desactivo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                    registros[0] = rs.getString("Nombre");
                    registros[1] = rs.getString("Apellido");
                    registros[2] = rs.getString("Genero");
                    registros[3] = rs.getString("Direccion");
                    registros[4] = rs.getString("Telefono");
                    registros[5] = rs.getString("Celular");
                    registros[6] = rs.getString("Cedula");
              
                    registros[7] = rs.getString("Empresa");
                    registros[8] = rs.getString("Prestablecimiento");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }

   
      
}
