package Maintnance;

import BattleSimulation.Army;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class WarGamesGUI extends Application {

    static Army ArmyOne;
    static Army ArmyTwo = new Army("Orc Army");
    private static Stage startStage;

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
        startStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewClasses/ArmyDetailView.fxml"));
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
        /*
        Unit infantry = new InfantryUnit("man", 10);
        Unit range = new RangedUnit("archer", 10);
        Unit cav = new CavalryUnit("rider", 10);
        Unit com = new CommanderUnit("king", 10);
        ArmyOne.add(infantry);
        ArmyOne.add(range);
        ArmyOne.add(cav);
        ArmyOne.add(com);

        Unit infantry2 = new InfantryUnit("orc", 10);
        Unit range2 = new RangedUnit("crossbow", 10);
        Unit cav2 = new CavalryUnit("strider", 10);
        Unit com2 = new CommanderUnit("Sauron", 10);
        ArmyTwo.add(infantry2);
        ArmyTwo.add(range2);
        ArmyTwo.add(cav2);
        ArmyTwo.add(com2);

         */
    }

    public static Window getStage() {
        return startStage;
    }
}
