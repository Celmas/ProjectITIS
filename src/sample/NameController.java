package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameController {
    @FXML
    private Button ready;
    @FXML
    private TextField text;
    @FXML
    private Label name;
    @FXML
    public void initialize() {

    }
    @FXML
    public void toFirst() throws Exception {
        FirstController.setName(text.getText());
        Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
        Stage stage=(Stage) name.getScene().getWindow();
        stage.setTitle("Подпишитесь за технику безопасности!");
        Scene scene = new Scene(root, 940, 560);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
