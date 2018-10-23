package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static trioteam.minigames.MainApp.pokemon;
import static trioteam.minigames.MainApp.enemy;

/**
 * FXML Controller class
 *
 * @author Conner
 */
public class PokemonMenuController implements Initializable {

    boolean chooseEnemy = false;
    
    @FXML
    private Label lblTitle;

    @FXML
    private void btnPokemon(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(btn.getText());
        if (chooseEnemy == false) {
            alert.setContentText("Are you sure you want to chose " + btn.getText() + "?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                pokemon = btn.getText();
                lblTitle.setText("Choose Your Enemy");
                chooseEnemy = true;
            }
            
        } else {
            alert.setContentText("Are you sure you want to chose " + btn.getText() + " for the enemy?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                enemy = btn.getText();
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/pokemonGame.fxml")); //where FXMLPage2 is the name of the scene

                Scene home_page_scene = new Scene(home_page_parent);
                //get reference to the stage 
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.hide(); //optional
                stage.setScene(home_page_scene); //puts the new scence in the stage

                stage.setTitle("Pokemon"); //changes the title
                stage.show(); //shows the new page
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
