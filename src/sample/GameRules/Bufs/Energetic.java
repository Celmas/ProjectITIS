package sample.GameRules.Bufs;

import sample.GameRules.Hero;
import sample.GameRules.Skill;
import sample.GameRules.Teacher;
import sample.GameRules.UnitForm;

public class Energetic extends Skill {
    private int hpBonus;
    private Hero hero;
    public Energetic() {
        super("Энергетический напиток");
        this.hpBonus = 170;
        hero = Hero.getInstance();
    }

    public void use(Teacher teacher) {
        Hero hero = Hero.getInstance();
        hero.setHp(hero.getHp() + hpBonus);
        hero.testHP();
    }
    public String notification(){
        return "Вы вылечились на " + hpBonus;
    }
}
