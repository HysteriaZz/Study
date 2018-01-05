package factory;

/**
 * Created by KaiLin.Guo on 2017-11-28.
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
