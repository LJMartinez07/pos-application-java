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
public class TableModelsEmpleado implements iVerificar{

 
    @Override
    public boolean isNumeric(String cadena) {//Si la cadena tiene numero que lo convierta a integer
        try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    
    
     String[] titulos = {"IdEmpleado","Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Celular", "Cedula", "Puesto", "Sueldo"};
     String[] registros = new String[10];
     String[] titulos2 = {"IdEmpleado","Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Celular", "Cedula", "Puesto", "Sueldo","Fecha de Cambio"};
     String[] registros2 = new String[11];
     
    public DefaultTableModel mostrarEmp(JTable table, String buscar, String ape) {
        DefaultTableModel modelo;

        modelo = new DefaultTableModel(null, titulos);
            
        
        try {
            
            if(isNumeric(buscar)) {
                 ResultSet Cd = Conexion.getRegistros("select * from personas,empleados where personas.IdPersona = empleados.PERSONAS_IdPersona and personas.Cedula = "+
                    buscar);//Hacemos un select de busqueda con la cedula de los empleados de la tabla persona
                 
            while (Cd.next()) {
                registros[0] = Cd.getString("IdEmpleado");
                registros[1] = Cd.getString("Nombre");
                registros[2] = Cd.getString("Apellido");
                registros[3] = Cd.getString("Genero");
                registros[4] = Cd.getString("Direccion");
                registros[5] = Cd.getString("Telefono");
                registros[6] = Cd.getString("Celular");
                registros[7] = Cd.getString("Cedula");
                registros[8] = Cd.getString("Puesto");
                registros[9] = Cd.getString("Sueldo");
          
                
                modelo.addRow(registros);
            }
            
                
            }else{
                ResultSet Nb = Conexion.getRegistros("Select * from personas, empleados where personas.IdPersona = empleados.PERSONAS_IdPersona AND (personas.Nombre = '"+buscar+"' OR "+
                "personas.Apellido = '"+ape+"')");//Hacemos un select con el nombre y apellido de los empleados
                
                while (Nb.next()) {
                    registros[0] = Nb.getString("IdEmpleado");
                    registros[1] = Nb.getString("Nombre");
                    registros[2] = Nb.getString("Apellido");
                    registros[3] = Nb.getString("Genero");
                    registros[4] = Nb.getString("Direccion");
                    registros[5] = Nb.getString("Telefono");
                    registros[6] = Nb.getString("Celular");
                    registros[7] = Nb.getString("Cedula");
                    registros[8] = Nb.getString("Puesto");
                    registros[9] = Nb.getString("Sueldo");
          
                
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
        
        ResultSet Td = Conexion.getRegistros("Select * from personas, empleados where personas.IdPersona = empleados.PERSONAS_IdPersona and Activo = 'Activo'");//Hacemos un select de todos lo empleado sque esten activos
       
        try {
            while (Td.next()) { 
                
                    registros[0] = Td.getString("IdEmpleado");
                    registros[1] = Td.getString("Nombre");
                    registros[2] = Td.getString("Apellido");
                    registros[3] = Td.getString("Genero");
                    registros[4] = Td.getString("Direccion");
                    registros[5] = Td.getString("Telefono");
                    registros[6] = Td.getString("Celular");
                    registros[7] = Td.getString("Cedula");
                    registros[8] = Td.getString("Puesto");
                    registros[9] = Td.getString("Sueldo");
          
            modelo.addRow(registros);      
        }
            table.setModel(modelo);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;
        
        
    }
       public DefaultTableModel NoveEmp(JTable table){
        
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos2);
        
        ResultSet Td = Conexion.getRegistros("Select * from personas, registros_de_novedades_de_empleados where personas.IdPersona = registros_de_novedades_de_empleados.PERSONAS_IdPersona and Activo = 'Activo'");//Hacemos un select de todos lo empleado sque esten activos
       
        try {
            while (Td.next()) { 
                
                    registros2[0] = Td.getString("IdEmpleado");
                    registros2[1] = Td.getString("Nombre");
                    registros2[2] = Td.getString("Apellido");
                    registros2[3] = Td.getString("Genero");
                    registros2[4] = Td.getString("Direccion");
                    registros2[5] = Td.getString("Telefono");
                    registros2[6] = Td.getString("Celular");
                    registros2[7] = Td.getString("Cedula");
                    registros2[8] = Td.getString("Puesto");
                    registros2[9] = Td.getString("Sueldo");
                    registros2[10] = Td.getString("FechaDeCambio");
          
            modelo.addRow(registros2);      
        }
            table.setModel(modelo);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;
        
        
    }
       public DefaultTableModel BNoveEmp(JTable table, String buscar, String ape){
        
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos2);
        
        ResultSet Td = Conexion.getRegistros("Select * from personas, registros_de_novedades_de_empleados where personas.IdPersona = registros_de_novedades_de_empleados.PERSONAS_IdPersona and Activo = 'Activo' and personas.Nombre = '"+buscar+"' or Personas.apellido = '"+ape+"'");//Hacemos un select de todos lo empleado sque esten activos
       
        try {
            while (Td.next()) { 
                
                    registros2[0] = Td.getString("IdEmpleado");
                    registros2[1] = Td.getString("Nombre");
                    registros2[2] = Td.getString("Apellido");
                    registros2[3] = Td.getString("Genero");
                    registros2[4] = Td.getString("Direccion");
                    registros2[5] = Td.getString("Telefono");
                    registros2[6] = Td.getString("Celular");
                    registros2[7] = Td.getString("Cedula");
                    registros2[8] = Td.getString("Puesto");
                    registros2[9] = Td.getString("Sueldo");
                    registros2[10] = Td.getString("FechaDeCambio");
          
            modelo.addRow(registros2);      
        }
            table.setModel(modelo);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;
        
        
    }
       public DefaultTableModel ReEmp(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM personas,empleados WHERE personas.IdPersona = empleados.PERSONAS_IdPersona and Activo = 'Desactivo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("IdEmpleado");
                    registros[1] = rs.getString("Nombre");
                    registros[2] = rs.getString("Apellido");
                    registros[3] = rs.getString("Genero");
                    registros[4] = rs.getString("Direccion");
                    registros[5] = rs.getString("Telefono");
                    registros[6] = rs.getString("Celular");
                    registros[7] = rs.getString("Cedula");
                    registros[8] = rs.getString("Puesto");
                    registros[9] = rs.getString("Sueldo");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }

   
}
