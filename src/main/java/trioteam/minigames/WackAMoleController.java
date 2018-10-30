/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
package trioteam.minigames;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Conner
 */
public class WackAMoleController implements Initializable {
    @FXML
    private Label mole0;
    @FXML
    private Label mole1;
    @FXML
    private Label mole2;
    @FXML
    private Label mole3;
    @FXML
    private Label mole4;
    @FXML
    private Label mole5;
    @FXML
    private Label mole6;
    @FXML
    private Label mole7;
    @FXML
    private Label mole8;
    
    Label mole[] = new Label[9];
    
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> moles()));
    
    private void moles() {
        Random rand = new Random();
            
        if (rand.nextInt(50) == 0) {
            mole[rand.nextInt(9)].setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mole[0] = mole0;
        mole[1] = mole1;
        mole[2] = mole2;
        mole[3] = mole3;
        mole[4] = mole4;
        mole[5] = mole5;
        mole[6] = mole6;
        mole[7] = mole7;
        mole[8] = mole8;
    }    
    
}
