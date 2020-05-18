package pers.dylan.factory.impl;

import pers.dylan.factory.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mail sender");
    }
}
