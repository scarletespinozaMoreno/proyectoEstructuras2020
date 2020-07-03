/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author scarlet Espinoza
 */
public class ventanaDoctorPuesto {
    private BorderPane rootDoctor;

   
    
    public ventanaDoctorPuesto() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootDoctor=new BorderPane();
        rootDoctor.setStyle("-fx-background-color: #FFFFFF;");
        
        
 
    }

    public BorderPane getRootDoctor() {
        return rootDoctor;
    }

    public void setRootDoctor(BorderPane rootDoctor) {
        this.rootDoctor = rootDoctor;
    }
    
     
    
}
