/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author scarlet Espinoza
 */
public class VentanaFormularioDoctor {
    private StackPane root = new StackPane();
    private Pane root2 = new Pane();
    private ImageView fondo = new ImageView ("imagenes/fondoInicio.jpg");

    public VentanaFormularioDoctor() {
        OrganizarVentana();
    }
     
    public void OrganizarVentana(){
          root.getChildren().addAll(fondo,root2);
    }

    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public Pane getRoot2() {
        return root2;
    }

    public void setRoot2(Pane root2) {
        this.root2 = root2;
    }

    public ImageView getFondo() {
        return fondo;
    }

    public void setFondo(ImageView fondo) {
        this.fondo = fondo;
    }
    
    
    
}
