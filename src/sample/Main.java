package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        // write your code here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));


        primaryStage.setTitle("Жизнь в ИТИСе");
        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
