package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.GameRules.Hero;
import sample.GameRules.Lectors.Arslanov;
import sample.GameRules.Teacher;

import java.io.IOException;
import java.util.Random;


public class FightController{
    private static Teacher current;
    private static Hero hero;
    @FXML
    private Label countOfCheat;
    @FXML
    private Label countOfCoffee;
    @FXML
    private Label countOfEnergetic;

    @FXML
    private Button first;
    @FXML
    private Button second;
    @FXML
    private Button third;
    @FXML
    private Label lvlHero;
    @FXML
    private Label teacher;
    @FXML
    private Label hpHero;
    @FXML
    private Label hpTeacher;
    @FXML
    private Label logBot;

    public static void setCurrent(Teacher current) {
        FightController.current = current;
    }

    public void update(){
        hpTeacher.setText(String.valueOf(current.getHp()));
        hpHero.setText(String.valueOf(hero.getHp()));
        lvlHero.setText("Уровень " + hero.getLvl());
        countOfCheat.setText("x" + hero.countOfBuffs[0]);
        countOfCoffee.setText("x" + hero.countOfBuffs[1]);
        countOfEnergetic.setText("x" + hero.countOfBuffs[2]);
    }
    public void checkTeacher(){
        if (current.getHp() < 1){
            current.setHp(0);
            current.lost();
            try {
                toSelection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void toSelection() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Selection.fxml"));
        Stage stage=(Stage) first.getScene().getWindow();
        stage.setTitle("Жизнь в ИТИСе");
        stage.setScene(new Scene(root, 960, 540));
        stage.setResizable(false);
        stage.show();
    }

    public void createAlertOfNULL(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Проблемка");
        alert.setHeaderText(null);
        alert.setContentText("У вас не достаточно " + s);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        hero = Hero.getInstance();
        teacher.setText(current.getName());
        lvlHero.setText("Уровень " + hero.getLvl());
        hpTeacher.setText(String.valueOf(current.getHp()));
        hpHero.setText(String.valueOf(hero.getHp()));
        logBot.setText("Преподователь: " + current.getName());
        first.setText("Придумать на ходу");
        second.setText("Списать");
        third.setText("Танцевать с бубном");
        countOfCheat.setText("x" + hero.countOfBuffs[0]);
        countOfCoffee.setText("x" + hero.countOfBuffs[1]);
        countOfEnergetic.setText("x" + hero.countOfBuffs[2]);

        if (hero.getI() == 1){
            second.setDisable(true);
            third.setDisable(true);
        } else if (hero.getI() == 2){
            third.setDisable(true);
        }
    }

    public void round(boolean isBuff, int number){
        int buf;
        String s;
        if (!isBuff){
            buf = hero.getSkills()[number].use() + new Random().nextInt(6);
            s = hero.getSkills()[number].notification() + buf;
            logBot.setText(s);
            current.takeDmg(buf);
        }else {
            hero.getBuffs()[number].use(current);
            hero.countOfBuffs[number]--;
            s = hero.getBuffs()[number].notification();
        }
        checkTeacher();
        update();
        if (current.getHp() < 1) return;
        buf = new Random().nextInt(current.getDmg());
        hero.takeDmg(buf);
        logBot.setText(s + "\n" + "Вас поразили на " + buf);
        checkHero(hero);
        update();
    }

    @FXML
    public void useCheat(){
        if (hero.countOfBuffs[0] > 0) {
            round(true, 0);
        }else createAlertOfNULL("шпаргалок");

    }
    @FXML
    public void useCoffee(){
        if (hero.countOfBuffs[1] > 0) {
            round(true, 1);
        }else createAlertOfNULL("коффе");
    }
    @FXML
    public void useEnergetic(){
        if (hero.countOfBuffs[2] > 0) {
            round(true, 2);
        }else createAlertOfNULL("энергетиков");
    }

    @FXML
    public void setSkill1(){
        round(false,0);
    }

    @FXML
    public void setSkill2(){
        round(false,1);
    }

    @FXML
    public void setSkill3(){
        round(false,2);
    }

    public void checkHero(Hero hero) {
        if (hero.getHp() < 1){
            logBot.setText("Вы не сдали экзамен");
            System.exit(0);
        }
    }

}
