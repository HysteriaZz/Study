package generic.reflect;

import java.lang.reflect.Method;

/**
 * Created by KaiLin.Guo on 2018-04-08.
 * 反射
 */
public class LatentReflection {
    public static void main(String[] args) {
        CommunicationReflectively.perform(new SmartDog());
        CommunicationReflectively.perform(new Mime());
    }
}
class Mime {
    public void walkAgainstTheWind() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls() {}
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting!");
    }
    public void reproduce() {

    }
}

class CommunicationReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speck = spkr.getMethod("speak");
                speck.invoke(speaker);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println(speaker + " cannot speak");
            }

            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }

    }
}