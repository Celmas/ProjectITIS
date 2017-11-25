package sample.GameRules.Skills;

import sample.GameRules.Skill;

public class Dancing extends Skill {
    public Dancing() {
        super("Танцевать с бубном");
    }

    @Override
    public int use() {
        return 50;
    }
}
