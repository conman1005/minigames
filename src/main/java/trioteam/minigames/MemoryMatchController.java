package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.net.URL;
import java.util.Random;
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
    
    
    
    @FXML
    private void play(ActionEvent event){           
        btnB1.setVisible(true); btnB2.setVisible(true);  btnB3.setVisible(true);  btnB4.setVisible(true);
        btnB5.setVisible(true); btnB6.setVisible(true);  btnB7.setVisible(true);  btnB8.setVisible(true);
        btnB9.setVisible(true); btnB10.setVisible(true); btnB11.setVisible(true); btnB12.setVisible(true);
        btnB13.setVisible(true); btnB14.setVisible(true); btnB15.setVisible(true); btnB16.setVisible(true);
        btnB17.setVisible(true); btnB18.setVisible(true); btnB19.setVisible(true); btnB20.setVisible(true);
        btnB21.setVisible(true); btnB22.setVisible(true); btnB23.setVisible(true); btnB24.setVisible(true);
        btnB25.setVisible(true); btnB26.setVisible(true); btnB27.setVisible(true); btnB28.setVisible(true);
        btnB29.setVisible(true); btnB30.setVisible(true);
        btnPlay.setVisible(false);
        
        Button btn = (Button) event.getSource();
        ImageView img = (ImageView) event.getSource();
        btn.setDisable(true);
        int add = +1;
        
        
        //random 1
        if (btnB1.isDisabled() == true && answer == 1){    
            img7.setVisible(true);
            lblShots.setText(""+add++);
        }  
        if (btnB2.isDisabled() == true && answer == 1){
            img28.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB3.isDisabled() == true && answer == 1){
            img10.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB4.isDisabled() == true && answer == 1){
            img1.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB5.isDisabled() == true && answer == 1){
            img20.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB6.isDisabled() == true && answer == 1){
            img15.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB7.isDisabled() == true && answer == 1){
            img18.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB8.isDisabled() == true && answer == 1){
            img9.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB9.isDisabled() == true && answer == 1){
            img4.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB10.isDisabled() == true && answer == 1){
            img3.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB11.isDisabled() == true && answer == 1){
            img2.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB12.isDisabled() == true && answer == 1){
            img17.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB13.isDisabled() == true && answer == 1){
            img12.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB14.isDisabled() == true && answer == 1){
            img11.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB15.isDisabled() == true && answer == 1){
            img23.setVisible(true);
            lblShots.setText(""+add++);
        } 
        if (btnB16.isDisabled() == true && answer == 1){
            img5.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB17.isDisabled() == true && answer == 1){
            img22.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB18.isDisabled() == true && answer == 1){
            img24.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB19.isDisabled() == true && answer == 1){
            img6.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB20.isDisabled() == true && answer == 1){
            img8.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB21.isDisabled() == true && answer == 1){
            img13.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB22.isDisabled() == true && answer == 1){
            img14.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB23.isDisabled() == true && answer == 1){
            img25.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB24.isDisabled() == true && answer == 1){
            img29.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB25.isDisabled() == true && answer == 1){
            img20.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB26.isDisabled() == true && answer == 1){
            img19.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB27.isDisabled() == true && answer == 1){
            img30.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB28.isDisabled() == true && answer == 1){
            img26.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB29.isDisabled() == true && answer == 1){
            img16.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB30.isDisabled() == true && answer == 1){
            img21.setVisible(true);
            lblShots.setText(""+add++);
        }
        
        if (lblShots.getText().equals("2") && btnB1.isDisabled() == true && answer == 1 && img7.isVisible() == true && btnB18.isDisabled() == true && img28.isVisible()){
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait();
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB2.isDisabled() == true && img28.isVisible() == true && btnB23.isDisabled() == true && img25.isVisible() == true && answer == 1){
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait();
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB3.isDisabled() == true && img10.isVisible() == true && btnB21.isDisabled() == true && img3.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB4.isDisabled() == true && img1.isVisible() == true && btnB26.isDisabled() == true && img19.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB5.isDisabled() == true && img20.isVisible() == true && btnB25.isDisabled() == true && img20.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB6.isDisabled() == true && img15.isVisible() == true && btnB29.isDisabled() == true && img16.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB7.isDisabled() == true && img18.isVisible() == true && btnB30.isDisabled() == true && img21.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB8.isDisabled() == true && img9.isVisible() == true && btnB24.isDisabled() == true && img29.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB9.isDisabled() == true && img4.isVisible() == true && btnB12.isDisabled() == true && img17.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB10.isDisabled() == true && img3.isVisible() == true && btnB22.isDisabled() == true && img14.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB11.isDisabled() == true && img2.isVisible() == true && btnB17.isDisabled() == true && img22.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait();
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB13.isDisabled() == true && img12.isVisible() == true && btnB15.isDisabled() == true && img23.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB14.isDisabled() == true && img11.isVisible() == true && btnB28.isDisabled() == true && img26.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("") && btnB16.isDisabled() == true && img5.isVisible() == true && btnB20.isDisabled() == true && img8.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        if (lblShots.getText().equals("2") && btnB19.isDisabled() == true && img6.isVisible() == true && btnB27.isDisabled() == true && img30.isVisible() == true && answer == 1){
           Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("yay you found a pair");
        alert.showAndWait(); 
        lblShots.setText("");
        }
        else if (lblShots.getText().equals("2")){
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Loser");
        alert.setHeaderText(null);
        alert.setContentText("oh no these are not a pair");
        alert.showAndWait();
        lblShots.setText("");
        btn.setDisable(false);
        img.setVisible(false);
        }
        
        
        //random 2
        if (btnB1.isDisabled() == true && answer == 2){    
            img3.setVisible(true);
            lblShots.setText(""+add++);
        }   
        if (btnB2.isDisabled() == true && answer == 2){
            img12.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB3.isDisabled() == true && answer == 2){
            img25.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB4.isDisabled() == true && answer == 2){
            img4.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB5.isDisabled() == true && answer == 2){
            img17.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB6.isDisabled() == true && answer == 2){
            img18.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB7.isDisabled() == true && answer == 2){
            img5.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB8.isDisabled() == true && answer == 2){
            img1.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB9.isDisabled() == true && answer == 2){
            img11.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB10.isDisabled() == true && answer == 2){
            img7.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB11.isDisabled() == true && answer == 2){
            img19.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB12.isDisabled() == true && answer == 2){
            img10.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB13.isDisabled() == true && answer == 2){
            img15.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB14.isDisabled() == true && answer == 2){
            img20.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB15.isDisabled() == true && answer == 2){
            img6.setVisible(true);
            lblShots.setText(""+add++);
        } 
        if (btnB16.isDisabled() == true && answer == 2){
            img2.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB17.isDisabled() == true && answer == 2){
            img9.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB18.isDisabled() == true && answer == 2){
            img24.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB19.isDisabled() == true && answer == 2){
            img30.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB20.isDisabled() == true && answer == 2){
            img21.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB21.isDisabled() == true && answer == 2){
            img29.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB22.isDisabled() == true && answer == 2){
            img13.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB23.isDisabled() == true && answer == 2){
            img23.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB24.isDisabled() == true && answer == 2){
            img22.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB25.isDisabled() == true && answer == 2){
            img8.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB26.isDisabled() == true && answer == 2){
            img26.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB27.isDisabled() == true && answer == 2){
            img28.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB28.isDisabled() == true && answer == 2){
            img16.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB29.isDisabled() == true && answer == 2){
            img14.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB30.isDisabled() == true && answer == 2){
            img27.setVisible(true);
            lblShots.setText(""+add++);
        }
        //random 3
        if (btnB1.isDisabled() == true && answer == 3){    
            img18.setVisible(true);
            lblShots.setText(""+add++);
        }   
        if (btnB2.isDisabled() == true && answer == 3){
            img9.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB3.isDisabled() == true && answer == 3){
            img25.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB4.isDisabled() == true && answer == 3){
            img4.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB5.isDisabled() == true && answer == 3){
            img2.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB6.isDisabled() == true && answer == 3){
            img10.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB7.isDisabled() == true && answer == 3){
            img20.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB8.isDisabled() == true && answer == 3){
            img6.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB9.isDisabled() == true && answer == 3){
            img12.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB10.isDisabled() == true && answer == 3){
            img5.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB11.isDisabled() == true && answer == 3){
            img1.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB12.isDisabled() == true && answer == 3){
            img11.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB13.isDisabled() == true && answer == 3){
            img3.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB14.isDisabled() == true && answer == 3){
            img7.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB15.isDisabled() == true && answer == 3){
            img15.setVisible(true);
            lblShots.setText(""+add++);
        } 
        if (btnB16.isDisabled() == true && answer == 3){
            img30.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB17.isDisabled() == true && answer == 3){
            img17.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB18.isDisabled() == true && answer == 3){
            img28.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB19.isDisabled() == true && answer == 3){
            img13.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB20.isDisabled() == true && answer == 3){
            img21.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB21.isDisabled() == true && answer == 3){
            img24.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB22.isDisabled() == true && answer == 3){
            img8.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB23.isDisabled() == true && answer == 3){
            img19.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB24.isDisabled() == true && answer == 3){
            img23.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB25.isDisabled() == true && answer == 3){
            img16.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB26.isDisabled() == true && answer == 3){
            img22.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB27.isDisabled() == true && answer == 3){
            img27.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB28.isDisabled() == true && answer == 3){
            img26.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB29.isDisabled() == true && answer == 3){
            img29.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (btnB30.isDisabled() == true && answer == 3){
            img14.setVisible(true);
            lblShots.setText(""+add++);
        }
        if (lblShots.getText().equals("2")){
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Loser");
        alert.setHeaderText(null);
        alert.setContentText("oh no these are not a pair");
        alert.showAndWait();
        }
        
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      if (answer==1){     
            lblRandom.setText("1");
        img1.setLayoutX(130);   img1.setLayoutY(440);
        img2.setLayoutX(293);   img2.setLayoutY(226);
        img3.setLayoutX(210);   img3.setLayoutY(512);
        img4.setLayoutX(210);   img4.setLayoutY(440);
        img5.setLayoutX(376);   img5.setLayoutY(512);
        img6.setLayoutX(376);   img6.setLayoutY(440);
        img7.setLayoutX(130);   img7.setLayoutY(224);
        img8.setLayoutX(377);   img8.setLayoutY(226);
        img9.setLayoutX(210);   img9.setLayoutY(368);
        img10.setLayoutX(130);  img10.setLayoutY(368);
        img11.setLayoutX(293);  img11.setLayoutY(440);
        img12.setLayoutX(293);  img12.setLayoutY(368);
        img13.setLayoutX(463);  img13.setLayoutY(228);
        img14.setLayoutX(463);  img14.setLayoutY(297);
        img15.setLayoutX(210);  img15.setLayoutY(234);
        img16.setLayoutX(549);  img16.setLayoutY(442);
        img17.setLayoutX(293);  img17.setLayoutY(297);
        img18.setLayoutX(210);  img18.setLayoutY(297);
        img19.setLayoutX(548);  img19.setLayoutY(228);
        img20.setLayoutX(130);  img20.setLayoutY(510);
        img21.setLayoutX(550);  img21.setLayoutY(514);
        img22.setLayoutX(377);  img22.setLayoutY(297);
        img23.setLayoutX(293);  img23.setLayoutY(512);
        img24.setLayoutX(376);  img24.setLayoutY(368);
        img25.setLayoutX(130);  img25.setLayoutY(295);
        img26.setLayoutX(553);  img26.setLayoutY(370);
        img27.setLayoutX(468);  img27.setLayoutY(512);
        img28.setLayoutX(463);  img28.setLayoutY(368);
        img29.setLayoutX(463);  img29.setLayoutY(440);
        img30.setLayoutX(553);  img30.setLayoutY(297);
        }
        if (answer==2){
            lblRandom.setText("2");
        img1.setLayoutX(210);   img1.setLayoutY(368);
        img2.setLayoutX(377);   img2.setLayoutY(226);
        img3.setLayoutX(130);   img3.setLayoutY(224);
        img4.setLayoutX(130);   img4.setLayoutY(440);
        img5.setLayoutX(210);   img5.setLayoutY(297);
        img6.setLayoutX(293);   img6.setLayoutY(512);
        img7.setLayoutX(210);   img7.setLayoutY(512);
        img8.setLayoutX(468);   img8.setLayoutY(512);
        img9.setLayoutX(377);   img9.setLayoutY(297);
        img10.setLayoutX(293);  img10.setLayoutY(297);
        img11.setLayoutX(210);  img11.setLayoutY(440);
        img12.setLayoutX(130);  img12.setLayoutY(295);
        img13.setLayoutX(463);  img13.setLayoutY(297);
        img14.setLayoutX(549);  img14.setLayoutY(442);
        img15.setLayoutX(293);  img15.setLayoutY(368);
        img16.setLayoutX(553);  img16.setLayoutY(370);
        img17.setLayoutX(130);  img17.setLayoutY(510);
        img18.setLayoutX(210);  img18.setLayoutY(234);
        img19.setLayoutX(293);  img19.setLayoutY(226);
        img20.setLayoutX(293);  img20.setLayoutY(440);
        img21.setLayoutX(376);  img21.setLayoutY(512);
        img22.setLayoutX(463);  img22.setLayoutY(440);
        img23.setLayoutX(463);  img23.setLayoutY(368);
        img24.setLayoutX(376);  img24.setLayoutY(368);
        img25.setLayoutX(130);  img25.setLayoutY(368);
        img26.setLayoutX(548);  img26.setLayoutY(228);
        img27.setLayoutX(550);  img27.setLayoutY(514);
        img28.setLayoutX(553);  img28.setLayoutY(293);
        img29.setLayoutX(463);  img29.setLayoutY(228);
        img30.setLayoutX(376);  img30.setLayoutY(440);    
        }
        if (answer==3){
            lblRandom.setText("3");
        img1.setLayoutX(293);   img1.setLayoutY(226);
        img2.setLayoutX(130);   img2.setLayoutY(510);
        img3.setLayoutX(293);   img3.setLayoutY(368);
        img4.setLayoutX(130);   img4.setLayoutY(440);
        img5.setLayoutX(210);   img5.setLayoutY(512);
        img6.setLayoutX(210);   img6.setLayoutY(368);
        img7.setLayoutX(293);   img7.setLayoutY(440);
        img8.setLayoutX(463);   img8.setLayoutY(297);
        img9.setLayoutX(130);   img9.setLayoutY(295);
        img10.setLayoutX(210);  img10.setLayoutY(234);
        img11.setLayoutX(293);  img11.setLayoutY(297);
        img12.setLayoutX(210);  img12.setLayoutY(440);
        img13.setLayoutX(376);  img13.setLayoutY(440);
        img14.setLayoutX(550);  img14.setLayoutY(514);
        img15.setLayoutX(293);  img15.setLayoutY(512);
        img16.setLayoutX(468);  img16.setLayoutY(512);
        img17.setLayoutX(377);  img17.setLayoutY(297);
        img18.setLayoutX(130);  img18.setLayoutY(224);
        img19.setLayoutX(463);  img19.setLayoutY(368);
        img20.setLayoutX(210);  img20.setLayoutY(297);
        img21.setLayoutX(376);  img21.setLayoutY(512);
        img22.setLayoutX(548);  img22.setLayoutY(228);
        img23.setLayoutX(463);  img23.setLayoutY(440);
        img24.setLayoutX(463);  img24.setLayoutY(228);
        img25.setLayoutX(130);  img25.setLayoutY(368);
        img26.setLayoutX(553);  img26.setLayoutY(370);
        img27.setLayoutX(376);  img27.setLayoutY(368);
        img28.setLayoutX(553);  img28.setLayoutY(297);
        img29.setLayoutX(549);  img29.setLayoutY(442);
        img30.setLayoutX(377);  img30.setLayoutY(226);    
        }  

}
}