package com.atguigu.juc;


import java.util.concurrent.CountDownLatch;

/**
 * 闭锁：在执行某些运算时，只有其他线程的运算全部完成时，当前运算才会执行
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);
        long start = System.currentTimeMillis();

        for (int i=0;i<5;i++){
            new Thread(latchDemo).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time ========"+ (end-start));

    }
}


class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {

        synchronized (this){
            try {
                for (int i=0;i<20;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }

        }

    }
}