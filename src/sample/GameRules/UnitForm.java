package sample.GameRules;

public class UnitForm {
    protected int hp;
    protected int xp;
    protected int dmg;
    protected String name;

    UnitForm(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.xp = 0;
        this.dmg = 30;
    }

    public void takeDmg(int dmg){
        this.hp -= dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }
}
