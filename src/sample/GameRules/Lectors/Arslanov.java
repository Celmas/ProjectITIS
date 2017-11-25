package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Dancing;
import sample.GameRules.Skills.Writing;
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
        if (hero.getI() == 2){
            hero.addSkill(new Dancing());
        }
    }

    @Override
    public void lost() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        alert.setHeaderText(null);
        Hero hero = Hero.getInstance();
        giveReward(hero);
        alert.setContentText("Вы сдали экзамен по Алгебре и Геометрии\n И получаете новый скилл: " + reward);
        alert.showAndWait();
    }
}
