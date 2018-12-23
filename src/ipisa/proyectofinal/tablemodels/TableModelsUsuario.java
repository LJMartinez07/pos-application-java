package ipisa.proyectofinal.tablemodels;

import ipisa.proyectofinal.clases.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Realiza el mismo proceso que la clase TableModelsCategoria ver para referencia
public class TableModelsUsuario {
   
    
    String[] titulos = {"Usuarios", "Contraseña", "Acceso"};
    String[] registros = new String[3];
    
       
      public DefaultTableModel initTable(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM  usuarios";//Selecciona todo de usuario
            ResultSet Rt = Conexion.getRegistros(q);
            while (Rt.next()) {

                    registros[0] = Rt.getString("Usuario");
                    registros[1] = Rt.getString("Password");          
                    registros[2] = Rt.getString("acceso");
                    
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
    public DefaultTableModel ReaUsa(JTable table){
          
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM usuarios WHERE Activo = 'Desactivo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("Password");          
                registros[2] = rs.getString("acceso");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;
    }
}
