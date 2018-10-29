package trioteam.minigames;

/*
 * Made By: Spencer Jones
 * Date: 
 * Description: User moves up and down to avoid asroids
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Spencer
 */
public class SideScrollerController implements Initializable {
//Health

    int health = 3;
    @FXML
    private ImageView picHealth;

//ship 
    @FXML
    private Pane panShip;
    @FXML
    private ImageView picShip;
//Hit boxes
    @FXML
    private Rectangle recShipCol1;
    @FXML
    private Rectangle recShipCol2;

//Astaroid one
    @FXML
    private Pane panAstro;
    @FXML
    private ImageView picAstaroid;
//Hit boxes
    @FXML
    private Rectangle recAstroCol1;
    @FXML
    private Ellipse ovlAstroCol2;

//Astaroid two
    @FXML
    private Pane panAstro2;
    @FXML
    private ImageView picAstaroid2;
//Hit boxes
    @FXML
    private Rectangle recAstroCol21;
    @FXML
    private Ellipse ovlAstroCol22;

//declaring the grid
    Shape grid[] = new Shape[6];

//Astro moving loop on off
    boolean astroLoop = false;
//timer
    Timeline timmer;
    Timeline movement;
    int min = 0;
    int sec = 0;
    @FXML
    private Label lblTime;
//bottom bar
    @FXML
    private Rectangle recBlackBar;
//TopBar
    @FXML
    private Rectangle recTopBar;
//background

    @FXML
    private ImageView picBack1;
    @FXML
    private ImageView picBack2;
    private int BACKGROUND_WIDTH = 3900;
    private ParallelTransition backgroundMove;
//game over
    boolean gameOver = true;
    @FXML
    private Label lblText;
//start button
    @FXML
    private ImageView picStartButton;
//missile
    @FXML
    private ImageView picAmmo;
    @FXML
    private Pane panMissile;
    @FXML
    private Rectangle recMissile;
    Timeline missile;
    int missiles = 3;
//God mode
    boolean godMode = false;
//sound
    MediaPlayer soundEffects;
    MediaPlayer music = new MediaPlayer((new Media(getClass().getResource("/sideScroller/backgroundMusic.mp3").toString())));
//menu
    @FXML
    private MenuItem munMenu;
    @FXML
    private Slider sliVolume;
    @FXML
    private Slider sliSoundEff;
    @FXML
    double soundVol = 1;
    double soundEff = 1;

    /* @FXML
    private Button btnControl;*/

    @FXML
    private void musicApply() {
        soundVol = sliVolume.getValue();
        soundEff = sliSoundEff.getValue();
        music.setVolume(soundVol);
    }
@FXML
private void returnToMenu(Event event)  throws IOException{
    music.pause();
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); //where FXMLPage2 is the name of the scene

        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getRoot().requestFocus();
        //get reference to the stage 
       

        MainApp.mainStage.hide(); //optional
         MainApp.mainStage.setScene(home_page_scene); //puts the new scence in the stage

