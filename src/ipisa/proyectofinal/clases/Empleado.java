/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author junio
 */
public class Empleado  extends Persona{//Extendemos empleado a personas ya que utilizaremos campos pertenecientes a esta
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql 
    private int IdEmpleado;
    private String Puesto;
    private double Sueldo;
    private String Estado;
    private String Activo;
    private int NumPersona;
    
    //Creamos un constructor de esas variables
    public Empleado(int IdEmpleado, String Puesto, double Sueldo, String Estado, String Activo, int NumPersona) {
        this.IdEmpleado = IdEmpleado;
        this.Puesto = Puesto;
        this.Sueldo = Sueldo;
        this.Estado = Estado;
        this.Activo = Activo;
        this.NumPersona = NumPersona;
    }
    //Creamos un Constructor vacio
    public Empleado() {
    }
    
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de esas variables
    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    public int getNumPersona() {
        return NumPersona;
    }

    public void setNumPersona(int NumPersona) {
        this.NumPersona = NumPersona;
    }

    

    /*Este metodo que retorna un String Es para convertir la fecha en el orden
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