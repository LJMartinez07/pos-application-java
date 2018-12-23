/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.clases;

/**
 *
 * @author junio
 */
//Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql 
public class Cliente  extends Persona{//Extendemos cliente a personas ya que utilizaremos campos pertenecientes a esta
    private int IdCliente;
    private double Creditos;
    private String Activo;
    private int NumPersona;

    //Creamos un constructor de esas variables
    public Cliente(int IdCliente, double Creditos, String Activo, int NumPersona) {
        this.IdCliente = IdCliente;
        this.Creditos = Creditos;
        this.Activo = Activo;
        this.NumPersona = NumPersona;
    }
    
    //Creamos un Constructor vacio
    public Cliente() {
    }

    //Y procedemos a crear los getter and setter para establecer y tomar los valores de esas variables
    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public double getCreditos() {
        return Creditos;
    }

    public void setCreditos(double Creditos) {
        this.Creditos = Creditos;
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
    
    

   
   
    
   
   
}
