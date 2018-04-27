package chapter19.part3;

/**
 * Created by KaiLin.Guo on 2018-04-27.
 * switch语句中的enum
 */
enum Signal {GREEN, YELLOW, RED}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED: color = Signal.GREEN;
                break;
            case GREEN: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
            default:
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }

}
