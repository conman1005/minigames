/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
package trioteam.minigames;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import static trioteam.minigames.MainApp.wacHighScore;

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

    @FXML
    private Label lblPoints;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblHighScore;

    @FXML
    private Button btnPlay;

    Label mole[] = new Label[9];

    int points = 0;

    int time = 30;

    Timeline timer = new Timeline(new KeyFrame(Duration.millis(5), ae -> moles()));

    Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private void btnPlay(ActionEvent event) {
        timer.setCycleCount(INDEFINITE);
        timer.play();
        btnPlay.setDisable(true);
    }

    private void moles() {
        Random rand = new Random();

        if (rand.nextInt(50) == 0) {
          
            mole[rand.nextInt(9)].setVisible(true);
        }
        if (rand.nextInt(50) == 1) {
            mole[rand.nextInt(9)].setVisible(false);
        }
        timee++;
        if (timee == 200) {
            time--;
            lblTime.setText("Time: " + time);
            timee = 0;
            if (time == 0) {
                timer.stop();
                alert.setTitle("Wack A Mole");
                alert.setHeaderText("Game Over");
                alert.setContentText("You got " + points + " Points!");

                if (points > wacHighScore) {
                    wacHighScore = points;
                    lblHighScore.setText("High Score: " + wacHighScore);
                    alert.setContentText("You got a new High Score of " + wacHighScore + "!");
                }

                Platform.runLater(alert::showAndWait);

                timee = 0;
                time = 30;
                lblTime.setText("Time: 30");
                
                points = 0;
                lblPoints.setText("Points: 0");

                btnPlay.setDisable(false);

                for (int i = 0; i < mole.length; i++) {
                    mole[i].setVisible(false);
                }
            }
        }
    }

    int timee = 0;

    @FXML
    private void moleClick(Event event) {
        Label lbl = (Label) event.getSource();
        lbl.setVisible(false);
        points++;
        lblPoints.setText("Points: " + points);
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
        
         for (int r = 0; r <= 8; r++) {
              mole[r].getStyleClass().clear();
                mole[r].getStyleClass().add(MainApp.wacImage);
               
                }
            
    }

}