         MainApp.mainStage.setTitle("MiniGames"); //changes the title
         MainApp.mainStage.show(); //shows the new page 
}
    
    @FXML
    private void start(Event event) {
        if (gameOver == false) {
            panAstro.setVisible(true);
            panAstro2.setVisible(true);
            picStartButton.setVisible(false);
            gameOver = false;
            startAmination();
            astroSetup();
            timeStart();
        } else if (gameOver == true) {
            gameOver = false;
            picStartButton.getStyleClass().clear();
            picStartButton.getStyleClass().add("start");
            lblText.setText("");
            lblText.setVisible(false);
            picShip.getStyleClass().clear();
            picShip.getStyleClass().add("ship");
            lblTime.setText("Time Survived: 00:00");
            picHealth.getStyleClass().clear();
            picHealth.getStyleClass().add("threeHeart");
            health = 3;
            min = 0;
            sec = 0;
            missiles = 3;
            picAmmo.getStyleClass().clear();
            picAmmo.getStyleClass().add("threeAmmo");
        }
    }

    private void timeStart() {
        timmer = new Timeline(new KeyFrame(Duration.seconds(1), ae -> time()));
        timmer.setCycleCount(Timeline.INDEFINITE);
        timmer.play();
    }

    private void astroSetup() {
        movement = new Timeline(new KeyFrame(Duration.millis(8), ae -> move()));
        movement.setCycleCount(Timeline.INDEFINITE);
        movement.play();
        astroLoop = true;

    }

    private void time() {
        sec = sec + 1;

        if (sec >= 60) {
            min = min + 1;
            sec = 0;
        }
        if (sec < 10) {
            lblTime.setText("Time Survived: " + min + ":0" + sec);
        } else if (sec < 10 && min < 10) {
            lblTime.setText("Time Survived: 0" + min + ":0" + sec);
        } else if (min < 10) {
            lblTime.setText("Time Survived: 0" + min + ":" + sec);
        } else {
            lblTime.setText("Time Survived: " + min + ":" + sec);
        }
    }

    @FXML
    public void keyPressed(KeyEvent event) {
        if (gameOver == false) {
            if ((event.getCode() == KeyCode.W)) {
                if (checkCol(recShipCol2, recTopBar)) {
                    panShip.setTranslateY(panShip.getTranslateY() + 10);
                } else {
                    panShip.setTranslateY(panShip.getTranslateY() - 10);
                }
                /*timmer = new Timeline(new KeyFrame(Duration.millis(50), ae -> shipMove("up")));
            timmer.setCycleCount(Timeline.INDEFINITE);
            if (Status.RUNNING == timmer.getStatus()) {
                timmer.stop();
            }

            timmer.play();*/
            }

            if ((event.getCode() == KeyCode.S)) {
                if (checkCol(recShipCol2, recBlackBar)) {
                    panShip.setTranslateY(panShip.getTranslateY() - 10);
                } else {
                    panShip.setTranslateY(panShip.getTranslateY() + 10);
                }
                /* timmer = new Timeline(new KeyFrame(Duration.millis(50), ae -> shipMove("down")));
            timmer.setCycleCount(Timeline.INDEFINITE);
            if (Status.RUNNING == timmer.getStatus()) {
                timmer.stop();
            }

            timmer.play();*/
            }
            if ((event.getCode() == KeyCode.E)) {
                if (missiles > 0) {
                    panMissile.setTranslateY(panShip.getTranslateY() + 35);
                    panMissile.setTranslateX(panShip.getTranslateX() + 180);
                    panMissile.setVisible(true);
                    missile = new Timeline(new KeyFrame(Duration.millis(2), ae -> missileMove()));
                    missile.setCycleCount(Timeline.INDEFINITE);
                    missile.play();
                    missiles = missiles - 1;
                    soundEffects = new MediaPlayer((new Media(getClass().getResource("/sideScroller/MissileLaunch.mp3").toString())));
                    soundEffects.setVolume(soundEff);
                    soundEffects.play();
                    switch (missiles) {
                        case 2:
                            picAmmo.getStyleClass().clear();
                            picAmmo.getStyleClass().add("twoAmmo");
                            break;
                        case 1:
                            picAmmo.getStyleClass().clear();
                            picAmmo.getStyleClass().add("oneAmmo");
                            break;
                        case 0:
                            picAmmo.getStyleClass().clear();
                            picAmmo.getStyleClass().add("noAmmo");
                            break;
                        default:
                            break;
                    }

                }

            }
            if ((event.getCode() == KeyCode.G)) {
                godMode = true;
                picHealth.getStyleClass().clear();
                picHealth.getStyleClass().add("godHeart");
            }
            if ((event.getCode() == KeyCode.M)) {
                godMode = false;
                picHealth.getStyleClass().clear();
                switch (health) {
                    case 3:
                        picHealth.getStyleClass().add("threeHeart");
                        break;
                    case 2:
                        picHealth.getStyleClass().add("twoHeart");
                        break;
                    case 1:
                        picHealth.getStyleClass().add("oneHeart");
                        break;
                    default:
                        break;
                }
            } else if (gameOver == true) {

            }

        }
    }

    private void missileMove() {
        panMissile.setTranslateX(panMissile.getTranslateX() + 1);
        if (checkCol(recMissile, ovlAstroCol2)) {
            panAstro.setTranslateX(-2000);
            missile.pause();
            panMissile.setVisible(false);
            soundEffects = new MediaPlayer((new Media(getClass().getResource("/sideScroller/astroBoom.mp3").toString())));
            soundEffects.setVolume(soundEff);
            soundEffects.play();
        } else if (checkCol(recMissile, ovlAstroCol22)) {
            panAstro2.setTranslateX(-2000);
            missile.pause();
            panMissile.setVisible(false);
            soundEffects = new MediaPlayer((new Media(getClass().getResource("/sideScroller/astroBoom.mp3").toString())));
            soundEffects.setVolume(soundEff);
            soundEffects.play();
        } else if (panMissile.getTranslateX() > 1360) {
            missile.pause();
            panMissile.setVisible(false);
        }

    }

    /* private void shipMove(String direction) {
        if ("up".equals(direction)) {
            if (checkCol(recShipCol2, recTopBar)) {
                panShip.setTranslateY(panShip.getTranslateY() + 10);
            } else {
                panShip.setTranslateY(panShip.getTranslateY() - 10);
            }

        } else if ("down".equals(direction)) {
            if (checkCol(recShipCol2, recBlackBar)) {
                panShip.setTranslateY(panShip.getTranslateY() - 10);
            } else {
                panShip.setTranslateY(panShip.getTranslateY() + 10);
            }
        }
    }*/
    private void move() {

        int x1 = ThreadLocalRandom.current().nextInt(1360, 1440 + 1);
        int x2 = ThreadLocalRandom.current().nextInt(1360, 1440 + 1);
        int y1 = ThreadLocalRandom.current().nextInt(30, 280 + 1);
        int y2 = ThreadLocalRandom.current().nextInt(390, 680 + 1);

        if (x1 == x2 || x2 == x1) {
            move();

        } else if (astroLoop == true) {
            panAstro.setTranslateX(x1);
            panAstro2.setTranslateX(x1);
            panAstro.setTranslateY(40);
            panAstro2.setTranslateY(650);

            astroLoop = false;
        }

        panAstro.setTranslateX(panAstro.getTranslateX() - 5);
        panAstro2.setTranslateX(panAstro2.getTranslateX() - 5);

        if (panAstro.getTranslateX() <= -1000) {
            panAstro.setTranslateX(x1);
            panAstro.setTranslateY(y1);
        } else if (panAstro2.getTranslateX() <= -1000) {
            panAstro2.setTranslateX(x2);
            panAstro2.setTranslateY(y2);
        }
        if (godMode == false) {
            astroCollision();
        }

    }

    private boolean checkCol(Shape obj1, Shape obj2) {
        Shape intersect = Shape.intersect(obj1, obj2);

        return intersect.getBoundsInParent().getWidth() > 0;

    }

    @FXML
    private void astroCollision() {
        for (int i = 0; i <= 1; i++) {
            for (int r = 2; r <= 5; r++) {

                if (checkCol(grid[i], grid[r])) {
                    collided();
                }
            }

        }

    }

    private void collided() { //code to run when player hits astaroid

        if (health >= 1) {
            health = health - 1;
            astroLoop = true;
            picHealth.getStyleClass().clear();
        }
        switch (health) {
            case 2:

                picHealth.getStyleClass().add("twoHeart");
                break;
            case 1:

                picHealth.getStyleClass().add("oneHeart");
                break;
            case 0:

                picHealth.getStyleClass().add("noHeart");
                timmer.pause();
                movement.pause();
                gameOver = true;
                panAstro.setVisible(false);
                panAstro2.setVisible(false);
                if (backgroundMove.getStatus() == Animation.Status.RUNNING) {
                    pauseAnimation();
                }
                soundEffects = new MediaPlayer((new Media(getClass().getResource("/sideScroller/spaceShipExplotion.mp3").toString())));
                soundEffects.play();
                picShip.getStyleClass().add("death");
                picStartButton.setVisible(true);
                picStartButton.getStyleClass().clear();
                picStartButton.getStyleClass().add("gameOver");
                lblText.setVisible(true);
                if (sec < 10) {
                    lblText.setText("You Survived: " + min + ":0" + sec);
                } else if (sec < 10 && min < 10) {
                    lblText.setText("You Survived: 0" + min + ":0" + sec);
                } else if (min < 10) {
                    lblText.setText("You Survived: 0" + min + ":" + sec);
                } else {
                    lblText.setText("You Survived: " + min + ":" + sec);
                }
                //you lose
                break;
            default:
                break;
        }
    }

    public void startAmination() {

        backgroundMove.play();
    }

    public void pauseAnimation() {
        backgroundMove.pause();
    }

    @FXML
    public void controlPressed(ActionEvent event) {
        if (backgroundMove.getStatus() == Animation.Status.RUNNING) {
            pauseAnimation();
        } else {
            startAmination();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panShip.getChildren().add(createBoundsRectangle(recAstroCol1.getBoundsInParent()));  //make copy of astro block in ship
        panShip.getChildren().add(createBoundsRectangle(recAstroCol21.getBoundsInParent()));
        panShip.getChildren().add(createBoundsEllipse(ovlAstroCol2.getBoundsInParent()));  //make copy of astro ovel in ship
        panShip.getChildren().add(createBoundsEllipse(ovlAstroCol22.getBoundsInParent()));
        panMissile.getChildren().add(createBoundsEllipse(ovlAstroCol2.getBoundsInParent()));
        panMissile.getChildren().add(createBoundsEllipse(ovlAstroCol22.getBoundsInParent()));
        // setting up collision array 
        grid[0] = recShipCol1;
        grid[1] = recShipCol2;
        grid[2] = recAstroCol1;
        grid[3] = ovlAstroCol2;
        grid[4] = recAstroCol21;
        grid[5] = ovlAstroCol22;

        //background mover
        /*This Transititon creates a move/translate animation that spans its duration. This is done by updating the translateX, Y and Z vsrisbles at regular interval*/
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(16000), picBack1);
        /*It strats from the (fromX, fromY, fromZ) value if proided else uses the items translateX, Y, Z vales*/
        translateTransition.setFromX(0);
        /*It stops at the (toX, toY, toZ) value if provided else it will use  start value plus (byX,byY, byZ) value*/
        translateTransition.setToX(-1 * BACKGROUND_WIDTH);
        /*the (toX, toY, toZ) value takes precedence if both (toX, toY, toZ) and (byX, byY, byZ) values are specified*/
        translateTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition translateTransition2
                = new TranslateTransition(Duration.millis(16000), picBack2);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(-1 * BACKGROUND_WIDTH);//goes to the opsite 
        translateTransition2.setInterpolator(Interpolator.LINEAR);

        backgroundMove
                = new ParallelTransition(translateTransition, translateTransition2);
        backgroundMove.setCycleCount(Animation.INDEFINITE);

        //
        // Sets the label of the Button based on the animation state
        //
        /*  backgroundMove.statusProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Animation.Status.RUNNING) {
                btnControl.setText("||");
            } else {
                btnControl.setText(">");
            }
        });*/
        music.setCycleCount(INDEFINITE);
        music.setVolume(1.5);
        music.play();
    }

    private Rectangle createBoundsRectangle(Bounds bounds) {  //method used to make the blank copy in other pane
        Rectangle rect = new Rectangle();
        rect.setFill(Color.TRANSPARENT);
        rect.setX(bounds.getMinX());
        rect.setY(bounds.getMinY());
        rect.setWidth(bounds.getWidth());
        rect.setHeight(bounds.getHeight());
        return rect;
    }

    private Ellipse createBoundsEllipse(Bounds bounds) {  //method used to make the blank copy in other pane
        Ellipse ovl = new Ellipse();
        ovl.setFill(Color.TRANSPARENT);
        ovl.setCenterX(bounds.getMinX());
        ovl.setCenterY(bounds.getMinY());
        ovl.setRadiusX(bounds.getWidth());
        ovl.setRadiusY(bounds.getHeight());
        return ovl;
    }
}
