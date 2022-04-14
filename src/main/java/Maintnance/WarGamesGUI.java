package Maintnance;

import BattleSimulation.Army;
import BattleSimulation.Battle;
import SpecificUnits.InfantryUnit;
import SpecificUnits.Unit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarGamesGUI extends Application {

    static Army ArmyOne = new Army("Human Army");
    static Army ArmyTwo = new Army("Orc Army");

    /**
     * main method that starts the application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * stating method with starting screen
     * @param stage starting stage
     * @throws Exception when path not found
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewClasses/SimulatorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("WarGames");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void init() throws Exception{
        super.init();
        startData();
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void stop() throws Exception{
        super.stop();
    }

    public static void startData(){
        Unit infantry = new InfantryUnit("man", 10);
        Unit range = new InfantryUnit("archer", 10);
        Unit cav = new InfantryUnit("rider", 10);
        Unit com = new InfantryUnit("king", 10);
        ArmyOne.add(infantry);
        ArmyOne.add(range);
        ArmyOne.add(cav);
        ArmyOne.add(com);

        Unit infantry2 = new InfantryUnit("orc", 10);
        Unit range2 = new InfantryUnit("crossbow", 10);
        Unit cav2 = new InfantryUnit("strider", 10);
        Unit com2 = new InfantryUnit("Sauron", 10);
        ArmyTwo.add(infantry2);
        ArmyTwo.add(range2);
        ArmyTwo.add(cav2);
        ArmyTwo.add(com2);
    }
}
