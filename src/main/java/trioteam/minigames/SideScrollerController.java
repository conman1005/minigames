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

/**
 * FXML Controller class
 *
 * @author Spencer
 */
public class SideScrollerController implements Initializable {
//Health

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
    //lives
    int health = 3;
//Astro moving loop on off
    boolean astroLoop = false;
//timer
    ScheduledExecutorService move;

    @FXML
    private void btnTest(ActionEvent event) throws IOException { //Test button remove before completion  
        astroSetup();

    }

    @FXML
    private void start() {
        panAstro.setVisible(true);
        panAstro2.setVisible(true);
       

    }

    private void astroSetup() {

        astroLoop = true;
        move = Executors.newScheduledThreadPool(1);
        move.scheduleAtFixedRate(() -> {
            move();
        }, 0, 10, TimeUnit.MILLISECONDS);
    }

    @FXML
    public void keyPressed(KeyEvent event) {
        if ((event.getCode() == KeyCode.W)) {
            panShip.setTranslateY(panShip.getTranslateY() - 10);
        }
        if ((event.getCode() == KeyCode.S)) {
            panShip.setTranslateY(panShip.getTranslateY() + 10);
        }

    }

    private void move() {
        int x1 = ThreadLocalRandom.current().nextInt(1360, 1480 + 1);
        int x2 = ThreadLocalRandom.current().nextInt(1360, 1480 + 1);
        int y1 = ThreadLocalRandom.current().nextInt(380, 0 + 1);
        int y2 = ThreadLocalRandom.current().nextInt(389, 871 + 1);
        
        if (x1 == x2  || x2 == x1 ) {
            move();
        } else if (astroLoop == true) {
            panAstro.setTranslateX(x1);
            panAstro2.setTranslateX(x1);
           
            astroLoop = false;
        }

        panAstro.setTranslateX(panAstro.getTranslateX() - 5);
        panAstro2.setTranslateX(panAstro2.getTranslateX() - 5);
        

        if (panAstro.getTranslateX() <= -1000) {
            panAstro.setTranslateX(x1);
            panAstro.setTranslateY(y1);
        } else if (panAstro2.getTranslateX() <= -1000) {
            panAstro2.setTranslateX(x2);
            panAstro2.setTranslateY(y2);//broke stuff
        } 
    }

    private boolean checkCol(Shape obj1, Shape obj2) {
        Shape intersect = Shape.intersect(obj1, obj2);

        return intersect.getBoundsInParent().getWidth() > 0;

    }

    @FXML
    private void collision() {
        for (int i = 0; i <= 1; i++) {
            for (int r = 2; r <= 7; r++) {

                if (checkCol(grid[i], grid[r])) {
                    collided();
                }
            }

        }

    }

    private void collided() { //code to run when player hits astaroid
        /*
    check lives 
    if lives left put astaroids back and keep going
    if no lives stop game kill player
    reset button apere
         */
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
