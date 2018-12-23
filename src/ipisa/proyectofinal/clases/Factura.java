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
 * @author Luis Martinez
 */
public class Factura {
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql 
    private int IdFactura;
    private Date FechaFac;
    private double SubTotal;
    private double Total;
    private double MontoDeuda;
    private double Itbis;
    private double PagoRecivido;
    private String Estado;
    private String Activo;
    private int NomCliente;
    private int NomUsuario;
    
    //Creamos un Constructor vacio
    public Factura() {
    }
    
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public Factura(double MontoDeuda) {
        this.MontoDeuda = MontoDeuda;
    }

    public double getMontoDeuda() {
        return MontoDeuda;
    }

    public void setMontoDeuda(double MontoDeuda) {
        this.MontoDeuda = MontoDeuda;
    }
    
    //Creamos un constructor de esas variables
    public Factura(int IdFactura, Date FechaFac, double SubTotal, double Total, double Itbis, double PagoRecivido, String Estado, String Activo, int NomCliente, int NomUsuario) {
        this.IdFactura = IdFactura;
        this.FechaFac = FechaFac;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.Itbis = Itbis;
        this.PagoRecivido = PagoRecivido;
        this.Estado = Estado;
        this.Activo = Activo;
        this.NomCliente = NomCliente;
        this.NomUsuario = NomUsuario;
    }
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public Date getFechaFac() {
        return FechaFac;
    }

    public void setFechaFac(Date FechaFac) {
        this.FechaFac = FechaFac;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getItbis() {
        return Itbis;
    }

    public void setItbis(double Itbis) {
        this.Itbis = Itbis;
    }

    public double getPagoRecivido() {
        return PagoRecivido;
    }

    public void setPagoRecivido(double PagoRecivido) {
        this.PagoRecivido = PagoRecivido;
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

    public int getNomCliente() {
        return NomCliente;
    }

    public void setNomCliente(int NomCliente) {
        this.NomCliente = NomCliente;
    }

    public int getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(int NomUsuario) {
        this.NomUsuario = NomUsuario;
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
