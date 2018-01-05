package factory;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class FactoryTest {
    public static void main(String[] args) {
        // 普通工厂
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("sms");
        sender = sendFactory.produce("mail");
        sender.send();

        // 多个工厂方法
        sender = sendFactory.produceMail();
        sender = sendFactory.produceSms();
        sender.send();

        // 静态工厂方法（常用）
        sender = SendFactory.sproduceMail();
        sender = SendFactory.sproduceSms();
        sender.send();

        // 抽象工厂方法
        Provider provider = new SendMailFactory();
        sender = provider.produce();
        sender.send();

    }
}
