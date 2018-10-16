package trioteam.minigames;

/*
 * Made By: Erica Wheatley
 * Date: 10/16/18
 * Description: Memory matchning game
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
        // TODO
    }

}
