package pers.dylan.factory;

import pers.dylan.factory.impl.MailSender;
import pers.dylan.factory.impl.SMSSender;

public class SenderFactory {
//    public Sender produce(String type) {
//        if (type.equals("mail")) {
//            return new MailSender();
//        } else if (type.equals("sms")) {
//            return new SMSSender();
//        } else {
//            System.out.println("请输入正确的类型!");
//            return null;
//        }
//
//    }
    public static Sender produceSMS() {
        return new SMSSender();
    }
    public static Sender produceMail() {
        return new MailSender();
    }
}