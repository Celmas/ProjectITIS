package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.GameRules.Hero;
import sample.GameRules.Lectors.Zubkov;
import sample.GameRules.Practicer.Korneeva;
import sample.GameRules.Teacher;

import java.util.Random;
import java.util.Scanner;

import static sample.GameRules.Battle.battle;


public class FightController{

    @FXML
    private Button first;
    @FXML
    private Label lvlHero;
    @FXML
    private Label teacher;
    @FXML
    private Label hpHero;
    @FXML
    private Label hpTeacher;
    @FXML
    private Label skill1;
    @FXML
    private Label skill2;
    @FXML
    private Label skill3;
    @FXML
    private Label logBot;

    Hero hero = new Hero("Ilnur", 200);
    Zubkov zubkov = new Zubkov();

    public void update(Hero hero, Teacher teacher){
        hpTeacher.setText(String.valueOf(teacher.getHp()));
        hpHero.setText(String.valueOf(hero.getHp()));
        lvlHero.setText("Уровень " + hero.getLvl());
    }
    public void checkTeacher() {
        if (zubkov.getHp() < 1){
            zubkov.setHp(0);
            zubkov.lost(logBot);
            zubkov.giveReward(logBot, hero);
            first.setDisable(true);

        }
    }

    @FXML
    public void initialize() {
        teacher.setText(zubkov.getName());
        lvlHero.setText("Уровень " + hero.getLvl());
        hpTeacher.setText(String.valueOf(zubkov.getHp()));
        hpHero.setText(String.valueOf(hero.getHp()));
        logBot.setText("Экзамен. Преподователь: " + zubkov.getName());
        skill1.setText(hero.getSkills()[0].getName());
        }

    @FXML
    public void setSkill1(){
        int buf = hero.getSkills()[0].use() + new Random().nextInt(5);
        String s = "Вы поразили на " + buf;
        logBot.setText(s);
        zubkov.takeDmg(buf);
        checkTeacher();
        update(hero,zubkov);
        if (zubkov.getHp() < 1) return;
        buf = new Random().nextInt(zubkov.getDmg());
        hero.takeDmg(buf);
        logBot.setText(s + "\n" + "Вас поразили на " + buf);
        checkHero(hero);
        update(hero,zubkov);
        if (hero.getHp() < 1) return;
    }

    public void checkHero(Hero hero) {
        if (hero.getHp() < 1){
            logBot.setText("Вы не сдали экзамен");
            System.exit(0);
        }
    }

}
