package sample.GameRules;

import javafx.scene.control.Alert;
import sample.GameRules.Bufs.Cheat;
import sample.GameRules.Bufs.Coffee;
import sample.GameRules.Bufs.Energetic;
import sample.GameRules.Skills.Thinking;

public class Hero extends UnitForm {
    protected Skill buffs[] = {new Cheat(), new Coffee(), new Energetic()};
    protected Skill skills[];
    protected int lvl;
    protected int i;
    protected int realHP;
    private int newLVL;
    public int countOfBuffs[];
    private boolean isDead = false;
    private static final Hero instance;

    static {
        instance = new Hero("Задрот", 500);
    }

    private Hero(String name, int hp) {
        super(name, hp);
        newLVL = 150;
        realHP = hp;
        lvl = 0;
        skills = new Skill[5];
        skills[0] = new Thinking();
        i = 1;
        countOfBuffs = new int[3];
        for (int i = 0; i < countOfBuffs.length;i++ ){
            countOfBuffs[i] = 0;
        }
    }

    public void nextLVL(){
        while (xp >= newLVL) {
            xp = xp - newLVL;
            upLVL();
        }
    }

    public void upLVL(){
        lvl+=1;
        dmg+=10;
        realHP += 50;
        newLVL *= 1.25;
    }
    public void addSkill(Skill skill, int i){
        skills[i] = skill;
    }
    public void testHP(){
        if (hp > realHP){
            hp = realHP;
        }
        if (hp < 0){
            isDead = true;
            System.exit(0);
        }
    }

    public void toDie(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Game Over");
        alert.setHeaderText("Простите, но вы проиграли");
        alert.setContentText("Попробуйте еще раз");
        alert.showAndWait();
    }

    public void sleep(int x){
        this.hp += x;
        testHP();
    }

    public int getRealHP() {
        return realHP;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getLvl() {
        return lvl;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public Skill[] getBuffs() {
        return buffs;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    public int getI() {
        return i;
    }

    public int getNewLVL() {
        return newLVL;
    }

    public static Hero getInstance() {
        return instance;
    }
}
