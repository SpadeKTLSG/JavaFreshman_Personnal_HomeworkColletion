interface Terrestrial {
    int getLegNum();
}

// !笔记: 良好的继承与接口Override以及extends例子.
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void shout() {
        System.out.println("动物会叫！");
    }
}

class Cat extends Animal implements Terrestrial {

    private int legNum;

    public Cat(String name, int legNum) {
        super(name);
        this.legNum = legNum;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void shout() {
        // TODO Auto-generated method stub
        System.out.println("猫咪喵喵叫！");
    }

    @Override
    public int getLegNum() {
        // TODO Auto-generated method stub
        return this.legNum;
    }

}

class Duck extends Animal implements Terrestrial {

    private int legNum;

    public Duck(String name, int legNum) {
        super(name);
        this.legNum = legNum;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void shout() {
        // TODO Auto-generated method stub
        System.out.println("鸭子嘎嘎叫");
    }

    @Override
    public int getLegNum() {
        // TODO Auto-generated method stub
        return this.legNum;
    }

}

class Dolphin extends Animal {

    public Dolphin(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void shout() {
        // TODO Auto-generated method stub
        System.out.println("海豚音");
    }
}

public class Zoo_test {

    public static void main(String[] args) {
        Cat cat = new Cat("皮卡丘", 4);

        System.out.println("\n皮卡丘有这些腿:" + cat.getLegNum());
        cat.shout();

        Duck duck = new Duck("唐老鸭", 2);
        System.out.println("\n唐老鸭有这些腿:" + duck.getLegNum());
        duck.shout();

        Dolphin d = new Dolphin("高宗武");
        System.out.println("\n高宗武没有腿");
        d.shout();
    }
}
