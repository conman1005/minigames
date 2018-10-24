package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static trioteam.minigames.MainApp.pokeInfo;
import static trioteam.minigames.MainApp.pokeInfoE;


/**
 * FXML Controller class
 *
 * @author Conner
 */
public class PokemonGameController implements Initializable {

    @FXML
    private Label picPokemon;
    @FXML
    private Label lblPokemon;
    @FXML
    private Label lblPokemonHP;
    @FXML
    private Label picEnemy;
    @FXML
    private Label lblEnemy;
    @FXML
    private Label lblEnemyHP;
    @FXML
    private Button btnM1;
    @FXML
    private Button btnM2;

    int hp;
    int enemyHP;
    
    Alert alert = new Alert(AlertType.INFORMATION);
    
    @FXML
    private void btnM1(ActionEvent event) {
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move1 + "!");
        alert.showAndWait();
    }
    @FXML
    private void btnM2(ActionEvent event) {
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move2 + "!");
        alert.showAndWait();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert.setHeaderText(null);
        alert.setContentText("You have been faced by " + pokeInfoE.pkmn + "!");
        Platform.runLater(alert::showAndWait);
        
        //Basic Pokemon Data
        
        lblPokemon.setText(pokeInfo.pkmn);
        lblEnemy.setText(pokeInfoE.pkmn);
        
        picPokemon.getStyleClass().add(pokeInfo.pkmn + "Back");
        picEnemy.getStyleClass().add(pokeInfoE.pkmn + "Front");

        hp = pokeInfo.maxHP;
        enemyHP = pokeInfoE.maxHP;

        lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);
        
        btnM1.setText(pokeInfo.move1);
        btnM2.setText(pokeInfo.move2);

    }

}
