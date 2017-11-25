package sample.GameRules.Practicer;

import javafx.scene.control.Alert;
import sample.GameRules.Hero;
import sample.GameRules.Teacher;

import java.util.Random;

public class Sidikov extends Teacher {
    private String reward;

    public Sidikov() {
        super("Сидиков М.Р.", 75, 75);
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
        alert.setContentText("Вы прошли практику по Информатики\nИ получаете: " + reward);
        alert.showAndWait();
    }
}
