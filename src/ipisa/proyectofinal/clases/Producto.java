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
 * @author Luis Martinez
 */
public class Producto {
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql
    private int IdProducto;
    private String NombrePro;
    private String DescripcionPro;
    private double PrecioVenta;
    private double PrecioCompra;
    private int CantidadProdu;
    private Date FechaCompra;
    private Date FechaVenci;
    private String Activo;
    private int NumCatego;
    private int NumSupli;

    //Creamos un constructor de esas variables
    public Producto(int IdProducto, String NombrePro, String DescripcionPro, double PrecioVenta, double PrecioCompra, int CantidadProdu, Date FechaCompra, Date FechaVenci, String Activo, int NumCatego, int NumSupli) {
        this.IdProducto = IdProducto;
        this.NombrePro = NombrePro;
        this.DescripcionPro = DescripcionPro;
        this.PrecioVenta = PrecioVenta;
        this.PrecioCompra = PrecioCompra;
        this.CantidadProdu = CantidadProdu;
        this.FechaCompra = FechaCompra;
        this.FechaVenci = FechaVenci;
        this.Activo = Activo;
        this.NumCatego = NumCatego;
        this.NumSupli = NumSupli;
    }

    //Creamos un Constructor vacio
    public Producto() {
    }

    //Y procedemos a crear los getter and setter para establecer y tomar los valores de las variables
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombrePro() {
        return NombrePro;
    }

    public void setNombrePro(String NombrePro) {
        this.NombrePro = NombrePro;
    }

    public String getDescripcionPro() {
        return DescripcionPro;
    }

    public void setDescripcionPro(String DescripcionPro) {
        this.DescripcionPro = DescripcionPro;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public int getCantidadProdu() {
        return CantidadProdu;
    }

    public void setCantidadProdu(int CantidadProdu) {
        this.CantidadProdu = CantidadProdu;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public Date getFechaVenci() {
        return FechaVenci;
    }

    public void setFechaVenci(Date FechaVenci) {
        this.FechaVenci = FechaVenci;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    public int getNumCatego() {
        return NumCatego;
    }

    public void setNumCatego(int NumCatego) {
        this.NumCatego = NumCatego;
    }

    public int getNumSupli() {
        return NumSupli;
    }

    public void setNumSupli(int NumSupli) {
        this.NumSupli = NumSupli;
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
