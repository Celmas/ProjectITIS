package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import sample.FightController;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Dancing;
import sample.GameRules.Teacher;

public class Arslanov extends Teacher{
    private final String reward = "Танцевать с бубном";
    public Arslanov() {
        super("Арсланов М.М", 175, 175);
        this.setDmg(60);
    }
    @Override
    public void giveReward(Hero hero) {
        hero.upLVL();
        if (!FightController.isIsThird()) hero.addSkill(new Dancing(), 2);
        FightController.setThird(true);
    }

    @Override
    public void lost() {
        String s = "";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        alert.setHeaderText(null);
        Hero hero = Hero.getInstance();
        if (!FightController.isIsThird()) s = "\nИ получаете новый скилл: " + reward;
        giveReward(hero);
        alert.setContentText("Вы сдали экзамен по Алгебре и Геометрии" + s);
        alert.showAndWait();
    }
}
