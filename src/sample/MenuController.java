package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {
    @FXML
    public void initialize() {
    }

    @FXML
    private Label menu;
    @FXML
    public void start() {
        menu.setText("Стартуем!");
    }
    @FXML
    public void toFight() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Selection.fxml"));
        Stage stage=(Stage) menu.getScene().getWindow();
        stage.setTitle("Жизнь в ИТИСе");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }
    public void toRules() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setTitle("Правило");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }
    public void toExit() {
        System.exit(0);
    }
}
