package pers.dylan.factory;

public class FactoryTest {
    public static void main(String[] args) {
//        Sender sender = new SenderFactory().produceMail();
//        sender.send();
        //静态工厂模式
        SenderFactory.produceSMS().send();
    }
}
