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
public class turno {
    private paciente paciente;
    private puesto puesto;
    private String numero;
    private estado estado;
    private int tipo;
    
    public turno(String numero,paciente paciente){
        this.numero=numero;
        this.paciente=paciente;
        this.tipo=Integer.valueOf(LecturaEscritura.leerSintomas(paciente.getSintoma()).get(0));
        estado = estado.EN_ESPERA;
    }

    public paciente getPaciente() {
        return paciente;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }

    public puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(puesto puesto) {
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
    public static List<turno> asignarTurnos(){
        List<turno> tmp=new LinkedList<>();
        int tmp2=0;
        for (paciente p:LecturaEscritura.leerCliente()){
            turno t=new turno(String.valueOf(++tmp2),p);
            tmp.add(t);
            
        }
        return tmp;
    }
}
