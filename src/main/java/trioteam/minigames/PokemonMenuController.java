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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static trioteam.minigames.MainApp.pokemon;

/**
 * FXML Controller class
 *
 * @author Conner
 */
public class PokemonMenuController implements Initializable {
    
    @FXML
    private void btnPokemon(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(btn.getText());
        alert.setContentText("Are you sure you want to chose " + btn.getText() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
            pokemon = btn.getText();
        }
        else {
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
