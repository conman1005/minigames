/*
 * Made By: Conner Cullity, Spencer Jones and Erica Wheatley
 * Date: 11/1/2018
 * Description: This is an application with 4 Minigames, Pokemon Battle, Asteroid Dodge, Memory Match and Whack A Mole
 */


package trioteam.minigames;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static pkmn pokeInfo;
    public static pkmn pokeInfoE;
    public static double pokeLevel = 0;
    public static double pokeXP = 0;
    public static double pokeXPNeeded = 500;
    public static double enemyLevel = 0;
    public static double credits = 0;
    public static Stage mainStage;
    public static Scene sideScroller;
   
    public static String wacImage;
    public static  boolean boo = false;
    public static  boolean bowser = false;
    public static  boolean bulbasoar = false;
    public static  boolean squirtle = false;
    public static  boolean ghost = false;
    public static  boolean darthVader = false;
    public static  boolean sonic = false;
    
    
    public static int wacHighScore = 0;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);

        mainStage = stage;
        stage.setTitle("MiniGames");
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
        stage.setOnCloseRequest(e -> System.exit(0));

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
