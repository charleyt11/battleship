package treen.battleship;

/*
Charley Treen
November 16th,2021
Program is a single player game. Guess where the boats are located to sink them. 
Keeps track of status. 
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import static treen.battleship.MainApp.setRoot;

public class FXMLController implements Initializable {

    @FXML
    private Rectangle shapeE4;

    @FXML
    private Rectangle shapeD0;

    @FXML
    private Rectangle shapeE2;

    @FXML
    private Rectangle shapeE0;

    @FXML
    private Rectangle shapeD1;

    @FXML
    private Rectangle shapeC0;

    @FXML
    private Rectangle shapeC3;

    @FXML
    private Rectangle shapeC4;

    @FXML
    private Rectangle shapeE3;

    @FXML
    private Rectangle shapeB0;

    @FXML
    private Rectangle shapeD2;

    @FXML
    private Rectangle shapeB3;

    @FXML
    private Rectangle shapeD4;

    @FXML
    private Rectangle shapeB1;

    @FXML
    private Rectangle shapeC2;

    @FXML
    private Rectangle shapeC1;

    @FXML
    private Rectangle shapeE1;

    @FXML
    private Rectangle shapeD3;

    @FXML
    private Rectangle shapeB4;

    @FXML
    private Rectangle shapeA3;

    @FXML
    private Rectangle shapeA1;

    @FXML
    private Rectangle shapeB2;

    @FXML
    private Rectangle shapeA4;

    @FXML
    private Rectangle shapeA0;

    @FXML
    private Rectangle shapeA2;

    @FXML
    private Label lblStart;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblMisses;

    @FXML
    private Button btnOk;

    
    @FXML
    private Label lblTime;
    @FXML
    private Label lblHits;
    int miss = 0;
    int hit = 0;

    Rectangle spots[];

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ae -> increase()));

    void increase() {
           int time = Integer.parseInt(lblTime.getText())+1;
           lblTime.setText(""+time);
           
    }

    @FXML
    void txtName(ActionEvent event) {
        /* TextField to insert name of user for score recording */

    }

    @FXML
    private void btnClickAction(ActionEvent event) throws IOException {
        MainApp.setRoot("second");
    }

    @FXML
    void btnOk(ActionEvent event) {
        txtName.setVisible(false);
        lblStart.setVisible(false);
        btnOk.setVisible(false);

        for (Rectangle name : spots) {
            name.setDisable(false);
            /* makes the 'spots' unclickable when the program is started */ }
        clearSpots();
        shipPlace();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        /* closes opening label screen, transfers game name to textareanames, clears all spots 
places 3 ships */
    }

    void shipPlace() {
        int rand = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        if (rand == 1) {
            shapeA0.setAccessibleText("X");
            shapeB0.setAccessibleText("X");
            shapeA1.setAccessibleText("X");
            shapeB1.setAccessibleText("X");
            shapeD0.setAccessibleText("X");
            shapeD1.setAccessibleText("X");
        }

        if (rand == 2) {
            shapeC0.setAccessibleText("X");
            shapeC1.setAccessibleText("X");
            shapeD2.setAccessibleText("X");
            shapeD1.setAccessibleText("X");
            shapeA4.setAccessibleText("X");
            shapeB4.setAccessibleText("X");
        }

        if (rand == 3) {
            shapeB3.setAccessibleText("X");
            shapeB2.setAccessibleText("X");
            shapeD4.setAccessibleText("X");
            shapeE4.setAccessibleText("X");
            shapeC3.setAccessibleText("X");
            shapeC2.setAccessibleText("X");
        }

        if (rand == 4) {
            shapeC0.setAccessibleText("X");
            shapeC1.setAccessibleText("X");
            shapeD2.setAccessibleText("X");
            shapeD1.setAccessibleText("X");
            shapeA4.setAccessibleText("X");
            shapeB4.setAccessibleText("X");
        }

        if (rand == 5) {
            shapeA2.setAccessibleText("X");
            shapeA1.setAccessibleText("X");
            shapeC1.setAccessibleText("X");
            shapeD1.setAccessibleText("X");
            shapeD0.setAccessibleText("X");
            shapeE0.setAccessibleText("X");
        }

        if (rand == 6) {
            shapeC1.setAccessibleText("X");
            shapeB1.setAccessibleText("X");
            shapeA1.setAccessibleText("X");
            shapeA2.setAccessibleText("X");
            shapeE1.setAccessibleText("X");
            shapeE0.setAccessibleText("X");
        }

        if (rand == 7) {
            shapeD2.setAccessibleText("X");
            shapeD3.setAccessibleText("X");
            shapeB1.setAccessibleText("X");
            shapeB2.setAccessibleText("X");
            shapeC0.setAccessibleText("X");
            shapeC1.setAccessibleText("X");
        }

        if (rand == 8) {
            shapeE2.setAccessibleText("X");
            shapeE3.setAccessibleText("X");
            shapeC1.setAccessibleText("X");
            shapeB1.setAccessibleText("X");
            shapeE0.setAccessibleText("X");
            shapeE1.setAccessibleText("X");
        }
        /* random placement of 3 ships (6 spots) with 8 choices. 
        Sets each to "X" (hit) 
         */
    }

    void clearSpots() {
        for (Rectangle name : spots) {
            name.setVisible(true);
            name.setAccessibleText("0");
            /* sets all spots to zero (miss) */
        }
    }

    @FXML
    void spot(MouseEvent event) {
        Rectangle rec = (Rectangle) event.getSource();

        if (rec.getAccessibleText().equals("X")) {
            rec.setFill(Color.RED);
            hit++;
            lblHits.setText("" + hit);
            checkLose();
        } else {
            rec.setFill(Color.WHITE);
            miss++;
            lblMisses.setText("" + miss);
            checkLose();
            /* sets all "X" spots to red fill (hit) and all 
        "0" spots to white fill (miss)*/ }
    }

    void checkLose() {
        if (miss == 12) {
            timeline.stop();
            for (Rectangle name : spots) {
                name.setDisable(true);
                 message("You have lost"); 
            }
          
        }
        if (hit == 6) {
            timeline.stop();
            for (Rectangle name : spots) {
                name.setDisable(true);
                message("You have WON");}
            
        }

    }

    void message(String msg) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(msg);
        alert.setHeaderText("Try Again!");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType("Play Again");
        ButtonType buttonTypeTwo = new ButtonType("Close Game");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
      alert.showAndWait();
        if (alert.getResult()==buttonTypeOne){
           for (Rectangle name : spots) {
            name.setDisable(false);
            /* makes the 'spots' unclickable when the program is started */ }
        clearSpots();
        shipPlace();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();  
        hit=0;
        miss=0;
        lblTime.setText("0");
        }
       else {
          System.exit(0);
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Rectangle temp[] = {shapeA0, shapeA1, shapeA2, shapeA3, shapeA4,
            shapeB0, shapeB1, shapeB2, shapeB3, shapeB4, shapeC0,
            shapeC1, shapeC2, shapeC3, shapeC4, shapeD0, shapeD1,
            shapeD2, shapeD3, shapeD4, shapeE0, shapeE1, shapeE2, shapeE3,
            shapeE4};
        spots = temp;

        /* creates an array of all the rectangles listed, makes them all 
      identified as "spots" */
        lblStart.setVisible(true);
        btnOk.setVisible(true);
        txtName.setVisible(true);
        /* makes everything in the lblStart label visible. */

        for (Rectangle name : spots) {
            name.setDisable(true);
            /* makes the 'spots' unclickable when the program is started */ }
        // btnClear.setDisable(true);
        /* the "Play Again" btnClear button is not pressable.
This button is not needed as the program is already at the start. */
    }
}
