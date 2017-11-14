package sample.GameRules.Bufs;

import sample.GameRules.Hero;
import sample.GameRules.Skill;

public class Energetic extends Skill {
    private int hpBonus;
    public Energetic() {
        super("Энергетический напиток");
        this.hpBonus = 35;
    }
    public void heal(Hero hero){
        hero.setHp(hero.getHp() + hpBonus);
        if (hero.getHp() > 100){
            hero.setHp(100);
        }
    }
}
