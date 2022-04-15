package Maintnance;

import BattleSimulation.Army;
import BattleSimulation.ArmyFiles;
import SpecificUnits.Unit;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArmyDetailsViewController implements Initializable {

    //Table View
    @FXML private TableView<Unit> armyOneTableView;
    @FXML private TableView<Unit> armyTwoTableView;
    @FXML private Text armyOneText;
    @FXML private Text armyTwoText;

    @FXML private TableColumn<Unit, String> armyOneUT;
    @FXML private TableColumn<Unit, String> armyOneUN;
    @FXML private TableColumn<Unit, Integer> armyOneH;

    @FXML private TableColumn<Unit, String> armyTwoUT;
    @FXML private TableColumn<Unit, String> armyTwoUN;
    @FXML private TableColumn<Unit, Integer> armyTwoH;

    //download army from file
    private String armyOneFilePath;
    private String armyTwoFilePath;
    private Army armyOne;
    private Army armyTwo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void updateArmyOneTabel(Army thisArmy){
        //winning army table update
        armyOneUT.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        armyOneUN.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        armyOneH.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("health"));

        armyOneText.setText(thisArmy.getName());
        armyOneTableView.setItems(FXCollections.observableArrayList(
                thisArmy.getUnits().stream().toList()));
        armyOneTableView.refresh();
    }

    @FXML
    public void updateArmyTwoTabel(Army thisArmy){
        //winning army table update
        armyTwoUT.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        armyTwoUN.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        armyTwoH.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("health"));

        armyTwoText.setText(thisArmy.getName());
        armyTwoTableView.setItems(FXCollections.observableArrayList(
                armyTwo.getUnits().stream().toList()));
        armyTwoTableView.refresh();
    }

    @FXML
    public void toSimulatorPage(ActionEvent event) throws IOException {
        if (armyOne == null || armyTwo == null){
            AlertBox.alertError("You need to have to armies before simulation");
            return;
        }
        SwitchScene.switchScene("SimulatorView", event);
    }

    public void getFileArmyOne(ActionEvent event) throws IOException {
        ArmyFiles armyFiles = new ArmyFiles();

        armyOneFilePath = armyFiles.getFilePath();
        if (armyOneFilePath == null){
            AlertBox.alertError("File Doesnt exist");
            return;
        }
        WarGamesGUI.ArmyOne = armyFiles.readFromCSV(armyOneFilePath);
        armyOne = WarGamesGUI.ArmyOne;
        updateArmyOneTabel(armyOne);
    }

    @FXML
    public void getFileArmyTwo(ActionEvent event) throws IOException {
        ArmyFiles armyFiles = new ArmyFiles();

        armyTwoFilePath = armyFiles.getFilePath();
        if (armyOneFilePath == null){
            AlertBox.alertError("File Doesnt exist");
            return;
        }
        WarGamesGUI.ArmyTwo = armyFiles.readFromCSV(armyTwoFilePath);
        armyTwo = WarGamesGUI.ArmyTwo;
        updateArmyTwoTabel(armyTwo);
    }
}
