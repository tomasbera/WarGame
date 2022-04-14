package Maintnance;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SimulationViewController implements Initializable {

    @FXML private Text layoutText;
    @FXML private ImageView layoutImageView;
    @FXML private ChoiceBox<String> warGamesTerrainInnput;

    @FXML private String choosenFormat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        warGamesTerrainInnput.getItems().add(0, "Hill");
        warGamesTerrainInnput.getItems().add(1, "Forest");
        warGamesTerrainInnput.getItems().add(2, "Plains");


    }

    /**
     * Method sets an image by the image name
     * The method requires that all images is located in the resources under {@code TournamentPictures} and that the image is png
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
        warGamesTerrainInnput.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2){
                choosenFormat = warGamesTerrainInnput.getItems().get((Integer) number2);
                if(choosenFormat.equals("Hill")){
                    layoutImageView.setImage(getImageByName("hill"));
                    layoutText.setText("Hill");
                }
                if(choosenFormat.equals("Forest")){
                    layoutImageView.setImage(getImageByName("forest"));
                    layoutText.setText("Forest");
                }
                if(choosenFormat.equals("Plains")){
                    layoutImageView.setImage(getImageByName("plains"));
                    layoutText.setText("Plains");
                }
            }
        });

    }

    @FXML
    public void toArmyDetails(ActionEvent event) throws IOException {
        SwitchScene.switchScene("ArmyDetailView", event);
    }


}
