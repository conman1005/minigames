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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static trioteam.minigames.MainApp.pokeInfo;
import static trioteam.minigames.MainApp.pokeInfoE;


/**
 * FXML Controller class
 *
 * @author Conner
 */
public class PokemonGameController implements Initializable {

    //http://java-buddy.blogspot.com/2013/05/implement-javafx-listview-for-custom.html
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

    int hp;
    int enemyHP;

    String pokemonMoves[][] = new String[3][3];

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Basic Pokemon Data
        
        lblPokemon.setText(pokeInfo.pkmn);
        lblEnemy.setText(pokeInfoE.pkmn);
        
        picPokemon.getStyleClass().add(pokeInfo.pkmn + "Back");
        picEnemy.getStyleClass().add(pokeInfoE.pkmn + "Front");

        hp = pokeInfo.maxHP;
        enemyHP = pokeInfoE.maxHP;

        lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);

    }

}
