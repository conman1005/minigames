/*
 * Made By: Conner Cullity, Spencer Jones and Erica Wheatley
 * Date: 11/1/2018
 * Description: This is an application with 4 Minigames, Pokemon Battle, Asteroid Dodge, Memory Match and Whack A Mole
 */

package trioteam.minigames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import static trioteam.minigames.MainApp.sideScroller;

public class FXMLController implements Initializable {

    @FXML
    private MenuItem menuExit;
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void btnPokemon(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/pokemonMenu.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getRoot().requestFocus();
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("Pokemon"); //changes the title
        stage.show(); //shows the new page
    }
    @FXML
    private void btnSideScroller(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/sideScroller.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        sideScroller =   home_page_scene;
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("Ateroid Dodge"); //changes the title
        stage.show(); //shows the new page
        home_page_scene.getRoot().requestFocus();
    }
    @FXML
    private void btnMemoryMatch(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/memoryMatch.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("Pokemon"); //changes the title
        stage.show(); //shows the new page
    }
    @FXML
    private void btnWac(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/wacMenu.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        //get reference to the stage 
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.hide(); //optional
        stage.setScene(home_page_scene); //puts the new scence in the stage

        stage.setTitle("Wac A Wac Character Picker"); //changes the title
        stage.show(); //shows the new page
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
