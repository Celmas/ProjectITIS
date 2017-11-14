package sample.GameRules.Practicer;

import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Teacher;

import java.util.Random;

public class Korneeva extends Teacher{

    public Korneeva() {
        super("Корнеева Н.Н.", 35, 25);
    }

    @Override
    public void giveReward(Label label, Hero hero){
        hero.countOfBuffs[new Random().nextInt(2)]++;
        hero.setXp(hero.getXp() + this.xp);
        label.setText("Вы получаете");
    }

    @Override
    public void lost(Label label) {
        System.out.println("Вы прошли практику");
    }
}
