/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.tablemodels;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import java.sql.ResultSet;//Importamos el ResultSet ya que contiene todas las filas que satisfacen las condiciones de una sentencia SQL 
import java.sql.SQLException;//Importamos la excepcion de sql
import javax.swing.JOptionPane;//Importamos el JOptionPane para mostrar un mensae
import javax.swing.JTable;//Importamos Jtable para crear la tabla
import javax.swing.table.DefaultTableModel;//Importamos el DeafaultTableModel para crear y modificar el contenido de la tabla

/**
 *
 * @author Luis Martinez
 */
public class TableModelsCategoria {
     String[] titulos = {"ID","Nombre", "Descripcion"};//Declaramos los titulos que va a tener nuestra tabla es decir los nombres de las columnas
        String[] registros = new String[3];//Declaramos los parametros al ingresar los registros esto va a depender de la cantidad de columnas que crearemmos
    
     public DefaultTableModel mostrarCat(JTable table, String buscar)  {//Creamos dos variables una que obtenga la tabla y la otra un valor para cuplir alguna sentencia
        DefaultTableModel modelo;//Establecemos la variable para el DefaultTableModle
        
       

        modelo = new DefaultTableModel(null, titulos);//Colocamos los titulos que establecimos
     
        if (buscar.isEmpty()){//Una condicion para cuando el buscar este vacio para que muestre todos los campos
            
            try {
                 ResultSet Td = Conexion.getRegistros("SELECT * FROM categorias WHERE activo = 'Activo'");//Seleccionamos todo de la tabla declarada donde la categoria este activa
                 //Hacemos un while para que recorra todos los registros de la tabla creada en mysql
                 while (Td.next()) {
                     //Obtenemos los valores que se encuentran en nuestra base de datos
                    registros[0] = Td.getString("IdCategoria");
                    registros[1] = Td.getString("NombreCat");
                    registros[2] = Td.getString("DescripcionCat");
                    modelo.addRow(registros);//Agregamos esos registros a nuestro modelo
                }
                table.setModel(modelo);//Y establecemos el modelo a la tabla
 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                return null;//un mensaje para que muestre si pasa un error en msql durante el proceso
            }
        }else {
            try {
                 ResultSet Nm = Conexion.getRegistros( "SELECT * FROM categorias where NombreCat = '"+buscar+"'");//Aqui hacemos que la tabla seleccione los registros donde la condicion sea igual a lo que ingresemos en buscar
                 while (Nm.next()) {
                    registros[0] = Nm.getString("IdCategoria");
                    registros[1] = Nm.getString("NombreCat");
                    registros[2] = Nm.getString("DescripcionCat");
                    modelo.addRow(registros);
                }
                table.setModel(modelo);
                
            } catch (SQLException e) {
            }
                    
            
           
        }
        return modelo;
    }
     
      public DefaultTableModel initTable(JTable table)  {
        DefaultTableModel modelo;
        
      
    

        modelo = new DefaultTableModel(null, titulos);
     
     
            
            try {
                 ResultSet Td = Conexion.getRegistros("SELECT * FROM categorias WHERE Activo = 'Activo'");
                 while (Td.next()) {
                    registros[0] = Td.getString("IdCategoria");
                    registros[1] = Td.getString("NombreCat");
                    registros[2] = Td.getString("DescripcionCat");
                    modelo.addRow(registros);
                }
                table.setModel(modelo);
 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                return null;
            }
      
               return modelo;     
            
           
        }
      public DefaultTableModel ReCategoria(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM Categorias WHERE Activo = 'Descativado'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("IdCategoria");
                registros[1] = rs.getString("NombreCat");
                registros[2] = rs.getString("DescripcionCat");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
        
    }

