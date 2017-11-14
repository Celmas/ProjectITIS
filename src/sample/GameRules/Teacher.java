package sample.GameRules;

import javafx.scene.control.Label;

public class Teacher extends UnitForm {
    public Teacher(String name, int hp, int xp) {
        super(name, hp);
        this.xp = xp;
    }
    public void giveReward(Label label, Hero hero){

    }
    public void lost(Label label){

    }


}
