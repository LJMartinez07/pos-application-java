/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.clases;


import java.text.SimpleDateFormat;//Importamos este para darle formato al date como deseamos
import java.util.Date;//Importamos el tipo de dato date

/**
 *
 * @author junio
 */
public class Persona {
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql
    private int IdPersona;
    private String Nombre;
    private String Apellido;
    private String Genero;
    private String Direccion;
    private String Telefono;
    private String Celular;
    private String Cedula;
    private Date FechaReg;

    //Creamos un constructor de esas variables
    public Persona(int IdPersona, String Nombre, String Apellido, String Genero, String Direccion, String Telefono, String Celular, String Cedula, Date FechaReg) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Cedula = Cedula;
        this.FechaReg = FechaReg;
    }

    //Creamos un Constructor vacio
    public Persona() {
    }

    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public Date getFechaReg() {
        return FechaReg;
    }

    public void setFechaReg(Date FechaReg) {
        this.FechaReg = FechaReg;
    }
    

    /*Este metodo que returna un String Es para convertir la fecha en el orden
    que queramos*/
    public String getFormatearFecha(Date fecha, String formato)
    {   
        SimpleDateFormat sdf = null;
        if(formato == null)
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        else
          sdf = new SimpleDateFormat(formato);  
        return sdf.format(fecha);
    }
    
    
    
   
}