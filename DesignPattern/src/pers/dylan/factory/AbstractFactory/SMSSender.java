package pers.dylan.factory.AbstractFactory;

public class SMSSender implements Sender{
    @Override
    public void send() {
        System.out.println("this is SMS sender");
    }
}
