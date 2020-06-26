/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author scarlet Espinoza
 */
public class ventanaMenu {
    private StackPane root = new StackPane();
    private Pane root2 = new Pane();
    private ImageView fondo = new ImageView ( "imagenes/fondoInicio.jpg");
    private Button btnPuestos = new Button ("Puesto");
    private Button btnMedico = new Button ("Medico");
    private Button btnAcceder = new Button ("Acceder");

    public ventanaMenu() {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana(){
        btnPuestos.setLayoutX(250);
        btnPuestos.setLayoutY(100);
        //btnPuestos.setAlignment(Pos.CENTER);
        btnPuestos.setPrefSize(120,100);
        btnPuestos.setDefaultButton(true);
        btnPuestos.setStyle("-fx-background-radius:13");
        btnMedico.setLayoutX(250);
        btnMedico.setLayoutY(250);
        btnMedico.setPrefSize(120,100);
        btnMedico.setDefaultButton(true);
        btnMedico.setStyle("-fx-background-radius:13");
        btnAcceder.setLayoutX(250);
        btnAcceder.setLayoutY(400);
        btnAcceder.setPrefSize(120,100);
        btnAcceder.setDefaultButton(true);
        btnAcceder.setStyle("-fx-background-radius:13");
        root2.getChildren().addAll(btnPuestos,btnMedico,btnAcceder);
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

    public Button getBtnPuestos() {
        return btnPuestos;
    }

    public void setBtnPuestos(Button btnPuestos) {
        this.btnPuestos = btnPuestos;
    }

    public Button getBtnMedico() {
        return btnMedico;
    }

    public void setBtnMedico(Button btnMedico) {
        this.btnMedico = btnMedico;
    }

    public Button getBtnAcceder() {
        return btnAcceder;
    }

    public void setBtnAcceder(Button btnAcceder) {
        this.btnAcceder = btnAcceder;
    }
    
    
    
}
 