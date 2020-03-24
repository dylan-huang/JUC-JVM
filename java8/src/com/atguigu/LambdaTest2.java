package com.atguigu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java 内置四大函数式接口
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */
public class LambdaTest2 {
    public static void main(String[] args) {

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去买瓶矿泉水" + aDouble);
            }
        });
        System.out.println("===================");
        happyTime(400, money -> System.out.println("学习太累了，去买瓶矿泉水" + money));


        List<String> list = Arrays.asList("北京", "天津", "东京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(list1.toString());
        System.out.println("===================");

        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2.toString());

    }

    public static void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //根据给定的规则过滤字符串，规则由Predicate规定
    public static List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

}

