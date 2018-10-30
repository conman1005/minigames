/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trioteam.minigames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    int image = 0;
    String grid[] = new String[8];
    boolean bought[] = new boolean[8];
    int cost = 0;

    @FXML
    private void next() {
        image = image + 1;
        lblDisplay.getStyleClass().clear();
        lblDisplay.getStyleClass().add(grid[image]);
        switch (image) {
            case 1:
                btnBack.setDisable(false);
                lblPrice.setText("Boo\n"
                        + "Price: "+cost);
                if (bought[image]==true){
                    cost = 0;
                }
                else{
                cost = 100;
                }
                break;
            case 2:
                lblPrice.setText("Bowser \n"
                        + "Price: "+cost);
                cost = 100;
                break;
            case 3:
                lblPrice.setText("Bulbasoar \n"
                        + "Price: "+cost);
                cost = 150;
                break;
            case 4:
                lblPrice.setText("Squirtle \n"
                        + "Price: "+cost);
                cost = 150;
                break;
            case 5:
                lblPrice.setText("Pacman \n"
                        + "Price: "+cost);
                cost = 200;
                break;
            case 6:
                lblPrice.setText("Darth Vader \n"
                        + "Price: "+cost);
                cost = 300;
                break;
            case 7:
                lblPrice.setText("sonic \n"
                        + "Price: "+cost);
                cost = 300;
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
                break;
            case 1:

                lblPrice.setText("Boo \n"
                        + "Price: "+cost);
                cost = 100;
                break;
            case 2:
                lblPrice.setText("The Bowser \n"
                        + "Price: "+cost);
                cost = 100;
                break;
            case 3:
                lblPrice.setText("Bulbasoar \n"
                        + "Price: "+cost);
                cost = 150;
                break;
            case 4:
                lblPrice.setText("Squirtle \n"
                        + "Price: "+cost);
                cost = 150;
                break;
            case 5:
                lblPrice.setText("Pacman Ghost \n"
                        + "Price: "+cost);
                cost = 200;
                break;
            case 6:
                 cost = 300;
                lblPrice.setText("Darth Vader \n"
                        + "Price: "+cost);
                cost = 300;
                btnNext.setDisable(false);
                break;
           
            default:
                break;
        }
    }
    
    @FXML
    private void confirm(){
        bought[image]=true;
        
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
        
        bought[0] = true;
        bought[1] = false;
        bought[2] = false;
        bought[3] = false;
        bought[4] = false;
        bought[5] = false;
        bought[6] = false;
        bought[7] = false;
        
                
    }

}
