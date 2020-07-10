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
    private List<paciente> pacientes;
    private turno  turno;
    private int contadorPacientes;
    
    public puesto(Medico medico,String nombrePuesto) {
       this.medico= medico;
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
        return "puesto{" + "medico=" + medico + ", nombrePuesto=" + nombrePuesto + ", pacientes=" + pacientes + ", turno=" + turno + ", contadorPacientes=" + contadorPacientes + '}';
    }

   
    
    
}
