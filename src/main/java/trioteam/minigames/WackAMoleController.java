/*
 * Made By: Conner Cullity, Spencer Jones and Erica Wheatley
 * Date: 11/1/2018
 * Description: Whack a mole mini game
 */
package trioteam.minigames;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import static trioteam.minigames.MainApp.credits;
import static trioteam.minigames.MainApp.wacHighScore;

/**
 * FXML Controller class
 *
 * @author Conner
 */
public class WackAMoleController implements Initializable {

    //Declairs Labels, Buttons and other nessisary objects
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
    private Label lblCredits;

    @FXML
    private Button btnPlay;

    //Array for each mole
    Label mole[] = new Label[9];

    int points = 0;

    int time = 30;

    boolean gameOn = false;

    Timeline timer = new Timeline(new KeyFrame(Duration.millis(5), ae -> moles()));

    Alert alert = new Alert(AlertType.INFORMATION);

    MediaPlayer punch = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/punch.mp3").toString())));

    //Starts the timer that makes the game work
    @FXML
    private void btnPlay(ActionEvent event) {
        timer.setCycleCount(INDEFINITE);
        timer.play();
        btnPlay.setDisable(true);
        gameOn = true;
    }

    private void moles() {

        Random rand = new Random();
        //if the random number is 0, then a random mole appears
        if (rand.nextInt(50) == 0) {
            mole[rand.nextInt(9)].setVisible(true);
        }
        //if the random number is 1, then a random mole disapears
        if (rand.nextInt(50) == 1) {
            mole[rand.nextInt(9)].setVisible(false);
        }
        //every 200 'timee' decreases the count down by 1.
        //the timer runs every 5 milliseconds,and 200 * 5 milliseconds = 1 second
        timee++;
        if (timee == 200) {
            time--;
            lblTime.setText("Time: " + time);
            timee = 0;
            //ends game when time is up
            if (time == 0) {
                timer.stop();
                alert.setTitle("Wack A Mole");
                alert.setHeaderText("Game Over");
                alert.setContentText("You got " + points + " Points!");

                //every point converts into a credit, which you can use in the charicter store
                credits = credits + points;
                lblCredits.setText("Credits: " + credits);
                //checks if your score is better than the highscore, updates highscore if so
                if (points > wacHighScore) {
                    wacHighScore = points;
                    lblHighScore.setText("High Score: " + wacHighScore);
                    alert.setContentText("You got a new High Score of " + wacHighScore + "!");
                }

                Platform.runLater(alert::showAndWait);
                //resets variables
                timee = 0;
                time = 30;
                lblTime.setText("Time: 30");

                points = 0;
                lblPoints.setText("Points: 0");

                btnPlay.setDisable(false);

                gameOn = false;
                //makes all moles invisible
                for (int i = 0; i < mole.length; i++) {
                    mole[i].setVisible(false);
                }
            }
        }
    }

    int timee = 0;

    //every mole uses this code
    @FXML
    private void moleClick(Event event) {
        //gets the source and makes it invisible
        Label lbl = (Label) event.getSource();
        lbl.setVisible(false);
        punch.stop();
        punch.play();
        //adds a point
        points++;
        lblPoints.setText("Points: " + points);
    }

    @FXML
    private void recMiss() {
        //decreases points when you miss the mole. you can't go under 0 points
        if ((gameOn == true) && (points > 0)) {
            points--;
            lblPoints.setText("Points: " + points);
        }
    }

    @FXML
    private void returnToMenu(Event event) throws IOException {
        timer.stop();
        //returns you to the mole menu
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/wacMenu.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getRoot().requestFocus();
        //get reference to the stage 

        MainApp.mainStage.hide(); //optional
        MainApp.mainStage.setScene(home_page_scene); //puts the new scence in the stage

        MainApp.mainStage.setTitle("MiniGames"); //changes the title
        MainApp.mainStage.show(); //shows the new page 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //adds all moles into the array
        mole[0] = mole0;
        mole[1] = mole1;
        mole[2] = mole2;
        mole[3] = mole3;
        mole[4] = mole4;
        mole[5] = mole5;
        mole[6] = mole6;
        mole[7] = mole7;
        mole[8] = mole8;
        //updates labels with the highscore and credits
        lblHighScore.setText("High Score: " + wacHighScore);
        lblCredits.setText("Credits: " + credits);

        //gives every mole the set picture
        for (int r = 0; r <= 8; r++) {
            mole[r].getStyleClass().clear();
            mole[r].getStyleClass().add(MainApp.wacImage);

        }

    }

}
