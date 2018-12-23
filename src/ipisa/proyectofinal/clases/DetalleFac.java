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
public class DetalleFac extends Factura{//Extendemos Detalle de factura a factura ya que utilizaremos campos pertenecientes a esta
    private int IdDetalleFac;
    private int CantidadProdu;
    private double importe;
    private double Descuento;
    private String Activo;
    private int IdFactura;
    private int IdProducto;

    //Creamos un Constructor vacio
    public DetalleFac() {
    }

    //Creamos un constructor de esas variables
    public DetalleFac(int IdDetalleFac, int CantidadProdu, double importe, double Descuento, String Activo, int IdFactura, int IdProducto) {
        this.IdDetalleFac = IdDetalleFac;
        this.CantidadProdu = CantidadProdu;
        this.importe = importe;
        this.Descuento = Descuento;
        this.Activo = Activo;
        this.IdFactura = IdFactura;
        this.IdProducto = IdProducto;
    }
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de esas variables
    public int getIdDetalleFac() {
        return IdDetalleFac;
    }

    public void setIdDetalleFac(int IdDetalleFac) {
        this.IdDetalleFac = IdDetalleFac;
    }

    public int getCantidadProdu() {
        return CantidadProdu;
    }

    public void setCantidadProdu(int CantidadProdu) {
        this.CantidadProdu = CantidadProdu;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }
    
    
}
