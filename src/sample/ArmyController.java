package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class ArmyController {
    private static final String SG =
            "C:\\Users\\Ilnur\\Desktop\\ProjectITIS\\src\\sample\\Resources\\ИУЭФ - &quot;56&quot; (320 kbps) (mp3cut.ru).mp3";
    Media lose = new Media(new File(SG).toURI().toString());
    MediaPlayer player1 = new MediaPlayer(lose);
    @FXML
    private Button btn;
    @FXML
    private Label lbl;
    @FXML
    private ImageView img;
    @FXML
    public void initialize() {
        player1.play();
    }
    public void toMenu() throws IOException {
        player1.stop();
        MenuController.setIsStarted(false);
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.setTitle("Жизнь в ИТИСе");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }


}
