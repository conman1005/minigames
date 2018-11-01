package trioteam.minigames;

/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.stage.Stage;
import static trioteam.minigames.MainApp.enemyLevel;
import static trioteam.minigames.MainApp.pokeLevel;
import static trioteam.minigames.MainApp.pokeXP;
import static trioteam.minigames.MainApp.pokeXPNeeded;

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
    private Label lblLevel;
    @FXML
    private Slider sldLevel;

    @FXML
    private ProgressBar prgLevel;
    @FXML
    private Label lblLevelCur;
    @FXML
    private Label lblLevelNext;

    @FXML
    private TextField txtCheat;

    DecimalFormat myFormat = new DecimalFormat("0");

    MediaPlayer music = new MediaPlayer((new Media(getClass().getResource("/pokemonimages/opening.mp3").toString())));

    @FXML
    private void btnCharmander(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Charmander");
        if (chooseEnemy == false) {
            alert.setContentText("Are you sure you want to chose Charmander?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                MainApp.pokeInfo = new pkmn("charmander", "Fire", 30 * (1 + (pokeLevel / 10)), "Scratch", "Normal", 5, "Ember", "Fire", 10);
                lblTitle.setText("Choose Your Enemy");
                chooseEnemy = true;
                lblLevel.setVisible(true);
                sldLevel.setVisible(true);
            }

        } else {
            alert.setContentText("Are you sure you want to chose Charmander for the enemy?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                music.stop();

                MainApp.pokeInfoE = new pkmn("charmander", "Fire", 30 * (1 + (Double.parseDouble(myFormat.format(sldLevel.getValue())) / 10)), "Scratch", "Normal", 5, "Ember", "Fire", 10);

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

    @FXML
    private void btnSquirtle(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Squirtle");
        if (chooseEnemy == false) {
            alert.setContentText("Are you sure you want to chose Squirtle?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                MainApp.pokeInfo = new pkmn("squirtle", "Water", 30 * (1 + (pokeLevel / 10)), "Scratch", "Normal", 5, "Watergun", "Water", 10);
                lblTitle.setText("Choose Your Enemy");
                chooseEnemy = true;
                lblLevel.setVisible(true);
                sldLevel.setVisible(true);
            }

        } else {
            alert.setContentText("Are you sure you want to chose Squirtle for the enemy?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                music.stop();

                MainApp.pokeInfoE = new pkmn("squirtle", "Water", 30 * (1 + (Double.parseDouble(myFormat.format(sldLevel.getValue())) / 10)), "Scratch", "Normal", 5, "Watergun", "Water", 10);

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

    @FXML
    private void btnBulbasoar(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Bulbasoar");
        if (chooseEnemy == false) {
            alert.setContentText("Are you sure you want to chose Bulbasoar?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                MainApp.pokeInfo = new pkmn("bulbasoar", "Grass", 30 * (1 + (pokeLevel / 10)), "Scratch", "Normal", 5, "Vine Whip", "Grass", 10);
                lblTitle.setText("Choose Your Enemy");
                chooseEnemy = true;
                lblLevel.setVisible(true);
                sldLevel.setVisible(true);
            }

        } else {
            alert.setContentText("Are you sure you want to chose Bulbasaur for the enemy?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                music.stop();

                MainApp.pokeInfoE = new pkmn("bulbasoar", "Grass", 30 * (1 + (Double.parseDouble(myFormat.format(sldLevel.getValue())) / 10)), "Scratch", "Normal", 5, "Vine Whip", "Grass", 10);

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

    @FXML
    private void sldLevel(Event event) {
        lblLevel.setText("Enemy Level: " + myFormat.format(sldLevel.getValue()));
        enemyLevel = Integer.parseInt(myFormat.format(sldLevel.getValue()));
        System.out.println("Enemy Level: " + enemyLevel);
    }

    @FXML
    private void btnHTP(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("How to Play");
        alert.setTitle("How to Play");
        alert.setContentText("Your goal is to keep leveling up and defeat the enemy Pokemon. You select your own pokemon then you select the opponent's pokemon and it's level. the higher the enemy level, the harder it is, but you get more XP if you defeat it. You level up by defeating enemy pokemon, and the higher your level, the stronger your pokemon.");
        alert.showAndWait();
    }

    @FXML
    private void btnMenu(ActionEvent event) throws IOException {
        music.stop();

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("MiniGames"); //changes the title
        stage.show(); //shows the new page
    }

    String command;

    @FXML
    private void cheat(KeyEvent event) throws IOException {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Command");

        if (event.getCode() == KeyCode.ESCAPE) {
            if (txtCheat.isVisible()) {
                if ((txtCheat.getText().equals("pokemon.set('missingno')")) && (chooseEnemy == true)) {

                    music.stop();

                    MainApp.pokeInfoE = new pkmn("missingno", "Unknown", 666, "Scratch", "Normal", 5, "Tackle", "Grass", 10);

                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/pokemonGame.fxml")); //where FXMLPage2 is the name of the scene

                    Scene home_page_scene = new Scene(home_page_parent);
                    //get reference to the stage 
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage.hide(); //optional
                    stage.setScene(home_page_scene); //puts the new scence in the stage

                    stage.setTitle("Qplfnpo"); //changes the title
                    stage.show(); //shows the new page
                } else if (txtCheat.getText().equals("level.set")) {
                    command = "level.set";
                    txtCheat.setText("");
                    txtCheat.setPromptText(command);
                } else if ("level.set".equals(command)) {
                    try {
                        if (Integer.parseInt(txtCheat.getText()) < 0) {
                            txtCheat.setText("");
                            return;
                        }
                        pokeLevel = Integer.parseInt(txtCheat.getText());
                        pokeXP = 0;
                        pokeXPNeeded = 500 + (500 * pokeLevel);
                        lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
                        lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
                        txtCheat.setPromptText("");
                        txtCheat.setText("");
                        txtCheat.setVisible(false);
                        command = null;
                    } catch (NumberFormatException numberFormatException) {
                        txtCheat.setText("");
                    }
                } else if (txtCheat.getText().equals("level++")) {
                    pokeLevel++;
                    pokeXP = 0;
                    pokeXPNeeded = 500 + (500 * pokeLevel);
                    lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
                    lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
                    txtCheat.setText("");
                    txtCheat.setVisible(false);
                }
            } else {
                txtCheat.setVisible(true);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
        lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
        prgLevel.setProgress(pokeXP / pokeXPNeeded);

        enemyLevel = 0;

        music.setCycleCount(INDEFINITE);
        music.setVolume(0.5);
        music.play();
    }

}
