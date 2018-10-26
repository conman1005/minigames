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
import static trioteam.minigames.MainApp.enemyLevel;
import static trioteam.minigames.MainApp.pokeInfo;
import static trioteam.minigames.MainApp.pokeInfoE;
import static trioteam.minigames.MainApp.pokeLevel;
import static trioteam.minigames.MainApp.pokeXP;
import static trioteam.minigames.MainApp.pokeXPNeeded;

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

    double hp;
    double enemyHP;

    Alert alert = new Alert(AlertType.INFORMATION);

    double dmg;

    @FXML
    private void btnM1(ActionEvent event) throws IOException {
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move1 + "!");
        alert.showAndWait();
        dmg = pokeInfo.move1DMG;
        if ((("Fire".equals(pokeInfo.move1Type)) && ("Grass".equals(pokeInfoE.type))) || (("Water".equals(pokeInfo.move1Type)) && ("Fire".equals(pokeInfoE.type))) || (("Grass".equals(pokeInfo.move1Type)) && ("Water".equals(pokeInfoE.type)))) {
            dmg = dmg * 1.5;
        }
        dmg = dmg * (1 + (pokeLevel / 10));
        enemyHP = enemyHP - dmg;
        alert.setContentText("That did " + dmg + " damage!");
        if (enemyHP <= 0) {
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            alert.showAndWait();
            if (enemyLevel < pokeLevel) {
                pokeXP = pokeXP + 100;
            } else {
                pokeXP = pokeXP + 100 + (100 * (enemyLevel - pokeLevel));
            }
            System.out.println("XP: " + pokeXP);
            System.out.println("XP needed: " + pokeXPNeeded);
            if (pokeXP >= pokeXPNeeded) {
                pokeXP = 0;
                pokeLevel++;
                pokeXPNeeded = 500 + (500 * pokeLevel);
                alert.setContentText("Congrats! You have reached Level " + pokeLevel + "!");
                alert.showAndWait();
            }
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
        dmg = pokeInfo.move2DMG;
        if ((("Fire".equals(pokeInfo.move2Type)) && ("Grass".equals(pokeInfoE.type))) || (("Water".equals(pokeInfo.move2Type)) && ("Fire".equals(pokeInfoE.type))) || (("Grass".equals(pokeInfo.move2Type)) && ("Water".equals(pokeInfoE.type)))) {
            dmg = dmg + (dmg * 0.5);
        }
        dmg = dmg * (1 + (pokeLevel / 10));
        enemyHP = enemyHP - dmg;
        alert.setContentText("That did " + dmg + " damage!");
        if (enemyHP <= 0) {
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            alert.showAndWait();
            if (enemyLevel < pokeLevel) {
                pokeXP = pokeXP + 100;
            } else {
                pokeXP = pokeXP + 100 + (100 * (enemyLevel - pokeLevel));
            }
            System.out.println("XP: " + pokeXP);
            System.out.println("XP needed: " + pokeXPNeeded);
            if (pokeXP >= pokeXPNeeded) {
                pokeXP = 0;
                pokeLevel++;
                pokeXPNeeded = 500 + (500 * pokeLevel);
                alert.setContentText("Congrats! You have reached Level " + pokeLevel + "!");
                alert.showAndWait();
            }
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
            dmg = pokeInfoE.move1DMG;
            if ((("Fire".equals(pokeInfoE.move1Type)) && ("Grass".equals(pokeInfo.type))) || (("Water".equals(pokeInfoE.move1Type)) && ("Fire".equals(pokeInfo.type))) || (("Grass".equals(pokeInfoE.move1Type)) && ("Water".equals(pokeInfo.type)))) {
                dmg = dmg + (dmg * 0.5);
            }
            dmg = dmg * (1 + (enemyLevel / 10));
            hp = hp - dmg;
            alert.setContentText("That did " + dmg + " damage!");
            if (hp <= 0) {
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
            dmg = pokeInfoE.move2DMG;
            if ((("Fire".equals(pokeInfoE.move2Type)) && ("Grass".equals(pokeInfo.type))) || (("Water".equals(pokeInfoE.move2Type)) && ("Fire".equals(pokeInfo.type))) || (("Grass".equals(pokeInfoE.move2Type)) && ("Water".equals(pokeInfo.type)))) {
                dmg = dmg + (dmg * 0.5);
            }
            dmg = dmg * (1 + (enemyLevel / 10));
            hp = hp - dmg;
            alert.setContentText("That did " + dmg + " damage!");
            if (hp <= 0) {
                lblPokemonHP.setText("HP: 0" + "/" + pokeInfo.maxHP);
                alert.setContentText("You have been defeated by " + pokeInfoE.pkmn);
                alert.showAndWait();
                btnM1.setDisable(true);
                btnM2.setDisable(true);
                btnMenu.setVisible(true);
                return;
            }
            alert.setContentText("That did " + dmg + " damage!");
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
        System.out.println("HP: " + pokeInfo.maxHP + " Enemy HP: " + pokeInfoE.maxHP);

        lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);

        btnM1.setText(pokeInfo.move1);
        btnM2.setText(pokeInfo.move2);

    }

}
