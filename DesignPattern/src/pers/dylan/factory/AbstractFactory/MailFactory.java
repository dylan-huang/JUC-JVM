package pers.dylan.factory.AbstractFactory;

public class MailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
