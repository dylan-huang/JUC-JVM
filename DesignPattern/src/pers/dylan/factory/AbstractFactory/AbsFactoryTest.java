package pers.dylan.factory.AbstractFactory;

public class AbsFactoryTest {
    public static void main(String[] args) {
        new MailFactory().produce().send();
        new SMSFactory().produce().send();
    }
}
