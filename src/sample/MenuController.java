package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.GameRules.Hero;

import java.io.IOException;


public class MenuController {
    private static boolean isStarted = false;
    private Hero hero = Hero.getInstance();
    @FXML
    public Button continueGame;

    public static boolean isIsStarted() {
        return isStarted;
    }

    public static void setIsStarted(boolean isStarted) {
        MenuController.isStarted = isStarted;
    }

    @FXML
    public void initialize() {
        if (!isStarted){
            continueGame.setDisable(true);
        } else continueGame.setDisable(false);
    }

    @FXML
    private Label menu;
    @FXML
    public void toFight() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Selection.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
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
    public void toNewGame() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Name.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
        FightController.setIsWon(false);
        hero.reset();

    }
    public void toExit() {
        System.exit(0);
    }
}
