package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstController {
    private static String name = "Сашко";
    @FXML
    private Button continueBtn;
    @FXML
    private Button newGame;
    @FXML
    private Label textLabel;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        FirstController.name = name;
    }

    @FXML
    public void initialize() {
        textLabel.setText("Привет, " + name + ", вот и кончились твои легкие школьные годы. Теперь попробуй выжить и не вылететь до конца 4-го  курса. Добро пожаловать в ИТИС!");
    }
    public void toFight() throws IOException {
        MenuController.setIsStarted(true);
        Parent root = FXMLLoader.load(getClass().getResource("Selection.fxml"));
        Stage stage = (Stage) textLabel.getScene().getWindow();
        stage.setTitle("Жизнь в ИТИСе");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }
    public void toMenu() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) textLabel.getScene().getWindow();
        stage.setTitle("Жизнь в ИТИСе");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }
}
