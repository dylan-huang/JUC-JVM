package com.atguigu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * callable接口： 相较于runnable，有返回值，并且需要抛出异常
 * 执行Callback方式，需要FutureTask的支持，用于接收运算结果
 */
public class CallableDemo {
    public static void main(String[] args) {
        ThreadDemo1 threadDemo = new ThreadDemo1();
        //执行callable方式，需要FutureTask实现类支持，用于接收结果
        FutureTask<Integer> futureTask = new FutureTask<Integer>(threadDemo);

        new Thread(futureTask).start();

        //接收运算后结果
        try {
            Integer integer = futureTask.get();  //FutureTask可用于闭锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class ThreadDemo1 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        sum+=2;
        return sum;
    }
}