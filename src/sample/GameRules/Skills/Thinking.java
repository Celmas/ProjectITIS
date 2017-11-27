package sample.GameRules.Skills;

import sample.GameRules.Skill;

public class Thinking extends Skill {
    public Thinking() {
        super("Придумать на ходу");
    }

    @Override
    public int use() {
        return 20;
    }
}
