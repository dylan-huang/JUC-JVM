package com.atguigu.chapter1;

import java.util.concurrent.TimeUnit;

public class StackStruTest {
    public static void main(String[] args) {
        int i = 3+2;

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
