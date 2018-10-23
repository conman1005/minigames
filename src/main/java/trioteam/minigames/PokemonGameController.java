package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static trioteam.minigames.MainApp.enemy;
import static trioteam.minigames.MainApp.enemyMaxHP;
import static trioteam.minigames.MainApp.maxHP;
import static trioteam.minigames.MainApp.pokemon;

/**
 * FXML Controller class
 *
 * @author Conner
 */
public class PokemonGameController implements Initializable {
    class moves {
        String pkmn;
        String move1;
        int move1DMG;
        String move2;
        int move2DMG;
    }
    
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
        lblPokemon.setText(pokemon);
        lblEnemy.setText(enemy);
        
        System.out.println(pokemon);
        
        picPokemon.getStyleClass().add(pokemon + "Back");
        picEnemy.getStyleClass().add(enemy + "Front");
        
        hp = maxHP;
        enemyHP = enemyMaxHP;
        
        lblPokemonHP.setText("HP: " + hp + "/" + maxHP);
        lblEnemyHP.setText("HP: " + enemyHP + "/" + enemyMaxHP);
        
        
        //Pokemon Movesets
        pokemonMoves[0][0] = "Charmander";
        pokemonMoves[0][1] = "Scratch";
        pokemonMoves[0][2] = "Ember";
        pokemonMoves[1][0] = "Squirtle";
        pokemonMoves[0][1] = "Scratch";
        pokemonMoves[0][2] = "Watergun";
        pokemonMoves[3][0] = "Bulbsoar";
        pokemonMoves[0][1] = "Scratch";
        pokemonMoves[0][2] = "Vine Whip";
        
    }    
    
}
