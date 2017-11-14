package sample.GameRules.Bufs;

import sample.GameRules.Skill;
import sample.GameRules.UnitForm;

public class Cheat extends Skill {
    private int dmg;
    public Cheat() {
        super("Шпаргалка");
        this.dmg = 40;
    }

    public void use(UnitForm unitForm){
        unitForm.takeDmg(dmg);
    }
}
