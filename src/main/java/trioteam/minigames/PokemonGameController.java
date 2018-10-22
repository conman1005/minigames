package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static trioteam.minigames.MainApp.enemy;
import static trioteam.minigames.MainApp.pokemon;

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
    
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblPokemon.setText(pokemon);
        lblEnemy.setText(pokemon);
        
        picPokemon.getStyleClass().add(pokemon + "Back");
        picEnemy.getStyleClass().add(pokemon + "Front");
    }    
    
}
