package sample.GameRules;

import sample.GameRules.Lectors.Arslanov;
import sample.GameRules.Practicer.Korneeva;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static void choose(Teacher[] teachers){
        System.out.println("****************");
        System.out.println("Выберите противника");
        System.out.println("0 Спать");
        for (int i = 0; i < 2; i++){
            System.out.println((i+1) + " " + teachers[i].name);
        }
    }
    public static void battle(Hero hero, Teacher teacher){
        while (true){
            System.out.println("Жизни преподователся " + teacher.hp);
            System.out.println("Ваши жизни " + hero.hp);
            System.out.println();
            for (int i = 0; i < hero.i; i++){
                System.out.println((i+1) + ". " + hero.skills[i].name);
            }
            int x = new Scanner(System.in).nextInt();
            if ( x == 1){
                int buf = hero.skills[0].use() + new Random().nextInt(5);
                System.out.println();
                System.out.println("Вы поразили на " + buf);
                teacher.takeDmg(buf);
            } else if (x == 2){
                int buf = hero.skills[1].use() + new Random().nextInt(5);
                System.out.println();
                System.out.println("Вы поразили на " + buf);
                teacher.takeDmg(buf);
            }else if (x == 3){
                int buf = hero.skills[2].use() + new Random().nextInt(5);
                System.out.println();
                System.out.println("Вы поразили на " + buf);
                teacher.takeDmg(buf);
            } else if (x == 4){
                int buf = hero.skills[3].use() + new Random().nextInt(5);
                System.out.println();
                System.out.println("Вы поразили на " + buf);
                teacher.takeDmg(buf);
            }
            if (teacher.hp < 1){
                //teacher.lost();
                //teacher.giveReward(hero);
                break;
            }
            int buf = new Random().nextInt(teacher.dmg);
            hero.takeDmg(buf);
            System.out.println("Вас поразили на " + buf);
            if (hero.hp < 1){
                System.out.println("Вы проиграли");
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Hero hero = Hero.getInstance();
        while (true){
            Teacher zubkov = new Arslanov();
            Teacher korneeva = new Korneeva();
            Teacher[] teachers = {zubkov, korneeva};
            choose(teachers);
            int i = new Scanner(System.in).nextInt();
            switch (i){
                case 0:
                    System.out.println("ZZZZZZZZZZZZZZZZZZZZ");
                    System.out.println("Урааа, сон");
                    hero.sleep(50);
                    hero.testHP();
                    System.out.println("Ваши жизни " + hero.hp);
                    break;
                case 1:
                    System.out.println("********************");
                    System.out.println("Бой с " + teachers[0].name);
                    battle(hero,zubkov);
                    break;
                case 2:
                    System.out.println("********************");
                    System.out.println("Бой с " + teachers[1].name);
                    battle(hero,korneeva);
                    break;
            }
        }
    }
}
