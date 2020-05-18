package pers.dylan.factory.impl;

import pers.dylan.factory.Sender;

public class SMSSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is SMS sender");
    }
}
