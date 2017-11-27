package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.GameRules.Hero;
import sample.GameRules.Lectors.Abramskiy;
import sample.GameRules.Lectors.Arslanov;
import sample.GameRules.Lectors.Shirokova;
import sample.GameRules.Practicer.Mullagaliev;
import sample.GameRules.Practicer.Shurygin;
import sample.GameRules.Practicer.Sidikov;
import sample.GameRules.Teacher;

import java.io.IOException;

public class SelectionController {
    private Hero hero = Hero.getInstance();
    private static boolean isFirst = false;
    private static boolean isSecond = false;
    private static boolean isThird = false;

    @FXML
    private ProgressBar hp;
    @FXML
    private ProgressIndicator xpToLVL;
    @FXML
    private Label xp;
    @FXML
    private Label hpByDigits;
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
    private Teacher[] practicer = {new Mullagaliev(), new Shurygin(), new Sidikov()};

    public static void setIsFirst(boolean isFirst) {
        SelectionController.isFirst = isFirst;
    }

    public static void setIsSecond(boolean isSecond) {
        SelectionController.isSecond = isSecond;
    }

    public static void setIsThird(boolean isThird) {
        SelectionController.isThird = isThird;
    }


    @FXML
    public void initialize() {
        //Инициализация текста
        xp.setText("Уровень " + hero.getLvl());

        if (!isFirst){
            lectorsBtn1.setDisable(true);
        }
        if (!isSecond){
            lectorsBtn2.setDisable(true);
        }
        if (!(isThird && isFirst && isSecond)){
            lectorsBtn3.setDisable(true);
        }

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
        xpToLVL.setProgress((double) hero.getXp()/hero.getNewLVL());
        hpByDigits.setText("" + hero.getHp());
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
        String s, sleeping = "zZzZzZzZ";
        if (hero.getHp() == hero.getRealHP()) {
            s = "Вы полны сил и уверенности в сегодняшнем дне";
            sleeping = "Не хочу спать";
        } else s = "Вы поспали 2 часа\n";
        hero.sleep(50);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(sleeping);
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
        hp.setProgress((double) hero.getHp()/hero.getRealHP());
        hpByDigits.setText("" + hero.getHp());
    }
}
