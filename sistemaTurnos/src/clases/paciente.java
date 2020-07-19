/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Modulo1.PantallaPrincipal;

/**
 *
 * @author scarlet Espinoza
 */
public class paciente extends Persona{
    private int edad;
    private sintoma sintoma;
    private String diagnostico;
    private turno turno;
    private String genero;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public paciente(String nombre, String apellido,String genero,int edad, String sintoma,int nivel,String letra) {
        super(nombre,apellido);
        this.edad=edad;
        this.genero=genero;
        this.sintoma =new sintoma(sintoma,nivel,letra);
        turno=new turno(String.valueOf(PantallaPrincipal.generarTurno()));
    }
    
    public paciente(String nombre, String apellido,String genero,int edad, sintoma sintoma) {
        super(nombre,apellido);
        this.edad=edad;
        this.genero=genero;
        this.sintoma =sintoma;
        turno=new turno(String.valueOf(PantallaPrincipal.generarTurno()));
    }



    
    public String getGenero() {
        return genero;
    }
    

    public int getEdad() {
        return edad;
    }

    public turno getTurno() {
        return turno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public sintoma getSintoma() {
        return sintoma;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + this.getNombre() + ", apellido=" + this.getApellido()+ ", sintoma=" + sintoma +  '}';
    }
    
    
    
}
