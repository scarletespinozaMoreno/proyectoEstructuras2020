/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author scarlet Espinoza
 */
public class ventanaAtencion {
    private BorderPane rootAtencion;

   
    
    public ventanaAtencion() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootAtencion=new BorderPane();
        rootAtencion.setStyle("-fx-background-color: #FFFFFF;");
        
        
 
    }

    public BorderPane getRootAtencion() {
        return rootAtencion;
    }

    public void setRootAtencion(BorderPane rootAtencion) {
        this.rootAtencion = rootAtencion;
    }
    
     
    
}
