package com.atguigu;

import java.util.Comparator;

public class LambdaTest {

    public static void main(String[] args) {

        //lambda
        Comparator<Integer> comparator = (o1,o2) -> Integer.compare(o1,o2);
        int compare = comparator.compare(21, 32);
        System.out.println(compare);

        System.out.println("===============");

        //方法引用
        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator.compare(43, 32);
        System.out.println(compare1);
    }
}
