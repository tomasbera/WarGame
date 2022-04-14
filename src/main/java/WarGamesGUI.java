import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarGamesGUI extends Application {
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
}
