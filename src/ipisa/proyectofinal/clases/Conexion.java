package ipisa.proyectofinal.clases;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Luis Martinez
 */
public class Conexion {
    
     public static String bd = "Sistemafac"; //Ponemos el nombre de la base de datos que vamos a usar
    public static String login = "root"; //Ponemos el nombre del usuario
    public static String password = "123456";//Ponemos la contraseña
    public static String url = "jdbc:mysql://localhost:3306/" + Conexion.bd;//Ponemos la ubicacion o link para que establezca la conexion
    public static Connection con;//Creamos la variable de tipo Connection
    
    //Creamos un Constructor vacio
    public Conexion() {
    }
    
    
    //Ahora creamos un metodo llamado conectar
    public static void Conectar(){
        
        try//Usamos un try para controlar los errores que se producen durante la conexion
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Llamamos el driver de mysql
            con = DriverManager.getConnection(url, login, password);//Establecemos los campos ya llenados mas arribas
            System.out.println("CONEXION EXITOSA");//Manda un mensaje si no hubo un error en la conexion
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)//Atrapa los errores mas comunes que pueden ocurrir durante el proceso  
        {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());//Manda un mensaje si paso un error y cual fue
        }

    }
    
  /**
     * @param sql sentencia sql como insertar, actualizar y eliminar
     * @return 0 si no hubo ningun cambio, devuelve 1 si hubo algun cambio 
     * en los registros
     */
    public static int guardarRegistro(String sql)
    {
        Conexion.Conectar();
        try{
            int eu;
            try (Statement St = Conexion.con.createStatement()) {
                eu = St.executeUpdate(sql);
            }
            Conexion.con.close();
            return eu;
            
        }catch(SQLException ex){           
        }           
        return 0;
    }
    
    public static ResultSet getRegistros(String sql){
        Conexion con = new Conexion();
        con.Conectar();
        try{
            Statement St = Conexion.con.createStatement();
            ResultSet eq = St.executeQuery(sql);            
            return eq;
            
        }catch(SQLException ex){           
        }
        
        return null;
    }
   
    
    public Connection conectar() {
        Connection link = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.login, this. password);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }

        return link;
    }
        
       
}
