package factory;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("input error!");
            return null;
        }
    }

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }

    public static Sender sproduceMail(){
        return new MailSender();
    }

    public static Sender sproduceSms(){
        return new SmsSender();
    }
}
