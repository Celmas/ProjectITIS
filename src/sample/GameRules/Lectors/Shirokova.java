package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Writing;
import sample.GameRules.Teacher;

public class Shirokova extends Teacher {
    private final String reward = "Списать";
    public Shirokova() {
        super("Широкова 0.0", 100, 100);
        this.setDmg(35);
    }

    @Override
    public void giveReward(Hero hero) {
        hero.upLVL();
        if (hero.getI() == 1){
            hero.addSkill(new Writing());
        }
    }

    @Override
    public void lost() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поздравляем!");
        alert.setHeaderText(null);
        Hero hero = Hero.getInstance();
        giveReward(hero);
        alert.setContentText("Вы сдали экзамен по Математическому анализу\n И получаете новый скилл: " + reward);
        alert.showAndWait();
    }
}
