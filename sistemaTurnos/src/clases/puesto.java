/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;

/**
 *
 * @author scarlet Espinoza
 */
public class puesto {
     private Medico medico;
    private String nombrePuesto;
    private String nombre, cedula;
    private List<paciente> pacientes;
    private turno  turno;
    private int contadorPacientes;
    
    public puesto(Medico medico,String nombrePuesto) {
        this.nombre = medico.getNombre();
        this.cedula=medico.getCedula();
        this.nombrePuesto=nombrePuesto;
    }


    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<paciente> getPacientes() {
        return pacientes;
    }

    @Override
    public String toString() {
        return "Puesto{" + "medico=" + medico + ", nombre=" + nombre + ", cedula=" + cedula + ", turno=" + turno + ", contadorPacientes=" + contadorPacientes + '}';
    }
    
    
}
