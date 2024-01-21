import java.util.Scanner;

// !笔记, 一个家庭收支管理系统,范例
public class House_income_System {

    private static Scanner input = new Scanner(System.in);

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection() {
        char c;
        String str = readKeyBoard(1); // 读取键盘
        // charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
        c = str.charAt(0);
        boolean isFlag = true;
        while (isFlag) {
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新输入");
            } else {
                isFlag = false;
            }
        }
        return c;
    }

    /**
     * 用于收入和支出金额的输入。该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值。
     */
    public static int readNumber() {
        int n;
        for (;;) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;

    }

    /**
     * 用于收入和支出说明的输入。该方法从键盘读取一个不超过8位长度的字符串，并将其作为方法的返回值。
     */
    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection() {
        char c;
        for (;;) {
            // 将用户输入的字符转换成大写
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，请重新输入");
            }
        }
        return c;
    }

    /**
     * 限制用户输入的字符长度
     *
     * @param limit
     * @return
     */
    private static String readKeyBoard(int limit) {
        String line = "";

        while (input.hasNext()) {
            line = input.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不大于" + limit + ")错误，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

    public static void main(String[] args) {

        String details = "收支\t账户金额\t收支金额\t说    明\n";
        // 初始账户余额为10000元
        int balance = 10000;

        boolean isFlag = true;
        while (isFlag) {

            System.out.println("\n------------------家庭收支记账软件------------------\n");

            System.out.println("                    1 收支明细");
            System.out.println("                    2 登记收入");
            System.out.println("                    3 登记支出");
            System.out.println("                    4 退    出\n");

            System.out.print("                    请选择(1——4):");
            char key = readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------------");
                    break;

                case '2':
                    System.out.println("本次收入金额");
                    int earning = readNumber();
                    System.out.println("本次收入说明");
                    String earingDescription = readString();

                    // 账户余额=收入+账户余额
                    balance += earning;
                    details += "收入\t" + balance + "\t\t" +
                            earning + "\t\t\t" + earingDescription + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;

                case '3':
                    System.out.println("本次支出金额");
                    int expense = readNumber();
                    System.out.println("本次支出说明");
                    String expenseDescription = readString();

                    // 账户余额=账户余额-支出金额
                    balance -= expense;
                    details += "支出\t" + balance + "\t\t" +
                            expense + "\t\t\t" + expenseDescription + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;

                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char isExit = readConfirmSelection();
                    if (isExit == 'Y')
                        ;
                    isFlag = false;
                    break;
            }
        }
    }
}
