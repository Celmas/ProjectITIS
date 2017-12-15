package sample.GameRules.Skills;

import sample.GameRules.Skill;

public class Writing extends Skill {
    public Writing() {
        super("Доказать теорию струн");
    }

    @Override
    public int use() {
        return 35;
    }
}
