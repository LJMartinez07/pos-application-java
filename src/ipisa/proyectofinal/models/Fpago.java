/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.models;

import ipisa.proyectofinal.clases.Conexion;//Importamos la clase Conexion
import ipisa.proyectofinal.clases.Pago;//Importamos la clase pago

/**
 *
 * @author junio
 */
public class Fpago {
    
    public int insertar(Pago dato){//Usamos una variable de instancia con la clase pago
        
        String sql = "Insert into pagos(MontoPagar, FechaDelPago, CLIENTES_IdCliente, FACTURAS_IdFactura) VALUES "+
                "("+dato.getMontoPagar()+",'"+dato.getFormatearFecha(dato.getFechaDelPago(), null)+"',"+dato.getNumCliente()+
                ","+dato.getNumFactura()+")";//Aqui creamos un sentencia mysql insert y llamamos los campos a traves de la variable de instancia
        
        return Conexion.guardarRegistro(sql);//retorna la sentencia 
        
        
    }
    
}
