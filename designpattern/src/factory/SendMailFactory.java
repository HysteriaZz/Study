package factory;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
