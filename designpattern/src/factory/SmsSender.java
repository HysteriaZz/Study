package factory;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }
}
