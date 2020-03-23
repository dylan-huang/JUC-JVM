package com.atguigu.juc;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int number = new Random().nextInt(100);
                    System.out.println(number);
                    return number;
                }
            }, 3, TimeUnit.SECONDS);
            try {
                Integer integer = schedule.get();
                System.out.println("======" + integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        scheduledExecutorService.shutdown();


    }
}
