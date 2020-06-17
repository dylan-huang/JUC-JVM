package pers.dylan;


/**
 * 1、何时使用lambda表达式
 * 当需要对一个函数式接口实例化的时候，可以使用lambda表达式
 * 在java中，lambda表达式本质，作为函数式接口的实例
 *
 * 2、何时使用给定的函数式接口
 * 如果开发中需要定义一个函数式接口，首先看看已有jdk提供的函数式接口是否提供了满足需求的函数式接口，
 * 如果有直接调用
 */

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LambdaTest {

    public static void main(String[] args) {

        //lambda
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator.compare(21, 32);
        System.out.println(compare);

        System.out.println("===============");

        //方法引用
        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator.compare(43, 32);
        System.out.println(compare1);

    }
}
