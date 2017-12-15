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

public class GreetingsController {
    private static final String vika =
            "C:\\Users\\Ilnur\\Desktop\\ProjectITIS\\src\\sample\\Resources\\Pesnya_papicha_VI_KA_pobednaya_(mp3co.co).mp3";
    Media win = new Media(new File(vika).toURI().toString());
    MediaPlayer player = new MediaPlayer(win);
    @FXML
    private Button btn;
    @FXML
    private Label lbl;
    @FXML
    private ImageView img;
    @FXML
    public void initialize(){
        player.play();
    }
    @FXML
    public void toMenu() throws IOException {
        player.stop();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage=(Stage) btn.getScene().getWindow();
        stage.setTitle("You lose(9(");
        MenuController.setIsStarted(false);
        Scene scene = new Scene(root, 960, 540);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
