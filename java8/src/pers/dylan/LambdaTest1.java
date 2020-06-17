package pers.dylan;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式本质，作为接口的实例
 *
 * lambda表达式使用：分为六种情况
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        //无参，无返回值


        //需要参数，但是无返回值

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("哈哈哈哈哈");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("a a a ");

        //需要参数，但是无返回值,数据类型可以省略，因为可以由编译器推断得出"推断类型"

        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("啊 。啊 ");

        //lambda若只需要一个参数时，参数的小括号可以删掉

        Consumer<String> consumer3 = s -> { System.out.println(s); };
        consumer3.accept("呵  。  呵");

        // lambda需要两个或两个以上的参数，多条执行语句，并且可以有返回值

        Comparator<Integer> comparator = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        //lambda 若只有一条语句时， 大括号和return 都可以省略
        Comparator<Integer> comparator1 = (o1,o2) ->  o1.compareTo(o2);
        System.out.println(comparator1.compare(1, 2));

    }
}
