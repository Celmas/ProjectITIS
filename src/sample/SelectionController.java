package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import sample.GameRules.Hero;
import sample.GameRules.Lectors.Abramskiy;
import sample.GameRules.Lectors.Arslanov;
import sample.GameRules.Lectors.Shirokova;
import sample.GameRules.Practicer.Korneeva;
import sample.GameRules.Practicer.Shurygin;
import sample.GameRules.Practicer.Sidikov;
import sample.GameRules.Teacher;

import java.io.IOException;

public class SelectionController {
    private Hero hero = Hero.getInstance();

    @FXML
    private ProgressBar hp;
    @FXML
    private Label xp;
    @FXML
    private Button backBtn;
    @FXML
    private Button practiksBtn1;
    @FXML
    private Button practiksBtn2;
    @FXML
    private Button practiksBtn3;
    @FXML
    private Button lectorsBtn1;
    @FXML
    private Button lectorsBtn2;
    @FXML
    private Button lectorsBtn3;

    private Teacher[] lectors = {new Shirokova(), new Arslanov(), new Abramskiy()};
    private Teacher[] practicer = {new Korneeva(), new Shurygin(), new Sidikov()};


    @FXML
    public void initialize() {
        //Инициализация текста
        xp.setText("Уровень " + hero.getLvl());

        //Инициализация текста кнопок
        lectorsBtn1.setText(lectors[0].getName());
        lectorsBtn2.setText(lectors[1].getName());
        lectorsBtn3.setText(lectors[2].getName());
        practiksBtn1.setText(practicer[0].getName());
        practiksBtn2.setText(practicer[1].getName());
        practiksBtn3.setText(practicer[2].getName());

        lectorsBtn1.setOnAction(event -> toFight(lectors[0]));
        lectorsBtn2.setOnAction(event -> toFight(lectors[1]));
        lectorsBtn3.setOnAction(event -> toFight(lectors[2]));
        practiksBtn1.setOnAction(event -> toFight(practicer[0]));
        practiksBtn2.setOnAction(event -> toFight(practicer[1]));
        practiksBtn3.setOnAction(event -> toFight(practicer[2]));

        hp.setProgress((double) hero.getHp()/hero.getRealHP());

    }

    @FXML
    public void toMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage=(Stage) practiksBtn1.getScene().getWindow();
        stage.setTitle("Добиваемся знаний");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }

    public void toFight(Teacher teacher){
        FightController.setCurrent(teacher);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Fight.fxml"));
            Stage stage=(Stage) practiksBtn1.getScene().getWindow();
            stage.setTitle("Жизнь в ИТИСе");
            stage.setScene(new Scene(root, 960, 540));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sleep(){
        hero.sleep(50);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("zZzZzZzZ");
        alert.setHeaderText(null);
        alert.setContentText("Вы поспали 2 часа\n" + hero.getHp());
        alert.showAndWait();
        hp.setProgress((double) hero.getHp()/hero.getRealHP());
    }
}
