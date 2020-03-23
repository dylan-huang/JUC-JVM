package com.atguigu.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculator task = new ForkJoinCalculator(0L,100000000L);
        Long result = pool.invoke(task);
        System.out.println(result);
    }
}


class ForkJoinCalculator extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1L;

    private long start;
    private long end;
    private static final long THURSHOLD = 10000L;  //临界值

    public ForkJoinCalculator(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end - start;

        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinCalculator left = new ForkJoinCalculator(start, middle);
            left.fork();

            ForkJoinCalculator right = new ForkJoinCalculator(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}