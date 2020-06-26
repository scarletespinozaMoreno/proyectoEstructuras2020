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
public class paciente {
    private int idRegistro;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int edadPaciente;
    private String generoPaciente;
    private sintoma sintomaPaciente;

    public paciente(String nombrePaciente, String apellidoPaciente, int edadPaciente, String generoPaciente, sintoma sintomaPaciente) {
       this.idRegistro = this.hashCode();
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.edadPaciente = edadPaciente;
        this.generoPaciente = generoPaciente;
        this.sintomaPaciente = sintomaPaciente;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getGeneroPaciente() {
        return generoPaciente;
    }

    public void setGeneroPaciente(String generoPaciente) {
        this.generoPaciente = generoPaciente;
    }

    public sintoma getSintomaPaciente() {
        return sintomaPaciente;
    }

    public void setSintomaPaciente(sintoma sintomaPaciente) {
        this.sintomaPaciente = sintomaPaciente;
    }
    
    
}
