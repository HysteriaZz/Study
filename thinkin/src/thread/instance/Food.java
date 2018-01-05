package thread.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaiLin.Guo on 2017-12-27.
 * 线程同步，死锁问题
 * 例：在一个KFC内，服务员负责生产食物，消费者负责消费食物，当生产到一定数量可以休息一下，直到消费完食物，再马上生产，一直循环
 */
public class Food {

    String name = "";

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Kfc kfc = new Kfc();

        Customer c1 = new Customer(kfc);
        Customer c2 = new Customer(kfc);
        Customer c3 = new Customer(kfc);
        Customer c4 = new Customer(kfc);

        Waiter waiter1 = new Waiter(kfc);
        Waiter waiter2 = new Waiter(kfc);
        Waiter waiter3 = new Waiter(kfc);

        waiter1.start();
        waiter2.start();
        waiter3.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}

class Kfc {
    String[] names = {"薯条", "烧板", "鸡翅", "可乐"};

    static final int Max = 20;

    List<Food> foods = new ArrayList<Food>();

    public void prod(int index) {
        synchronized (this) {
            while (foods.size() > Max) {
                System.out.println("食材够了");
                this.notifyAll();
                try {
                    String name = Thread.currentThread().getName();
                    this.wait();
                    System.out.println("生产者：" + name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("开始生产食物");
            for (int i = 0; i < index; i++) {
                Food food = new Food(names[(int)Math.random() * 4]);
                foods.add(food);
                System.out.println("生产了" + food.getName() + foods.size());
            }
        }
    }

    public void consu(int index) {
        synchronized (this) {
            while (foods.size() < index) {
                System.out.println("食材不够了");
                this.notifyAll();
                try {
                    String name = Thread.currentThread().getName();
                    this.wait();
                    System.out.println("消费者："+ name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("开始消费");
            for (int i = 0; i < index; i++) {
                Food food = foods.remove(foods.size() - 1);
                System.out.println("消费了一个" + food.getName() + foods.size());
            }
        }
    }
}

class Customer extends Thread {
    Kfc kfc;

    public Customer(Kfc kfc) {
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size = (int)(Math.random()*5);
        while (true) {
            kfc.consu(size);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Waiter extends Thread {
    Kfc kfc;

    public Waiter(Kfc kfc) {
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size = (int)(Math.random()*5) + 5;
        while (true) {
            kfc.prod(size);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
