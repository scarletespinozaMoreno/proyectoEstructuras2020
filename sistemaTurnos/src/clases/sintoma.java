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
public class sintoma {
    private String nombreSintoma;
    private int prioridad;
    private String letra;

    public sintoma(String nombreSintoma, int prioridad,String letra) {
        this.nombreSintoma = nombreSintoma;
        this.prioridad = prioridad;
        this.letra=letra;
    }

    public String getLetra() {
        return letra;
    }

    public String getNombreSintoma() {
        return nombreSintoma;
    }

    public void setNombreSintoma(String nombreSintoma) {
        this.nombreSintoma = nombreSintoma;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return  nombreSintoma;
    }
    
    
    
}
