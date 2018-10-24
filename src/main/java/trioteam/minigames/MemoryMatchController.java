package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.net.URL;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

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
    private Button btnB37;  @FXML private Button btnB38;    @FXML private Button btnB39;     @FXML private Button btnB40;
    
    @FXML
    private Button btnPlay;
    
    String pics[] = {"picture-boo", "picture-bowser", "picture-controller", "picture-donkey-kong", "picture-game-boy",
                     "picture-mario-star", "picture-mario", "picture-pacman-ghost", "picture-pacman", "picture-poke-ball",
                     "picture-sonic", "picture-space-invaders", "picture-star-wars", "picture-toad", "picture-yoshi"};
    
    Button grid[] = new Button[40];    
    
    Random rand = new Random();
    
    @FXML
    private Label lblShots;

    PauseTransition pause = new PauseTransition(Duration.seconds(5));
    
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
    private void buttons(ActionEvent event){
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
        int answer = rand.nextInt((15 - 0) + 0) + 0;
            btn.getStyleClass().add(pics[answer]);
            
    }
    @FXML
    private void click(MouseEvent event){
    
    }
    
    @FXML
    private void play(ActionEvent event){
        for (int i = 0; i < grid.length; i++){
        grid[i].setVisible(true);
    }
        btnPlay.setVisible(false);
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    grid[0] = btnB1;    grid[20] = btnB21;
    grid[1] = btnB2;    grid[21] = btnB22;
    grid[2] = btnB3;    grid[22] = btnB23;
    grid[3] = btnB4;    grid[23] = btnB24;
    grid[4] = btnB5;    grid[24] = btnB25;
    grid[5] = btnB6;    grid[25] = btnB26;
    grid[6] = btnB7;    grid[26] = btnB27;
    grid[7] = btnB8;    grid[27] = btnB28;
    grid[8] = btnB9;    grid[28] = btnB29;
    grid[9] = btnB10;   grid[29] = btnB30;
    grid[10] = btnB11;  grid[30] = btnB31;
    grid[11] = btnB12;  grid[31] = btnB32;
    grid[12] = btnB13;  grid[32] = btnB33;
    grid[13] = btnB14;  grid[33] = btnB34;
    grid[14] = btnB15;  grid[34] = btnB35;
    grid[15] = btnB16;  grid[35] = btnB36;
    grid[16] = btnB17;  grid[36] = btnB37;
    grid[17] = btnB18;  grid[37] = btnB38;
    grid[18] = btnB19;  grid[38] = btnB39;
    grid[19] = btnB20;  grid[39] = btnB40;
    }

}
