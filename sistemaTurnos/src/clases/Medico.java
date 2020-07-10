/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author scarlet Espinoza
 */
public class Medico {
    private String cedula;
    private String nombre;
    private String apellido;
    private String Profesion;
    private String genero;
    //private int edad;
    
   
    public Medico(String cedula, String nombre,String apellido,String genero,String profesion){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.genero=genero;
        this.Profesion=profesion;
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

   

    @Override
    public String toString() {
        return "Medico{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", Profesion=" + Profesion + ", genero=" + genero + '}';
    }

    

    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
