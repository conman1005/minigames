package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Erica
 */
public class MemoryMatchController implements Initializable {

  /*  @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuInstructions;
    
private ImageView cImg1=null;
private ImageView cImg2=null;

private Button cBtn1=null;
private Button cBtn2=null;
    
ArrayList<Integer> imageList = new <Integer>ArrayList();
ArrayList<Button> buttons = new <Button>ArrayList();
int firstCard = 100;
int secondCard = 100;
int pairsLeft = 15;

    @FXML
    private Button btnB01;    @FXML private Button btnB02;    @FXML private Button btnB03;
    
    @FXML
    private Button btnB04;   @FXML private Button btnB05;     @FXML private Button btnB06;
    
    @FXML
    private Button btnB07;   @FXML private Button btnB08;     @FXML private Button btnB09;
    
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
    private ImageView img1;     @FXML private ImageView img2;   @FXML private ImageView img3;
    
    @FXML
    private ImageView img4;     @FXML private ImageView img5;   @FXML private ImageView img6;
    
    @FXML
    private ImageView img7;     @FXML private ImageView img8;   @FXML private ImageView img9;
    
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

    int answer = ThreadLocalRandom.current().nextInt(1,3+1);
    
    @FXML
    private Label lblShots;
    
    @FXML
    private Label lblRandom;
       
    int add = 0;
    
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
    
    public void putCard(int cardNum) {
        for (int i = 0; i < 15; i++) {
            imageList.add(i);
            imageList.add(i);
        }
        Collections.shuffle(imageList);
        //Check to see if the card has already been used or they clicked on the same one again. If so stop the code
        if (buttons.get(cardNum).isDisabled() == true || firstCard == cardNum) {
        return;
    }

        //Checks to see if two cards are showing, if they are flip them
        if (firstCard != 100 && secondCard != 100) {
        //clear the image
        buttons.get(firstCard).setImage(null);
        buttons.get(secondCard).setImage(null);
        //resets the cards
        firstCard = 20;
        secondCard = 20;
}

        //Checks to see if this is the first card they pushed
        if (firstCard == 20 && secondCard == 20) {
        firstCard = cardNum;
        //Load the image
        buttons.get(cardNum).setIcon(new Image(this.getClass().getResource(imageList.get(cardNum) + ".jpg")));
    }
        //Checks to see if this is the second card they pushed
        else if (firstCard != 20 && secondCard == 20) {
        secondCard = cardNum;
        buttons.get(cardNum).setIcon(new Image(this.getClass().getResource(imageList.get(cardNum) + ".jpg")));
        //Check to see if the cards match
        if (imageList.get(firstCard).equals(imageList.get(secondCard))) {
        //Turn the labels off
        buttons.get(firstCard).setDisable(true);
        buttons.get(secondCard).setDisable(true);
        //Reset the card hold varable
        firstCard = 20;
        secondCard = 20;
        //One less pair to find
        pairsLeft--;
        }
    }
        //Check to see if you won
        if (pairsLeft == 0) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found all the pairs");
        alert.showAndWait();
    }

    }
    
    
    */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    /*buttons.add(btnB01);
    buttons.add(btnB02);
    buttons.add(btnB03);
    buttons.add(btnB04);
    buttons.add(btnB05);
    buttons.add(btnB06);
    buttons.add(btnB07);
    buttons.add(btnB08);
    buttons.add(btnB09);
    buttons.add(btnB10);
    buttons.add(btnB11);
    buttons.add(btnB12);
    buttons.add(btnB13);
    buttons.add(btnB14);
    buttons.add(btnB15);
    buttons.add(btnB16);
    buttons.add(btnB17);
    buttons.add(btnB18);
    buttons.add(btnB19);
    buttons.add(btnB20);
    buttons.add(btnB21);
    buttons.add(btnB22);
    buttons.add(btnB23);
    buttons.add(btnB24);     
    buttons.add(btnB25);
    buttons.add(btnB26);
    buttons.add(btnB27);
    buttons.add(btnB28);
    buttons.add(btnB29);
    buttons.add(btnB30);
          
*/
}
}