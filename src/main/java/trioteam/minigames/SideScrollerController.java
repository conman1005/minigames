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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
private ImageView picShip;
//Astaroid
@FXML
private ImageView picAstaroid;
//Hit boxes
@FXML
private Label lblShipCol1;
@FXML
private Label lblShipCol2;
@FXML
private Label lblAstroCol1;
@FXML
private Label lblAstroCol2;
//pane
@FXML
private Pane panShip;
@FXML
private Pane panAstro;
        
@FXML
private void btnTest(ActionEvent event) throws IOException { //Test button remove before completion  
   panAstro.setTranslateX(panAstro.getTranslateX()+5); 
}

private void throwAstro(){
    
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
