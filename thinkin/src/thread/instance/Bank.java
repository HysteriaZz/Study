package thread.instance;

/**
 * Created by KaiLin.Guo on 2017-12-26.
 * 对同一个对象进行操作
 * 例：一个账户分别在柜台和ATM机同时取钱
 */
public class Bank {

    static int money = 1000;

    public void counter(int balance) {
        money -= balance;
        System.out.println("柜台取走了" + balance + "还剩下" + money);
    }

    public void atm(int balance) {
        money -= balance;
        System.out.println("ATM取走了" + balance + "还剩下" + money);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Counter counter = new Counter(bank);
        Atm atm = new Atm(bank);

        counter.start();
        atm.start();
    }
}

class Counter extends Thread {
    Bank bank;

    public Counter(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.counter(100);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Atm extends Thread {
    Bank bank;

    public Atm(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 200) {
            bank.atm(200);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
