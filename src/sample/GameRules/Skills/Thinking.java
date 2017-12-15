package sample.GameRules.Skills;

import sample.GameRules.Skill;

public class Thinking extends Skill {
    public Thinking() {
        super("Заглянуть в чертоги разума");
    }

    @Override
    public int use() {
        return 20;
    }
}
