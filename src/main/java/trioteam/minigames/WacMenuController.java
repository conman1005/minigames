/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trioteam.minigames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author spenc
 */
public class WacMenuController implements Initializable {

    @FXML
    private Label lblDisplay;
    @FXML
    private Label lblPrice;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnBack;
    @FXML
    private Label lblCredits;
    @FXML
    private Button btnCon;

    int image = 0;
    String grid[] = new String[8];

    int cost = 0;

    @FXML
    private void next() {
        image = image + 1;
        lblDisplay.getStyleClass().clear();
        lblDisplay.getStyleClass().add(grid[image]);
        switch (image) {
            case 1:
                btnBack.setDisable(false);
                if (MainApp.boo == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    cost = 100;
                    btnCon.setText("Buy");
                }
                lblPrice.setText("Boo\n"
                        + "Price: " + cost);

                break;
            case 2:
                if (MainApp.bowser == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    cost = 100;
                    btnCon.setText("Buy");
                }
                lblPrice.setText("Bowser \n"
                        + "Price: " + cost);

                break;
            case 3:
                if (MainApp.bulbasoar == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    cost = 150;
                    btnCon.setText("Buy");
                }
                lblPrice.setText("Bulbasoar \n"
                        + "Price: " + cost);

                break;
            case 4:
                if (MainApp.squirtle == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 150;
                }
                lblPrice.setText("Squirtle \n"
                        + "Price: " + cost);

                break;
            case 5:
                if (MainApp.ghost == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 200;
                }
                lblPrice.setText("Ghost \n"
                        + "Price: " + cost);

                break;
            case 6:
                if (MainApp.darthVader == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 300;
                }
                lblPrice.setText("Darth Vader \n"
                        + "Price: " + cost);

                break;
            case 7:
                if (MainApp.sonic == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 300;
                }
                lblPrice.setText("sonic \n"
                        + "Price: " + cost);

                btnNext.setDisable(true);
                break;

            default:
                break;
        }
    }

    @FXML
    private void back() {
        image = image - 1;
        lblDisplay.getStyleClass().clear();
        lblDisplay.getStyleClass().add(grid[image]);
        switch (image) {
            case 0:
                lblPrice.setText("Mole the Mole Face \n"
                        + "Price: Free");
                btnBack.setDisable(true);
                btnCon.setText("Confrim");
                break;
            case 1:
                if (MainApp.boo == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 100;
                }
                lblPrice.setText("Boo \n"
                        + "Price: " + cost);

                break;
            case 2:
                if (MainApp.bowser == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 100;
                }
                lblPrice.setText("Bowser \n"
                        + "Price: " + cost);

                break;
            case 3:
                if (MainApp.bulbasoar == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 150;
                }
                lblPrice.setText("Bulbasoar \n"
                        + "Price: " + cost);

                break;
            case 4:
                if (MainApp.squirtle == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 150;
                }
                lblPrice.setText("Squirtle \n"
                        + "Price: " + cost);

                break;
            case 5:
                if (MainApp.ghost == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 200;
                }
                lblPrice.setText("Pacman Ghost \n"
                        + "Price: " + cost);

                break;
            case 6:
                if (MainApp.darthVader == true) {
                    cost = 0;
                    btnCon.setText("Confirm");
                } else {
                    btnCon.setText("Buy");
                    cost = 300;
                }

                lblPrice.setText("Darth Vader \n"
                        + "Price: " + cost);

                btnNext.setDisable(false);
                break;

            default:
                break;
        }
    }

    @FXML

    private void confirm(ActionEvent event) throws IOException {
        if ("Buy".equals(btnCon.getText())) {
            if (cost <= MainApp.credits) {
                MainApp.credits = MainApp.credits - cost;
                MainApp.wacImage = grid[image];
                switch (image) {
                    case 1:

                        MainApp.boo = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Boo\n"
                                + "Price: " + cost);

                        break;
                    case 2:
                        MainApp.bowser = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Bowser \n"
                                + "Price: " + cost);

                        break;
                    case 3:
                        MainApp.bulbasoar = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Bulbasoar \n"
                                + "Price: " + cost);

                        break;
                    case 4:
                        MainApp.squirtle = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Squirtle \n"
                                + "Price: " + cost);

                        break;
                    case 5:
                        MainApp.ghost = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Ghost \n"
                                + "Price: " + cost);

                        break;
                    case 6:
                        MainApp.darthVader = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("Darth Vader \n"
                                + "Price: " + cost);

                        break;
                    case 7:
                        MainApp.sonic = true;
                        cost = 0;
                        btnCon.setText("Confirm");
                        lblCredits.setText(MainApp.credits + "");

                        lblPrice.setText("sonic \n"
                                + "Price: " + cost);

                        break;

                    default:
                        break;
                }

            }
        } else if ("Confirm".equals(btnCon.getText())) {
                System.out.println("hbnjk");
                MainApp.wacImage = grid[image];
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/wackAMole.fxml")); //where FXMLPage2 is the name of the scene

                Scene home_page_scene = new Scene(home_page_parent);
                home_page_scene.getRoot().requestFocus();
                //get reference to the stage 
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.hide(); //optional
                stage.setScene(home_page_scene); //puts the new scence in the stage

                stage.setTitle("Wac A Mole"); //changes the title
                stage.show(); //shows the new page
            }
    }

    @FXML
    private void returnToMenu(Event event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getRoot().requestFocus();
        //get reference to the stage 

        MainApp.mainStage.hide(); //optional
        MainApp.mainStage.setScene(home_page_scene); //puts the new scence in the stage

        MainApp.mainStage.setTitle("MiniGames"); //changes the title
        MainApp.mainStage.show(); //shows the new page 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCredits.setText("Credits: " + MainApp.credits);

        grid[0] = "mole";
        grid[1] = "picture-boo";
        grid[2] = "bowser";
        grid[3] = "bulbasoarFront";
        grid[4] = "squirtleFront";
        grid[5] = "pacman-ghost";
        grid[6] = "picture-star-wars";
        grid[7] = "picture-sonic";

    }

}
