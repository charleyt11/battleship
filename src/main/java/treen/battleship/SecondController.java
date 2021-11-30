/*
 Charley Treen
November 25th, 2021
Second screen to battleship game. 
Opening includes an instructions, a play and an exit game button. 
 */
package treen.battleship;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author charleyt11
 */
public class SecondController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private Label lblInstructions;

    @FXML
    void lblExitGame(ActionEvent event) {
System.exit(0);
    }

    @FXML
    void lblHow(ActionEvent event) {
lblInstructions.setVisible (true);
    }
       @FXML
    void lblPlay(ActionEvent event) throws IOException {
 MainApp.setRoot("primary");
 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
