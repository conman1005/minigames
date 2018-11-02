package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 11/1/2018
 * Description: The pokemon game of the MiniGames program.
 */

//imports
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.stage.Stage;
import javafx.util.Duration;
import static trioteam.minigames.MainApp.credits;
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
    
    //Declairing Labels, Buttons and other objects
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

    @FXML
    private ProgressBar prgLevel;
    @FXML
    private Label lblLevelCur;
    @FXML
    private Label lblLevelNext;
    
    boolean enemyTurn = false;

    DecimalFormat myFormat = new DecimalFormat("0");

    double hp;
    double enemyHP;

    Alert alert = new Alert(AlertType.INFORMATION);

    double dmg;
    
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), ae -> animate()));
    
    MediaPlayer punch = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/punch.mp3").toString())));
    MediaPlayer music = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/battle.mp3").toString())));
    
    //Attack 1
    @FXML
    private void btnM1(ActionEvent event) throws IOException {
        enemyTurn = false;
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move1 + "!");
        alert.showAndWait();
        
        //Starts attacking animation
        animation.setCycleCount(50);
        animation.play();
        punch.play();
        dmg = pokeInfo.move1DMG;
        
        //Checks if an attack is super effective
        if ((("Fire".equals(pokeInfo.move1Type)) && ("Grass".equals(pokeInfoE.type))) || (("Water".equals(pokeInfo.move1Type)) && ("Fire".equals(pokeInfoE.type))) || (("Grass".equals(pokeInfo.move1Type)) && ("Water".equals(pokeInfoE.type)))) {
            dmg = dmg * 1.5;
        }
        //Increase damage by the Level and subtracts opponents HP by the damage
        dmg = dmg * (1 + (pokeLevel / 10));
        enemyHP = enemyHP - dmg;
        alert.setContentText("That did " + dmg + " damage!");
        
        //checks if enemy is down
        if (enemyHP <= 0) {
            music.stop();
            music.setCycleCount(INDEFINITE);
            music = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/victory.mp3").toString())));
            music.play();
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            Platform.runLater(alert::showAndWait);
            //checks is enemy level is lower than your level; gives you 100 XP and 10 credits
            if (enemyLevel <= pokeLevel) {
                pokeXP = pokeXP + 100;
                credits = credits + 10;
            } else {
                //this equasion allows you to gain more XP the higher the enemy level is compared to your level.
                pokeXP = pokeXP + 100 + (100 * (enemyLevel - pokeLevel));
                credits = credits + (100 * (enemyLevel - pokeLevel));
            }
            //checks if you got enough XP to go to next level, and increased the XP needed for the next level
            if (pokeXP >= pokeXPNeeded) {
                pokeXP = 0;
                pokeLevel++;
                pokeXPNeeded = 500 + (500 * pokeLevel);
                alert.setContentText("Congrats! You have reached Level " + pokeLevel + "!");
                Platform.runLater(alert::showAndWait);
            }
            lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
            lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
            prgLevel.setProgress(pokeXP / pokeXPNeeded);
            btnM1.setDisable(true);
            btnM2.setDisable(true);
            btnMenu.setVisible(true);
            return;
        }
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);
        alert.showAndWait();
        punch.stop();
        enemyTurn();
    }

    @FXML
    private void btnM2(ActionEvent event) {
        enemyTurn = false;
        alert.setContentText(pokeInfo.pkmn + " used " + pokeInfo.move2 + "!");
        alert.showAndWait();
        //Starts attacking animation
        animation.setCycleCount(50);
        animation.play();
        punch.play();
        dmg = pokeInfo.move2DMG;
        //Checks if an attack is super effective
        if ((("Fire".equals(pokeInfo.move2Type)) && ("Grass".equals(pokeInfoE.type))) || (("Water".equals(pokeInfo.move2Type)) && ("Fire".equals(pokeInfoE.type))) || (("Grass".equals(pokeInfo.move2Type)) && ("Water".equals(pokeInfoE.type)))) {
            dmg = dmg + (dmg * 0.5);
        }
        //Increase damage by the Level and subtracts opponents HP by the damage
        dmg = dmg * (1 + (pokeLevel / 10));
        enemyHP = enemyHP - dmg;
        alert.setContentText("That did " + dmg + " damage!");
        //checks if enemy is down
        if (enemyHP <= 0) {
            music.stop();
            music.setCycleCount(INDEFINITE);
            music = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/victory.mp3").toString())));
            music.play();
            lblEnemyHP.setText("HP: 0" + "/" + pokeInfoE.maxHP);
            alert.setContentText("You have defeated the enemy " + pokeInfoE.pkmn);
            Platform.runLater(alert::showAndWait);
            //checks is enemy level is lower than your level; gives you 100 XP and 10 credits
            if (enemyLevel <= pokeLevel) {
                pokeXP = pokeXP + 100;
                credits = credits + 10;
            } else {
                //this equasion allows you to gain more XP the higher the enemy level is compared to your level.
                pokeXP = pokeXP + 100 + (100 * (enemyLevel - pokeLevel));
                credits = credits + (10 * (enemyLevel - pokeLevel));
            }
            //checks if you got enough XP to go to next level, and increased the XP needed for the next level
            if (pokeXP >= pokeXPNeeded) {
                pokeXP = 0;
                pokeLevel++;
                pokeXPNeeded = 500 + (500 * pokeLevel);
                alert.setContentText("Congrats! You have reached Level " + pokeLevel + "!");
                Platform.runLater(alert::showAndWait);
            }
            lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
            lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
            prgLevel.setProgress(pokeXP / pokeXPNeeded);
            btnM1.setDisable(true);
            btnM2.setDisable(true);
            btnMenu.setVisible(true);
            return;
        }
        lblEnemyHP.setText("HP: " + enemyHP + "/" + pokeInfoE.maxHP);
        alert.showAndWait();
        punch.stop();
        enemyTurn();
    }

    private void enemyTurn() {
        enemyTurn = true;
        Random rand = new Random();
        //random number for random move
        int ans = rand.nextInt(2);
        if (ans == 0) {
            alert.setContentText(pokeInfoE.pkmn + " used " + pokeInfoE.move1 + "!");
            alert.showAndWait();
            dmg = pokeInfoE.move1DMG;
            //Starts pokemon animation
            animation.setCycleCount(50);
            animation.play();
            punch.play();
            //Checks if the enemy attack is super effective
            if ((("Fire".equals(pokeInfoE.move1Type)) && ("Grass".equals(pokeInfo.type))) || (("Water".equals(pokeInfoE.move1Type)) && ("Fire".equals(pokeInfo.type))) || (("Grass".equals(pokeInfoE.move1Type)) && ("Water".equals(pokeInfo.type)))) {
                dmg = dmg + (dmg * 0.5);
            }
            //increased the damage depending on the enemy level
            dmg = dmg * (1 + (enemyLevel / 10));
            hp = hp - dmg;
            alert.setContentText("That did " + dmg + " damage!");
            //checks if your pokemon is down
            if (hp <= 0) {
                lblPokemonHP.setText("HP: 0" + "/" + pokeInfo.maxHP);
                alert.setContentText("You have been defeated by " + pokeInfoE.pkmn);
                Platform.runLater(alert::showAndWait);
                btnM1.setDisable(true);
                btnM2.setDisable(true);
                btnMenu.setVisible(true);
                return;
            }
            lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
            alert.showAndWait();
            punch.stop();

        } else {
            alert.setContentText(pokeInfoE.pkmn + " used " + pokeInfoE.move2 + "!");
            alert.showAndWait();
            //Starts pokemon animation
            animation.setCycleCount(50);
            animation.play();
            punch.play();
            dmg = pokeInfoE.move2DMG;
            //Checks if the enemy attack is super effective
            if ((("Fire".equals(pokeInfoE.move2Type)) && ("Grass".equals(pokeInfo.type))) || (("Water".equals(pokeInfoE.move2Type)) && ("Fire".equals(pokeInfo.type))) || (("Grass".equals(pokeInfoE.move2Type)) && ("Water".equals(pokeInfo.type)))) {
                dmg = dmg + (dmg * 0.5);
            }
            //increased the damage depending on the enemy level
            dmg = dmg * (1 + (enemyLevel / 10));
            hp = hp - dmg;
            alert.setContentText("That did " + dmg + " damage!");
            //checks if your pokemon is down
            if (hp <= 0) {
                lblPokemonHP.setText("HP: 0" + "/" + pokeInfo.maxHP);
                alert.setContentText("You have been defeated by " + pokeInfoE.pkmn);
                Platform.runLater(alert::showAndWait);
                btnM1.setDisable(true);
                btnM2.setDisable(true);
                btnMenu.setVisible(true);
                return;
            }
            alert.setContentText("That did " + dmg + " damage!");
            lblPokemonHP.setText("HP: " + hp + "/" + pokeInfo.maxHP);
            alert.showAndWait();
            punch.stop();
        }
    }
    int animate = 0;
    private void animate() {
        animate++;
        //checks who's turn it is
        if (enemyTurn == false) {
            if (animate >= 25) {
                //moves your pokemon 25 pixels to the Left
                picPokemon.setTranslateX(picPokemon.getTranslateX() - 1);
                if (animate >= 50) {
                    //moves your pokemon back to it's original spot
                    animate = 0;
                    picPokemon.setTranslateX(0);
                }
            } else {
                //moves your pokemon 25 pixels to the right
                picPokemon.setTranslateX(picPokemon.getTranslateX() + 1);
            }
        } else {
            if (animate >= 25) {
                //moves your pokemon 25 pixels to the right
                picEnemy.setTranslateX(picEnemy.getTranslateX() + 1);
                if (animate >= 50) {
                    //moves your enemy back to it's original spot
                    animate = 0;
                    picEnemy.setTranslateX(0);
                }
            } else {
                //moves your enemy 25 pixels to the left
                picEnemy.setTranslateX(picEnemy.getTranslateX() - 1);
            }
        }
    }
    
    //takes you to the pokemon menu
    @FXML
    private void btnMenu(ActionEvent event) throws IOException {
        music.stop();
        
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
        
        //checks if you used the missingno easter egg
        if ("missingno".equals(pokeInfoE.pkmn)) {
            alert.setContentText("cY_*RK`O*LHYUO ^RO*QKWO*KXN*ROVOK]ON*WS]]SXQNY");
            alert.setTitle("Qplfnpo");
            music = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/secret.mp3").toString())));
        }
        
        Platform.runLater(alert::showAndWait);

        //Basic Pokemon Data, setting to pictures to the right pokemon, setting labels to the names of the pokemon
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

        lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
        lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
        prgLevel.setProgress(pokeXP / pokeXPNeeded);
        
        //starts music
        music.setCycleCount(INDEFINITE);
        music.setVolume(0.5);
        music.play();
    }

}
