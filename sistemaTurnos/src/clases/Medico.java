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
public class Medico extends Persona{
    
    private String cedula;
    private String Profesion;

    
   
    public Medico(String cedula, String nombre,String apellido,String profesion){
        super(nombre,apellido);
        this.Profesion=profesion;
        this.cedula=cedula;
        
    }


    public String getCedula() {
        return cedula;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }




   

    @Override
    public String toString() {
        return "Medico{" + "cedula=" + this.getCedula() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", Profesion=" + Profesion + ", genero=" + this.getProfesion() + '}';
    }  
}
