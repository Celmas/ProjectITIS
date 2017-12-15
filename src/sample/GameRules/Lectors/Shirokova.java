package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.FightController;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Writing;
import sample.GameRules.Teacher;
import sample.SelectionController;

public class Shirokova extends Teacher {
    private final String reward = "Доказать теорию струн";
    public Shirokova() {
        super("Широкова Е.А", 130, 50);
        this.setDmg(20);
    }

    @Override
    public void giveReward(Hero hero) {
        hero.upLVL();
        if (!FightController.isIsSecond()) hero.addSkill(new Writing(),1);
        FightController.setSecond(true);
    }

    @Override
    public void lost() {
        String s = "";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        SelectionController.setIsSecondLector(true);
        alert.setHeaderText(null);
        Hero hero = Hero.getInstance();
        if (!FightController.isIsSecond()) s = "\nИ получаете новый скилл: " + reward;
        giveReward(hero);
        alert.setContentText("Вы сдали экзамен по Математическому анализу" + s);
        alert.showAndWait();
    }
}
