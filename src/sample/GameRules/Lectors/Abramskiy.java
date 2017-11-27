package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Writing;
import sample.GameRules.Teacher;

public class Abramskiy extends Teacher {
    private final String reward = "toDo";//toDo
    public Abramskiy() {
        super("Абрамский М.М.", 250, 250);
        this.setDmg(100);
    }

    @Override
    public void giveReward(Hero hero) {
        hero.upLVL();
    }

    @Override
    public void lost() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        alert.setHeaderText(null);
        alert.setContentText("Вы сдали экзамен по Информатики\nИ прошли эту замечательную игру");
        alert.showAndWait();
    }
}
