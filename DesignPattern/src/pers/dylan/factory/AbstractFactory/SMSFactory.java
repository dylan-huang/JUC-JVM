package pers.dylan.factory.AbstractFactory;

public class SMSFactory implements Provider{
    @Override
    public Sender produce() {
        return new SMSSender();
    }
}
