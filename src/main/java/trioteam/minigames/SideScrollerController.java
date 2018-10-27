package trioteam.minigames;

/*
 * Made By: Spencer Jones
 * Date: 
 * Description: 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
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

    @FXML
    private void btnTest(ActionEvent event) { //Test button remove before completion  
        start();

    }

    @FXML
    private void start() {
        panAstro.setVisible(true);
        panAstro2.setVisible(true);
        astroSetup();
       timeStart();
    }
    
    private void timeStart(){
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
        lblTime.setText("Time Survived: " + min + ":" + sec);
    }

    @FXML
    public void keyPressed(KeyEvent event) {
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
        int y1 = ThreadLocalRandom.current().nextInt(30, 300 + 1);
        int y2 = ThreadLocalRandom.current().nextInt(390, 680 + 1);
        

        if (x1 == x2 || x2 == x1) {
            move();

        } else if (astroLoop == true) {
            panAstro.setTranslateX(x1);
            panAstro2.setTranslateX(x1);
            panAstro.setTranslateY(y1);
            panAstro2.setTranslateY(y2);

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
        collision();
    }

    private boolean checkCol(Shape obj1, Shape obj2) {
        Shape intersect = Shape.intersect(obj1, obj2);

        return intersect.getBoundsInParent().getWidth() > 0;

    }

    @FXML
    private void collision() {
        for (int i = 0; i <= 1; i++) {
            for (int r = 2; r <= 5; r++) {

                if (checkCol(grid[i], grid[r])) {
                    collided();
                }
            }

        }

    }

    private void collided() { //code to run when player hits astaroid
       
      if(health >= 1){
       health = health - 1;
       astroLoop = true;
      
      }
    switch (health) {
        case 2:
            picHealth.getStyleClass().clear();
            picHealth.getStyleClass().add("twoHeart");
            break;
        case 1:
            picHealth.getStyleClass().clear();
            picHealth.getStyleClass().add("oneHeart");
            break;
        case 0:
             picHealth.getStyleClass().clear();
            picHealth.getStyleClass().add("noHeart");
            timmer.pause();
            movement.pause();
            //you lose
            break;
        default:
            break;
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panShip.getChildren().add(createBoundsRectangle(recAstroCol1.getBoundsInParent()));  //make copy of astro block in ship
        panShip.getChildren().add(createBoundsEllipse(ovlAstroCol2.getBoundsInParent()));  //make copy of astro ovel in ship
        // setting up collision array 
        grid[0] = recShipCol1;
        grid[1] = recShipCol2;
        grid[2] = recAstroCol1;
        grid[3] = ovlAstroCol2;
        grid[4] = recAstroCol21;
        grid[5] = ovlAstroCol22;

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
