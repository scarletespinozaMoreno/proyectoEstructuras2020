/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author scarlet Espinoza
 */
public class Turno {
    private Paciente paciente;
    private Puesto puesto;
    private String numero;
    private Estado estado;
    private int tipo;
    
    public Turno(String numero,Paciente paciente){
        this.numero=numero;
        this.paciente=paciente;
        this.tipo=Integer.valueOf(LecturaEscritura.leerSintomas(paciente.getSintoma()).get(0));
        estado = Estado.EN_ESPERA;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Turno{" + "paciente=" + paciente  +", numero=" + numero + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    public static List<Turno> asignarTurnos(){
        List<Turno> tmp=new LinkedList<>();
        int tmp2=0;
        for (Paciente p:LecturaEscritura.leerCliente()){
            Turno t=new Turno(String.valueOf(++tmp2),p);
            tmp.add(t);
            
        }
        return tmp;
    }
    
    
}
