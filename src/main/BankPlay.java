
import java.security.Guard;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom; //随机数使用的类

//主要内容由天地银行拼接,主要框架来自博主.
//后面独立开发一个兰斯的战斗系统.
//! 黑历史警告
//开发日志:9月1日,未完成,需要战斗功能继续,同时对函数与类之间的访问确实之前做的不多.
public class BankPlay {
    public static void main(String[] args) {
        Utility uti = new Utility();
        uti.login();
        System.out.println("谢谢使用");
        return;
    }
}

// 整活开始,开始采用兰斯的回合制游戏模式.
class Bank_Guard {
    static String name = "泰森";
    static int health = 100;
    static int damage = 20;
    static int tick = 2;
}

class You {
    Scanner input = new Scanner(System.in);
    static String name = "曹文星";
    static int health = 50;
    static int damage = 5;
    static int tick = 1;

    int Punch() {
        return You.damage;
    }

    Boolean Run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt() > 0.5; // 打不过开润,润失败直接被秒杀.
    }

    int UseSth() {
        System.out.println("没办法了, 只能使用道具了");
        System.out.println("1.从裤裆掏出手榴弹");
        System.out.println("2.氪金5000空投AWM");
        System.out.println("3.扔出裤衩");
        System.out.println("作出选择吧! ");

        while (true) {
            int chooseforsth = input.nextInt();
            if (chooseforsth == 1) {

                return 5;

            } else if (chooseforsth == 2) {

                return gun.damage;

            } else if (chooseforsth == 3) {

                if (Run()) {
                    System.out.println("可恶,对手被你臭倒了");
                }
            } else {
                System.out.println("怎么能重新选择啊！");
            }
        }

    }

    class gun {

        static String name = "AWM";
        static int health = 500;
        static int damage = 50;
        static int tick = 1;

        int Fire() {
            return You.gun.damage;
        }

    }
}

class BankCard { // 银行卡类:代表一张银行卡,里面是他的属性

    String name;
    int passWord;
    int cash;

}

class Utility {

    BankCard card = new BankCard();
    Scanner input = new Scanner(System.in);

    public void Fight() {
        int roundNun = 1;

        System.out.println(" --  让战斗开始吧  --");

        while (You.health > 0 || Bank_Guard.health > 0) {
            System.out.print(" --  Round" + roundNun + " -- ");

        }
    }

    public void login() { // 登录
        System.out.println("******** 试做型中国天地银行ATM零号机 ********");
        System.out.println("1.登录");
        System.out.println("2.退出");
        System.out.println("3.抢钱");

        System.out.print("请选择");

        for (;;) {
            int choose = input.nextInt();
            if (choose == 1) {
                money();
                break;

            } else if (choose == 2) {
                System.out.println("谢谢使用");
                break;
            } else if (choose == 3) {
                System.out.println("不讲武德是吧");
                Fight();
                break;
            } else {
                System.out.println("输入错误，请重新选择！");
            }
        }
    }

    public void money() { // 主菜单
        card.name = "cwx";
        card.passWord = 233333;
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        int passWord = input.nextInt();
        if (name.equals("cwx") && card.passWord == passWord) { // 验证通过后,,
            System.out.println("******中国建设银行atm******");
            System.out.println("1.显示余额");
            System.out.println("2.开始存钱");
            System.out.println("3.开始取钱");
            System.out.println("请选择,按0返回上级菜单");
            for (;;) {
                int choose = input.nextInt();
                if (choose == 1) {
                    card.cash = 2000;
                    System.out.println("余额为：" + card.cash);
                    return;
                } else if (choose == 2) {
                    addMoney();
                    return;
                } else if (choose == 3) {
                    subMoney();
                    return;
                } else if (choose == 0) {
                    System.out.println("按0返回上级菜单");
                    login();
                } else {
                    System.out.println("选择错误，请重新输入");
                }
            }
        } else {
            System.out.println("用户名或者密码错误！！");
        }
    }

    public int addMoney() { // 存钱
        System.out.println("请输入存入的钱数：");
        int money = input.nextInt();
        System.out.println("您存入的钱为：" + money);
        return money;
    }

    public int subMoney() { // 取钱
        System.out.println("请输入要取的钱数：");
        int money = input.nextInt();
        System.out.println("您要取的钱为：" + money);
        return money;
    }

}
