package sample.GameRules;

public  class Skill {
    protected String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int use(){return 0;};
    public void use(Teacher teacher){};

    public String notification(){return "Вы поразили на ";};
}
