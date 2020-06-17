package pers.dylan;


import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用：
 * 1、使用情景：当要传递给lambda体的操作，已经有实现的方法时，可以使用方法引用
 * 2、方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例。
 * 所以方法引用，也是函数式接口的实例
 * <p>
 * 3、使用格式： 类(或对象)::方法名
 * <p>
 * 4、具体分为三种情况：
 * 对象::非静态方法
 * 类::静态方法
 * 类::非静态方法
 *
 * 5、方法引用使用的要求：
 *      要求接口中的抽象方法的形参列表和返回值类型的方法引用的形参列表和返回值类型相同
 */
public class MethodRefTest {


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    //consumer void accept(T t)
    //PrintStream void println(T t)
    public static void test1() {
        Consumer<String> consumer = str -> { System.out.println(str); };
        consumer.accept("hello,world");

        System.out.println("================");
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("hello,world!");

    }
    //Supplier T get()
    //Employee getName()
    public static void test2() {
        Employee employee = new Employee(1001,"tom",18,9000);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());

        System.out.println("================");
        Supplier<String> supplier1 = employee::getName;
        System.out.println(supplier1.get());
    }

    //Comparator int compare(T t1,T t2)
    //Integer int compare(T t1,T t2)
    public static void test3() {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1, 2));

    }
    //Function  R apply(T t)
    //Math long round(Double d)
    public static void test4() {

        Function<Double,Long> function = d -> Math.round(d);

        Function<Double,Long> function1 = Math::round;
    }

    //情况3  类::实例方法
    //Comparator int compare(T t1,T t2)
    //String int t1.compareTo(t2)
    public static void test5() {
        Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("A", "B"));

        Comparator<String> comparator1 = String::compareTo;

    }
    //BiPredicate boolean test(T t1,T t2)
    //String boolean t1.equals(t2)
    public static void test6() {
        BiPredicate<String,String> biPredicate = (t1,t2) -> t1.equals(t2);

        BiPredicate<String,String> biPredicate1 = String::equals;

    }
    //Function 中 R apply(T t)
    //Employee String getName
    public static void test7() {
        Employee employee = new Employee(1001,"tom",18,9000);

        Function<Employee,String> emp = employee1 -> employee.getName();

        Function<Employee,String> emp1 = Employee::getName;
        System.out.println(emp1.apply(employee));

    }

}
