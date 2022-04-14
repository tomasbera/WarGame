package Maintnance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArmyDetailsViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void toSimulatorPage(ActionEvent event) throws IOException {
        SwitchScene.switchScene("SimulatorView", event);
    }
}
