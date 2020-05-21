package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch2 {



    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
           new Thread(()->{
               try {
                   System.out.println("线程1开始");
                   TimeUnit.SECONDS.sleep(3);
                   System.out.println("线程1结束");
                   latch.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();


        new Thread(() -> {

            try {
                System.out.println("线程2开始");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("线程2结束");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("等待两个线程执行完毕");
        latch.await();
        System.out.println("继续执行");
    }




}
