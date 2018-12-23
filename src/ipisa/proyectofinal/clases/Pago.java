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
public class Pago {
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql
    private double MontoPagar;
    private Date FechaDelPago;
    private int NumCliente;
    private  int NumFactura;

    //Creamos un constructor de esas variables
    public Pago(double MontoPagar, Date FechaDelPago, int NumCliente, int NumFactura) {
        this.MontoPagar = MontoPagar;
        this.FechaDelPago = FechaDelPago;
        this.NumCliente = NumCliente;
        this.NumFactura = NumFactura;
    }
    
    //Creamos un Constructor vacio
    public Pago() {
    }
    
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public double getMontoPagar() {
        return MontoPagar;
    }

    public void setMontoPagar(double MontoPagar) {
        this.MontoPagar = MontoPagar;
    }

    public Date getFechaDelPago() {
        return FechaDelPago;
    }

    public void setFechaDelPago(Date FechaDelPago) {
        this.FechaDelPago = FechaDelPago;
    }

    public int getNumCliente() {
        return NumCliente;
    }

    public void setNumCliente(int NumCliente) {
        this.NumCliente = NumCliente;
    }

    public int getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(int NumFactura) {
        this.NumFactura = NumFactura;
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
