/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.clases;

/**
 *
 * @author Luis Martinez
 */
public class Almacen extends Producto{
    
    private int IdAlmacen;
    private int CantidadTotal;
    
  

    public Almacen(int IdAlmacen, int CantidadTotal) {
        this.IdAlmacen = IdAlmacen;
        this.CantidadTotal = CantidadTotal;
    }

    public Almacen() {
    }

    public int getIdAlmacen() {
        return IdAlmacen;
    }

    public void setIdAlmacen(int IdAlmacen) {
        this.IdAlmacen = IdAlmacen;
    }

    public int getCantidadTotal() {
        return CantidadTotal;
    }

    public void setCantidadTotal(int CantidadTotal) {
        this.CantidadTotal = CantidadTotal;
    }

    
  
    
}
