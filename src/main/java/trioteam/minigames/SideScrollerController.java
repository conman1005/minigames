package trioteam.minigames;

/*
 * Made By: Spencer Jones
 * Date: 
 * Description: 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

/**
 * FXML Controller class
 *
 * @author Spencer
 */
public class SideScrollerController implements Initializable {
//Health
@FXML    
private ImageView picHealth;

//ship 
@FXML
private Pane panShip;
@FXML
private ImageView picShip;
//Hit boxes
@FXML
private Rectangle recShipCol1;
@FXML
private Rectangle recShipCol2;

//Astaroid one
@FXML
private Pane panAstro;
@FXML
private ImageView picAstaroid;
//Hit boxes
@FXML
private Rectangle recAstroCol1;
@FXML
private Ellipse ovlAstroCol2;

//Astaroid two
@FXML
private Pane panAstro2;
@FXML
private ImageView picAstaroid2;
//Hit boxes
@FXML
private Rectangle recAstroCol21;
@FXML
private Ellipse ovlAstroCol22;

//Astaroid two
@FXML
private Pane panAstro3;
@FXML
private ImageView picAstaroid3;
//Hit boxes
@FXML
private Rectangle recAstroCol31;
@FXML
private Ellipse ovlAstroCol32;





        
@FXML
private void btnTest(ActionEvent event) throws IOException { //Test button remove before completion  
   panAstro.setTranslateX(panAstro.getTranslateX()-10); 
  checkCol();
  
}


private void checkCol(){
     Shape intersect = Shape.intersect(recShipCol1, ovlAstroCol2);
     
       if (intersect.getBoundsInParent().getWidth() > 0) {
           System.out.print("ObjectA intersects ObjectB"); //remove later
        }
       
}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       panShip.getChildren().add(createBoundsRectangle(recAstroCol1.getBoundsInParent()));  //make copy of astro block in ship
        panShip.getChildren().add(createBoundsEllipse(ovlAstroCol2.getBoundsInParent()));  //make copy of astro ovel in ship
    }    
    
    private Rectangle createBoundsRectangle(Bounds bounds) {  //method used to make the blank copy in other pane
        Rectangle rect = new Rectangle();      
        rect.setFill(Color.TRANSPARENT);
        rect.setX(bounds.getMinX());
        rect.setY(bounds.getMinY());
        rect.setWidth(bounds.getWidth());
        rect.setHeight(bounds.getHeight());
        return rect;
      }
    private Ellipse createBoundsEllipse(Bounds bounds) {  //method used to make the blank copy in other pane
        Ellipse ovl = new Ellipse();      
        ovl.setFill(Color.TRANSPARENT);
        ovl.setCenterX(bounds.getMinX());
        ovl.setCenterY(bounds.getMinY());
        ovl.setRadiusX(bounds.getWidth());
        ovl.setRadiusY(bounds.getHeight());
        return ovl;
      }
}