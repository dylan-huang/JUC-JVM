package com.atguigu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        write w = new write(cyclicBarrier);
        for (int i = 0; i < 4; i++) {
        new write(cyclicBarrier).start();
//            if(i<3){
//                new write(cyclicBarrier).start();
//
//            }else {
//                TimeUnit.SECONDS.sleep(5);
//            new write(cyclicBarrier).start();
//            }
        }

        //重用CyclicBarrier
        TimeUnit.SECONDS.sleep(25);
        System.out.println("重用CyclicBarrier");
        for (int i = 0; i < 4; i++) {
            new write(cyclicBarrier).start();
        }
    }

    static class write extends Thread {

        private CyclicBarrier cyclicBarrier;

        public write(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "执行结束");
                cyclicBarrier.await(2,TimeUnit.SECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
