package sample.GameRules.Practicer;

import javafx.scene.control.Alert;
import sample.GameRules.Hero;
import sample.GameRules.Teacher;
import sample.SelectionController;

import java.util.Random;

public class Mullagaliev extends Teacher{
    private String reward;

    public Mullagaliev() {
        super("Муллагалиев Э.А.", 35, 25);
    }

    @Override
    public void giveReward(Hero hero){
        int buf = new Random().nextInt(3);
        hero.countOfBuffs[buf]++;
        hero.setXp(hero.getXp() + this.xp);
        reward = hero.getBuffs()[buf].getName();
    }

    @Override
    public void lost() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        alert.setHeaderText(null);
        Hero hero = Hero.getInstance();
        giveReward(hero);
        SelectionController.setIsFirst(true);
        alert.setContentText("Вы прошли практику по Математическому анализу\nИ получаете: " + reward);
        alert.showAndWait();
    }
}
