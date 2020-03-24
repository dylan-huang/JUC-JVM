package com.atguigu;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口接口的抽象方法的形参列表和构造器形参列表一致
 *      抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 *      可以把数组看作是一个特殊的类，则写法与构造器引用一致
 *
 */
public class ConstructorRefTest {
    public static void main(String[] args) {

    }

    //Supplier中的T get()
    public static void test1(){

        Supplier<Employee> supplier = () -> new Employee(1002,"jerry",23,3000);

        Supplier<Employee> supplier1 = Employee::new;

    }
    //Function中的R apply(T t)
    public static void test2(){
        Function<Integer,Employee> function = t -> new Employee(t);
        Employee employee = function.apply(1001);


        Function<Integer,Employee> function1= Employee::new;
    }

    //BiFunction中的R apply(T t,U u)
    public static void test3(){
        BiFunction<Integer,String,Employee> biFunction = (id,name) -> new Employee(id,name);

        Function<Integer,Employee> biFunction1= Employee::new;
    }
    //数组引用
    //Function 中 R apply(T t)
    public static void test4(){
       Function<Integer,String[]> function = length -> new String[length];

        Function<Integer,String[]> function1 = String[]::new;
    }
}
