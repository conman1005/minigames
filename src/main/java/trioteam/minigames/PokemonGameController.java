package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
    @FXML
    private Button btnMenu;

    int hp;
    int enemyHP;

    Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private void btnM1(ActionEvent event) throws IOException {
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move1 + "!");
        alert.showAndWait();
        enemyHP = enemyHP - pokeInfo.move1DMG;
        alert.setContentText("That did " + pokeInfo.move1DMG + " damage!");
        if (enemyHP <= 0) {
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            alert.showAndWait();
            btnM1.setDisable(true);
            btnM2.setDisable(true);
            btnMenu.setVisible(true);
            return;
        }
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);
        alert.showAndWait();
        enemyTurn();
    }

    @FXML
    private void btnM2(ActionEvent event) {
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move2 + "!");
        alert.showAndWait();
        enemyHP = enemyHP - pokeInfo.move2DMG;
        alert.setContentText("That did " + pokeInfo.move2DMG + " damage!");
        if (enemyHP <= 0) {
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            alert.showAndWait();
            btnM1.setDisable(true);
            btnM2.setDisable(true);
            btnMenu.setVisible(true);
            return;
        }
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);
        alert.showAndWait();
        enemyTurn();
    }
    
    private void enemyTurn() {
        Random rand = new Random();
        int ans = rand.nextInt(2);
        if (ans == 0) {
            alert.setContentText(pokeInfoE.pkmn + " used " + pokeInfoE.move1 + "!");
            alert.showAndWait();
            hp = hp - pokeInfoE.move1DMG;
            alert.setContentText("That did " + pokeInfoE.move1DMG + " damage!");
            if (enemyHP <= 0) {
                lblPokemonHP.setText("HP: 0" + "/" + pokeInfo.maxHP);
                alert.setContentText("You have been defeated by " + pokeInfoE.pkmn);
                alert.showAndWait();
                btnM1.setDisable(true);
                btnM2.setDisable(true);
                btnMenu.setVisible(true);
                return;
            }
            lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
            alert.showAndWait();

        } else {
            alert.setContentText(pokeInfoE.pkmn + " used " + pokeInfoE.move2 + "!");
            alert.showAndWait();
            hp = hp - pokeInfoE.move2DMG;
            alert.setContentText("That did " + pokeInfoE.move2DMG + " damage!");
            lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
            alert.showAndWait();
        }
    }
    
    @FXML
    private void btnMenu(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/pokemonMenu.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("Pokemon"); //changes the title
        stage.show(); //shows the new page
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert.setTitle("Pokemon");
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
