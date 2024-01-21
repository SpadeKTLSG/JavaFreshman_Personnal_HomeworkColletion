import java.util.Scanner;

//! 笔记: 比较优秀的开发界面,内容朴实无华.
public class ATMTest {

    public static void main(String[] args) {
        System.out.println("**********中国建设银行**********");
        try (Scanner input = new Scanner(System.in)) { // ?这里我加上了一个错误处理
            ATM atm = new ATM();
            atm.info();
            for (int i = 4; i > 0; i--) { // 次数:循环
                System.out.println("请输入账号");
                int account = input.nextInt(); // 这个获得输入流的下一个对象
                System.out.println("请输入密码");
                int passWord = input.nextInt();

                boolean num = atm.login(account, passWord);

                if (num) {
                    System.out.println("登录成功");
                    atm.Usage();
                    break;
                } else
                    System.out.println("账号或密码错误" + "您还有" + (i - 1) + "次机会");

            }
        } catch (Exception e) {
            System.out.println("出问题了,你是不是在乱搞? " + e);
        }

    }
}

class ATM {
    public class Bank { // 内部类
        int account;
        int passWord;
        double balance;
    }

    Scanner input = new Scanner(System.in);
    Bank bank = new Bank();

    public void info() { // 初始化账号
        bank.account = 114;
        bank.passWord = 514;
        bank.balance = 250;
    }

    public void Usage() {
        System.out.println("1.显示余额");
        System.out.println("2.我要存钱");
        System.out.println("3.我要取钱");
        System.out.println("4.退出");
        while (true) {
            System.out.println("请选择功能：");
            int choose = input.nextInt(); // 输入
            if (choose == 1) {
                showMoney();
            } else if (choose == 2) {
                System.out.println("请输入要存入的钱");
                deposit(input.nextDouble());
            } else if (choose == 3) {
                System.out.println("请输入要取出的钱");
                withdraw(input.nextDouble());
            } else if (choose == 4) {
                System.out.println("谢谢使用");
                break; // ! 由于没有穿透因此只需要真正停下的时候break;
            } else {
                System.out.println("没有此选项，请重新输入!");
            }
        }
    }

    public boolean login(int acc, int pass) { // 校验账户密码
        return acc == bank.account && pass == bank.passWord;
        // return true ? (acc == bank.account && pass == bank.passWord) : false;
        // !Dead code!
    }

    public void showMoney() { // 账户余额
        System.out.println("您的余额为" + bank.balance);
    }

    public void deposit(double amount) { // 存钱
        if (bank.balance > 0)
            bank.balance += amount;

        System.out.println("存钱成功，您当前余额为" + bank.balance);
    }

    public void withdraw(double amount) { // 取钱
        if (bank.balance < amount) {
            System.out.println("对不起，您的余额不足！");
        } else {
            bank.balance -= amount;
            System.out.println("取钱成功，您当前余额为" + bank.balance);
        }
    }

}
