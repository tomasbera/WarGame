package Maintnance;

import BattleSimulation.Army;
import BattleSimulation.Battle;
import SpecificUnits.Unit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SimulationViewController implements Initializable {


    //winning Army Tableview
    @FXML private TableView<Unit> winningArmyTable;
    @FXML private TableColumn<Unit, String> winningArmyUT;
    @FXML private TableColumn<Unit, String> winningArmyUN;
    @FXML private TableColumn<Unit, Integer> winningArmyH;

    //army One TableView
    @FXML
    private ListView<String> ArmyOneList;
    private ArrayList<String> armyOneArray;

    //army Two TableView
    @FXML
    private ListView<String> ArmyTwoList;
    private ArrayList<String> armyTwoArray;

    //picture layout
    @FXML private Text layoutText;
    @FXML private ImageView layoutImageView;
    @FXML private ChoiceBox<String> warGamesTerrainInput;
    @FXML private String chosenFormat;

    //terrain
    private int chosenTerrain;

    //TextInputs
    @FXML private Text scoreText;
    @FXML private Text armyOneText;
    @FXML private Text armyTwoText;
    private int scoreArmyOne;
    private int scoreArmyTwo;

    //battle
    private Battle battle;
    private Army winningArmy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        warGamesTerrainInput.getItems().add(0, "Hill");
        warGamesTerrainInput.getItems().add(1, "Forest");
        warGamesTerrainInput.getItems().add(2, "Plains");

        updateArmyOneTable();
        updateArmyTwoTable();
    }

    /**
     * Method sets an image by the image name
     * The method requires that all images is located in the resources under {@code TerrainPictures} and that the image is jpg
     * @param imageName The name of the image
     * @return The image if found
     */
    private Image getImageByName(String imageName) {
        return new Image("/TerrainPictures/" + imageName +  ".jpg");
    }

    /**
     * method that sets a specific image on the screen when chosen by user
     */
    @FXML
    public void setImage() {
        warGamesTerrainInput.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2){
                chosenFormat = warGamesTerrainInput.getItems().get((Integer) number2);
                if(chosenFormat.equals("Hill")){
                    layoutImageView.setImage(getImageByName("hill"));
                    layoutText.setText("Hill");
                    chosenTerrain = 1;
                }
                if(chosenFormat.equals("Plains")){
                    layoutImageView.setImage(getImageByName("plains"));
                    layoutText.setText("Plains");
                    chosenTerrain = 2;
                }
                if(chosenFormat.equals("Forest")){
                    layoutImageView.setImage(getImageByName("forest"));
                    layoutText.setText("Forest");
                    chosenTerrain = 3;
                }
            }
        });

    }

    @FXML
    public void updateArmyOneTable(){
        //army one table update
        if(WarGamesGUI.ArmyOne.getName().isEmpty())armyOneText.setText("Army not chosen");
        else armyOneText.setText(WarGamesGUI.ArmyOne.getName());


        unitToStringMethod(1);
        ArmyOneList.setItems(FXCollections.observableArrayList(armyOneArray.stream().toList()));
    }

    @FXML
    public void updateArmyTwoTable(){
        //army one table update
        if(WarGamesGUI.ArmyTwo.getName().isEmpty())armyTwoText.setText("Army not chosen");
        else armyTwoText.setText(WarGamesGUI.ArmyTwo.getName());

        unitToStringMethod(2);
        ArmyTwoList.setItems(FXCollections.observableArrayList(armyTwoArray.stream().toList()));
    }

    @FXML
    public void updateWinner(){
        //winning army table update
        winningArmyUT.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        winningArmyUN.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        winningArmyH.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("health"));

        winningArmyTable.setItems(FXCollections.observableArrayList(
                winningArmy.getUnits().stream().toList()));
        winningArmyTable.refresh();
    }

    @FXML
    public void simulateBattle() {
        if(chosenTerrain == 0) chosenTerrain = 1;

        ArrayList<Army> armies = resetMethod();
        battle = new Battle(armies.get(0), armies.get(1));
        winningArmy = battle.simulate(chosenTerrain);

        if(winningArmy == armies.get(0)){
            scoreArmyOne++;
        } else {
            scoreArmyTwo++;
        }
        scoreText.setText(scoreArmyOne + "-" + scoreArmyTwo);

        updateWinner();
        updateArmyOneTable();
        updateArmyTwoTable();
    }

    @FXML
    public ArrayList<Army> resetMethod() {
        ArrayList<Army> armies = new ArrayList<>();
        ArrayList<Unit> armyOneUnits = new ArrayList<>();
        ArrayList<Unit> armyTwoUnits = new ArrayList<>();

        WarGamesGUI.ArmyOne.getUnits()
                .forEach(unit -> armyOneUnits.add(unit.deepCopyUnit(unit)));
        WarGamesGUI.ArmyTwo.getUnits()
                .forEach(unit -> armyTwoUnits.add(unit.deepCopyUnit(unit)));

        Army armyOne = new Army(WarGamesGUI.ArmyOne.getName());
        armyOne.addAll(armyOneUnits);

        Army armyTwo = new Army(WarGamesGUI.ArmyTwo.getName());
        armyTwo.addAll(armyTwoUnits);

        armies.add(armyOne);
        armies.add(armyTwo);

        return armies;
    }

    @FXML
    public void toArmyDetails(ActionEvent event) throws IOException {
        SwitchScene.switchScene("ArmyDetailView", event);
    }

    public void unitToStringMethod(int armyNum){
        if(armyNum == 1){
            armyOneArray = new ArrayList<>();
            armyOneArray.add("Infantry Unit: " + WarGamesGUI.ArmyOne.getInfantryUnits().size());
            armyOneArray.add("Range Unit: " + WarGamesGUI.ArmyOne.getRangeUnits().size());
            armyOneArray.add("Cavalry Unit: " + WarGamesGUI.ArmyOne.getCavalryUnits().size());
            armyOneArray.add("Commander Unit: " + WarGamesGUI.ArmyOne.getCommanderUnits().size());

        } else {
            armyTwoArray = new ArrayList<>();
            armyTwoArray.add("Infantry Unit: " + WarGamesGUI.ArmyTwo.getInfantryUnits().size());
            armyTwoArray.add("Range Unit: " + WarGamesGUI.ArmyTwo.getRangeUnits().size());
            armyTwoArray.add("Cavalry Unit: " + WarGamesGUI.ArmyTwo.getCavalryUnits().size());
            armyTwoArray.add("Commander Unit: " + WarGamesGUI.ArmyTwo.getCommanderUnits().size());
        }
    }
}
