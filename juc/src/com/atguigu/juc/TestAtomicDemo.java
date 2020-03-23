package com.atguigu.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {

    public static void main(String[] args) {

        AtomicDemo ad = new AtomicDemo();
        for(int i=0;i<10;i++){
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable{

//    private int serialNumber = 0;

    private AtomicInteger atomicInteger = new AtomicInteger();
    public int getSerialNumber() {
        return atomicInteger.getAndIncrement();
    }

    @Override
    public void run() {

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+":" +getSerialNumber());
    }
}