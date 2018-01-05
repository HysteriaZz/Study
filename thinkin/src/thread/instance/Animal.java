package thread.instance;

/**
 * Created by KaiLin.Guo on 2017-12-26.
 * 回调方法使用
 * 例：龟兔赛跑问题
 */
public abstract class Animal extends Thread {
    public double length = 20.0;

    public abstract void running();

    public CallBack callBack;

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            running();
        }
    }
}

interface CallBack{

    void win();
}

class LetOneStop implements CallBack {

    Animal an;

    public LetOneStop(Animal an) {
        this.an = an;
    }

    @Override
    public void win() {
        if (an instanceof Rabbit)
            System.out.println("兔子距离终点还有" + an.length + "米");
        else if (an instanceof Tortoise)
            System.out.println("乌龟距离终点还有" + an.length + "米");
        an.stop();
    }

}

class Rabbit extends Animal {

    public Rabbit() {
        setName("兔子");
    }

    @Override
    public void running() {
        double dis = 0.5;
        length -= dis;
        if (length <= 0) {
            length = 0;
            System.out.println("兔子获得了胜利");

            if (callBack != null) {
                callBack.win();
            }
        }
        System.out.println("兔子跑了" + dis + "米，距离终点还有" + length + "米");

        if (length % 2 == 0) {// 两米休息一次
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Tortoise extends Animal {

    public Tortoise() {
        setName("乌龟");
    }

    @Override
    public void running() {
        double dis = 0.1;
        length -= dis;
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");

            if (callBack != null) {
                callBack.win();
            }
        }
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
        try {
            sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Enter {
    public static void main(String[] args) {
        Animal tortoise = new Tortoise();
        Animal rabbit = new Rabbit();

        tortoise.callBack = new LetOneStop(rabbit);
        rabbit.callBack = new LetOneStop(tortoise);

        tortoise.start();
        rabbit.start();
    }
}
