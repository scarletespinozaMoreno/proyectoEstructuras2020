/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Modulo1.PantallaPrincipal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author scarlet Espinoza
 */
public class puesto {
     private Medico medico;
    private String nombrePuesto;
    private paciente paciente;
    
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

    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }
    

    public paciente getPacientes() {
        return paciente;
    }

    @Override
    public String toString() {
        return "puesto{" + "medico=" + medico + ", nombrePuesto=" + nombrePuesto + ", pacientes=" + paciente  +'}';
    }

   public static List<puesto> asignarPuestos(){
        List<puesto> tmp=new LinkedList<>();
        int tmp2=0;
        for (Medico m:PantallaPrincipal.getMEDICO()){
            puesto p=new puesto(m,String.valueOf(++tmp2));
            tmp.add(p);
            
        }
        return tmp;
     
     }
    
    
}
