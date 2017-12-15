package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import sample.FightController;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Dancing;
import sample.GameRules.Teacher;
import sample.SelectionController;

public class Arslanov extends Teacher{
    private final String reward = "Танцевать с бубном";
    public Arslanov() {
        super("Арсланов М.М", 230, 100);
        this.setDmg(40);
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
        SelectionController.setIsThirdLector(true);
        Hero hero = Hero.getInstance();
        if (!FightController.isIsThird()) s = "\nИ получаете новый скилл: " + reward;
        giveReward(hero);
        alert.setContentText("Вы сдали экзамен по Алгебре и Геометрии" + s);
        alert.showAndWait();
    }
}
