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
public class Suplidores extends Persona{//Extendemos suplidores a personas ya que utilizaremos campos pertenecientes a esta
     //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql
    private int IDSupli;
    private String Empresa;
    private String Prestablecimiento;
    private String Activo;
    private int NumPersona;

    //Creamos un constructor de esas variables
    public Suplidores(int IDSupli, String Empresa, String Prestablecimiento, String Activo, int NumPersona) {
        this.IDSupli = IDSupli;
        this.Empresa = Empresa;
        this.Prestablecimiento = Prestablecimiento;
        this.Activo = Activo;
        this.NumPersona = NumPersona;
    }

    //Creamos un Constructor vacio
    public Suplidores() {
    }

    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public int getIDSupli() {
        return IDSupli;
    }

    public void setIDSupli(int IDSupli) {
        this.IDSupli = IDSupli;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getPrestablecimiento() {
        return Prestablecimiento;
    }

    public void setPrestablecimiento(String Prestablecimiento) {
        this.Prestablecimiento = Prestablecimiento;
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
