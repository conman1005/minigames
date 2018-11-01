package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Erica
 */
public class MemoryMatchController implements Initializable {

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ae -> moveSeconds()));
    
    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuInstructions;

        

ArrayList<Integer> imageList = new <Integer>ArrayList();
ArrayList<ImageView> buttons = new <ImageView>ArrayList();
int firstCard = 100;
int secondCard = 100;
int pairsLeft = 15;

MediaPlayer player;

 

    @FXML
    private ImageView img01;     @FXML private ImageView img02;   @FXML private ImageView img03;
    
    @FXML
    private ImageView img04;     @FXML private ImageView img05;   @FXML private ImageView img06;
    
    @FXML
    private ImageView img07;     @FXML private ImageView img08;   @FXML private ImageView img09;
    
    @FXML
    private ImageView img10;    @FXML private ImageView img11;  @FXML private ImageView img12;
    
    @FXML
    private ImageView img13;     @FXML private ImageView img14;   @FXML private ImageView img15;
    
    @FXML
    private ImageView img16;     @FXML private ImageView img17;   @FXML private ImageView img18;
    
    @FXML
    private ImageView img19;     @FXML private ImageView img20;   @FXML private ImageView img21;
    
    @FXML
    private ImageView img22;    @FXML private ImageView img23;  @FXML private ImageView img24;
    
    @FXML
    private ImageView img25;     @FXML private ImageView img26;   @FXML private ImageView img27;
    
    @FXML
    private ImageView img28;     @FXML private ImageView img29;   @FXML private ImageView img30;
    
    @FXML
    private Button btnPlay;

   @FXML
   private Label lblScore;
    
    @FXML
    private Label lblTime;
    
    @FXML

    private Label lblRandom;
    
    @FXML
    private Label lblPair;
   
    private Label lblHighScore;
    
    @FXML
    private MenuItem menuBack;
       

    int add = 0;
    int time = 0;
    int minute = 0;
    int highscore = 0;
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void instructions(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instructions");
        alert.setHeaderText(null);
        alert.setContentText("Click on 2 spaces and tr and find all 15 pairs!"
                + "Find all the pairs in the shortest time possible!");
        alert.showAndWait();
    }
    

    @FXML
    private void play(ActionEvent event){
        btnPlay.setVisible(false);
    }

    @FXML
    private void back(ActionEvent event) throws IOException{
    Parent second = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene first = new Scene(second);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(first);
        stage.setTitle("Page 1");
        stage.show();
    }
    
    @FXML
    private void moveSeconds() {
        time++;
        lblTime.setText(minute + ":" + time);
        if (time >= 60) {
            minute++;
            lblTime.setText(minute + ":" + time);
            time = 0;
        }

    }
 
    public void putCard(MouseEvent event) {
      ImageView btn = (ImageView) event.getSource();
      int cardNum=Integer.parseInt(btn.getId().substring(btn.getId().length()-2));
        //Check to see if the card has already been used or they clicked on the same one again. If so stop the code
        if (buttons.get(cardNum).isDisabled() == true || firstCard == cardNum) {
        return;
    }

        //Checks to see if two cards are showing, if they are flip them
        if (firstCard != 100 && secondCard != 100) {
        //clear the image
        Image blank = new Image(getClass().getResource("/PICTURES/background-new.jpg").toString());
        buttons.get(firstCard).setImage(blank);
        buttons.get(secondCard).setImage(blank);
        //resets the cards
        firstCard = 100;
        secondCard = 100;
}

        //Checks to see if this is the first card they pushed
        if (firstCard == 100 && secondCard == 100) {
        firstCard = cardNum;
        //Load the image
        Image name = new Image(getClass().getResource("/PICTURES/"+imageList.get(cardNum) + ".png").toString());
        buttons.get(cardNum).setImage(name);
        
    }
        //Checks to see if this is the second card they pushed
        else if (firstCard != 100 && secondCard == 100) {
        secondCard = cardNum;
         Image name = new Image(getClass().getResource("/PICTURES/"+imageList.get(cardNum) + ".png").toString());
        buttons.get(cardNum).setImage(name);
        //Check to see if the cards match
        }
        if (imageList.get(firstCard).equals(imageList.get(secondCard))) {
        //Turn the labels off
        buttons.get(firstCard).setVisible(false);
        buttons.get(secondCard).setVisible(false);
        MainApp.credits = 0;
        MainApp.credits ++;
        lblScore.setText(""+MainApp.credits);
        //Reset the card hold varable
        firstCard = 100;
        secondCard = 100;
        //One less pair to find
        pairsLeft--;
        highscore = minute * 60 + time;
        lblScore.setText("" + highscore + "seconds");
        timeline.stop();
        MainApp.credits = highscore;

    
        }
    }
    



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        player = new MediaPlayer((new Media(getClass().getResource("/PICTURES/music.mp3").toString())));
    buttons.add(img01);
    buttons.add(img02);
    buttons.add(img03);
    buttons.add(img04);
    buttons.add(img05);
    buttons.add(img06);
    buttons.add(img07);
    buttons.add(img08);
    buttons.add(img09);
    buttons.add(img10);
    buttons.add(img11);
    buttons.add(img12);
    buttons.add(img13);
    buttons.add(img14);
    buttons.add(img15);
    buttons.add(img16);
    buttons.add(img17);
    buttons.add(img18);
    buttons.add(img19);
    buttons.add(img20);
    buttons.add(img21);
    buttons.add(img22);
    buttons.add(img23);
    buttons.add(img24);     
    buttons.add(img25);
    buttons.add(img26);
    buttons.add(img27);
    buttons.add(img28);
    buttons.add(img29);
    buttons.add(img30);
      //Add two of each of the possible cards to an array
        for (int i = 0; i < 15; i++) {
            imageList.add(i);
            imageList.add(i);
        }
        //This randomly sorts the array to move the images around
        Collections.shuffle(imageList);    


}
}
        
    

