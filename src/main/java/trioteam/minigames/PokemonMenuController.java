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

    DecimalFormat myFormat = new DecimalFormat("0");

    

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

    /*public void keyPressed(KeyEvent event) {
        sldLevel
    }*/

    @FXML
    private void btnMenu(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("MiniGames"); //changes the title
        stage.show(); //shows the new page
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblLevelCur.setText("Level: " + myFormat.format(pokeLevel));
        lblLevelNext.setText("Level: " + myFormat.format(pokeLevel + 1));
        prgLevel.setProgress(pokeXP / pokeXPNeeded);

        enemyLevel = 0;
    }

}
