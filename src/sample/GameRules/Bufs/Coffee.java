package sample.GameRules.Bufs;

import sample.GameRules.Hero;
import sample.GameRules.Skill;

public class Coffee extends Skill {
    private int hpBonus;
    public Coffee() {
        super("Кофе");
        this.hpBonus = 20;
    }
    public void heal(Hero hero){
        hero.setHp(hero.getHp() + hpBonus);
        if (hero.getHp() > 100){
            hero.setHp(100);
        }
    }
}
