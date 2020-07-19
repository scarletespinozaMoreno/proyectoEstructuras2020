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
public class turno {
    private String numero;
    private estado estado;
    
    public turno(String numero){
        estado = estado.EN_ESPERA;
        this.numero=numero;
    }


    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Turno{" +", numero=" + numero + ", estado=" + estado + '}';
    }
     
}