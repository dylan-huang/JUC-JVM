package com.atguigu.juc;


import java.util.concurrent.*;

/**
 * 一、线程池：提供了一个线程队列，队列中保存着所以处于等待状态的线程，避免了创建与销毁的额外开销，提高响应速度
 *
 * 二、线程池体系结构
 *  java.util.concurrent.Executor :负责线程使用和调度的根接口
 *      ｜--ExecutorService：线程池的主要接口
 *          ｜--ThreadPoolExecutor：实现类
 *          ｜--ScheduleExecutorService 子接口：负责线程调度
 *              ｜--ScheduleThreadPoolExecutor ：实现类 ， 继承ThreadPoolExecutor 实现ScheduleExecutorService
 *
 * 三、工具类
 * Executors：
 *  newFixedThreadPool(): 创建固定大小的线程池
 *  newCachedThreadPool():缓存线程池，数量不固定， 可以根据需求更改数量
 *  newSingleThreadExecutor():创建单个线程池，线程池中只有一个线程
 *
 *  newScheduledThreadPool:创建固定大小的线程池，可以延迟或者定时执行任务
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //为线程池中的线程分配任务
      /*  for (int i=0;i<5;i++){
            pool.submit(threadPoolDemo);
        }
        //关闭线程池
        pool.shutdown();*/

        Future<Integer> submit = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                System.out.println(sum);
                return sum;
            }
        });
        try {
            Integer integer = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();

    }
}

class ThreadPoolDemo implements Runnable{

    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+" : " + i);
        }
    }
}