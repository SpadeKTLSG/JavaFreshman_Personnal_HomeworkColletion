

import java.util.Scanner;

public class PlayGuessPunchGame {

    int computer;
    int self;

    public int selfGuss() { // 玩家出拳
        Scanner input = new Scanner(System.in);
        System.out.println("请您开始出拳:1-石头、2-剪刀、3-布");
        int self = input.nextInt();
        for (;;) {
            if (self == 1) {
                System.out.println("您选择出拳: 石头");
                break;

            } else if (self == 2) {
                System.out.println("您选择出拳: 剪刀");
                break;

            } else if (self == 3) {
                System.out.println("您选择出拳: 布");
                break;
            }
        }
        return self;
    }

    public int computerGuss() { // 电脑出拳
        int computer = (int) (Math.random() * 3 + 1);
        for (;;) {
            if (computer == 1) {
                System.out.println("电脑选择出拳: 石头");
                break;

            } else if (computer == 2) {
                System.out.println("电脑选择出拳: 剪刀");
                break;

            } else if (computer == 3) {
                System.out.println("电脑选择出拳: 布");
                break;
            }
        }
        return computer;

    }

    public void compare() { // 判断谁赢
        self = selfGuss();
        computer = computerGuss();

        if (computer == 1 && self == 2 || computer == 2 && self == 3
                || computer == 3 && self == 1) {
            System.out.println("电脑赢！！");
        } else if (computer == self) {
            System.out.println("平手！！");
        } else {
            System.out.println("恭喜，您赢了！");
        }
    }

    public static void main(String[] args) {
        PlayGuessPunchGame finGuss = new PlayGuessPunchGame();
        Scanner input = new Scanner(System.in);
        System.out.println("********猜拳游戏********\n");
        System.out.println("请输入您的角色名");
        String name = input.next();
        System.out.println("请选择您的对手：1-洛天依 2-Atri 3-玄桃K");
        
        // for(;;)
        for (;;) {
            int person = input.nextInt();
            if (person == 1) {
                System.out.println("***********" + name + " Vs " + "洛天依" + "***********");
                break;
            } else if (person == 2) {
                System.out.println("***********" + name + " Vs " + "Atri" + "***********");
                break;
            } else if (person == 3) {
                System.out.println("***********" + name + " Vs " + "玄桃K" + "***********");
                break;
            } else {
                System.out.println("没有此角色，请重新输入!");
            }
        }
        
        finGuss.compare();
    }
}
