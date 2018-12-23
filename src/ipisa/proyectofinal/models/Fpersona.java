/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase conexion
import ipisa.proyectofinal.clases.Persona;//Importamos la clase persona

/**
 *
 * @author junio
 */
public class Fpersona extends Persona{
 
    
    public int grabar(Persona n) {//Creamos una variable de instancia de persona
    String sql = "INSERT INTO persona (Nombre, Apellido, Genero, Direccion, Telefono, Celular, Cedula)"+ 
            "VALUES ('"+n.getNombre()+"','"+n.getApellido()+"','"+n.getGenero()+"','"+n.getDireccion()+"',"
            + "'"+n.getTelefono()+"','"+n.getCelular()+"','"+n.getCedula()+"')";//Aqui creamos un sentencia mysql insert y llamamos los campos a traves de la variable de instancia
    return Conexion.guardarRegistro(sql);//retorna la sentencia 
}
    public int actualizarP(Persona n) {//Creamos una variable de instancia
    String sql = "UPDATE persona"+ 
            "SET Nombre = '"+n.getNombre()+"',"+
            "Apellido = '"+n.getApellido()+"',"+
            "Genero = '"+n.getGenero()+"',"+
            "Direccion = '"+n.getDireccion()+"',"+
            "Telefono = '"+n.getTelefono()+"',"+
            "Celular = '"+n.getCelular()+"',"+
            "Cedula = '"+n.getCedula()+"',";
    //Creamos una sentencia mysql para editar los campos de la tabla seleccionada
            return Conexion.guardarRegistro(sql);//Retornamos el valor de los campos
}
    
}
