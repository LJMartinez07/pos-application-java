package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Categoria;//Importamos la clase categoria para usar las variables ya creadas
import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion para ejecutar las sentencias Mysql


public class Fcategoria  {
    
    public int insertar(Categoria datos){//Usamos una variable de instancia con la clase categoria 
        
       String sql="INSERT INTO categorias(NombreCat, DescripcionCat, Activo) Values('"+datos.getNombreCat()+
               "','"+datos.getDescripcionCat()+"', DEFAULT)";//Aqui creamos un sentencia mysql insert y llamamos los campos a traves de la variable de instancia
        
        return Conexion.guardarRegistro(sql);//retorna la sentencia 
        
    }
    
    public int Eliminar(int nom){//Creamos un variable
        String sql= "UPDATE categorias set Activo = 'Descativado' where IdCategoria = "+ nom;
        return Conexion.guardarRegistro(sql);//Hacemos un update donde para cumplirse se debe ser igual a la variable creada
        
    }

   
  
    
    
    
}
