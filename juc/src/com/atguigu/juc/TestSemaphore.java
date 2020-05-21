package com.atguigu.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 8个资源争夺5个信号量
 */
public class TestSemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        for (int i=0;i<8;i++){
            new Worker(i,semaphore).start();
        }

    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //获取信号量
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+ this.num + "开始工作");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+ this.num + "完成工作");
                //释放信号量
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
