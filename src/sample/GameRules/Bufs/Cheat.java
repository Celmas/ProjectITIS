package sample.GameRules.Bufs;

import sample.GameRules.Skill;
import sample.GameRules.Teacher;
import sample.GameRules.UnitForm;

public class Cheat extends Skill {
    private int dmg;
    public Cheat() {
        super("Шпаргалка");
        this.dmg = 200;
    }

    public void use(Teacher teacher){
        teacher.takeDmg(dmg);
    }

    public String notification(){
        return "Вы поразили на " + dmg;
    }
}
