package sample.GameRules.Bufs;

import sample.GameRules.Hero;
import sample.GameRules.Skill;
import sample.GameRules.Teacher;
import sample.GameRules.UnitForm;

public class Coffee extends Skill {
    private int hpBonus;
    public Coffee() {
        super("Кофе");
        this.hpBonus = 125;
    }

    public void use(Teacher teacher) {
        Hero hero = Hero.getInstance();
        hero.setHp(hero.getHp()+hpBonus);
        hero.testHP();
    }
    public String notification(){
        return "Вы вылечились на " + hpBonus;
    }
}
