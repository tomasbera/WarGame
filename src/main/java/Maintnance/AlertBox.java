package Maintnance;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * this class is used as a message class
 * its purpose is to give the user different popup windows that alert the user about different events
 * @author Gruppe 6
 */
public class AlertBox {

    /**
     * The method provides a general error alert box which can be specified with the display message
     * @param message the display message to the alert box
     */
    public static void alertError(String message) {
        Alert dateAlert = new Alert(Alert.AlertType.ERROR);
        dateAlert.setTitle("Error");
        dateAlert.setContentText(message);
        dateAlert.showAndWait();
    }
}

