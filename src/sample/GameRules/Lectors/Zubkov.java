package sample.GameRules.Lectors;

import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Skills.Writing;
import sample.GameRules.Teacher;

public class Zubkov extends Teacher{
    public Zubkov() {
        super("Зубков М.В.", 50, 50);
    }
    @Override
    public void giveReward(Label label, Hero hero) {
        hero.upLVL();
        if (hero.getI() == 1){
            hero.addSkill(new Writing());
        }
    }

    @Override
    public void lost(Label label) {
        label.setText("Вы сдали экзамен");
    }
}
