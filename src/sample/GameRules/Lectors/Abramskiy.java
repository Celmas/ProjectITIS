package sample.GameRules.Lectors;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.FightController;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Writing;
import sample.GameRules.Teacher;

public class Abramskiy extends Teacher {
    private final String reward = "toDo";//toDo
    public Abramskiy() {
        super("Абрамский М.М.", 330, 150);
        this.setDmg(60);
    }

    @Override
    public void giveReward(Hero hero) {
        hero.upLVL();
    }

    @Override
    public void lost() {
        FightController.setIsWon(true);
    }
}
