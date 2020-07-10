/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author scarlet Espinoza
 */
public class ventanaAtencion {
    private BorderPane rootAtencion;
    private Label titulo,diagnostico,receta,nom,ape,e;
    private TextField fieldNombre,fieldApellido,fieldEdad;
    private TextArea areaDiagnostico,areaReceta;
    private Button registrar;

   
    
    public ventanaAtencion() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootAtencion=new BorderPane();
        rootAtencion.setStyle("-fx-background-color: #FFFFFF;");
        rootAtencion.setTop(crearTop());
        rootAtencion.setCenter(crearCenter());
        rootAtencion.setBottom(crearBottom());
        
        
 
    }

     public Pane crearTop(){
         VBox arriba=new VBox();
         arriba.setPadding(new Insets(25,20,20,20));
         arriba.setAlignment(Pos.CENTER);
         titulo = new Label("Atencion cliente");
         titulo.setFont(new Font("Arial Black",19));
         titulo.setTextFill(Color.web("#2E86C1"));
         
         
          HBox hBoxNombre = new HBox();
          nom = new Label("Nombre:");
          fieldNombre = new TextField();
          hBoxNombre.getChildren().addAll(nom,fieldNombre);
          hBoxNombre.setSpacing(15);
          hBoxNombre.setPadding(new Insets(9,9,9,9));
          hBoxNombre.setAlignment(Pos.TOP_LEFT);
          
          HBox hBoxApellido = new HBox();
          ape = new Label("Apellido:");
          fieldApellido = new TextField();
          hBoxApellido.getChildren().addAll(ape,fieldApellido);
           hBoxApellido.setPadding(new Insets(9,9,9,9));
          hBoxApellido.setSpacing(15);
          hBoxApellido.setAlignment(Pos.TOP_LEFT);
          
          HBox hBoxEdad = new HBox();
          e = new Label("Edad:");
          fieldEdad = new TextField();
          hBoxEdad.setPadding(new Insets(9,9,9,9));
          hBoxEdad.getChildren().addAll(e,fieldEdad);
          hBoxEdad.setSpacing(35);
          hBoxEdad.setAlignment(Pos.TOP_LEFT);
          
          arriba.getChildren().addAll(titulo,hBoxNombre,hBoxApellido,hBoxEdad);
          return arriba;
         
         
     }
     public Pane crearCenter(){
         HBox contenedor = new HBox();
         contenedor.setPadding(new Insets(10,10,10,10));
         VBox area1 = new VBox();
         areaDiagnostico = new TextArea();
         areaDiagnostico.setMaxHeight(300);
         areaDiagnostico.setMaxWidth(300);
         
         diagnostico = new Label("Diagnostico");
          area1.getChildren().addAll(diagnostico,areaDiagnostico);
         
         VBox area2 = new VBox();
         areaReceta = new TextArea();
         areaReceta.setMaxHeight(200);
         areaReceta.setMaxWidth(300);
         receta = new Label("Receta");
         area2.getChildren().addAll(receta,areaReceta);
         contenedor.setSpacing(30);
         contenedor.getChildren().addAll(area1,area2);
         
         return contenedor;
     }
      public Pane crearBottom(){
          HBox b = new HBox();
          registrar = new Button("Atender");
          b.setPadding(new Insets(10,10,10,10));
          b.setAlignment(Pos.TOP_RIGHT);
          b.getChildren().add(registrar);
          return b;
          
      }
    public BorderPane getRootAtencion() {
        return rootAtencion;
    }

    public void setRootAtencion(BorderPane rootAtencion) {
        this.rootAtencion = rootAtencion;
    }
    
     
}
