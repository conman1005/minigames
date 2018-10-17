package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author Erica
 */
public class MemoryMatchController implements Initializable {

    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuInstructions;
    
    @FXML
    private Button btnB1;    @FXML private Button btnB2;    @FXML private Button btnB3;
    
    @FXML
    private Button btnB4;   @FXML private Button btnB5;     @FXML private Button btnB6;
    
    @FXML
    private Button btnB7;   @FXML private Button btnB8;     @FXML private Button btnB9;
    
    @FXML
    private Button btnB10;  @FXML private Button btnB11;    @FXML private Button btnB12;
    
    @FXML 
    private Button btnB13;  @FXML private Button btnB14;    @FXML private Button btnB15;
    
    @FXML
    private Button btnB16;  @FXML private Button btnB17;    @FXML private Button btnB18;
    
    @FXML
    private Button btnB19;  @FXML private Button btnB20;    @FXML private Button btnB21;
    
    @FXML
    private Button btnB22;  @FXML private Button btnB23;    @FXML private Button btnB24;
    
    @FXML
    private Button btnB25;  @FXML private Button btnB26;    @FXML private Button btnB27;
    
    @FXML 
    private Button btnB28;  @FXML private Button btnB29;    @FXML private Button btnB30;
    
    @FXML
    private Button btnB31;  @FXML private Button btnB32;    @FXML private Button btnB33;
    
    @FXML
    private Button btnB34;  @FXML private Button btnB35;    @FXML private Button btnB36;
    
    @FXML
    private Button btnB37;  @FXML private Button btnB38;    @FXML private Button btnB39;
    
    @FXML 
    private Button btnB40;
    
    ArrayList <Button> grid = new ArrayList();
    
    Random rand = new Random();

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void instructions(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instructions");
        alert.setHeaderText(null);
        alert.setContentText("A series of pictures will show up on the screen, memeorize the placements of the images"
                + "The pictures will go away after 3 seconds"
                + "Click on the buttons to try and find pairs in the fastest time possible");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    grid.add(btnB1);    grid.add(btnB21);
    grid.add(btnB2);    grid.add(btnB22);
    grid.add(btnB3);    grid.add(btnB23);
    grid.add(btnB4);    grid.add(btnB24);
    grid.add(btnB5);    grid.add(btnB25);
    grid.add(btnB6);    grid.add(btnB26);
    grid.add(btnB7);    grid.add(btnB27);
    grid.add(btnB8);    grid.add(btnB28);
    grid.add(btnB9);    grid.add(btnB29);
    grid.add(btnB10);   grid.add(btnB30);
    grid.add(btnB11);   grid.add(btnB31);
    grid.add(btnB12);   grid.add(btnB32);
    grid.add(btnB13);   grid.add(btnB33);
    grid.add(btnB14);   grid.add(btnB34);
    grid.add(btnB15);   grid.add(btnB35);
    grid.add(btnB16);   grid.add(btnB36);
    grid.add(btnB17);   grid.add(btnB37);
    grid.add(btnB18);   grid.add(btnB38);
    grid.add(btnB19);   grid.add(btnB39);
    grid.add(btnB20);   grid.add(btnB40);
    
   
    }

}
