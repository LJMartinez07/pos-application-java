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
public class Categoria {
    //Aqui creamos la variables que vamos a necesitar para manejar los datos de mysql 
    private int idCategoria;
    private String NombreCat;
    private String DescripcionCat;
    private String Activo;
    
    //Creamos un constructor de esas variables
    public Categoria(int idCategoria, String NombreCat, String DescripcionCat, String Activo) {
        this.idCategoria = idCategoria;
        this.NombreCat = NombreCat;
        this.DescripcionCat = DescripcionCat;
        this.Activo = Activo;
    }
    //Creamos un Constructor vacio
    public Categoria() {
    }
    
    //Y procedemos a crear los getter and setter para establecer y tomar los valores de esas variables
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCat() {
        return NombreCat;
    }

    public void setNombreCat(String NombreCat) {
        this.NombreCat = NombreCat;
    }

    public String getDescripcionCat() {
        return DescripcionCat;
    }

    public void setDescripcionCat(String DescripcionCat) {
        this.DescripcionCat = DescripcionCat;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

   
    
}
